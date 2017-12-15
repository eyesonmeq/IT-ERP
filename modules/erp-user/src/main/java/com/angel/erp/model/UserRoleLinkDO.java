package com.angel.erp.model;

import javax.persistence.*;

/**
 * 用户角色关系
 *
 * @date: 2017年12月15日 下午11:58:56
 * @author li_ming 
 */
@Table(name = "user_role_link")
public class UserRoleLinkDO {
    /**
     * 用户主键
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 角色主键
     */
    @Id
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 获取用户主键
     *
     * @return user_id - 用户主键
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户主键
     *
     * @param userId 用户主键
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取角色主键
     *
     * @return role_id - 角色主键
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色主键
     *
     * @param roleId 角色主键
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}