package com.company.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommonDAOImpl implements CommonDAO {
    private Connection conn;

    @Override
    public <T> List<T> executeQuery(Class<?> clazz, String query,
                                    List<Object> params) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> itemList = new ArrayList<T>();
        try {
            conn = DBTool.getInstance().getConnection();
            // 设置隔离级别
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            ps = conn.prepareStatement(query);
            if (params != null && params.size() > 0) {
                for (int i = 0; i < params.size(); i++) {
                    ps.setObject(i + 1, params.get(i));
                }
            }
            rs = ps.executeQuery();
            Field[] fields = clazz.getDeclaredFields();

            while (rs.next()) {
                @SuppressWarnings("unchecked")
                T entity = (T) clazz.newInstance(); //利用反射实例化一个对象
                for (Field field : fields) {
                    // VERY IMPORTANT!!!
                    field.setAccessible(true);
                    Object rsVal = rs.getObject(field.getName());

                    //##############ORACLE##############
                    Object val = null;
                    if (rsVal.getClass() == BigDecimal.class) {
                        if (field.getType() == Double.class) {
                            val = ((BigDecimal) rsVal).doubleValue();
                        } else if (field.getType() == Integer.class) {
                            val = ((BigDecimal) rsVal).intValue();
                        } else {
                            val = rsVal;
                        }
                    } else {
                        val = rsVal;
                    }
                    //##############ORACLE##############
                    field.set(entity, val);
                }
                itemList.add(entity);
            }
        } catch (SQLException | InstantiationException | IllegalAccessException
                | SecurityException e) {
            e.printStackTrace();
        } finally {
            DBTool.closeAll(rs, ps, conn);
        }
        return itemList;
    }

    public int executeUpdate(String query, List<Object> params) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int row = 0;
        try {
            conn = DBTool.getInstance().getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            if (params.size() > 0) {
                for (int i = 0; i < params.size(); i++) {
                    ps.setObject(i + 1, params.get(i));
                }
            }
            row = ps.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            /*try
			{
				conn.rollback();
			}
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
            e.printStackTrace();
        } finally {
            DBTool.closeAll(rs, ps, conn);
        }
        return row;
    }

    public void executeUpdateBatch(String query, Map<Integer, List<Object>> paramsMap) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBTool.getInstance().getConnection();
            conn.setTransactionIsolation(8);
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            Set<Integer> querySet = paramsMap.keySet();
            Iterator<Integer> it = querySet.iterator();
            while (it.hasNext()) {
                Integer idx = it.next();
                List<Object> params = paramsMap.get(idx);
                if (params.size() > 0) {
                    for (int i = 0; i < params.size(); i++) {
                        ps.setObject(i + 1, params.get(i));
                    }
                }
                ps.addBatch();
            }
            ps.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException | SecurityException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBTool.closeAll(rs, ps, conn);
        }
    }

    public void executeUpdateBatch(Map<String, List<Object>> queryMap) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBTool.getInstance().getConnection();
            conn.setTransactionIsolation(8);
            conn.setAutoCommit(false);
            Set<String> querySet = queryMap.keySet();
            Iterator<String> it = querySet.iterator();
            while (it.hasNext()) {
                String query = it.next();
                ps = conn.prepareStatement(query);
                List<Object> params = queryMap.get(query);
                if (params.size() > 0) {
                    for (int i = 0; i < params.size(); i++) {
                        ps.setObject(i + 1, params.get(i));
                    }
                }
                ps.executeUpdate();
            }
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException | SecurityException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBTool.closeAll(rs, ps, conn);
        }
    }

    @Override
    public int update(Object obj) {
        int row = 0;
        try {
            // 获取到对象声明的所有属性字段
            Field[] fields = obj.getClass().getDeclaredFields();
            Field primaryField = null;
            List<Object> params = new ArrayList<Object>();
            StringBuffer sb = new StringBuffer();
            sb.append("UPDATE ");
            sb.append(obj.getClass().getSimpleName());
            sb.append(" SET ");
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                // 如果字段上标记了@Id注解，表示这是一个主键
                boolean b = fields[i].isAnnotationPresent(Id.class);
                if (!b) {
                    if (i < fields.length - 1) {
                        sb.append(fields[i].getName() + "=?,");
                    } else {
                        sb.append(fields[i].getName() + "=? ");
                    }
                    params.add(fields[i].get(obj));
                } else {
                    primaryField = fields[i]; // 获取主键属性
                }
            }
            sb.append(" WHERE " + primaryField.getName() + "=?");
            params.add(primaryField.get(obj));
            row = executeUpdate(sb.toString(), params);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int add(Object obj) {
        int row = 0;
        try {
            // 获取到对象声明的所有属性字段
            Field[] fields = obj.getClass().getDeclaredFields();
            List<Object> params = new ArrayList<Object>();
            StringBuffer sb = new StringBuffer();
            sb.append("INSERT INTO ");
            sb.append(obj.getClass().getSimpleName());
            sb.append(" (");
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                // 如果字段上标记了@Id注解，表示这是一个主键
                boolean b = fields[i].isAnnotationPresent(Id.class);
                if (!b) {
                    if (i < fields.length - 1) {
                        sb.append(fields[i].getName() + ",");
                    } else {
                        sb.append(fields[i].getName() + ") VALUES (");
                    }
                    params.add(fields[i].get(obj));
                }
            }
            for (int i = 0; i < params.size() - 1; i++) {
                sb.append("?,");
            }
            sb.append("?)");
            System.out.println(sb.toString());
            row = executeUpdate(sb.toString(), params);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int delete(Object obj) {
        int row = 0;
        try {
            // 获取到对象声明的所有属性字段
            Field[] fields = obj.getClass().getDeclaredFields();
            Field primaryField = null;
            List<Object> params = new ArrayList<Object>();
            StringBuffer sb = new StringBuffer();
            sb.append("DELETE FROM ");
            sb.append(obj.getClass().getSimpleName());
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                // 如果字段上标记了@Id注解，表示这是一个主键
                boolean b = fields[i].isAnnotationPresent(Id.class);
                if (b) {
                    primaryField = fields[i]; // 获取主键属性
                }
            }
            sb.append(" WHERE " + primaryField.getName() + "=?");
            System.out.println(sb.toString());
            params.add(primaryField.get(obj));
            row = executeUpdate(sb.toString(), params);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return row;
    }
}
