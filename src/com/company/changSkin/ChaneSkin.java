package com.company.changSkin;

import javax.swing.*;

public class ChaneSkin extends JFrame {
    public ChaneSkin() {
        iniFrame();
    }

    public void iniFrame() {
        this.setTitle("����");
        this.setSize(400, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        try {
            //UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
            //Darcula�������ͳһ��
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
