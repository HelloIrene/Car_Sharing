package com.company.other;
import com.company.dao.CommonDAOImpl;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.text.DateFormatter;


public class ClientRegisterWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 3945786951241769598L;
	private JPanel mainPane; // �����
	private JLabel labelNeiBuNo;
	private JTextField txtNeibubianhao; // �ڲ����
	private JLabel labelClientNo;
	private JTextField textClientNo; // �ͻ����
	private JLabel labelClientName;
	private JTextField textField_ClientName; // �ͻ�����
	private JButton buttFindCilent; // ���ҿͻ�
	private JComboBox<String> comBoxCarNo; // ���ƺ�
	private JLabel labelCarNo;
	private JComboBox<String> comBoxIsExecute; // ִ�����
	private JLabel labelIsExecute;
	private JTextField txtPrice; // ���޵��ۣ�Ԫ/�죩
	private JLabel labelPrice;
	private JTextField txtAntecedentMoney; // Ѻ��
	private JLabel labelAntecedentMoney;
	private JTextField txtDepositReceived; // Ԥ�����
	private JLabel labelDepositReceived;
	private JTextField txtDeadline; // ��������
	private JLabel labelDeadline;
	private JTextField txtOverJourneyPrice; // ��ʻ�շѣ�Ԫ/���
	private JLabel labelOverJourneyPrice;
	private JTextField txtLimitJourney; // ÿ����ʻ���
	private JLabel labelLimitJourney;
	private JTextField txtOverHourPrice; // �����շѣ�Ԫ/Сʱ��
	private JLabel labelOverHourPrice;
	private JComboBox<String> comBoxOperator; // ������
	private JLabel labelOperator;
	private JTextField txtDateTime; // Ԥ������
	private JLabel labelDateTime;
	private JLabel labelJspYudingTime; // Ԥ��ʱ��
	private JSpinner jspYudingTime;
	private JLabel labelRemark;
	private JTextArea txtAreaRemark; // ��ע

	private JButton buttAdd; // ����
	private JButton buttSave; // ����
	private JButton buttCancel; // ȡ��
	private JButton buttReturn; // ����

	public ClientRegisterWindow() {
		iniClientJFrame();
		labelNeiBuNo = new JLabel("�ڲ����:");
		labelNeiBuNo.setBounds(12, 25, 60, 12);
		txtNeibubianhao = new JTextField();
		txtNeibubianhao.setBounds(labelNeiBuNo.getX() + labelNeiBuNo.getWidth() + 5, labelNeiBuNo.getY() - 4, 120, 23);

		labelClientNo = new JLabel("�ͻ����:");
		labelClientNo.setBounds(txtNeibubianhao.getX() + txtNeibubianhao.getWidth() + 10, labelNeiBuNo.getY(), 60, 12);
		textClientNo = new JTextField();
		textClientNo.setBounds(labelClientNo.getX() + labelClientNo.getWidth() + 5, txtNeibubianhao.getY(), 120, 23);

		labelClientName = new JLabel("�ͻ�����:");
		labelClientName.setBounds(textClientNo.getX() + textClientNo.getWidth() + 10, labelNeiBuNo.getY(), 60, 12);
		textField_ClientName = new JTextField();
		textField_ClientName.setBounds(labelClientName.getX() + labelClientName.getWidth() + 5, txtNeibubianhao.getY(),
				120, 23);

		buttFindCilent = new JButton("����");
		buttFindCilent.setBounds(610, textField_ClientName.getY(), 78, 23);
		buttFindCilent.addActionListener(this);

		labelCarNo = new JLabel("���ƺ�:");
		labelCarNo.setHorizontalAlignment(JLabel.RIGHT);
		labelCarNo.setBounds(15, 84, 120, 12);
		comBoxCarNo = new JComboBox<String>(); // ���ƺ�
		comBoxCarNo.setBounds(146, 80, 143, 23);
		List<String> temItem = new ArrayList<>();
		List<Tb_Cust_Yd> tempClient = new ArrayList<>();
		tempClient = new CommonDAOImpl().executeQuery(Tb_Cust_Yd.class, "select distinct Car_Id from tb_cust_yd", null);
		tempClient.forEach(a -> temItem.add(a.getCar_Id()));
		temItem.forEach(s -> comBoxCarNo.addItem(s));

		labelIsExecute = new JLabel("ִ�����:");
		labelIsExecute.setHorizontalAlignment(JLabel.RIGHT);
		labelIsExecute.setBounds(310, 84, 120, 12);
		comBoxIsExecute = new JComboBox<String>(); // ִ�����
		comBoxIsExecute.setBounds(441, 80, 143, 23);
		comBoxIsExecute.addItem("��");
		comBoxIsExecute.addItem("��");

		labelPrice = new JLabel("���޵��ۣ�Ԫ/�죩:");
		labelPrice.setHorizontalAlignment(JLabel.RIGHT);
		labelPrice.setBounds(15, 131, 120, 12);
		txtPrice = new JTextField(); // ���޵��ۣ�Ԫ/�죩
		txtPrice.setBounds(comBoxCarNo.getX(), comBoxCarNo.getY() + 46, 143, 23);

		labelAntecedentMoney = new JLabel("Ѻ��:");
		labelAntecedentMoney.setHorizontalAlignment(JLabel.RIGHT);
		labelAntecedentMoney.setBounds(310, 131, 120, 12);
		txtAntecedentMoney = new JTextField(); // Ѻ��
		txtAntecedentMoney.setBounds(comBoxIsExecute.getX(), comBoxIsExecute.getY() + 46, 143, 23);

		labelDepositReceived = new JLabel("Ԥ�����:");
		labelDepositReceived.setHorizontalAlignment(JLabel.RIGHT);
		labelDepositReceived.setBounds(15, 178, 120, 12);
		txtDepositReceived = new JTextField(); // Ԥ�����
		txtDepositReceived.setBounds(comBoxCarNo.getX(), txtPrice.getY() + 46, 143, 23);

		labelDeadline = new JLabel("��������:");
		labelDeadline.setHorizontalAlignment(JLabel.RIGHT);
		labelDeadline.setBounds(310, 178, 120, 12);
		txtDeadline = new JTextField(); // ��������
		txtDeadline.setBounds(comBoxIsExecute.getX(), txtAntecedentMoney.getY() + 46, 143, 23);

		labelOverJourneyPrice = new JLabel("��ʻ�շѣ�Ԫ/km��:");
		labelOverJourneyPrice.setHorizontalAlignment(JLabel.RIGHT);
		labelOverJourneyPrice.setBounds(15, 224, 120, 12);
		txtOverJourneyPrice = new JTextField(); // ��ʻ�շѣ�Ԫ/���
		txtOverJourneyPrice.setBounds(comBoxCarNo.getX(), txtDepositReceived.getY() + 46, 143, 23);

		labelLimitJourney = new JLabel("ÿ����ʻ���:");
		labelLimitJourney.setHorizontalAlignment(JLabel.RIGHT);
		labelLimitJourney.setBounds(310, 224, 120, 12);
		txtLimitJourney = new JTextField(); // ÿ����ʻ���
		txtLimitJourney.setBounds(comBoxIsExecute.getX(), txtDeadline.getY() + 46, 143, 23);

		labelOverHourPrice = new JLabel("�����շѣ�Ԫ/h��:");
		labelOverHourPrice.setHorizontalAlignment(JLabel.RIGHT);
		labelOverHourPrice.setBounds(15, 270, 120, 12);
		txtOverHourPrice = new JTextField(); // ��ʱ�շѣ�Ԫ/Сʱ��
		txtOverHourPrice.setBounds(comBoxCarNo.getX(), txtOverJourneyPrice.getY() + 46, 143, 23);

		labelOperator = new JLabel("������:");
		labelOperator.setHorizontalAlignment(JLabel.RIGHT);
		labelOperator.setBounds(310, 270, 120, 12);
		comBoxOperator = new JComboBox<>(); // ������
		comBoxOperator.setBounds(comBoxIsExecute.getX(), txtLimitJourney.getY() + 46, 143, 23);
		List<String> temItemOperator = new ArrayList<>();
		List<Tb_Cust_Yd> tempClient_1 = new ArrayList<>();
		tempClient_1 = new CommonDAOImpl().executeQuery(Tb_Cust_Yd.class, "select distinct Jinbanren from tb_cust_yd",
				null);
		tempClient_1.forEach(a -> temItemOperator.add(a.getCar_Id()));
		temItemOperator.forEach(s -> comBoxOperator.addItem(s));

		labelDateTime = new JLabel("Ԥ������:");
		labelDateTime.setHorizontalAlignment(JLabel.RIGHT);
		labelDateTime.setBounds(15, 316, 120, 12);
		txtDateTime = new JTextField(); // Ԥ������
		txtDateTime.setBounds(comBoxCarNo.getX(), txtOverHourPrice.getY() + 46, 143, 23);
		CalendarPanel p = new CalendarPanel(txtDateTime, "yyyy-MM-dd");
		p.initCalendarPanel();

		labelJspYudingTime = new JLabel("Ԥ��ʱ��:");
		labelJspYudingTime.setHorizontalAlignment(JLabel.RIGHT);
		labelJspYudingTime.setBounds(310, 316, 120, 12);
		SpinnerDateModel model = new SpinnerDateModel();
		jspYudingTime = new JSpinner(model);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(jspYudingTime, "HH:mm:ss");
		editor.getTextField().setHorizontalAlignment(JTextField.RIGHT);
		DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();
		formatter.setAllowsInvalid(false);
		jspYudingTime.setEditor(editor);
		jspYudingTime.setBounds(comBoxOperator.getX(), comBoxOperator.getY() + 46, 143, 23);

		labelRemark = new JLabel("��ע:");
		labelRemark.setHorizontalAlignment(JLabel.RIGHT);
		labelRemark.setBounds(15, 362, 120, 12);
		txtAreaRemark = new JTextArea();
		txtAreaRemark.setBounds(comBoxCarNo.getX(), txtDateTime.getY() + 46, 440, 70);

		buttAdd = new JButton("����(A)"); // ����
		buttAdd.setBounds(610, 200, 78, 22);
		buttAdd.addActionListener(this);

		buttSave = new JButton("����(S)"); // ����
		buttSave.setBounds(610, 250, 78, 22);
		buttSave.addActionListener(this);

		buttCancel = new JButton("ȡ��(C)"); // ȡ��
		buttCancel.setBounds(610, 300, 78, 22);
		buttCancel.addActionListener(this);

		buttReturn = new JButton("����(R)"); // ����
		buttReturn.setBounds(610, 350, 78, 22);
		buttReturn.addActionListener(this);

		mainPane = new JPanel(null);
		mainPane.add(labelNeiBuNo);
		mainPane.add(txtNeibubianhao);
		mainPane.add(labelClientNo);
		mainPane.add(textClientNo);
		mainPane.add(labelClientName);
		mainPane.add(textField_ClientName);
		mainPane.add(buttFindCilent);
		mainPane.add(labelCarNo);
		mainPane.add(comBoxCarNo);
		mainPane.add(labelIsExecute);
		mainPane.add(comBoxIsExecute);
		mainPane.add(labelPrice);
		mainPane.add(txtPrice);
		mainPane.add(labelAntecedentMoney);
		mainPane.add(txtAntecedentMoney);
		mainPane.add(labelDepositReceived);
		mainPane.add(txtDepositReceived);
		mainPane.add(labelDeadline);
		mainPane.add(txtDeadline);
		mainPane.add(labelOverJourneyPrice);
		mainPane.add(txtOverJourneyPrice);
		mainPane.add(labelLimitJourney);
		mainPane.add(txtLimitJourney);
		mainPane.add(labelOverHourPrice);
		mainPane.add(txtOverHourPrice);
		mainPane.add(labelOperator);
		mainPane.add(comBoxOperator);
		mainPane.add(labelDateTime);
		mainPane.add(p);
		mainPane.add(txtDateTime);
		mainPane.add(labelJspYudingTime);
		mainPane.add(jspYudingTime);
		mainPane.add(labelRemark);
		mainPane.add(txtAreaRemark);
		mainPane.add(buttAdd);
		mainPane.add(buttSave);
		mainPane.add(buttCancel);
		mainPane.add(buttReturn);
		this.add(mainPane);
	}

	private void iniClientJFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("img/car.png");
		this.setIconImage(img);
		this.setTitle("��������ϵͳ");
		this.setSize(710, 560);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttFindCilent) {
			String query = "select * from tb_cust_yd where Inner_Id = ?";
			List tempList = new ArrayList<>();
			String tempInnerId = txtNeibubianhao.getText();
			if (null != tempInnerId) {
				Integer tempId = Integer.parseInt(tempInnerId);
				tempList.add(tempInnerId);
				List<Tb_Cust_Yd> tempClientRe = new CommonDAOImpl().executeQuery(Tb_Cust_Yd.class, query, tempList);
				tempClientRe.forEach(a -> System.out.println(a.toString()));
				if (tempClientRe.size() > 0) {
					Tb_Cust_Yd tempT = tempClientRe.get(0);
					textClientNo.setText(tempT.getCustomer_Id());
					textField_ClientName.setText(tempT.getCustomer_Name());
					comBoxCarNo.setSelectedItem(tempT.getCar_Id());
					comBoxIsExecute.setSelectedIndex(tempT.getZhixing());
					txtPrice.setText("" + tempT.getZulin_Price());
					txtAntecedentMoney.setText("" + tempT.getYanjin());
					txtDepositReceived.setText("" + tempT.getPre_Zujin());
					txtDeadline.setText("" + tempT.getZulin_Qixian());
					txtOverJourneyPrice.setText("" + tempT.getChaoshi_Fee());
					txtLimitJourney.setText("" + tempT.getLicheng_Meitian());
					txtOverHourPrice.setText("" + tempT.getOutTime_Fee());
					comBoxOperator.setSelectedItem(tempT.getJinbanren());
					txtDateTime.setText("" + tempT.getYuding_Date());
					jspYudingTime.setValue(tempT.getYuding_Time());
					txtAreaRemark.setText(tempT.getDemo());
				} else {
					JOptionPane.showMessageDialog(this, "ƥ��ʧ�ܣ�����", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "�ڲ����벻��Ϊ�գ�����", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if (e.getSource() == buttAdd) {
			Tb_Cust_Yd clientRegister = new Tb_Cust_Yd();
			clientRegister.setCustomer_Id(textClientNo.getText());
			clientRegister.setCustomer_Name(textField_ClientName.getText());
			clientRegister.setCar_Id((String) comBoxCarNo.getSelectedItem());
			clientRegister.setZhixing(comBoxIsExecute.getSelectedIndex());
			clientRegister.setZulin_Price(Long.parseLong(txtPrice.getText()));
			clientRegister.setYanjin(Integer.parseInt(txtAntecedentMoney.getText()));
			clientRegister.setPre_Zujin(Integer.parseInt(txtDepositReceived.getText()));
			clientRegister.setZulin_Qixian(Integer.parseInt(txtDeadline.getText()));
			clientRegister.setChaoshi_Fee(Integer.parseInt(txtOverJourneyPrice.getText()));
			clientRegister.setLicheng_Meitian(Integer.parseInt(txtLimitJourney.getText()));
			clientRegister.setOutTime_Fee(Integer.parseInt(txtOverHourPrice.getText()));
			clientRegister.setJinbanren((String) comBoxOperator.getSelectedItem());
			clientRegister.setYuding_Date(txtDateTime.getText());
			clientRegister.setYuding_Time((Date) jspYudingTime.getValue());
			clientRegister.setDemo(txtAreaRemark.getText());
			int row = new CommonDAOImpl().add(clientRegister);
			if (row > 0) {
				JOptionPane.showMessageDialog(this, "��ӳɹ�������", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "���ʧ�ܣ�����", "��Ϣ", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == buttSave) {
			String tempInn = txtNeibubianhao.getText();
			Integer temId = Integer.valueOf(Integer.parseInt(tempInn));
			if (null != tempInn) {
				Tb_Cust_Yd clientRegister = new Tb_Cust_Yd();
				clientRegister.setInner_Id(temId);
				clientRegister.setCustomer_Id(textClientNo.getText());
				clientRegister.setCustomer_Name(textField_ClientName.getText());
				clientRegister.setCar_Id((String) comBoxCarNo.getSelectedItem());
				clientRegister.setZhixing(comBoxIsExecute.getSelectedIndex());
				clientRegister.setZulin_Price(Integer.parseInt(txtPrice.getText()));
				clientRegister.setYanjin(Integer.parseInt(txtAntecedentMoney.getText()));
				clientRegister.setPre_Zujin(Integer.parseInt(txtDepositReceived.getText()));
				clientRegister.setZulin_Qixian(Integer.parseInt(txtDeadline.getText()));
				clientRegister.setChaoshi_Fee(Integer.parseInt(txtOverJourneyPrice.getText()));
				clientRegister.setLicheng_Meitian(Integer.parseInt(txtLimitJourney.getText()));
				clientRegister.setOutTime_Fee(Integer.parseInt(txtOverHourPrice.getText()));
				clientRegister.setJinbanren((String) comBoxOperator.getSelectedItem());
				clientRegister.setYuding_Date(txtDateTime.getText());
				clientRegister.setYuding_Time((Date) jspYudingTime.getValue());
				clientRegister.setDemo(txtAreaRemark.getText());
				new CommonDAOImpl().update(clientRegister);
			} else {
				JOptionPane.showMessageDialog(this, "�ڲ����벻��Ϊ�գ�����", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if (e.getSource() == buttCancel) {
			textClientNo.setText("");
			textField_ClientName.setText("");
			comBoxCarNo.setSelectedItem("");
			comBoxIsExecute.setSelectedItem("");
			txtPrice.setText("");
			txtAntecedentMoney.setText("");
			txtDepositReceived.setText("");
			txtDeadline.setText("");
			txtOverJourneyPrice.setText("");
			txtLimitJourney.setText("");
			txtOverHourPrice.setText("");
			comBoxOperator.setSelectedItem("");
			txtDateTime.setText("");
			jspYudingTime.setValue("");
			txtAreaRemark.setText("");
		}
		if (e.getSource() == buttReturn) {
			this.dispose();
		}
	}

}
