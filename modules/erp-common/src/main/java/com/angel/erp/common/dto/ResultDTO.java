/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.dto;

import java.io.Serializable;

import com.angel.erp.common.util.JsonUtil;

/**
 * 统一API响应结果封装
 *
 * @date: 2017年12月6日 下午11:06:00
 * @author li_ming 
 */
public class ResultDTO implements Serializable {
	private static final long serialVersionUID = 6085491328987799L;
	// 响应结果编码
	private int code;
	// 提示信息
	private String message;
	// 返回结果
	private Object data;

	public int getCode() {
		return code;
	}

	public ResultDTO setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ResultDTO setMessage(String message) {
		this.message = message;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ResultDTO setData(Object data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}

	public enum ResultCode {
		SUCCESS(200), //成功
		FAIL(400), //失败
		UNAUTHORIZED(401), //未认证（签名错误）
		NOT_FOUND(404), //接口不存在
		INTERNAL_SERVER_ERROR(500);//服务器内部错误
		public int code;

		ResultCode(int code) {
			this.code = code;
		}
	}

	private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

	public static ResultDTO genSuccessResult() {
		return new ResultDTO().setCode(ResultCode.SUCCESS.code).setMessage(DEFAULT_SUCCESS_MESSAGE);
	}

	public static ResultDTO genSuccessResult(Object data) {
		return new ResultDTO().setCode(ResultCode.SUCCESS.code).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data);
	}

	public static ResultDTO genFailResult(String message) {
		return new ResultDTO().setCode(ResultCode.FAIL.code).setMessage(message);
	}
}
