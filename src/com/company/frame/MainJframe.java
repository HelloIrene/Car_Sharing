package com.company.frame;

import com.company.dao.CommonDAOImpl;
import com.company.editCarInformation.EditCarInfFrame;
import com.company.entity.LoginIdentity;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;

public class MainJframe extends JFrame {
    //todo 导入身份权限后的相应限制
    private static final long serialVersionUID = 4745675222291465223L;
    private JPanel contentPane;
    private CommonDAOImpl commonDAO;
    private LoginIdentity users;
    private int idIdentify;
    /**
     * Create the frame.
     */
    public MainJframe(int inputidIdentify) {
        idIdentify=inputidIdentify;
        try {
            //UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setResizable(false);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u7EF4\u62A4\uFF08S\uFF09");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("\u6570\u636E\u521D\u59CB\u5316");
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u64CD\u4F5C\u4EBA\u5458\u66F4\u6539");
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenu mnNewMenu_1 = new JMenu("\u65E5\u5E38\u4E1A\u52A1\uFF08R\uFF09");
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u8F66\u8F86\u6863\u6848\u7BA1\u7406");
        mnNewMenu_1.add(mntmNewMenuItem_2);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5BA2\u6237\u8D44\u6599\u7BA1\u7406");
        mnNewMenu_1.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u5BA2\u6237\u9884\u5B9A\u767B\u8BB0");
        mnNewMenu_1.add(mntmNewMenuItem_4);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u6C7D\u8F66\u79DF\u8D41\u767B\u8BB0");
        mnNewMenu_1.add(mntmNewMenuItem_5);

        JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u6C7D\u8F66\u79DF\u8D41\u7ED3\u7B97");
        mnNewMenu_1.add(mntmNewMenuItem_6);

        JMenu mnNewMenu_2 = new JMenu("\u5176\u4ED6\u4E1A\u52A1\uFF08Q\uFF09");
        menuBar.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u8F66\u8F86\u7EF4\u4FEE\u767B\u8BB0");
        mnNewMenu_2.add(mntmNewMenuItem_7);

        JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u8F66\u8F86\u8FDD\u7AE0\u767B\u8BB0");
        mnNewMenu_2.add(mntmNewMenuItem_8);

        JMenu mnNewMenu_3 = new JMenu("\u7EDF\u8BA1\u5206\u6790\uFF08T\uFF09");
        menuBar.add(mnNewMenu_3);

        JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u8F66\u8F86\u79DF\u8D41\u7EDF\u8BA1");
        mnNewMenu_3.add(mntmNewMenuItem_9);

        JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u5BA2\u6237\u79DF\u8D41\u7EDF\u8BA1");
        mnNewMenu_3.add(mntmNewMenuItem_10);

        JMenu mnNewMenu_4 = new JMenu("\u5E2E\u52A9\uFF08H\uFF09");
        menuBar.add(mnNewMenu_4);

        JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u5E2E\u52A9");
        mnNewMenu_4.add(mntmNewMenuItem_11);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JToolBar toolBar = new JToolBar();
        contentPane.add(toolBar, BorderLayout.NORTH);

        JButton btnNewButton = new JButton("\u4FEE\u6539\u5BC6\u7801");
        btnNewButton.setIcon(new ImageIcon(
                "img/password_manager.png"));
        Border border = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        btnNewButton.setBorder(border);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainJframe.ChangePassword().setVisible(true);
            }
        });
        toolBar.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u8F66\u8F86\u6863\u6848");
        btnNewButton_1.setIcon(
                new ImageIcon("img/carfile.png"));
        btnNewButton_1.setBorder(border);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditCarInfFrame(idIdentify).setVisible(true);
            }
        });
        toolBar.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("\u5BA2\u6237\u8D44\u6599");
        btnNewButton_2.setIcon(
                new ImageIcon("img/customer.png"));
        btnNewButton_2.setBorder(border);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyFrame(idIdentify).setVisible(true);
            }
        });
        toolBar.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("\u5BA2\u6237\u9884\u8BA2");
        btnNewButton_3.setIcon(
                new ImageIcon("img/Order.png"));
        btnNewButton_3.setBorder(border);
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientRegisterWindow(idIdentify).setVisible(true);
            }
        });
        toolBar.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("\u79DF\u8D41\u767B\u8BB0");
        btnNewButton_4.setIcon(
                new ImageIcon("img/register.png"));
        btnNewButton_4.setBorder(border);
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new RegisterFrame().setVisible(true);
            }
        });
        toolBar.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("\u79DF\u8D41\u7ED3\u7B97");
        btnNewButton_5.setIcon(
                new ImageIcon("img/dollar.png"));
        btnNewButton_5.setBorder(border);
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CarSettlement().setVisible(true);
            }
        });
        toolBar.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("\u65E5\u8BB0\u8D26");
        btnNewButton_6.setIcon(
                new ImageIcon("img/accounting.png"));
        btnNewButton_6.setBorder(border);
        toolBar.add(btnNewButton_6);

        JButton btnNewButton_7 = new JButton("\u63D0\u9192\u529F\u80FD");
        btnNewButton_7.setIcon(
                new ImageIcon("img/remind.png"));
        btnNewButton_7.setBorder(border);
        toolBar.add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("\u9000\u51FA");
        btnNewButton_8.setIcon(
                new ImageIcon("img/sign_out.png"));
        btnNewButton_8.setBorder(border);
        btnNewButton_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        toolBar.add(btnNewButton_8);

        JPanel panel_1 = new MyPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
    }

    class MyPanel extends JPanel {
        Image image = null;

        public void paint(Graphics g) {
            try {
                image = ImageIO.read(new File("img/carPanl.png"));
                g.drawImage(image, 10, 10, 670, 450, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class ChangePassword extends JDialog {
        public ChangePassword() {
            setTitle("修改密码");
            setLocationRelativeTo(null);
            setSize(250, 225);
            setResizable(false);
            setModal(true);
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(null);
            JLabel jLabel = new JLabel("用户名:");
            jLabel.setBounds(30, 30, 150, 25);
            mainPanel.add(jLabel);
            JLabel jLabelold = new JLabel("旧密码:");
            jLabelold.setBounds(30, 70, 150, 25);
            mainPanel.add(jLabelold);
            JLabel jLabelNew = new JLabel("新密码:");
            jLabelNew.setBounds(30, 110, 150, 25);
            mainPanel.add(jLabelNew);

            JTextField jTextFielduserName = new JTextField();
            jTextFielduserName.setBounds(75, 30, 150, 20);
            JPasswordField jTextFieldOldPassword = new JPasswordField();
            jTextFieldOldPassword.setBounds(75, 70, 150, 20);
            JPasswordField jTextFieldNewPassword = new JPasswordField();
            jTextFieldNewPassword.setBounds(75, 110, 150, 20);
            mainPanel.add(jTextFielduserName);
            mainPanel.add(jTextFieldOldPassword);
            mainPanel.add(jTextFieldNewPassword);

            JButton isConfirm = new JButton("确定");
            isConfirm.setBounds(75, 145, 84, 40);
            isConfirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    commonDAO = new CommonDAOImpl();
                    if (!(commonDAO.searchClo(jTextFielduserName.getText(), "user_customer", "user_id"))) {
                        JOptionPane.showMessageDialog(ChangePassword.this, "没有此用户！", "提示！", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else if(commonDAO.isPasswordRight(new String(jTextFieldOldPassword.getPassword()),jTextFielduserName.getText())){
                        if (commonDAO.updatePassword(new String(jTextFieldNewPassword.getPassword()), jTextFielduserName.getText()) != 0) {
                            JOptionPane.showMessageDialog(ChangePassword.this, "修改成功！", "提示！", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(ChangePassword.this, "修改失败！", "提示！", JOptionPane.WARNING_MESSAGE);
                        }
                    }else {
                        JOptionPane.showMessageDialog(ChangePassword.this, "密码错误！", "提示！", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            mainPanel.add(isConfirm);
            this.add(mainPanel);
        }
    }
}
