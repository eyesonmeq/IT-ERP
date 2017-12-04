/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.model.member;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午2:02:29
 * @author li_ming 
 */
public class MemberDO implements Serializable {

	private static final long serialVersionUID = 3875800299262546808L;

	@Id
	@Column(name = "uid")
	@GeneratedValue(generator = "UUID")
	private String uid;

	private String account;

	private String password;

	private String salt;

	private Integer state;

	private String createdAt;

	private String updatedAt;

	@Transient
	@JsonIgnore
	private String sort = "";

	@Transient
	@JsonIgnore
	private String order = "";

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
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
}
