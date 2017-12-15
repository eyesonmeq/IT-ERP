package com.angel.erp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.angel.erp.common.util.JsonUtil;

/**
 * 系统日志
 *
 * @date: 2017年12月15日 下午11:06:30
 * @author li_ming 
 */
@Table(name = "sys_log")
public class SysLogDO implements Serializable {
	private static final long serialVersionUID = 1184689588322262636L;

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 创建时间
	 */
	@Column(name = "gmt_create")
	private Date gmtCreate;

	/**
	 * 变更时间
	 */
	@Column(name = "gmt_modified")
	private Date gmtModified;

	/**
	 * 活动
	 */
	private String activity;

	/**
	 * 参数
	 */
	private String paramters;

	/**
	 * 资源
	 */
	private String res;

	/**
	 * 访问IP
	 */
	private String ip;

	/**
	 * 用户名
	 */
	@Column(name = "user_name")
	private String userName;

	/**
	 * 获取主键
	 *
	 * @return id - 主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置主键
	 *
	 * @param id 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取创建时间
	 *
	 * @return gmt_create - 创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * 设置创建时间
	 *
	 * @param gmtCreate 创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * 获取变更时间
	 *
	 * @return gmt_modified - 变更时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}

	/**
	 * 设置变更时间
	 *
	 * @param gmtModified 变更时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * 获取活动
	 *
	 * @return activity - 活动
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * 设置活动
	 *
	 * @param activity 活动
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}

	/**
	 * 获取参数
	 *
	 * @return paramters - 参数
	 */
	public String getParamters() {
		return paramters;
	}

	/**
	 * 设置参数
	 *
	 * @param paramters 参数
	 */
	public void setParamters(String paramters) {
		this.paramters = paramters;
	}

	/**
	 * 获取资源
	 *
	 * @return res - 资源
	 */
	public String getRes() {
		return res;
	}

	/**
	 * 设置资源
	 *
	 * @param res 资源
	 */
	public void setRes(String res) {
		this.res = res;
	}

	/**
	 * 获取访问IP
	 *
	 * @return ip - 访问IP
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * 设置访问IP
	 *
	 * @param ip 访问IP
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 获取用户名
	 *
	 * @return user_name - 用户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户名
	 *
	 * @param userName 用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}

	/* 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysLogDO other = (SysLogDO) obj;
		if (gmtCreate == null) {
			if (other.gmtCreate != null)
				return false;
		} else if (!gmtCreate.equals(other.gmtCreate))
			return false;
		if (gmtModified == null) {
			if (other.gmtModified != null)
				return false;
		} else if (!gmtModified.equals(other.gmtModified))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}