package com.demo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;
import com.jfinal.kit.StrKit;

public class BasePathHandler extends Handler {
	
	private String contextPathName;
	
	public BasePathHandler() {
		contextPathName = "basePath";
	}
	
	public BasePathHandler(String contextPathName) {
		if (StrKit.isBlank(contextPathName))
			throw new IllegalArgumentException("contextPathName can not be blank");
		this.contextPathName = contextPathName;
	}
	
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		request.setAttribute(contextPathName, basePath);
		nextHandler.handle(target, request, response, isHandled);
	}
	
}
