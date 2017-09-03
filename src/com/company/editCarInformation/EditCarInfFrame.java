package com.company.editCarInformation;

import com.company.changSkin.ChaneSkin;
import com.company.dao.CommonDAOImpl;
import com.company.entity.CarInformation;
import org.apache.poi.hssf.usermodel.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author student Ross
 * @2017年8月30日
 */
public class EditCarInfFrame extends JFrame {
    private CommonDAOImpl commonDAO = new CommonDAOImpl();
    private ChaneSkin chaneSkin;
    private boolean skin;
    private JPanel mianBody;
    private JTabbedPane jTabbedPane;
    private JPanel basicData;
    private JPanel carInf;
    private JPanel demo;
    private JCheckBox jCheckBox;
    private JButton jButtonPrint;
    private JButton jButtonDesgin;
    private JButton jButtonAdd;
    private JButton jButtonSave;
    private JButton jButtonCancel;
    private JButton jButtonBack;
    private JButton jButtonChangeSkin;

    private JTextField jTextFieldCarNo;
    private JTextField jTextFieldOutFactoryNo;
    private JTextField jTextFieldDIPANNo;
    private JTextField jTextFieldPrice;
    private JTextField jTextFieldGetCarNoFee;
    private JTextField jTextFieldCarOwnerName;
    private JTextField jTextFieldStartMils;
    private JTextField erBaoMils;
    private JTextField enginerNo;
    private JTextField purchaseTax;
    private JTextField decorationFee;
    private JTextField telNo;
    private JTextField nowMils;
    private JTextField nextErBao;
    private JComboBox carClass;
    private JComboBox color;
    private JComboBox seatNum;
    private JSpinner buyyingTime;//购买时间
    private JSpinner YLFTime;   //养路费
    private JSpinner YLFEndTime;
    private JSpinner NSTime;    //年审
    private JSpinner NSEndTime;
    private JSpinner BXTime;    //保险
    private JSpinner BXEndTime;
    private JSpinner CCSTime;   //车船税
    private JSpinner CCSEndTime;
    private JSpinner LQPTime;   //路桥票
    private JSpinner LQPEndTime;
    private JSpinner YYZTime;   //运营证
    private JSpinner YYZEndTime;
    private JSpinner GLFTime;   //管理费
    private JSpinner GLFEndTime;

    private JLabel jLabel;
    private String[] carTyle = {"小轿车", "中巴车", "大卡车"};
    private String[] carColor = {"黑", "白", "灰"};
    private String[] carSeat = {"4", "5", "6", "7"};
    private String[] basicDateName = {
            "车牌号：", "车型：", "出厂编号：", "底盘编号：", "购买价格：", "上牌费：", "车主姓名：", "起始公里数："
            , "养路费购买时间：", "年审时间：", "保险购买时间：", "车船税购买时间：", "路桥票购买时间：", "运营证办理时间：", "运营费购买时间：", "二保里程："
            , "购买时间：", "颜色：", "发动机号：", "座位数：", "购置税：", "汽车装饰：", "联系电话：", "当前公里数："
            , "截止时间：", "截止时间：", "截止时间：", "截止时间：", "截止时间：", "截止时间：", "截止时间：", "下次二保："};

    public EditCarInfFrame() {
        iniFrame();
        iniBody();
        this.add(mianBody);
    }

