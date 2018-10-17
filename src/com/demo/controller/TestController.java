package com.demo.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.demo.shiro.ShiroPrincipal;

public class TestController extends Controller{
	@RequiresRoles(value = { "normal" })
	public void test(){
		// 获取当前登录的用户名
		ShiroPrincipal subject = (ShiroPrincipal) SecurityUtils.getSubject().getPrincipal();
		String username = subject.getUsername();
		renderText(username+"是normal角色");
	}
	
	@RequiresPermissions(value = { "searchUser" })
	public void test2(){
		String sql = "select * from SEC_USERS";
		List<Record> find = Db.find(sql);
		renderJson(find);
	}
}
