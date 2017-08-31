package com.company.changSkin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ChaneSkin extends JFrame {
    public boolean skin = true;
    private JRadioButton normal;
    private JRadioButton darcula;

    public ChaneSkin() {
        iniFrame();
        JPanel mainJPanel = new MyPanel();
        mainJPanel.setLayout(null);
        normal = new JRadioButton("默认");
        normal.setBounds(75, 150, 80, 20);
        normal.setVisible(true);
        mainJPanel.add(normal);
        darcula = new JRadioButton("Darcula");
        darcula.setBounds(275, 150, 80, 20);
        darcula.setVisible(true);
        mainJPanel.add(darcula);
        ButtonGroup group = new ButtonGroup();
        group.add(normal);
        group.add(darcula);

        this.add(mainJPanel);
    }

    private void setSkin() {
        try {
            //UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
            //Darcula主题与系统默认主题
            if (skin) {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } else {
                UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
            }
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

    public void iniFrame() {
        this.setTitle("换肤");
        this.setSize(400, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setSkin();
    }

    class MyPanel extends JPanel {
        Image image = null;
        Image image2 = null;

        public void paint(Graphics g) {
            try {
                image = ImageIO.read(new File("img/SystemLookNFeel.png"));
                image2 = ImageIO.read(new File("img/DarLookNFeel.png"));
                g.drawImage(image, 10, 10, 186, 131, null);
                g.drawImage(image2, 200, 10, 186, 131, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}