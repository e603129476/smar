package com.huaxun.smart.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Json与对象之间的转换工具类
 * 
 */
public class JsonUtil {
	 public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	 public static final Gson GSON=new GsonBuilder().setDateFormat(DATE_FORMAT).serializeNulls().create();

	/**
	 * 从一个JSON 对象字符格式中得到一个java对象
	 * 
	 * @param jsonString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonToBean(String jsonString, Class<T> objectCalss) {
		T bean = GSON.fromJson(jsonString, objectCalss);
		return bean;
	}
	/**
	 * 将java对象转换成json字符串
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String beanToJson(Object object) {
		return GSON.toJson(object);
	}

	/**
	 * 将java对象List集合转换成json字符串
	 * 
	 * @param objectArray
	 * @return string
	 */
	@SuppressWarnings("unchecked")
	public static String ojectArrayToJson(List<?> objectArray) {
		return GSON.toJson(objectArray);
	}

	/**
	 * 从json数组中得到相应java数组
	 *
	 * @param jsonString
	 * @return objectArray
	 */
	@SuppressWarnings("unchecked")
	public static List<?> jsonToObjectArray(String jsonString) {
		 List<?> objectArray = GSON.fromJson(jsonString,  
	                new TypeToken<List<?>>() {
	                }.getType());  
		return objectArray;
	}

}