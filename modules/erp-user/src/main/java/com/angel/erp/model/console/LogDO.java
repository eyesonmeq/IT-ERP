/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.model.console;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午1:44:51
 * @author li_ming 
 */
public class LogDO {
	@Id
	@Column(name = "log_id")
	@GeneratedValue(generator = "UUID")
	private String logId;

	private String logUser;

	private String logTime;

	private String logIp;

	private String logAction;

	@Transient
	@JsonIgnore
	private String sort = "";

	@Transient
	@JsonIgnore
	private String order = "";

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getLogUser() {
		return logUser;
	}

	public void setLogUser(String logUser) {
		this.logUser = logUser;
	}

	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	public String getLogIp() {
		return logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}

	public String getLogAction() {
		return logAction;
	}

	public void setLogAction(String logAction) {
		this.logAction = logAction;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Log{" + "logId='" + logId + '\'' + ", logUser='" + logUser + '\'' + ", logTime='" + logTime + '\''
				+ ", logIp='" + logIp + '\'' + ", logAction='" + logAction + '\'' + '}';
	}
}
