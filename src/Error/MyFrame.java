package Error;

import java.awt.*;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;

public class MyFrame extends JFrame{

	/**
	 * @author student Irene
	 * @2017��8��30��
	 */
	//private static final long serialVersionUID = -7683754515231853118L;
	private JTextField clientId;
	private JTextField clientName;
	private JPasswordField clientPassword;
	private JTextField clientIdentityCardId;
	private JTextField clientTel;
	private JTextField clientPhone;
	private JTextField clientHomeAdd;
	private JTextField clientWorkUnit;
	private JTextField clientUnitAdd;
	private JTextField yingShouMembershipFee;
	private JTextField shiShouMembershipFee;
	
	private JPanel panel;
	private JTabbedPane showInfo;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MyFrame().setVisible(true);
			}
		});
	}
	public MyFrame(){
		initFrame();
	}
	
	public void initBody(){
		panel = new JPanel();
//		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);//ָ��Ϊ�ղ���
		top();
		button();
		showit();
	}
	
	public void top(){		
		JLabel lblNewLabel = new JLabel("�ͻ��ţ�");
		lblNewLabel.setBounds(10, 10, 73, 15);
		panel.add(lblNewLabel);
		
		clientId = new JTextField();
		clientId.setBounds(60, 7, 111, 21);
		panel.add(clientId);
		clientId.setColumns(10);
		
		JLabel label = new JLabel("��ʼ���ڣ�");
		label.setBounds(181, 10, 73, 15);
		panel.add(label);
		
		JComboBox startDateComboBox = new JComboBox();
		startDateComboBox.setBounds(243, 7, 111, 21);
		panel.add(startDateComboBox);
		
		JLabel label_1 = new JLabel("��ֹ���ڣ�");
		label_1.setBounds(364, 10, 73, 15);
		panel.add(label_1);
		
		JComboBox expiryDateComboBox = new JComboBox();
		expiryDateComboBox.setBounds(428, 7, 111, 21);
		panel.add(expiryDateComboBox);
		
		JCheckBox stopUse = new JCheckBox("ͣ��");
		stopUse.setBounds(561, 6, 54, 23);
		panel.add(stopUse);
	}
	
	public void button(){
		JButton btnReturn = new JButton("����(R)");
		btnReturn.setBounds(550, 406, 93, 23);
		panel.add(btnReturn);
		
		JButton btnCancle = new JButton("ȡ��(C)");
		btnCancle.setBounds(550, 370, 93, 23);
		panel.add(btnCancle);
		
		JButton btnCunPan = new JButton("����(S)");
		btnCunPan.setBounds(550, 337, 93, 23);
		panel.add(btnCunPan);
		
		JButton btnAdd = new JButton("����(A)");
		btnAdd.setBounds(550, 301, 93, 23);
		panel.add(btnAdd);
		
		JButton btnReplace = new JButton("�滻(T)");
		btnReplace.setBounds(550, 268, 93, 23);
		panel.add(btnReplace);
		
		JButton btnDesign = new JButton("��Ƶ���");
		btnDesign.setBounds(550, 233, 93, 23);
		panel.add(btnDesign);
		
		JButton btnPrint = new JButton("��ӡ����");
		btnPrint.setBounds(550, 201, 93, 23);
		panel.add(btnPrint);
	}
	
	public void showit(){
		showInfo = new JTabbedPane();//չʾ��Ϣ�ĸ��ϴ���
		showInfo.setBounds(10, 47, 530, 395);
		
		clientInfo();
		driverInfo();
		bondsmanInfo();
		companyInfo();
		photo();
		panel.add(showInfo);
	}
	
	public void clientInfo(){
		JPanel panel_1 = new JPanel();
		showInfo.addTab("�ͻ�����", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_2 = new JLabel("������");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(10, 10, 96, 15);
		panel_1.add(label_2);
		
		clientName = new JTextField();
		clientName.setBounds(116, 7, 114, 21);
		panel_1.add(clientName);
		clientName.setColumns(10);
		
		JLabel label_3 = new JLabel("�Ա�");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(240, 10, 73, 15);
		panel_1.add(label_3);
		
		JComboBox clientGenderComboBox = new JComboBox();
		clientGenderComboBox.setBounds(323, 7, 96, 21);
		panel_1.add(clientGenderComboBox);
		
		JLabel lblD = new JLabel("�ͻ����ͣ�");
		lblD.setHorizontalAlignment(SwingConstants.RIGHT);
		lblD.setBounds(10, 41, 96, 15);
		panel_1.add(lblD);
		
		JComboBox clientTypeComboBox = new JComboBox();
		clientTypeComboBox.setBounds(116, 38, 114, 21);
		panel_1.add(clientTypeComboBox);
		
		JLabel label_4 = new JLabel("���룺");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(240, 41, 73, 15);
		panel_1.add(label_4);
		
		clientPassword = new JPasswordField();
		clientPassword.setBounds(323, 38, 97, 21);
		panel_1.add(clientPassword);
		
		JLabel label_5 = new JLabel("������֤ʱ�䣺");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(10, 80, 96, 15);
		panel_1.add(label_5);
		
		JComboBox firstGetPapersDate = new JComboBox();
		firstGetPapersDate.setBounds(116, 77, 114, 21);
		panel_1.add(firstGetPapersDate);
		
		JLabel label_6 = new JLabel("׼�����ͣ�");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(240, 80, 73, 15);
		panel_1.add(label_6);
		
		JComboBox drivingType = new JComboBox();
		drivingType.setBounds(323, 77, 96, 21);
		panel_1.add(drivingType);
		
		JLabel label_7 = new JLabel("���֤�ţ�");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(10, 119, 96, 15);
		panel_1.add(label_7);
		
		clientIdentityCardId = new JTextField();
		clientIdentityCardId.setBounds(116, 116, 303, 21);
		panel_1.add(clientIdentityCardId);
		clientIdentityCardId.setColumns(10);
		
		JLabel label_8 = new JLabel("��ϵ�绰��");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(10, 154, 96, 15);
		panel_1.add(label_8);
		
		clientTel = new JTextField();
		clientTel.setBounds(116, 151, 303, 21);
		panel_1.add(clientTel);
		clientTel.setColumns(10);
		
		JLabel label_9 = new JLabel("�ƶ��绰��");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(10, 192, 96, 15);
		panel_1.add(label_9);
		
		clientPhone = new JTextField();
		clientPhone.setBounds(116, 189, 303, 21);
		panel_1.add(clientPhone);
		clientPhone.setColumns(10);
		
		JLabel label_10 = new JLabel("��ͥסַ��");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(10, 228, 96, 15);
		panel_1.add(label_10);
		
		clientHomeAdd = new JTextField();
		clientHomeAdd.setBounds(116, 225, 303, 21);
		panel_1.add(clientHomeAdd);
		clientHomeAdd.setColumns(10);
		
		JLabel label_11 = new JLabel("������λ��");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setBounds(10, 267, 96, 15);
		panel_1.add(label_11);
		
		clientWorkUnit = new JTextField();
		clientWorkUnit.setBounds(116, 264, 303, 21);
		panel_1.add(clientWorkUnit);
		clientWorkUnit.setColumns(10);
		
		JLabel label_12 = new JLabel("��λ��ַ��");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setBounds(10, 302, 96, 15);
		panel_1.add(label_12);
		
		clientUnitAdd = new JTextField();
		clientUnitAdd.setBounds(116, 299, 303, 21);
		panel_1.add(clientUnitAdd);
		clientUnitAdd.setColumns(10);
		
		JLabel label_13 = new JLabel("Ӧ�ջ�ѣ�");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setBounds(10, 341, 96, 15);
		panel_1.add(label_13);
		
		yingShouMembershipFee = new JTextField();
		yingShouMembershipFee.setBounds(116, 338, 114, 21);
		panel_1.add(yingShouMembershipFee);
		yingShouMembershipFee.setColumns(10);
		
		JLabel label_14 = new JLabel("ʵ�ջ�ѣ�");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setBounds(240, 341, 73, 15);
		panel_1.add(label_14);
		
		shiShouMembershipFee = new JTextField();
		shiShouMembershipFee.setBounds(323, 338, 96, 21);
		panel_1.add(shiShouMembershipFee);
		shiShouMembershipFee.setColumns(10);
	}
	
	public void driverInfo(){
		JPanel panel_2 = new JPanel();
		showInfo.addTab("��ʻԱ����", null, panel_2, null);
		panel_2.setLayout(null);
	}
	
	public void bondsmanInfo(){
		JPanel panel_3 = new JPanel();
		showInfo.addTab("����������", null, panel_3, null);
		panel_3.setLayout(null);
	}
	
	public void companyInfo(){
		JPanel panel_4 = new JPanel();
		showInfo.addTab("��ҵ����", null, panel_4, null);
		panel_4.setLayout(null);
	}
	
	public void photo(){
		JPanel panel_5 = new JPanel();
		showInfo.addTab("��Ƭ", null, panel_5, null);
		panel_5.setLayout(null);
	}
	
	public void initFrame(){
		this.setTitle("�ͻ��ǼǱ�༭");
		this.setSize(680, 490);// �����ı����С
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		 try {
	            //UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
	            //DarculaLaf�������ͳһ��
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
		// initBody();
		 //this.add(panel);
	}
	
}
