<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: Microsoft Yahei;font-size: 14px;">
<form action="${basePath}/user/dologin" method="post">
用户名:<input type="text" name="username" />
密码:<input type="text" name="password" />
<input type="submit" value="登陆" />${error }
登陆用户:sys 密码:sys
登陆用户:user 密码:user
</form>
</body>
</html>