<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: Microsoft Yahei;font-size: 14px;">
<shiro:guest>
欢迎游客访问<br/>
</shiro:guest>
<shiro:user>
欢迎[<shiro:principal/>]登录-<a href="${basePath}/logout">out</a><br/>
</shiro:user>
<shiro:authenticated>
用户[<shiro:principal/>]已身份验证通过<br/>
</shiro:authenticated>
<shiro:notAuthenticated>
未身份验证<br/>
</shiro:notAuthenticated>
<shiro:hasRole name="system">
用户[<shiro:principal/>]拥有角色system<br/>
</shiro:hasRole>
<shiro:hasAnyRoles name="system,normal">
用户[<shiro:principal/>]拥有角色system或normal<br/>
</shiro:hasAnyRoles>
<shiro:lacksRole name="system">
用户[<shiro:principal/>]没有角色system<br/>
</shiro:lacksRole>
<shiro:hasPermission name="searchUser">
用户[<shiro:principal/>]拥有权限searchUser<br/>
</shiro:hasPermission>
<shiro:lacksPermission name="deleteUser">
用户[<shiro:principal/>]没有权限deleteUser<br/>
</shiro:lacksPermission>
</body>
</html>