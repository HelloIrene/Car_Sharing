package com.company.editCarInformation;

import javax.swing.*;
import java.awt.*;

/**
 * @author student Ross
 * @2017年8月30日
 */
public class EditCarInfFrame extends JFrame {
    private JPanel mianBody;
    private JTabbedPane jTabbedPane;
    private String[] jTabbedPaneName = {"基本资料", "车辆照片", "备注"};
    private JPanel basicData;
    private JPanel carInf;
    private JPanel demo;
    private JButton jButton;

    private JLabel jLabel;

    public EditCarInfFrame() {
        mianBody = new JPanel();
        mianBody.setLayout(null);
        mianBody.setBackground(Color.DARK_GRAY);
        iniFrame();
        iniTabbedPanel();
        mianBody.add(jTabbedPane);
        this.add(mianBody);
    }

    private void iniTabbedPanel() {
        jTabbedPane = new JTabbedPane();
//        jTabbedPane.setMargin()
        jTabbedPane.setBounds(5, 5, 580, 452);
//        jTabbedPane.setBorder(BorderFactory.createRaisedBevelBorder());
        basicData = new JPanel();
        basicData.add(jButton);
        basicData.setBorder(BorderFactory.createEtchedBorder());
        jTabbedPane.addTab(jTabbedPaneName[0], null, basicData, "基本资料");
        carInf = new JPanel();
        jTabbedPane.addTab(jTabbedPaneName[1], null, carInf, "照片");
        demo = new JPanel();
        jTabbedPane.addTab(jTabbedPaneName[2], null, demo, "备注");
    }

    private void iniFrame() {
        this.setTitle("汽车档案编辑");
        this.setSize(680, 490);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
            //DarculaLaf主题最后统一换
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
}
