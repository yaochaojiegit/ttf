package com.qf.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

/** 
* @author：老邢 
* @version：v1.0 
* 创建时间：2017年4月25日
* 类说明： 生成随机数字，主要生产激活码，订单编号，商品编号
*/
public class RandomUtils {

	//生成激活码:当前时间+随机
	public static String createActiveCode() {
		return getTime()+Integer.toHexString(new Random().nextInt(900)+100);
	}
	//生成产品编号
	public static String createProductId() {
		return ((int)(Math.random()*90)+10)+getTime();
	}
	//订单编号
	public static String createOrderId() {
		return getTime()+UUID.randomUUID().toString().replace("-", "");
	}
	//获取当前时间，精确到毫秒
	private static String getTime() {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
	}
	
}
