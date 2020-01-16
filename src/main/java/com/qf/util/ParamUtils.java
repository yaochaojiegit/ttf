package com.qf.util;

import java.lang.reflect.Field;
import java.util.Map;

//将所有的请求参数转换为指定类型的对象
public class ParamUtils {

	public static <T> T parseParam(Map<String, String[]> map, Class<T> cls) {
		try {
			T obj = cls.newInstance();
			// 获取指定类的所有属性，不包含继承
			Field[] fs = cls.getDeclaredFields();
			for (Field f : fs) {
				// 验证当前的属性名称是否在请求参数中
				if (map.containsKey(f.getName())) {
					//设置忽略访问校验
					f.setAccessible(false);
					//赋值
					f.set(obj, map.get(f.getName()));
				}
			}
			return obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
