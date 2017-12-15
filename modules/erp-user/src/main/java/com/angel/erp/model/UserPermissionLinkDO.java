package com.angel.erp.model;

import javax.persistence.*;

/**
 * 用户权限关系
 *
 * @date: 2017年12月15日 下午11:58:36
 * @author li_ming 
 */
@Table(name = "user_permission_link")
public class UserPermissionLinkDO {
    /**
     * 用户主键
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 权限主键
     */
    @Id
    @Column(name = "permission_id")
    private Long permissionId;

    /**
     * 权限类型（1：新增，2：删除）
     */
    @Column(name = "permission_type")
    private Byte permissionType;

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
     * 获取权限主键
     *
     * @return permission_id - 权限主键
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 设置权限主键
     *
     * @param permissionId 权限主键
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 获取权限类型（1：新增，2：删除）
     *
     * @return permission_type - 权限类型（1：新增，2：删除）
     */
    public Byte getPermissionType() {
        return permissionType;
    }

    /**
     * 设置权限类型（1：新增，2：删除）
     *
     * @param permissionType 权限类型（1：新增，2：删除）
     */
    public void setPermissionType(Byte permissionType) {
        this.permissionType = permissionType;
    }
}