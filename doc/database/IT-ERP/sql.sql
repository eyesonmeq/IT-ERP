drop table if exists role_permission_link;

drop index idx_user_name on sys_log;

drop table if exists sys_log;

drop table if exists sys_organization;

drop table if exists sys_permission;

drop table if exists sys_role;

drop table if exists sys_user;

drop table if exists user_organization_link;

drop table if exists user_permission_link;

drop table if exists user_role_link;

/*==============================================================*/
/* Table: role_permission_link                                  */
/*==============================================================*/
create table role_permission_link
(
   role_id              bigint not null comment '角色主键',
   permission_id        bigint not null comment '权限主键',
   primary key (role_id, permission_id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table role_permission_link comment '角色权限关系';

/*==============================================================*/
/* Table: sys_log                                               */
/*==============================================================*/
create table sys_log
(
   id                   bigint unsigned not null auto_increment comment '主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '变更时间',
   activity             varchar(2000) not null comment '活动',
   paramters            varchar(4000) comment '参数',
   res                  varchar(2000) not null comment '资源',
   ip                   varchar(100) not null comment '访问IP',
   user_name            varchar(20) not null comment '用户名',
   primary key (id)
)
auto_increment = 1
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table sys_log comment '系统日志';

/*==============================================================*/
/* Index: idx_user_name                                         */
/*==============================================================*/
create index idx_user_name on sys_log
(
   user_name
);

/*==============================================================*/
/* Table: sys_organization                                      */
/*==============================================================*/
create table sys_organization
(
   id                   bigint unsigned not null auto_increment comment '主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '变更时间',
   parent_id            bigint comment '所属上级',
   org_name             varchar(50) not null comment '组织名称',
   primary key (id)
);

alter table sys_organization comment '系统组织';

/*==============================================================*/
/* Table: sys_permission                                        */
/*==============================================================*/
create table sys_permission
(
   id                   bigint unsigned not null auto_increment comment '主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '变更时间',
   permission_code      varchar(20) not null comment '权限编码',
   permission_name      varchar(50) not null comment '权限名称',
   url                  varchar(500) not null comment 'url',
   parent_id            bigint comment '父权限',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table sys_permission comment '系统权限';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   id                   bigint unsigned not null auto_increment comment '主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '变更时间',
   role_name            varchar(50) not null comment '角色名称',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table sys_role comment '系统角色';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   id                   bigint unsigned not null auto_increment comment '主键',
   gmt_create           datetime not null comment '创建时间',
   gmt_modified         datetime not null comment '变更时间',
   user_name            varchar(20) not null comment '用户名',
   nickname             varchar(50) not null comment '用户昵称',
   user_password        varchar(50) not null comment '密码',
   user_state           tinyint unsigned not null comment '用户状态（1：正常，2：停用，3：锁定）',
   salt                 varchar(32) comment '盐',
   primary key (id),
   unique key AK_uk_user_name (user_name)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table sys_user comment '系统用户';

/*==============================================================*/
/* Table: user_organization_link                                */
/*==============================================================*/
create table user_organization_link
(
   user_id              bigint not null comment '用户主键',
   org_id               bigint not null comment '组织主键',
   primary key (user_id, org_id)
);

alter table user_organization_link comment '用户组织关系';

/*==============================================================*/
/* Table: user_permission_link                                  */
/*==============================================================*/
create table user_permission_link
(
   user_id              bigint not null comment '用户主键',
   permission_id        bigint not null comment '权限主键',
   permission_type      tinyint unsigned not null comment '权限类型（1：新增，2：删除）',
   primary key (user_id, permission_id)
);

alter table user_permission_link comment '用户权限关系';

/*==============================================================*/
/* Table: user_role_link                                        */
/*==============================================================*/
create table user_role_link
(
   user_id              bigint not null comment '用户主键',
   role_id              bigint not null comment '角色主键',
   primary key (user_id, role_id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table user_role_link comment '用户角色关系';
