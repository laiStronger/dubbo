<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user list</title>
</head>
<body>
	
      user id ....user name<br/>
-------------        -------------	<br/>	
	<c:forEach items="${users}" var="u" >
		${u.userName}....${u.userId}<br/>
	</c:forEach>
</body>
</html>