package com.demo.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.User;

public class ShiroPrincipal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// 用户对象
	private User user;
	// 用户权限列表
	private List<String> authorities = new ArrayList<String>();
	// 用户角色列表
	private List<String> roles = new ArrayList<String>();
	// 用户是否已授权
	private boolean isAuthorized = false;
	
	/**
	 * 构造函数, 参数为User对象
	 * @param user
	 */
	public ShiroPrincipal(User user) {
		this.user = user;
	}
	
	public List<String> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public boolean isAuthorized() {
		return isAuthorized;
	}
	
	public void setAuthorized(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUsername() {
		return this.user.get("username");
	}
	
	public Integer getId() {
		return this.user.getBigDecimal("id").intValue();
	}
	
	/**
	 * <shiro:principal/>标签显示中文名称
	 */
	@Override
	public String toString() {
	    return this.user.get("username");
	}
}
