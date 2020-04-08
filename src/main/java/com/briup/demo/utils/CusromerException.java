package com.briup.demo.utils;
 /**
  * 自定义异常
 * @author 亮澳
 *
 */
public class CusromerException  extends RuntimeException{

	private static final long serialVersionUID = 1L;
	/**
	 *状态码
	 */
	private Integer code;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public CusromerException(Integer code,String message) {
		super(message);
		this.code = code;
	}
	
	
}
