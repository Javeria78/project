<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Flight login</h2>

<h2>Login - CRM</h2>
<div class="container">
<form:form action="loginpassenger" method="post" modelAttribute="loginpass">
	
	<label>
		<div style="color:pink">Email</div></label>
							
		<form:input path="email"/>
					<br><br>		
<label>
		<div style="color: pink">Password</div></label>
							
		<form:password path="password"/>
							
					<br><br>													
	<form:button>Login</form:button>					

					</form:form>

<div style="color: red">${error}</div>
</div>
</body>
</html>