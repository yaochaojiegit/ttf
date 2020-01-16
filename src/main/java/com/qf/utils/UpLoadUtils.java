package com.qf.utils;

import java.io.File;

import java.util.UUID;

public class UpLoadUtils {
	/**
	 * 产生新的文件名
	 * @param filename
	 * @return
	 */
	public static String getFileName(String filename){
		if(filename!=null){
			String ext=filename.substring(filename.lastIndexOf("."));
			return UUID.randomUUID().toString().replaceAll("-", "")+ext;
		}
		return null;
	}
	
	/**
	 * 根据文件名产生新的路径
	 * @param filename
	 * @return
	 */
	
	public static String getDir(String baseDir,String filename){
		int code=filename.hashCode();
		String hex = Integer.toHexString(code);
		//保证一定有hex有八位
		int count=8-hex.length();
		for (int i = 0; i < count; i++) {
			hex=hex+"0";
		}
		//fa432413
		
		char dir1=hex.charAt(0);
		char dir2=hex.charAt(1);
		
		String realpath=baseDir+"\\"+dir1+"\\"+dir2;
		File dir=new File(realpath);
		if(!dir.exists()){
			//创建多级目录
			dir.mkdirs();
		}
		return realpath;
	}
	
}
