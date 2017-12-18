/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.angel.erp.common.dto.AuthenticationTokenDTO;
import com.angel.erp.common.dto.ResultDTO;
import com.angel.erp.common.util.LogUtil;
import com.angel.erp.service.SysUserService;

/**
 * 登录控制器
 *
 * @date: 2017年12月10日 上午12:02:11
 * @author li_ming 
 */
@Controller
@RequestMapping(value = "/erp")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 用户管理
	 */
	@Autowired
	private SysUserService userService;

	/**
	 * 登录界面
	 *
	 * @param model
	 * @return 
	 */
	@RequestMapping(value = "/login.html")
	public String loginPage(Model model) {
		return "login";
	}

	/**
	 * 用户登录
	 *
	 * @param token
	 * @return 
	 */
	@ResponseBody
	@PostMapping("/userLogin")
	public ResultDTO<AuthenticationTokenDTO> login(@RequestBody AuthenticationTokenDTO token) {
		ResultDTO<AuthenticationTokenDTO> result = new ResultDTO<AuthenticationTokenDTO>();
		try {
			token = userService.login(token);
			result.genSuccessResult(token);
		} catch (Exception e) {
			result.genFailResult(e.getMessage());
			LogUtil.error(logger, e);
		}
		return result;
	}
}
