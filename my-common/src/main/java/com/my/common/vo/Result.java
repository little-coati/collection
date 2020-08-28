package com.my.common.vo;

import com.my.common.constant.CommonConstant;

import java.io.Serializable;

public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 成功标志
	 */
	private String success;

	/**
	 * 返回处理消息
	 */
	private String message;

	/**
	 * 返回代码
	 */
	private String code;
	
	/**
	 * 返回数据对象 data
	 */
	private T data;

	/**
	 * 时间戳
	 */
	private long timestamp = System.currentTimeMillis();

	public static long getSerialVersionUID() {
		return com.my.common.vo.Result.serialVersionUID;
	}

	public String getSuccess() {
		return this.success;
	}

	public void setSuccess(final String success) {
		this.success = success;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public T getData() {
		return this.data;
	}

	public void setData(final T data) {
		this.data = data;
	}

	public long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(final long timestamp) {
		this.timestamp = timestamp;
	}

	public void error500(String message) {
		this.message = message;
		this.code = CommonConstant.INTERNAL_SERVER_ERROR_500;
		this.success = CommonConstant.FALSE_1;
	}

	public void successDeal(String message) {
		this.message = message;
		this.code = CommonConstant.OK_200;
		this.success = CommonConstant.SUCCESS_0;
	}
	
	public static com.my.common.vo.Result<Object> error(String msg) {
		return error(CommonConstant.INTERNAL_SERVER_ERROR_500, msg);
	}
	
	public static com.my.common.vo.Result<Object> error(String code, String msg) {
		com.my.common.vo.Result<Object> r = new com.my.common.vo.Result<Object>();
		r.setCode(code);
		r.setMessage(msg);
		r.setSuccess(CommonConstant.FALSE_1);
		return r;
	}
	
	public static com.my.common.vo.Result<Object> ok(String msg) {
		com.my.common.vo.Result<Object> r = new com.my.common.vo.Result<Object>();
		r.setSuccess(CommonConstant.SUCCESS_0);
		r.setCode(CommonConstant.OK_200);
		r.setMessage(msg);
		return r;
	}

	public static com.my.common.vo.Result<Object> okEx(String msg) {
		com.my.common.vo.Result<Object> r = new com.my.common.vo.Result<Object>();
		r.setSuccess(CommonConstant.SUCCESS_0);
		r.setCode(CommonConstant.OK_200);
		r.setMessage(msg);
		r.setData(msg);
		return r;
	}
	
	public static com.my.common.vo.Result<Object> ok(Object obj) {
		com.my.common.vo.Result<Object> r = new com.my.common.vo.Result<Object>();
		r.setSuccess(CommonConstant.SUCCESS_0);
		r.setCode(CommonConstant.OK_200);
		r.setData(obj);
		return r;
	}


	public static com.my.common.vo.Result<Object> ok(Object obj, String msg){
		com.my.common.vo.Result<Object> r = new com.my.common.vo.Result<Object>();
		r.setSuccess(CommonConstant.SUCCESS_0);
		r.setCode(CommonConstant.OK_200);
		r.setData(obj);
		r.setMessage(msg);
		return r;
	}

	public static com.my.common.vo.Result<Object> error(String code, String msg, Object objv) {
		com.my.common.vo.Result<Object> r = new com.my.common.vo.Result<Object>();
		r.setCode(code);
		r.setMessage(msg);
		r.setData(objv);
		r.setSuccess(CommonConstant.FALSE_1);
		return r;
	}
}
