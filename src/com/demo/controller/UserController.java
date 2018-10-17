package com.demo.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class UserController extends Controller {
	
	@ActionKey("/login")
	public void login() {
		render("login.jsp");
	}
	
	@ActionKey("/logout")
	public void logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}
	
	public void dologin() {
		String error = "";
		String username = getPara("username");
		String password = getPara("password");
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			error = "账号或密码不能为空";
		}
		if(StringUtils.isEmpty(error)) {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			 token.setRememberMe(false);
			try {
				subject.login(token);
			} catch(UnknownAccountException ue) {
				token.clear();
				error = "您输入的账号不存在";
			} catch(IncorrectCredentialsException ie) {
				token.clear();
				error = "登录失败密码不匹配";
			} catch(RuntimeException re) {
				token.clear();
				error = "登录失败";
			}
		}
		if(StringUtils.isEmpty(error)) {
			//redirect("/index/index");
			render("test.jsp");
		} else {
			setAttr("error", error);
			render("login.jsp");
		}
	}
}


