/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.angel.erp.common.util.DateUtil;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午3:01:06
 * @author li_ming 
 */
@Controller
@RequestMapping
public class IndexController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value = "/test", method = { RequestMethod.GET })
	public String test(Model model) {
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
		logger.error("This is an error message");

		String rq = DateUtil.getCurrentTime();
		System.out.println(rq);
		model.addAttribute("rq", rq);
		return "test/test";
	}

	@ResponseBody
	@RequestMapping(value = "/testPost", method = { RequestMethod.POST })
	public String testpost(HttpServletRequest request) {
		return request.getParameter("rq");
	}

	@RequestMapping("/403")
	public String forbidden() {
		return "403";
	}
}
