package com.company.other;
import com.company.dao.Id;

import java.util.Date;

public class Tb_Cust_Yd {

	@Id
	private Integer Inner_Id;//�ڲ����      ����
	
	private String Customer_Id;//�ͻ���
	private String Customer_Name;//����
	private String Car_Id;//���ƺ�
	private int Zhixing;//ִ�����
	private long Zulin_Price;//���޵���
	private int Yanjin;//Ѻ��
	private int Pre_Zujin;//Ԥ�����
	private int Zulin_Qixian;//��������
	private int Chaoshi_Fee;// ��ʻ�շ�
	private int Licheng_Meitian;//ÿ����ʻ�����
	private int OutTime_Fee;//��ʱ�շ�
	private String Jinbanren;//������
	private String Yuding_Date;//Ԥ������
	private Date Yuding_Time;//Ԥ��ʱ��
	private String Demo;//��ע
	
	public Tb_Cust_Yd() {
		super();
	}

	public Tb_Cust_Yd(Integer inner_Id, String customer_Id, String customer_Name, String car_Id, int zhixing,
			long zulin_Price, int yanjin, int pre_Zujin, int zulin_Qixian, int chaoshi_Fee, int licheng_Meitian,
			int outTime_Fee, String jinbanren, String yuding_Date, Date yuding_Time, String demo) {
		super();
		Inner_Id = inner_Id;
		Customer_Id = customer_Id;
		Customer_Name = customer_Name;
		Car_Id = car_Id;
		Zhixing = zhixing;
		Zulin_Price = zulin_Price;
		Yanjin = yanjin;
		Pre_Zujin = pre_Zujin;
		Zulin_Qixian = zulin_Qixian;
		Chaoshi_Fee = chaoshi_Fee;
		Licheng_Meitian = licheng_Meitian;
		OutTime_Fee = outTime_Fee;
		Jinbanren = jinbanren;
		Yuding_Date = yuding_Date;
		Yuding_Time = yuding_Time;
		Demo = demo;
	}

	public Integer getInner_Id() {
		return Inner_Id;
	}

	public void setInner_Id(Integer inner_Id) {
		Inner_Id = inner_Id;
	}

	public String getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}

	public String getCustomer_Name() {
		return Customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}

	public String getCar_Id() {
		return Car_Id;
	}

	public void setCar_Id(String car_Id) {
		Car_Id = car_Id;
	}

	public int getZhixing() {
		return Zhixing;
	}

	public void setZhixing(int zhixing) {
		Zhixing = zhixing;
	}

	public long getZulin_Price() {
		return Zulin_Price;
	}

	public void setZulin_Price(long zulin_Price) {
		Zulin_Price = zulin_Price;
	}

	public int getYanjin() {
		return Yanjin;
	}

	public void setYanjin(int yanjin) {
		Yanjin = yanjin;
	}

	public int getPre_Zujin() {
		return Pre_Zujin;
	}

	public void setPre_Zujin(int pre_Zujin) {
		Pre_Zujin = pre_Zujin;
	}

	public int getZulin_Qixian() {
		return Zulin_Qixian;
	}

	public void setZulin_Qixian(int zulin_Qixian) {
		Zulin_Qixian = zulin_Qixian;
	}

	public int getChaoshi_Fee() {
		return Chaoshi_Fee;
	}

	public void setChaoshi_Fee(int chaoshi_Fee) {
		Chaoshi_Fee = chaoshi_Fee;
	}

	public int getLicheng_Meitian() {
		return Licheng_Meitian;
	}

	public void setLicheng_Meitian(int licheng_Meitian) {
		Licheng_Meitian = licheng_Meitian;
	}

	public int getOutTime_Fee() {
		return OutTime_Fee;
	}

	public void setOutTime_Fee(int outTime_Fee) {
		OutTime_Fee = outTime_Fee;
	}

	public String getJinbanren() {
		return Jinbanren;
	}

	public void setJinbanren(String jinbanren) {
		Jinbanren = jinbanren;
	}

	public String getYuding_Date() {
		return Yuding_Date;
	}

	public void setYuding_Date(String yuding_Date) {
		Yuding_Date = yuding_Date;
	}

	public Date getYuding_Time() {
		return Yuding_Time;
	}

	public void setYuding_Time(Date yuding_Time) {
		Yuding_Time = yuding_Time;
	}

	public String getDemo() {
		return Demo;
	}

	public void setDemo(String demo) {
		Demo = demo;
	}
}
