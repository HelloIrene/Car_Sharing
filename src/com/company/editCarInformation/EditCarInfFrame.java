package com.company.editCarInformation;

import com.company.changSkin.ChaneSkin;
import com.company.dao.CommonDAOImpl;
import com.company.entity.CarInformation;
import org.apache.poi.hssf.usermodel.*;

import javax.swing.*;
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
import java.util.Date;
import java.util.Calendar;
import java.util.Properties;

/**
 * @author student Ross
 * @2017��8��30��
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
    private JSpinner buyyingTime;//����ʱ��
    private JSpinner YLFTime;   //��·��
    private JSpinner YLFEndTime;
    private JSpinner NSTime;    //����
    private JSpinner NSEndTime;
    private JSpinner BXTime;    //����
    private JSpinner BXEndTime;
    private JSpinner CCSTime;   //����˰
    private JSpinner CCSEndTime;
    private JSpinner LQPTime;   //·��Ʊ
    private JSpinner LQPEndTime;
    private JSpinner YYZTime;   //��Ӫ֤
    private JSpinner YYZEndTime;
    private JSpinner GLFTime;   //�����
    private JSpinner GLFEndTime;

    private JLabel jLabel;
    private String[] carTyle = {"С�γ�", "�аͳ�", "�󿨳�"};
    private String[] carColor = {"��", "��", "��"};
    private String[] carSeat = {"4", "5", "6", "7"};
    private String[] basicDateName = {
            "���ƺţ�", "���ͣ�", "������ţ�", "���̱�ţ�", "����۸�", "���Ʒѣ�", "����������", "��ʼ��������"
            , "��·�ѹ���ʱ�䣺", "����ʱ�䣺", "���չ���ʱ�䣺", "����˰����ʱ�䣺", "·��Ʊ����ʱ�䣺", "��Ӫ֤����ʱ�䣺", "��Ӫ�ѹ���ʱ�䣺", "������̣�"
            , "����ʱ�䣺", "��ɫ��", "�������ţ�", "��λ����", "����˰��", "����װ�Σ�", "��ϵ�绰��", "��ǰ��������"
            , "��ֹʱ�䣺", "��ֹʱ�䣺", "��ֹʱ�䣺", "��ֹʱ�䣺", "��ֹʱ�䣺", "��ֹʱ�䣺", "��ֹʱ�䣺", "�´ζ�����"};

    public EditCarInfFrame() {
        iniFrame();
        iniBody();
        this.add(mianBody);
    }

    private void iniBody() {
        mianBody = new JPanel();
        mianBody.setLayout(null);
        jCheckBox = new JCheckBox("ͣ��");
        jCheckBox.setBounds(585, 50, 60, 20);
        jButtonPrint = new JButton("��ӡ����");
        jButtonPrint.setBounds(585, 210, 84, 40);
        jButtonPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Properties p = new Properties();
                PrintJob jp = Toolkit.getDefaultToolkit().getPrintJob(EditCarInfFrame.this, "�ͻ��ǼǱ�༭", p);
                Graphics pg = jp.getGraphics();//Graphics��ӡͼ�ε�ͼ�λ���
                if (pg != null) {
                    try {
                        EditCarInfFrame.this.printAll(pg); //��ӡ�ô��弰�����е����
                    } finally {
                        pg.dispose(); //ע��ͼ�λ���
                    }
                }
                jp.end(); //������ӡ��ҵ
            }
        });

        jButtonDesgin = new JButton("��Ƶ���");
        jButtonDesgin.setBounds(585, 250, 84, 40);
        jButtonDesgin.addActionListener(new ActionListener() {
            @Override
            //ʵ���Ƥ����������
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(EditCarInfFrame.this, "", "!!!", JOptionPane.OK_OPTION);
            }
        });
        jButtonAdd = new JButton("����(A)");
        jButtonAdd.setBounds(585, 290, 84, 40);
        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO finish
                if (commonDAO.searchClo(jTextFieldCarNo.getText(), "tb_car", "Car_Id")) {
                    JOptionPane.showMessageDialog(EditCarInfFrame.this, "���˻���������û�б���", "!!!", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                commonDAO.add2(getPanelINf(), "tb_car");
            }
        });
        jButtonSave = new JButton("����(S)");
        jButtonSave.setBounds(585, 330, 84, 40);
        jButtonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commonDAO.update2(getPanelINf(), "tb_car");
            }
        });
        jButtonCancel = new JButton("ȡ��(C)");
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
        jButtonBack = new JButton("����(R)");
        jButtonBack.setBounds(585, 410, 84, 40);
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        iniTabbedPanel();

        jButtonChangeSkin = new JButton("����");
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

    //�������������ƣ���Ҫ����´���
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
        jTabbedPane.addTab("��������", null, basicData, "��������");
        carInf = new JPanel();
        carInf.setBorder(BorderFactory.createEtchedBorder());
        jTabbedPane.addTab("������Ƭ", null, carInf, "��Ƭ");
        demo = new JPanel();
        demo.setBorder(BorderFactory.createEtchedBorder());
        jTabbedPane.addTab("��ע", null, demo, "��ע");
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

    private void saveASExcel() {
        // ��һ��������һ��webbook����Ӧһ��Excel�ļ�
        HSSFWorkbook wb = new HSSFWorkbook();
        // �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
        HSSFSheet sheet = wb.createSheet("ѧ����һ");
        // ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
        HSSFRow row = sheet.createRow((int) 0);
        // ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ

        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("ѧ��");
        cell.setCellStyle(style);
        cell = row.createCell((short) 1);
        cell.setCellValue("����");
        cell.setCellStyle(style);
        cell = row.createCell((short) 2);
        cell.setCellValue("����");
        cell.setCellStyle(style);
        cell = row.createCell((short) 3);
        cell.setCellValue("����");
        cell.setCellStyle(style);

        //TODO ����excel�ļ�
        // ���岽��д��ʵ������ ʵ��Ӧ������Щ���ݴ����ݿ�õ���
        List<CarInformation> list = commonDAO.getAllInfFormTb_car("tb_car");

        for (int i = 0; i < list.size(); i++)
        {
            row = sheet.createRow((int) i + 1);
            CarInformation stu = (CarInformation) list.get(i);
            // ���Ĳ���������Ԫ�񣬲�����ֵ
            row.createCell((short) 0).setCellValue((double) stu.getCode());
            row.createCell((short) 1).setCellValue(stu.getName());
            row.createCell((short) 2).setCellValue((double) stu.getAge());
            cell = row.createCell((short) 3);
            cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu
                    .getBirth()));
        }
    }

    private void saveFile() {
        JFileChooser jfc = new JFileChooser();
        jfc.showSaveDialog(EditCarInfFrame.this);
        try {
            File file = jfc.getSelectedFile();
            FileOutputStream fout = new FileOutputStream(file);
            wb.write(fout);
            fout.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void iniFrame() {
        this.setTitle("���������༭");
        this.setSize(680, 490);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        skin = true;
//        try {
//            //UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
//            //Darcula������Ի���
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
