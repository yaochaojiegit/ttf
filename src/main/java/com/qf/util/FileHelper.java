package com.qf.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//实现文件上传文件名的重新打乱、文件夹的创建
public class FileHelper {
	
	//创建文件夹，用于保存文件
	public static File createDir(String rootDir){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		File dir=new File(new File(rootDir).getParent(), "files"+File.separator+sdf.format(Calendar.getInstance().getTime()));
		//验证当前的目录是否存在，如果不存在就新建
		if(!dir.exists()){
			dir.mkdirs();
		}
		return dir;
	}
	//创建文件名，目的防止上传的文件名重复
	public static String createFileName(String fn){
		return System.currentTimeMillis()+"_"+Math.round((Math.random()*1000))+"_"+fn;
	}
	
	

}
