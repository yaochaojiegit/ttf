package com.qf.util;

public class StringUtils {

	//校验字符串是否为null,并且长度是否>0
	public static boolean checkEmpty(String... vs) {
		boolean res=true;
		for(int i=0;i<vs.length;i++){
			if(!(vs[i]!=null && vs[i].length()>0)){
				res=false;
				break;
			}
		}
		
		return res;
	}
}
