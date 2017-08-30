package com.company.editCarInformation;

import org.omg.CORBA.DATA_CONVERSION;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Calendar;

/**
 * @author student Ross
 * @2017年8月30日
 */
public class EditCarInfFrame extends JFrame {
    private boolean skin = false;
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
            @Override
            //实验各皮肤弹出窗口
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(EditCarInfFrame.this, "", "!!!", JOptionPane.OK_OPTION);
            }
        });
        jButtonDesgin = new JButton("设计档案");
        jButtonDesgin.setBounds(585, 250, 84, 40);
        jButtonAdd = new JButton("增加(A)");
        jButtonAdd.setBounds(585, 290, 84, 40);
        jButtonSave = new JButton("存盘(S)");
        jButtonSave.setBounds(585, 330, 84, 40);
        jButtonCancel = new JButton("取消(C)");
        jButtonCancel.setBounds(585, 370, 84, 40);
        jButtonBack = new JButton("返回(R)");
        jButtonBack.setBounds(585, 410, 84, 40);
        iniTabbedPanel();

        jButtonChangeSkin = new JButton("换肤");
        jButtonChangeSkin.setBounds(585, 170, 84, 40);
        jButtonChangeSkin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSkin();
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

    //换肤方法待改善，需要设计新窗口
    private void changeSkin() {
        try {
            if (skin) {
                UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
                skin = !skin;
            } else {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                skin = !skin;
            }
            SwingUtilities.updateComponentTreeUI(this);
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
        Date nextyearToday  = (Date) calendar.getTime();
        for (int i = 0; i < basicDateName.length; i++) {
            basicData.add(setjLabel(basicDateName[i], i));
        }
        jTextFieldCarNo = new JTextField();
        jTextFieldCarNo.setBounds(120, 15, 175, 20);
        basicData.add(jTextFieldCarNo);
        jTextFieldOutFactoryNo = new JTextField();
        carClass = new JComboBox();
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

        YLFTime=setJSpinner(YLFTime,today);
        YLFTime.setBounds(120, 215, 175, 22);
        basicData.add(YLFTime);
        NSTime=setJSpinner(NSTime,today);
        NSTime.setBounds(120, 240, 175, 22);
        basicData.add(NSTime);
        BXTime=setJSpinner(BXTime,today);
        BXTime.setBounds(120, 265, 175, 22);
        basicData.add(BXTime);
        CCSTime=setJSpinner(CCSTime,today);
        CCSTime.setBounds(120, 290, 175, 22);
        basicData.add(CCSTime);
        LQPTime=setJSpinner(LQPTime,today);
        LQPTime.setBounds(120, 315, 175, 22);
        basicData.add(LQPTime);
        YYZTime=setJSpinner(YYZTime,today);
        YYZTime.setBounds(120, 340, 175, 22);
        basicData.add(YYZTime);
        GLFTime=setJSpinner(GLFTime,today);
        GLFTime.setBounds(120, 365, 175, 22);
        basicData.add(GLFTime);
        erBaoMils = new JTextField();
        erBaoMils.setBounds(120, 390, 175, 20);
        basicData.add(erBaoMils);

        buyyingTime=setJSpinner(buyyingTime,today);
        buyyingTime.setBounds(385, 15, 175, 22);
        basicData.add(buyyingTime);
        color = new JComboBox();
        color.setBounds(385, 40, 175, 22);
        basicData.add(color);
        enginerNo = new JTextField();
        enginerNo.setBounds(385, 65, 175, 20);
        basicData.add(enginerNo);
        seatNum = new JComboBox();
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

        YLFEndTime=setJSpinner(YLFEndTime,nextyearToday);
        YLFEndTime.setBounds(385, 215, 175, 22);
        basicData.add(YLFEndTime);
        NSEndTime=setJSpinner(NSEndTime,nextyearToday);
        NSEndTime.setBounds(385, 240, 175, 22);
        basicData.add(NSEndTime);
        BXEndTime=setJSpinner(BXEndTime,nextyearToday);
        BXEndTime.setBounds(385, 265, 175, 22);
        basicData.add(BXEndTime);
        CCSEndTime=setJSpinner(CCSEndTime,nextyearToday);
        CCSEndTime.setBounds(385, 290, 175, 22);
        basicData.add(CCSEndTime);
        LQPEndTime=setJSpinner(LQPEndTime,nextyearToday);
        LQPEndTime.setBounds(385, 315, 175, 22);
        basicData.add(LQPEndTime);
        YYZEndTime=setJSpinner(YYZEndTime,nextyearToday);
        YYZEndTime.setBounds(385, 340, 175, 22);
        basicData.add(YYZEndTime);
        GLFEndTime=setJSpinner(GLFEndTime,nextyearToday);
        GLFEndTime.setBounds(385, 365, 175, 22);
        basicData.add(GLFEndTime);
        nextErBao.setBounds(385, 390, 175, 20);
        basicData.add(nextErBao);
    }

    private JSpinner setJSpinner(JSpinner temp, Date tempDate){
        SpinnerDateModel model = new SpinnerDateModel();
        temp = new JSpinner(model);
        temp.setValue(tempDate);
        JSpinner.DateEditor edit = new JSpinner.DateEditor(temp, "yyyy-MM-dd");
        temp.setEditor(edit);
        return temp;
    }

    private JLabel setjLabel(String name, int i) {
        jLabel = new JLabel(name);
        jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel.setBounds(10 + 265 * (i / 16), 15 + 25 * (i % 16), 104, 20);
        return jLabel;
    }

    private void iniFrame() {
        this.setTitle("汽车档案编辑");
        this.setSize(680, 490);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
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
