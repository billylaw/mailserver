package com.wxluo.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	
	/**类型转化
	 * @param collectionClass
	 * @param cl
	 * @return
	 */
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>...cl){
		return objectMapper.getTypeFactory().constructParametricType(collectionClass, cl);
	}
	
	/**
	 * Object 2 String
	 * @param object
	 * @return
	 */
	public static String convertObject2String(Object object){
		String string =null;
		try{
			string =objectMapper.writeValueAsString(object);
		}catch(JsonProcessingException e){ 
			e.printStackTrace();
		}
		return string;
	}
	
	
	/**
	 * String 2 Object
	 * @param s
	 * @param javaType
	 * @return
	 */
	public static <T> T convertString2Obj(String s, Class<T> clazz) throws Exception{
		T t = null;
		t = objectMapper.readValue(s, clazz);
		return t;
	}
	
	/**
	 * String 2 Object
	 * @param s
	 * @param javaType
	 * @return
	 */
	public static <T> T convertString2Obj(String s, JavaType jType){
		T t = null;
		try{
			t = objectMapper.readValue(s, jType);
		}catch(IOException e){
			e.printStackTrace();
		}
		return t;
	}
}
