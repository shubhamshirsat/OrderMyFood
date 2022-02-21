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

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<body>
	<div class="w3-container">
		<div class="w3-border w3-padding">
			<button class="w3-btn w3-indigo" onclick="addTable()">Add New Table</button>
		</div>
	</div>
	<br>
	<div class="w3-container w3-card-4">
		<div>
			<table cellspacing="30">
			<%
				ArrayList<Table> tableList = (ArrayList<Table>) request.getAttribute("tableList");
				int row = tableList.size()/1; 
				
				if(row<1)
				{
					row = 1;
				}
  		    	int j=0;
			
				for(int i=0; i<row; i++)
				{
					out.println("<tr>");
	  				int counter = 0;
					
	  				while(j<tableList.size())
	  				{
	  					  				
						Table table = tableList.get(j);
						
						if(counter < 5)
						{
					
							if(j==tableList.size()-1)
							{
				%>
					
									<td style="width: 120px"><button class="w3-btn w3-indigo">Table <%=table.getTable() %></button> 
									<a href="#" style="text-decoration: none;" onclick="removeTable()"><i class="material-icons">delete_forever</i></a>
									</td>
					
				<%			
							}
							else
							{
				%>
					
									<td style="width: 120px"><button class="w3-btn w3-indigo">Table <%=table.getTable()%></button></td>
					
				<%
							}
							
							
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
		</div>
	</div>
</body>
</html>