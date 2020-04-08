package com.briup.demo.utils;

import java.util.Date;

/**
 *  返回消息的工具类
 * @author 亮澳
 *
 */
public class MessageUtil {
	/**
	 * 成功，并返回数据
	 */
	public static <E>Message<E> success(E obj){
		return new Message<E>(200,"seccess",obj,new Date().getTime());
	}
	/**
	 * 成功，无返回数据
	 */
	public static <E>Message<E> success(){
		return new Message<E>(200,"seccess",null,new Date().getTime());
	}
	/**
	 * 失败，将自定义异常信息返回
	 */
	public static <E>Message<E> error(Integer status,String message){
		return new Message<E>(status,message,null,new Date().getTime());
	}
	
}
