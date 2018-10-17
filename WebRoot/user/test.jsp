<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: Microsoft Yahei;font-size: 14px;">
测试权限
登陆账号是sys有所有权限
登陆账号是user没有查看用户权限
<a href="${basePath}/user/logout" target="view_window">退出登陆</a>
<a href="${basePath}/test/test" target="view_window">测试按钮1,都有权限</a>
<a href="${basePath}/test/test2" target="view_window">测试按钮2,user没有权限,sys有权限</a>
</body>
</html>