    private void iniBody() {
        mianBody = new JPanel();
        mianBody.setLayout(null);
        jCheckBox = new JCheckBox("停用");
        jCheckBox.setBounds(585, 50, 60, 20);
        jButtonPrint = new JButton("打印档案");
        jButtonPrint.setBounds(585, 210, 84, 40);
        jButtonPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Properties p = new Properties();
                PrintJob jp = Toolkit.getDefaultToolkit().getPrintJob(EditCarInfFrame.this, "客户登记表编辑", p);
                Graphics pg = jp.getGraphics();//Graphics打印图形的图形环境
                if (pg != null) {
                    try {
                        EditCarInfFrame.this.printAll(pg); //打印该窗体及其所有的组件
                    } finally {
                        pg.dispose(); //注销图形环境
                    }
                }
                jp.end(); //结束打印作业
            }
        });

        jButtonDesgin = new JButton("设计档案");
        jButtonDesgin.setBounds(585, 250, 84, 40);
        jButtonDesgin.addActionListener(new ActionListener() {
            @Override
            //实验各皮肤弹出窗口
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(EditCarInfFrame.this, "", "!!!", JOptionPane.OK_OPTION);
            }
        });
        jButtonAdd = new JButton("增加(A)");
        jButtonAdd.setBounds(585, 290, 84, 40);
        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean carNoNo = isCar(jTextFieldCarNo.getText());
                boolean telNoNo = isTel(telNo.getText());
                if (carNoNo && telNoNo) {
                    if (commonDAO.searchClo(jTextFieldCarNo.getText(), "tb_car", "Car_Id")) {
                        JOptionPane.showMessageDialog(EditCarInfFrame.this, "有了还添，心里有没有比数！", "错误！", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (commonDAO.add2(getPanelINf(), "tb_car") != 0) {
                        JOptionPane.showMessageDialog(EditCarInfFrame.this, "添加成功！", "成功！", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (carNoNo == false) {
                    JOptionPane.showMessageDialog(EditCarInfFrame.this, "车牌格式不正确！", "错误！", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(EditCarInfFrame.this, "电话格式不正确！", "错误！", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jButtonSave = new JButton("存盘(S)");
        jButtonSave.setBounds(585, 330, 84, 40);
        jButtonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (saveASExcel()) {
                    case 0:
                        JOptionPane.showMessageDialog(EditCarInfFrame.this, "导出成功！", "成功！", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(EditCarInfFrame.this, "导出失败！", "错误！", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        break;
                }
            }
        });
        jButtonCancel = new JButton("取消(C)");
        jButtonCancel.setBounds(585, 370, 84, 40);
        jButtonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldCarNo.setText("");
                jTextFieldOutFactoryNo.setText("");
                jTextFieldDIPANNo.setText("");
                jTextFieldPrice.setText("");
                jTextFieldGetCarNoFee.setText("");
                jTextFieldCarOwnerName.setText("");
                jTextFieldStartMils.setText("");
                erBaoMils.setText("");
                enginerNo.setText("");
                purchaseTax.setText("");
                decorationFee.setText("");
                telNo.setText("");
                nowMils.setText("");
                nextErBao.setText("");
            }
        });
        jButtonBack = new JButton("返回(R)");
        jButtonBack.setBounds(585, 410, 84, 40);
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        iniTabbedPanel();

        jButtonChangeSkin = new JButton("换肤");
        jButtonChangeSkin.setBounds(585, 170, 84, 40);
        jButtonChangeSkin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chaneSkin = new ChaneSkin(skin);
                int back = chaneSkin.showChangeSkin(EditCarInfFrame.this);
                if (back == chaneSkin.APPROVE_OPTION) {
                    skin = chaneSkin.returnSkinStyle();
                    changeSkin();
                    revalidate();
                }
            }
        });

        mianBody.add(jButtonChangeSkin);
        mianBody.add(jCheckBox);
        mianBody.add(jButtonPrint);
        mianBody.add(jButtonDesgin);
        mianBody.add(jButtonAdd);
        mianBody.add(jButtonSave);
        mianBody.add(jButtonCancel);
        mianBody.add(jButtonBack);
        mianBody.add(jTabbedPane);
    }

    private CarInformation getPanelINf() {
        CarInformation carInformation = new CarInformation();
        carInformation.setCar_Id(jTextFieldCarNo.getText());
        System.out.println(carTyle[carClass.getSelectedIndex()]);
        carInformation.setCar_Type(carTyle[carClass.getSelectedIndex()]);
        carInformation.setChuchang_Id(jTextFieldOutFactoryNo.getText());
        carInformation.setDipan_Id(jTextFieldDIPANNo.getText());
        carInformation.setBuy_Price(new BigDecimal(jTextFieldPrice.getText()));
        carInformation.setShangpai_fee(new BigDecimal(jTextFieldGetCarNoFee.getText()));
        carInformation.setChezhu_Name(jTextFieldCarOwnerName.getText());
        carInformation.setStart_Gongli(new BigDecimal(jTextFieldStartMils.getText()));

        carInformation.setYLF_Starttime(new Timestamp(((Date) YLFTime.getValue()).getTime()));
        carInformation.setNS_Starttime(new Timestamp(((Date) NSTime.getValue()).getTime()));
        carInformation.setBX_Starttime(new Timestamp(((Date) BXTime.getValue()).getTime()));
        carInformation.setCCS_Starttime(new Timestamp(((Date) CCSTime.getValue()).getTime()));
        carInformation.setLQP_Starttime(new Timestamp(((Date) LQPTime.getValue()).getTime()));
        carInformation.setYYZ_Starttime(new Timestamp(((Date) YYZTime.getValue()).getTime()));
        carInformation.setYGF_Starttime(new Timestamp(((Date) GLFTime.getValue()).getTime()));
        carInformation.setErbaolicheng(new BigDecimal(erBaoMils.getText()));

        carInformation.setBuy_Time(new Timestamp(((Date) buyyingTime.getValue()).getTime()));
        carInformation.setCar_Color(carColor[color.getSelectedIndex()]);
        carInformation.setMotor_Id(enginerNo.getText());
        carInformation.setChair_Num(carSeat[seatNum.getSelectedIndex()]);
        carInformation.setBuy_tax(new BigDecimal(purchaseTax.getText()));
        System.out.println(new BigDecimal(decorationFee.getText()));
        carInformation.setCar_Zhuangshi(new BigDecimal(decorationFee.getText()));
        carInformation.setTel(telNo.getText());
        carInformation.setCurrent_Gongli(new BigDecimal(nowMils.getText()));

        carInformation.setYLF_Endtime(new Timestamp(((Date) YLFEndTime.getValue()).getTime()));
        carInformation.setNS_Endtime(new Timestamp(((Date) NSEndTime.getValue()).getTime()));
        carInformation.setBX_Endtime(new Timestamp(((Date) BXEndTime.getValue()).getTime()));
        carInformation.setCCS_Endtime(new Timestamp(((Date) CCSEndTime.getValue()).getTime()));
        carInformation.setLQP_Endtime(new Timestamp(((Date) LQPEndTime.getValue()).getTime()));
        carInformation.setYYZ_Endtime(new Timestamp(((Date) YYZEndTime.getValue()).getTime()));
        carInformation.setYGF_Endtime(new Timestamp(((Date) GLFEndTime.getValue()).getTime()));
        carInformation.setNextErbao(new BigDecimal(nextErBao.getText()));

        return carInformation;
    }

    //换肤方法待改善，需要设计新窗口
    private void changeSkin() {
        try {
            if (!skin) {
                UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
            } else {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    SwingUtilities.updateComponentTreeUI(EditCarInfFrame.this);
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }


    private void iniTabbedPanel() {
        jTabbedPane = new JTabbedPane();
        jTabbedPane.setBounds(5, 5, 575, 452);
        basicData = new JPanel();
        basicData.setLayout(null);
        basicData.setBorder(BorderFactory.createEtchedBorder());
        iniBasicData();
        jTabbedPane.addTab("基本资料", null, basicData, "基本资料");
        carInf = new JPanel();
        carInf.setBorder(BorderFactory.createEtchedBorder());
        jTabbedPane.addTab("车辆照片", null, carInf, "照片");
        demo = new JPanel();
        demo.setBorder(BorderFactory.createEtchedBorder());
        jTabbedPane.addTab("备注", null, demo, "备注");
    }

    private void iniBasicData() {
        Calendar calendar = Calendar.getInstance();
        Date today = new Date(System.currentTimeMillis());
        calendar.setTime(today);
//        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        calendar.add(Calendar.YEAR, 1);
        Date nextyearToday = (Date) calendar.getTime();
        for (int i = 0; i < basicDateName.length; i++) {
            basicData.add(setjLabel(basicDateName[i], i));
        }
        jTextFieldCarNo = new JTextField();
        jTextFieldCarNo.setBounds(120, 15, 175, 20);
        basicData.add(jTextFieldCarNo);
        jTextFieldOutFactoryNo = new JTextField();
        carClass = new JComboBox(carTyle);
        carClass.setBounds(120, 40, 175, 22);
        basicData.add(carClass);
        jTextFieldOutFactoryNo.setBounds(120, 65, 175, 20);
        basicData.add(jTextFieldOutFactoryNo);
        jTextFieldDIPANNo = new JTextField();
        jTextFieldDIPANNo.setBounds(120, 90, 175, 20);
        basicData.add(jTextFieldDIPANNo);
        jTextFieldPrice = new JTextField();
        jTextFieldPrice.setBounds(120, 115, 175, 20);
        basicData.add(jTextFieldPrice);
        jTextFieldGetCarNoFee = new JTextField();
        jTextFieldGetCarNoFee.setBounds(120, 140, 175, 20);
        basicData.add(jTextFieldGetCarNoFee);
        jTextFieldCarOwnerName = new JTextField();
        jTextFieldCarOwnerName.setBounds(120, 165, 175, 20);
        basicData.add(jTextFieldCarOwnerName);
        jTextFieldStartMils = new JTextField();
        jTextFieldStartMils.setBounds(120, 190, 175, 20);
        basicData.add(jTextFieldStartMils);

        YLFTime = setJSpinner(YLFTime, today, true);
        YLFTime.setBounds(120, 215, 175, 22);
        basicData.add(YLFTime);
        NSTime = setJSpinner(NSTime, today, true);
        NSTime.setBounds(120, 240, 175, 22);
        basicData.add(NSTime);
        BXTime = setJSpinner(BXTime, today, true);
        BXTime.setBounds(120, 265, 175, 22);
        basicData.add(BXTime);
        CCSTime = setJSpinner(CCSTime, today, true);
        CCSTime.setBounds(120, 290, 175, 22);
        basicData.add(CCSTime);
        LQPTime = setJSpinner(LQPTime, today, true);
        LQPTime.setBounds(120, 315, 175, 22);
        basicData.add(LQPTime);
        YYZTime = setJSpinner(YYZTime, today, true);
        YYZTime.setBounds(120, 340, 175, 22);
        basicData.add(YYZTime);
        GLFTime = setJSpinner(GLFTime, today, true);
        GLFTime.setBounds(120, 365, 175, 22);
        basicData.add(GLFTime);
        erBaoMils = new JTextField();
        erBaoMils.setBounds(120, 390, 175, 20);
        basicData.add(erBaoMils);

        buyyingTime = setJSpinner(buyyingTime, today, true);
        buyyingTime.setBounds(385, 15, 175, 22);
        basicData.add(buyyingTime);
        color = new JComboBox(carColor);
        color.setBounds(385, 40, 175, 22);
        basicData.add(color);
        enginerNo = new JTextField();
        enginerNo.setBounds(385, 65, 175, 20);
        basicData.add(enginerNo);
        seatNum = new JComboBox(carSeat);
        seatNum.setBounds(385, 90, 175, 22);
        basicData.add(seatNum);
        purchaseTax = new JTextField();
        purchaseTax.setBounds(385, 115, 175, 20);
        basicData.add(purchaseTax);
        decorationFee = new JTextField();
        decorationFee.setBounds(385, 140, 175, 20);
        basicData.add(decorationFee);
        telNo = new JTextField();
        telNo.setBounds(385, 165, 175, 20);
        basicData.add(telNo);
        nowMils = new JTextField();
        nowMils.setBounds(385, 190, 175, 20);
        basicData.add(nowMils);
        nextErBao = new JTextField();

        YLFEndTime = setJSpinner(YLFEndTime, nextyearToday, false);
        YLFEndTime.setBounds(385, 215, 175, 22);
        basicData.add(YLFEndTime);
        NSEndTime = setJSpinner(NSEndTime, nextyearToday, false);
        NSEndTime.setBounds(385, 240, 175, 22);
        basicData.add(NSEndTime);
        BXEndTime = setJSpinner(BXEndTime, nextyearToday, false);
        BXEndTime.setBounds(385, 265, 175, 22);
        basicData.add(BXEndTime);
        CCSEndTime = setJSpinner(CCSEndTime, nextyearToday, false);
        CCSEndTime.setBounds(385, 290, 175, 22);
        basicData.add(CCSEndTime);
        LQPEndTime = setJSpinner(LQPEndTime, nextyearToday, false);
        LQPEndTime.setBounds(385, 315, 175, 22);
        basicData.add(LQPEndTime);
        YYZEndTime = setJSpinner(YYZEndTime, nextyearToday, false);
        YYZEndTime.setBounds(385, 340, 175, 22);
        basicData.add(YYZEndTime);
        GLFEndTime = setJSpinner(GLFEndTime, nextyearToday, false);
        GLFEndTime.setBounds(385, 365, 175, 22);
        basicData.add(GLFEndTime);
        nextErBao.setBounds(385, 390, 175, 20);
        basicData.add(nextErBao);
    }

    private JSpinner setJSpinner(JSpinner temp, Date tempDate) {
        SpinnerDateModel model = new SpinnerDateModel();
        temp = new JSpinner(model);
        temp.setValue(tempDate);
        JSpinner.DateEditor edit = new JSpinner.DateEditor(temp, "yyyy-MM-dd");
        temp.setEditor(edit);
        return temp;
    }

    private JSpinner setJSpinner(JSpinner temp, Date tempDate, boolean isEditable) {
        SpinnerDateModel model = new SpinnerDateModel();
        temp = new JSpinner(model);
        temp.setValue(tempDate);
        JSpinner.DateEditor edit = new JSpinner.DateEditor(temp, "yyyy-MM-dd");
        edit.getTextField().setEditable(isEditable);
        DefaultFormatterFactory factory = (DefaultFormatterFactory) edit.getTextField().getFormatterFactory();
        DateFormatter formatter = (DateFormatter) factory.getDefaultFormatter();
        formatter.setAllowsInvalid(false);
        formatter.setOverwriteMode(true);
        temp.setEditor(edit);
        return temp;
    }

    private JLabel setjLabel(String name, int i) {
        jLabel = new JLabel(name);
        jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel.setBounds(10 + 265 * (i / 16), 15 + 25 * (i % 16), 104, 20);
        return jLabel;
    }

    private int saveASExcel() {
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("学生表一");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = row.createCell(0);
        cell.setCellValue("车牌号");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("购买时间");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("车型");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("颜色");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("出厂编号");
        cell.setCellStyle(style);
        cell = row.createCell(5);
        cell.setCellValue("发动机号");
        cell.setCellStyle(style);
        cell = row.createCell(6);
        cell.setCellValue("底盘编号");
        cell.setCellStyle(style);
        cell = row.createCell(7);
        cell.setCellValue("座位数");
        cell.setCellStyle(style);
        cell = row.createCell(8);
        cell.setCellValue("购买价格");
        cell.setCellStyle(style);
        cell = row.createCell(9);
        cell.setCellValue("购置税");
        cell.setCellStyle(style);
        cell = row.createCell(10);
        cell.setCellValue("上牌费");
        cell.setCellStyle(style);
        cell = row.createCell(11);
        cell.setCellValue("汽车装饰");
        cell.setCellStyle(style);
        cell = row.createCell(12);
        cell.setCellValue("车主姓名");
        cell.setCellStyle(style);
        cell = row.createCell(13);
        cell.setCellValue("联系电话");
        cell.setCellStyle(style);
        cell = row.createCell(14);
        cell.setCellValue("起始公里数");
        cell.setCellStyle(style);
        cell = row.createCell(15);
        cell.setCellValue("当前公里数");
        cell.setCellStyle(style);
        cell = row.createCell(16);
        cell.setCellValue("养路费购买时间");
        cell.setCellStyle(style);
        cell = row.createCell(17);
        cell.setCellValue("养路费截止时间");
        cell.setCellStyle(style);
        cell = row.createCell(18);
        cell.setCellValue("年审时间");
        cell.setCellStyle(style);
        cell = row.createCell(19);
        cell.setCellValue("年审截止时间");
        cell.setCellStyle(style);
        cell = row.createCell(20);
        cell.setCellValue("保险购买时间");
        cell.setCellStyle(style);
        cell = row.createCell(21);
        cell.setCellValue("保险截止时间");
        cell.setCellStyle(style);
        cell = row.createCell(22);
        cell.setCellValue("车船税购买时间");
        cell.setCellStyle(style);
        cell = row.createCell(23);
        cell.setCellValue("车船税截止时间");
        cell.setCellStyle(style);
        cell = row.createCell(24);
        cell.setCellValue("路桥票购买时间");
        cell.setCellStyle(style);
        cell = row.createCell(25);
        cell.setCellValue("路桥票截止时间");
        cell.setCellStyle(style);
        cell = row.createCell(26);
        cell.setCellValue("营运证办理时间");
        cell.setCellStyle(style);
        cell = row.createCell(27);
        cell.setCellValue("营运证截止时间");
        cell.setCellStyle(style);
        cell = row.createCell(28);
        cell.setCellValue("运营费购买时间");
        cell.setCellStyle(style);
        cell = row.createCell(29);
        cell.setCellValue("运营费截止时间");
        cell.setCellStyle(style);
        cell = row.createCell(30);
        cell.setCellValue("二保里程");
        cell.setCellStyle(style);
        cell = row.createCell(31);
        cell.setCellValue("下次二保");
        cell.setCellStyle(style);

        //TODO 存盘excel文件
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
        //java.awt和java.util下都有list要声明正确
        java.util.List<CarInformation> list = commonDAO.getAllInfFormTb_car("tb_car");
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow((int) i + 1);
            CarInformation carInf = list.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell(0).setCellValue(carInf.getCar_Id());
            row.createCell(1).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getBuy_Time()));
            row.createCell(2).setCellValue(carInf.getCar_Type());
            row.createCell(3).setCellValue(carInf.getCar_Color());
            row.createCell(4).setCellValue(carInf.getChuchang_Id());
            row.createCell(5).setCellValue(carInf.getMotor_Id());
            row.createCell(6).setCellValue(carInf.getDipan_Id());
            row.createCell(7).setCellValue(carInf.getChair_Num());
            row.createCell(8).setCellValue(String.valueOf(carInf.getBuy_Price()));
            row.createCell(9).setCellValue(String.valueOf(carInf.getBuy_tax()));
            row.createCell(10).setCellValue(String.valueOf(carInf.getShangpai_fee()));
            row.createCell(11).setCellValue(String.valueOf(carInf.getZhuangshi()));
            row.createCell(12).setCellValue(carInf.getChezhu_Name());
            row.createCell(13).setCellValue(carInf.getTel());
            row.createCell(14).setCellValue(String.valueOf(carInf.getStart_Gongli()));
            row.createCell(15).setCellValue(String.valueOf(carInf.getCurrent_Gongli()));
            row.createCell(16).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getYLF_Starttime()));
            row.createCell(17).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getYLF_Endtime()));
            row.createCell(18).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getNS_Starttime()));
            row.createCell(19).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getNS_Endtime()));
            row.createCell(20).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getBX_Starttime()));
            row.createCell(21).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getBX_Endtime()));
            row.createCell(22).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getCCS_Starttime()));
            row.createCell(23).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getCCS_Endtime()));
            row.createCell(24).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getLQP_Starttime()));
            row.createCell(25).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getLQP_Endtime()));
            row.createCell(26).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getYYZ_Starttime()));
            row.createCell(27).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getYYZ_Endtime()));
            row.createCell(28).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getYGF_Starttime()));
            row.createCell(29).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getYGF_Endtime()));
            row.createCell(30).setCellValue(String.valueOf(carInf.getErbaolicheng()));
            row.createCell(31).setCellValue(String.valueOf(carInf.getNextErbao()));
        }
        return saveFile(wb);
    }

    private int saveFile(HSSFWorkbook wb) {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Excel文件(*.xls)", "xls");
        jfc.setFileFilter(filter);
        int option = jfc.showSaveDialog(EditCarInfFrame.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            String fname = jfc.getName(file);   //从文件名输入框中获取文件名
            //假如用户填写的文件名不带我们制定的后缀名，那么我们给它添上后缀
            if (fname.indexOf(".xls") == -1) {
                file = new File(jfc.getCurrentDirectory(), fname + ".xls");
//            System.out.println("renamed");
//            System.out.println(file.getName());
            }
            try {
                FileOutputStream fout = new FileOutputStream(file);
                wb.write(fout);
                fout.close();
            } catch (IOException e1) {
                e1.printStackTrace();
                return 1;
            }
        } else if (option == JFileChooser.CANCEL_OPTION) {
            return 2;
        }
        return 0;
    }

    public boolean isTel(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        //^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$
        //^1[3|4|5|8][0-9]\d{8}\s?$ ←\s?表示句末可以允许一个空格(暂时不用)
        //^1[3|4|5|8][0-9]\d{8}$
        p = Pattern.compile(
                "^1[3|4|5|8][0-9]\\d{8}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public boolean isCar(String str) {
        /*
        1.常规车牌号：仅允许以汉字开头，后面可录入六个字符，由大写英文字母和阿拉伯数字组成。如：粤B12345；
        2.最后一个为汉字的车牌：允许以汉字开头，后面可录入六个字符，前五位字符，由大写英文字母和阿拉伯数字组成，而最后一个字符为汉字，汉字包括“挂”、“学”、“警”、“港”、“澳”。如：粤Z1234港。
        3.新军车牌：以两位为大写英文字母开头，后面以5位阿拉伯数字组成。如：BA12345。
         */
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(
                "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$"); // 验证车牌号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    private void iniFrame() {
        this.setTitle("汽车档案编辑");
        this.setSize(680, 490);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        skin = true;
//        try {
//            //UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
//            //Darcula主题可以换肤
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
        changeSkin();
    }
}
