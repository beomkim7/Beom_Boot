<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<spring:message code="${result}" var="msg"></spring:message>
	<script type="text/javascript">
		alert('${msg}')
		location.href="${path}"
		
	</script>
</body>
</html>