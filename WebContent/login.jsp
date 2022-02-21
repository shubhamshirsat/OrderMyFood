<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

</head>
<body>

<br><br><br><br><br><br>

<div class="w3-container">
	<div class="w3-third">&nbsp;</div>
 
	 <div class="w3-third">
		<form class="w3-container" action="Login" method="post">
  			<label class="w3-label w3-text-blue">User Name</label>
	  		<input class="w3-input w3-border " type="text" name="username" required>
	
  			<label class="w3-label w3-text-blue">Password</label>
  			<input class="w3-input w3-border " type="password" name="password" required>
	
			<br><div align="center"><input type="submit" value="Login" class="w3-btn w3-blue"></div>
		</form>
		<br>
		<%
			String errorMsg= (String) request.getAttribute("errorMsg");
		
			if(errorMsg != null)
			{
				out.print("<div align=center class= w3-text-red>"+errorMsg+"</div>");
			}
		%>
		<%
			String changeMsg= (String) request.getAttribute("ChangeMsg");
		
			if(changeMsg != null)
			{
				out.print("<div align=center class= w3-text-green>"+changeMsg+"</div>");
			}
		%>
	</div>
</div>

</body>
</html>