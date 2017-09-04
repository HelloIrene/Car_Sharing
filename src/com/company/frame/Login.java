package com.company.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Component;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Create the frame.
	 */
	public Login() {
		try {
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 400, 385);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(270, 150, 70, 25);
		panel.add(comboBox);
//		List<String> uList = dao.deptName();
//		comboBox_1 = new JComboBox(uList.toArray(new String[uList.size()]));
		String[] s={"master","system","customer"};
		for(String dept:s){
			comboBox.addItem(dept);
		}
		
		textField = new JTextField();
		textField.setBounds(120, 150, 130, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u767B\u5F55\u540D\uFF1A");
		lblNewLabel.setBounds(60, 150, 55, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_1.setBounds(60, 200, 55, 25);
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 200, 130, 25);
		panel.add(passwordField);
		
		String path1 = "img/0.png";
        // ����ͼƬ  
        ImageIcon background1 = new ImageIcon(path1);  
        // �ѱ���ͼƬ��ʾ��һ����ǩ����  
        JLabel label1 = new JLabel(background1);  
        label1.setBounds(150, 5, 100, 120);
        panel.add(label1);
		
//		setSize(500, 400);  
//        //����λ��  
//        setLocation(200, 50);  
        //����ͼƬ��·���������·�����߾���·��������ͼƬ����"java��Ŀ��"���ļ��£�  
        String path = "img/2.png";
        // ����ͼƬ  
        ImageIcon background = new ImageIcon(path);  
        // �ѱ���ͼƬ��ʾ��һ����ǩ����  
        JLabel label = new JLabel(background);  
        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
        // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��  
        JPanel imagePanel = (JPanel) (this.getContentPane()); 
        imagePanel.setOpaque(false);
        panel.setOpaque(false); 
        // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        //���ÿɼ�  
        setVisible(true); 
        
        JButton btnNewButton = new JButton("\u767B\u5F55");
        btnNewButton.setBounds(100, 260, 60, 25);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
        btnNewButton_1.setBounds(210, 260, 60, 25);
        panel.add(btnNewButton_1);

	}
}
