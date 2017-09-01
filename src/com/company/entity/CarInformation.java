package com.company.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CarInformation {

    public String Car_Id;
    public Timestamp Buy_Time;
    public String Car_Type;
    public String Car_Color;
    public String Chuchang_Id;
    public String Motor_Id;
    public String Dipan_Id;
    public String Chair_Num;

    public BigDecimal Buy_Price;
    public BigDecimal Buy_tax;
    public BigDecimal Shangpai_fee;
    public BigDecimal Car_Zhuangshi;
    public String Chair_Num;
    public String Chair_Num;
    public BigDecimal Start_Gongli;
    public BigDecimal Current_Gongli;

    /*
    CREATE TABLE `tb_car` (
  `Car_Id` varchar(10) NOT NULL COMMENT '车牌号',
  `Buy_Time` timestamp NULL DEFAULT NULL COMMENT '购买时间',
  `Car_Type` varchar(50) DEFAULT NULL COMMENT '车型',
  `Car_Color` varchar(20) DEFAULT NULL COMMENT '颜色',
  `Chuchang_Id` varchar(10) DEFAULT NULL COMMENT '出厂编号',
  `Motor_Id` varchar(10) DEFAULT NULL COMMENT '发动机号',
  `Dipan_Id` varchar(10) DEFAULT NULL COMMENT '底盘编号',
  `Chair_Num` varchar(5) DEFAULT NULL COMMENT '座位数',

  `Buy_Price` decimal(8,2) DEFAULT NULL COMMENT '购买价格',
  `Buy_tax` decimal(8,2) DEFAULT NULL COMMENT '购置税',
  `Shangpai_fee` decimal(8,2) DEFAULT NULL COMMENT '上牌费',
  `Car_Zhuangshi` decimal(8,0) DEFAULT NULL COMMENT '汽车装饰',
  `Chezhu_Name` varchar(10) DEFAULT NULL COMMENT '车主姓名',
  `Tel` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `Start_Gongli` decimal(8,1) DEFAULT NULL COMMENT '起始公里数',
  `Current_Gongli` decimal(8,1) DEFAULT NULL COMMENT '当前公里数',

  `YLF_Starttime` timestamp NULL DEFAULT NULL COMMENT '养路费购买时间',
  `YLF_Endtime` timestamp NULL DEFAULT NULL COMMENT '养路费截止时间',
  `NS_Starttime` timestamp NULL DEFAULT NULL COMMENT '年审时间',
  `NS_Endtime` timestamp NULL DEFAULT NULL COMMENT '年审截止时间',
  `BX_Starttime` timestamp NULL DEFAULT NULL COMMENT '保险购买时间',
  `BX_Endtime` timestamp NULL DEFAULT NULL COMMENT '保险截止时间',
  `CCS_Starttime` timestamp NULL DEFAULT NULL COMMENT '车船税购买时间',
  `CCS_Endtime` timestamp NULL DEFAULT NULL COMMENT '车船税截止时间',
  `LQP_Starttime` timestamp NULL DEFAULT NULL COMMENT '路桥票购买时间',
  `LQP_Endtime` timestamp NULL DEFAULT NULL COMMENT '路桥票截止时间',
  `YYZ_Starttime` timestamp NULL DEFAULT NULL COMMENT '营运证办理时间',
  `YYZ_Endtime` timestamp NULL DEFAULT NULL COMMENT '营运证截止时间',
  `YGF_Starttime` timestamp NULL DEFAULT NULL COMMENT '运营证购买时间',
  `YGF_Endtime` timestamp NULL DEFAULT NULL COMMENT '运营证截止时间',

  `Erbaolicheng` decimal(8,0) DEFAULT NULL COMMENT '二保里程',
  `NextErbao` decimal(8,0) DEFAULT NULL COMMENT '下次二保',
     */


}
