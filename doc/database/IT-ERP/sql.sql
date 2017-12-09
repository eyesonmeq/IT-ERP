drop table if exists ROLE_PERMISSION_RELATIONSHIP;

drop table if exists SYS_LOG;

drop table if exists SYS_PERMISSION;

drop table if exists SYS_ROLE;

drop table if exists SYS_USER;

drop table if exists USER_ROLE_RELATIONSHIP;

/*==============================================================*/
/* Table: ROLE_PERMISSION_RELATIONSHIP                          */
/*==============================================================*/
create table ROLE_PERMISSION_RELATIONSHIP
(
   ID                   int not null comment '主键',
   CODE                 varchar(20) not null comment '主键',
   primary key (ID, CODE)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table ROLE_PERMISSION_RELATIONSHIP comment '角色权限关系';

/*==============================================================*/
/* Table: SYS_LOG                                               */
/*==============================================================*/
create table SYS_LOG
(
   ID                   int not null auto_increment comment '主键',
   SYS_ACCOUNT          varchar(50) comment '账户',
   ACTION               varchar(2000) not null comment '活动',
   PARAMTERS            text not null comment '参数',
   RES                  varchar(2000) not null comment '资源',
   ACCOUNT              varchar(50) not null comment '账户',
   IP                   varchar(100) not null comment '访问IP',
   LOG_TIME             datetime not null comment '记录时间',
   primary key (ID)
)
auto_increment = 1
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table SYS_LOG comment '系统日志';

/*==============================================================*/
/* Table: SYS_ORGANIZATION                                      */
/*==============================================================*/
create table SYS_ORGANIZATION
(
   ID                   int not null auto_increment comment '主键',
   PARENT_ID            int comment '所属上级',
   NAME                 varchar(50) not null comment '名称',
   primary key (ID)
)
auto_increment = 1
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table SYS_ORGANIZATION comment '系统组织';

/*==============================================================*/
/* Table: SYS_PERMISSION                                        */
/*==============================================================*/
create table SYS_PERMISSION
(
   CODE                 varchar(20) not null comment '主键',
   SYS_CODE             varchar(20) comment '主键',
   ACCOUNT              varchar(50) comment '账户',
   NAME                 varchar(50) not null comment '名称',
   ACTION               varchar(500) not null comment '动作',
   PARENT_ID            varchar(20) comment '父权限',
   primary key (CODE)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table SYS_PERMISSION comment '系统权限';

/*==============================================================*/
/* Table: SYS_ROLE                                              */
/*==============================================================*/
create table SYS_ROLE
(
   ID                   int not null auto_increment comment '主键',
   NAME                 varchar(50) not null comment '名称',
   primary key (ID)
)
auto_increment = 1
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table SYS_ROLE comment '系统角色';

/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
create table SYS_USER
(
   ACCOUNT              varchar(50) not null comment '账户',
   NAME                 varchar(50) not null comment '姓名',
   PASSWORD             varchar(50) not null comment '密码',
   STATE                smallint not null comment '状态',
   SALT                 varchar(32) comment '盐',
   CREATE_TIME          datetime not null comment '创建时间',
   primary key (ACCOUNT)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table SYS_USER comment '系统用户';

/*==============================================================*/
/* Table: USER_ORGANIZATION_RELATIONSHIP                        */
/*==============================================================*/
create table USER_ORGANIZATION_RELATIONSHIP
(
   ACCOUNT              varchar(50) not null comment '账户',
   ID                   int not null comment '主键',
   primary key (ACCOUNT, ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table USER_ORGANIZATION_RELATIONSHIP comment '用户组织关系';

/*==============================================================*/
/* Table: USER_ROLE_RELATIONSHIP                                */
/*==============================================================*/
create table USER_ROLE_RELATIONSHIP
(
   ACCOUNT              varchar(50) not null comment '账户',
   ID                   int not null comment '主键',
   primary key (ACCOUNT, ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table USER_ROLE_RELATIONSHIP comment '用户角色关系';

drop table if exists CUSTOMER;

drop table if exists CUSTOMER_CATEGORY;

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
create table CUSTOMER
(
   ID                   int not null auto_increment,
   CUS_ID               int not null,
   CATEGORY_ID          int not null,
   CODE                 varchar(50) not null,
   NAME                 varchar(100) not null,
   CONTACT              varchar(50),
   TEL                  varchar(20),
   QQ                   varchar(50),
   MOBILE               varchar(11),
   ADDRESS              varchar(255),
   ADDRESS_SHIPPING     varchar(255),
   ADDRESS_RECEIPT      varchar(255),
   BANK_NAME            varchar(100),
   BANK_ACCOUNT         varchar(100),
   TAX_NUMBER           varchar(100),
   FAX                  varchar(20),
   primary key (ID)
)
auto_increment = 1
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table CUSTOMER comment '客户';

/*==============================================================*/
/* Table: CUSTOMER_CATEGORY                                     */
/*==============================================================*/
create table CUSTOMER_CATEGORY
(
   ID                   int not null auto_increment,
   NAME                 varchar(50) not null,
   PARENT_ID            int,
   primary key (ID)
)
auto_increment = 1
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table CUSTOMER_CATEGORY comment '客户分类';


