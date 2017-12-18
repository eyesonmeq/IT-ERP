/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

/**
 * shiro配置类
 *
 * @date: 2017年12月9日 下午11:50:36
 * @author li_ming 
 */
public abstract class AbstractShiroConfig {

	/**
	 * 注册realm
	 *
	 * @return 
	 */
	@Bean(name = "JWTRealm")
	public JWTRealm getJWTRealm() {
		JWTRealm realm = new JWTRealm();
		return realm;
	}

	/**
	 * SecurityManager，权限管理，这个类组合了登录，登出，权限，session的处理，是个比较重要的类。
	 *
	 * @return 
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		// 使用自己的realm
		manager.setRealm(this.getJWTRealm());
		// 关闭shiro自带的session
		DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
		DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
		defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
		subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
		manager.setSubjectDAO(subjectDAO);

		return manager;
	}

	/**
	 * ShiroFilterFactoryBean，是个factorybean，为了生成ShiroFilter。它主要保持了三项数据，securityManager，filters，filterChainDefinitionManager。
	 *
	 * @return 
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager());

		Map<String, Filter> filters = new LinkedHashMap<>();
		filters.put("jwt", new AuthenticationFilter());
		shiroFilterFactoryBean.setFilters(filters);

		Map<String, String> filterRuleMap = new LinkedHashMap<String, String>();
		// 配置不会被拦截的链接 顺序判断
		filterRuleMap.put("/static/**", "anon");
		filterRuleMap.put("/erp/userLogin", "anon");
		// 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterRuleMap.put("/erp/logout", "logout");
		//<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		//<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterRuleMap.put("/**", "authc");
		if (this.getFilterRuleMap() != null) {
			filterRuleMap.putAll(this.getFilterRuleMap());
		}
		filterRuleMap.put("/edit", "jwt, perms[edit]");
		filterRuleMap.put("/admin/**", "jwt, roles[admin]");
		filterRuleMap.put("/annotation/**", "jwt");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterRuleMap);

		shiroFilterFactoryBean.setLoginUrl("/erp/login.html");
		shiroFilterFactoryBean.setSuccessUrl("/erp/index.html");
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		return shiroFilterFactoryBean;
	}

	/**
	 * 下面的代码是添加注解支持
	 */
	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		return new DefaultAdvisorAutoProxyCreator();
	}

	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
			DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}

	public abstract Map<String, String> getFilterRuleMap();
}
