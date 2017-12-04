/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.controller.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午3:38:15
 * @author li_ming 
 */
@Controller
@RequestMapping("/console/upload")
public class FileUploadController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/index")
	public String index() {
		return "console/file/index";
	}
}
