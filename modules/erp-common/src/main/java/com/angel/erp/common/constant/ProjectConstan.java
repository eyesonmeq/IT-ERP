/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.constant;

/**
 * 项目常量
 *
 * @date: 2017年12月6日 下午11:11:49
 * @author li_ming 
 */
public class ProjectConstan {
	public static final String BASE_PACKAGE = "com.company.project";//项目基础包名称，根据自己公司的项目修改

	public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";//Model所在包
	public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";//Mapper所在包
	public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//Service所在包
	public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//ServiceImpl所在包
	public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";//Controller所在包

	public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";//Mapper插件基础接口的完全限定名
}
