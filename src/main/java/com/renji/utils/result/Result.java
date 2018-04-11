package com.renji.utils.result;

/**
 * 
 * @author zhang 返回数据类型封装
 *
 * @param <T>
 */
public class Result<T> {
	private String code; // 状态码
	private String msg; // 消息
	private T data; // 数据
	
	public Result(String code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
}
