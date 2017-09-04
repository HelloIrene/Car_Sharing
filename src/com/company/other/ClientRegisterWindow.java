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
	private JPanel mainPane; // 主面板
	private JLabel labelNeiBuNo;
	private JTextField txtNeibubianhao; // 内部编号
	private JLabel labelClientNo;
	private JTextField textClientNo; // 客户编号
	private JLabel labelClientName;
	private JTextField textField_ClientName; // 客户姓名
	private JButton buttFindCilent; // 查找客户
	private JComboBox<String> comBoxCarNo; // 车牌号
	private JLabel labelCarNo;
	private JComboBox<String> comBoxIsExecute; // 执行完毕
	private JLabel labelIsExecute;
	private JTextField txtPrice; // 租赁单价（元/天）
	private JLabel labelPrice;
	private JTextField txtAntecedentMoney; // 押金
	private JLabel labelAntecedentMoney;
	private JTextField txtDepositReceived; // 预收租金
	private JLabel labelDepositReceived;
	private JTextField txtDeadline; // 租赁期限
	private JLabel labelDeadline;
	private JTextField txtOverJourneyPrice; // 超驶收费（元/公里）
	private JLabel labelOverJourneyPrice;
	private JTextField txtLimitJourney; // 每天限驶里程
	private JLabel labelLimitJourney;
	private JTextField txtOverHourPrice; // 超市收费（元/小时）
	private JLabel labelOverHourPrice;
	private JComboBox<String> comBoxOperator; // 经办人
	private JLabel labelOperator;
	private JTextField txtDateTime; // 预定日期
	private JLabel labelDateTime;
	private JLabel labelJspYudingTime; // 预定时间
	private JSpinner jspYudingTime;
	private JLabel labelRemark;
	private JTextArea txtAreaRemark; // 备注

	private JButton buttAdd; // 增加
	private JButton buttSave; // 保存
	private JButton buttCancel; // 取消
	private JButton buttReturn; // 返回

	public ClientRegisterWindow() {
		iniClientJFrame();
		labelNeiBuNo = new JLabel("内部编号:");
		labelNeiBuNo.setBounds(12, 25, 60, 12);
		txtNeibubianhao = new JTextField();
		txtNeibubianhao.setBounds(labelNeiBuNo.getX() + labelNeiBuNo.getWidth() + 5, labelNeiBuNo.getY() - 4, 120, 23);

		labelClientNo = new JLabel("客户编号:");
		labelClientNo.setBounds(txtNeibubianhao.getX() + txtNeibubianhao.getWidth() + 10, labelNeiBuNo.getY(), 60, 12);
		textClientNo = new JTextField();
		textClientNo.setBounds(labelClientNo.getX() + labelClientNo.getWidth() + 5, txtNeibubianhao.getY(), 120, 23);

		labelClientName = new JLabel("客户姓名:");
		labelClientName.setBounds(textClientNo.getX() + textClientNo.getWidth() + 10, labelNeiBuNo.getY(), 60, 12);
		textField_ClientName = new JTextField();
		textField_ClientName.setBounds(labelClientName.getX() + labelClientName.getWidth() + 5, txtNeibubianhao.getY(),
				120, 23);

		buttFindCilent = new JButton("查找");
		buttFindCilent.setBounds(610, textField_ClientName.getY(), 78, 23);
		buttFindCilent.addActionListener(this);

		labelCarNo = new JLabel("车牌号:");
		labelCarNo.setHorizontalAlignment(JLabel.RIGHT);
		labelCarNo.setBounds(15, 84, 120, 12);
		comBoxCarNo = new JComboBox<String>(); // 车牌号
		comBoxCarNo.setBounds(146, 80, 143, 23);
		List<String> temItem = new ArrayList<>();
		List<Tb_Cust_Yd> tempClient = new ArrayList<>();
		tempClient = new CommonDAOImpl().executeQuery(Tb_Cust_Yd.class, "select distinct Car_Id from tb_cust_yd", null);
		tempClient.forEach(a -> temItem.add(a.getCar_Id()));
		temItem.forEach(s -> comBoxCarNo.addItem(s));

		labelIsExecute = new JLabel("执行完毕:");
		labelIsExecute.setHorizontalAlignment(JLabel.RIGHT);
		labelIsExecute.setBounds(310, 84, 120, 12);
		comBoxIsExecute = new JComboBox<String>(); // 执行完毕
		comBoxIsExecute.setBounds(441, 80, 143, 23);
		comBoxIsExecute.addItem("是");
		comBoxIsExecute.addItem("否");

		labelPrice = new JLabel("租赁单价（元/天）:");
		labelPrice.setHorizontalAlignment(JLabel.RIGHT);
		labelPrice.setBounds(15, 131, 120, 12);
		txtPrice = new JTextField(); // 租赁单价（元/天）
		txtPrice.setBounds(comBoxCarNo.getX(), comBoxCarNo.getY() + 46, 143, 23);

		labelAntecedentMoney = new JLabel("押金:");
		labelAntecedentMoney.setHorizontalAlignment(JLabel.RIGHT);
		labelAntecedentMoney.setBounds(310, 131, 120, 12);
		txtAntecedentMoney = new JTextField(); // 押金
		txtAntecedentMoney.setBounds(comBoxIsExecute.getX(), comBoxIsExecute.getY() + 46, 143, 23);

		labelDepositReceived = new JLabel("预收租金:");
		labelDepositReceived.setHorizontalAlignment(JLabel.RIGHT);
		labelDepositReceived.setBounds(15, 178, 120, 12);
		txtDepositReceived = new JTextField(); // 预收租金
		txtDepositReceived.setBounds(comBoxCarNo.getX(), txtPrice.getY() + 46, 143, 23);

		labelDeadline = new JLabel("租赁期限:");
		labelDeadline.setHorizontalAlignment(JLabel.RIGHT);
		labelDeadline.setBounds(310, 178, 120, 12);
		txtDeadline = new JTextField(); // 租赁期限
		txtDeadline.setBounds(comBoxIsExecute.getX(), txtAntecedentMoney.getY() + 46, 143, 23);

		labelOverJourneyPrice = new JLabel("超驶收费（元/km）:");
		labelOverJourneyPrice.setHorizontalAlignment(JLabel.RIGHT);
		labelOverJourneyPrice.setBounds(15, 224, 120, 12);
		txtOverJourneyPrice = new JTextField(); // 超驶收费（元/公里）
		txtOverJourneyPrice.setBounds(comBoxCarNo.getX(), txtDepositReceived.getY() + 46, 143, 23);

		labelLimitJourney = new JLabel("每天限驶里程:");
		labelLimitJourney.setHorizontalAlignment(JLabel.RIGHT);
		labelLimitJourney.setBounds(310, 224, 120, 12);
		txtLimitJourney = new JTextField(); // 每天限驶里程
		txtLimitJourney.setBounds(comBoxIsExecute.getX(), txtDeadline.getY() + 46, 143, 23);

		labelOverHourPrice = new JLabel("超市收费（元/h）:");
		labelOverHourPrice.setHorizontalAlignment(JLabel.RIGHT);
		labelOverHourPrice.setBounds(15, 270, 120, 12);
		txtOverHourPrice = new JTextField(); // 超时收费（元/小时）
		txtOverHourPrice.setBounds(comBoxCarNo.getX(), txtOverJourneyPrice.getY() + 46, 143, 23);

		labelOperator = new JLabel("经办人:");
		labelOperator.setHorizontalAlignment(JLabel.RIGHT);
		labelOperator.setBounds(310, 270, 120, 12);
		comBoxOperator = new JComboBox<>(); // 经办人
		comBoxOperator.setBounds(comBoxIsExecute.getX(), txtLimitJourney.getY() + 46, 143, 23);
		List<String> temItemOperator = new ArrayList<>();
		List<Tb_Cust_Yd> tempClient_1 = new ArrayList<>();
		tempClient_1 = new CommonDAOImpl().executeQuery(Tb_Cust_Yd.class, "select distinct Jinbanren from tb_cust_yd",
				null);
		tempClient_1.forEach(a -> temItemOperator.add(a.getCar_Id()));
		temItemOperator.forEach(s -> comBoxOperator.addItem(s));

		labelDateTime = new JLabel("预定日期:");
		labelDateTime.setHorizontalAlignment(JLabel.RIGHT);
		labelDateTime.setBounds(15, 316, 120, 12);
		txtDateTime = new JTextField(); // 预定日期
		txtDateTime.setBounds(comBoxCarNo.getX(), txtOverHourPrice.getY() + 46, 143, 23);
		CalendarPanel p = new CalendarPanel(txtDateTime, "yyyy-MM-dd");
		p.initCalendarPanel();

		labelJspYudingTime = new JLabel("预定时间:");
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

		labelRemark = new JLabel("备注:");
		labelRemark.setHorizontalAlignment(JLabel.RIGHT);
		labelRemark.setBounds(15, 362, 120, 12);
		txtAreaRemark = new JTextArea();
		txtAreaRemark.setBounds(comBoxCarNo.getX(), txtDateTime.getY() + 46, 440, 70);

		buttAdd = new JButton("增加(A)"); // 增加
		buttAdd.setBounds(610, 200, 78, 22);
		buttAdd.addActionListener(this);

		buttSave = new JButton("保存(S)"); // 保存
		buttSave.setBounds(610, 250, 78, 22);
		buttSave.addActionListener(this);

		buttCancel = new JButton("取消(C)"); // 取消
		buttCancel.setBounds(610, 300, 78, 22);
		buttCancel.addActionListener(this);

		buttReturn = new JButton("返回(R)"); // 返回
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
		this.setTitle("汽车租赁系统");
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
					JOptionPane.showMessageDialog(this, "匹配失败！！！", "信息", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "内部编码不能为空！！！", "信息", JOptionPane.INFORMATION_MESSAGE);
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
				JOptionPane.showMessageDialog(this, "添加成功！！！", "信息", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "添加失败！！！", "信息", JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(this, "内部编码不能为空！！！", "信息", JOptionPane.INFORMATION_MESSAGE);
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
