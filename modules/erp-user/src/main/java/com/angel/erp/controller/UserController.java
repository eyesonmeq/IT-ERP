/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angel.erp.model.SysUserDO;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月14日 下午10:50:47
 * @author li_ming 
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
	// 创建线程安全的Map 
	static Map<Long, SysUserDO> users = Collections.synchronizedMap(new HashMap<Long, SysUserDO>());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<SysUserDO> getUserList() {
		// 处理"/users/"的GET请求，用来获取用户列表 
		// 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递 
		List<SysUserDO> r = new ArrayList<SysUserDO>(users.values());
		return r;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postUser(@ModelAttribute SysUserDO user) {
		// 处理"/users/"的POST请求，用来创建User 
		// 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数 
		//users.put(user.getId(), user);
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public SysUserDO getUser(@PathVariable Long id) {
		// 处理"/users/{id}"的GET请求，用来获取url中id值的User信息 
		// url中的id可通过@PathVariable绑定到函数的参数中 
		return users.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable Long id, @ModelAttribute SysUserDO user) {
		// 处理"/users/{id}"的PUT请求，用来更新User信息 
		SysUserDO u = users.get(id);
		//u.setName(user.getName());
		//u.setAge(user.getAge());
		users.put(id, u);
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		// 处理"/users/{id}"的DELETE请求，用来删除User 
		users.remove(id);
		return "success";
	}
}
