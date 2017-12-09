package com.angel.erp.model;

import java.io.Serializable;

import javax.persistence.*;

import com.angel.erp.common.util.JsonUtil;

/**
 * 系统机构
 *
 * @date: 2017年12月9日 下午8:42:52
 * @author li_ming 
 */
@Table(name = "sys_organization")
public class SysOrganizationDO implements Serializable {
	private static final long serialVersionUID = -8540450968869051494L;

	/**
	 * 主键
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 所属上级
	 */
	@Column(name = "PARENT_ID")
	private Integer parentId;

	/**
	 * 名称
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * 获取主键
	 *
	 * @return ID - 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置主键
	 *
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取所属上级
	 *
	 * @return PARENT_ID - 所属上级
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * 设置所属上级
	 *
	 * @param parentId 所属上级
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取名称
	 *
	 * @return NAME - 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 *
	 * @param name 名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SysOrganizationDO other = (SysOrganizationDO) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}