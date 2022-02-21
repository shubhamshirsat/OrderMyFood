<%@page import="pkg.dto.Table"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


<style>
	.mySlides {display:none;}
</style>

</head>
<body>
	<a href="login.jsp"><i class="material-icons" style="float: right;">person</i></a>
	
	<br>
	
	<!-- <div class="w3-container w3-blue">
  	<h2>Input Form</h2>
	</div>
 -->
 
 <div class="w3-third">&nbsp;</div>
 
 <div class="w3-third">
	<form class="w3-container" action="SaveCustomer" method="post">
  		<label class="w3-label w3-text-blue">First Name</label>
  		<input class="w3-input w3-border" type="text" name="firstName" required>
	
  		<label class="w3-label w3-text-blue">Last Name</label>
  		<input class="w3-input w3-border" type="text" name="lastName" required>

		<label class="w3-label w3-text-blue">Mobile Number</label>
  		<input class="w3-input w3-border" type="text" name="mobile" required>
  		<br>
  		<table border="0">
  		<%
  			ArrayList<Table> tableList = (ArrayList<Table>) request.getAttribute("tableList");
  			int row = tableList.size()/3; 
  		    int j=0;
  		    
  			for(int i=0; i<row; i++)
  			{
  				out.println("<tr>");
  				int counter = 0;
  				
  				while(j<tableList.size())
  				{
  					
  					Table table = tableList.get(j);
  					
  					if(counter < 4)
  					{
  		%>
							
  					<td>
  						<input class="w3-radio" type="radio" name="table" value="<%=table.getTable() %>" required>
						<label class="w3-validate">Table <%=table.getTable() %></label>
					</td>
				
  		<%
  					j++;
  					counter++;
  					}
  					else
  					{
  						break;
  					}
  				}
  				out.println("</tr>");
  			}
  		%>
  		
  			
  			
  		</table>

		<br><div align="center"><input type="submit" value="Next" class="w3-btn w3-blue"></div>
	</form>
</div>



<br><br><br>

	<%
		String errorMsg = (String) request.getAttribute("errorMsg");
	
		if(errorMsg != null)
		{
	%>
		<div class= 'w3-panel w3-red w3-card-4 w3-margin w3-animate-zoom'>
			<span onclick=this.parentElement.style.display='none' class=w3-closebtn>&times;</span>
			<%=errorMsg %>
			</div>		
	<%
			
		}
	%>
	
	

<!-- 
<div class="w3-content w3-section" style="max-width:800px">
  <img class="mySlides w3-animate-right" src="images/pizza.jpg" style="width:100%; height: 70%">
  <img class="mySlides w3-animate-right" src="images/pizza.jpg" style="width:100%">
  <img class="mySlides w3-animate-right" src="images/pizza.jpg" style="width:100%">
  <img class="mySlides w3-animate-right" src="images/pizza.jpg" style="width:100%">
</div>

<script>
	var myIndex = 0;
	carousel();

	function carousel() 
	{
	    var i;
	    var x = document.getElementsByClassName("mySlides");
	    for (i = 0; i < x.length; i++) 
	    {
	      x[i].style.display = "none";  
	    }
	    myIndex++;
	    if (myIndex > x.length) {myIndex = 1}    
	    x[myIndex-1].style.display = "block";  
	    setTimeout(carousel, 2500);    
	}
</script>

 -->

</body>
</html>