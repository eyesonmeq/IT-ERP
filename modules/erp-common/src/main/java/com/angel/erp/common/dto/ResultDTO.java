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
public class ResultDTO<T> implements Serializable {
	private static final long serialVersionUID = 6085491328987799L;
	// 响应结果编码
	private int code;
	// 提示信息
	private String message;
	// 返回结果
	private T data;

	public ResultDTO() {}

	public ResultDTO(T data) {
		this.setCode(ResultCode.SUCCESS.code);
		this.setMessage(DEFAULT_SUCCESS_MESSAGE);
		this.setData(data);
	}

	public void genSuccessResult() {
		this.setCode(ResultCode.SUCCESS.code);
		this.setMessage(DEFAULT_SUCCESS_MESSAGE);
	}

	public void genSuccessResult(T data) {
		this.setCode(ResultCode.SUCCESS.code);
		this.setMessage(DEFAULT_SUCCESS_MESSAGE);
		this.setData(data);
	}

	public void genFailResult(String message) {
		this.setCode(ResultCode.FAIL.code);
		this.setMessage(message);
		this.setData(data);
	}

	public int getCode() {
		return code;
	}

	public ResultDTO<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ResultDTO<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ResultDTO<T> setData(T data) {
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
}
