package com.qf.util;

import java.util.Base64;

/**
* 作者：老邢
* 时间：2017年5月26日
* 版本：v1.0
* 说明：base64加密解密，激活邮件
*/
public class Base64Utils {

	//转换为base64
	public static String encoder(String msg) {
		return Base64.getEncoder().encodeToString(msg.getBytes());
	}
	//解码成base64
	public static String decoder(String msg) {
		return new String(Base64.getDecoder().decode(msg));
	}
}
