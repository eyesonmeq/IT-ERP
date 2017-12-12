/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动程序
 *
 * @date: 2017年12月6日 下午10:37:21
 * @author li_ming 
 */
@SpringBootApplication
@EnableTransactionManagement
public class ErpUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpUserApplication.class, args);
	}
}
