package com.wiseweb.ntc.comment.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
/**
 * 通过反射获取当前Dao类对应得实体对象
 * @author ntc
 *
 */
public class ReflectUtils {
	public static Class getSupportClassGenericType(Class clazz,int index) {
		Type type= clazz.getGenericSuperclass();//获取当前实体超类的类型
		if(!(type instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType)type).getActualTypeArguments();
		if(index > params.length || index < 0) {
			return Object.class;
		}
		if(!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}

	public static Class getSuperClassGenricType(Class clazz) {
		return getSupportClassGenericType(clazz, 0);
	}
}
