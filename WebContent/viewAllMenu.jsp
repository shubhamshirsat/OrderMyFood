<%@page import="pkg.dto.Category"%>
<%@page import="pkg.dto.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="w3.css">

</head>
<body>
	<%		
		
		ArrayList<Category> categoryList = (ArrayList<Category>) request.getAttribute("categoryList");
		ArrayList<Menu> menuList = (ArrayList<Menu>) request.getAttribute("menuList");
	
		ArrayList<Menu> sortedMenuList = new ArrayList<Menu>();
		int count[] = new int[categoryList.size()];
		int counter;
		
		for(int i=0; i < categoryList.size(); i++)
		{
			counter=0;
			Category category = categoryList.get(i);
		
			
			for(int j=0; j < menuList.size(); j++)
			{
				Menu menu = menuList.get(j);
			
				if(menu.getType() == category.getCategoryId())
				{
					sortedMenuList.add(menu);
					counter++;
				}
			}
			count[i] = counter;
		}
		
		
		
		
	
	%>
	
 
	
		<!-- ================================================================== -->
		
	<%
	  
		int row = (int)Math.ceil((float)categoryList.size()/3);
	
		int columnCounter = 1;
		int menuCounter = 0;
		
		for(int i=0 ,j=0; i< row; i++)
		{
			out.println("<div class='w3-row'>");
			
				while(columnCounter < 4)
				{
					
						if(categoryList.size() == j)
						{
							break;
						}
						Category category = categoryList.get(j);
						
	%>
			
							<div class="w3-third">
	  								<h2><%=category.getCategoryName() %></h2>
            
    		        				<table class="w3-table-all w3-centered">
    									<thead>
      										<tr class="w3-sand">
        										<th>ID</th>
        										<th>Type</th>
        										<th>Menu</th>
        										<th>Price(Rs)</th>
      										</tr>
    									</thead>
	<%
    								for(int k=0; k< count[j]; k++)
									{
		    							Menu menu = sortedMenuList.get(menuCounter); 
	%>
				    					<tr>
	        								<td><%=menu.getId() %></td>
        									<td><%=menu.getType() %></td>
        									<td><%=menu.getName() %></td>
        									<td><%=menu.getPrice() %></td>
      									</tr>
    							
	<%
    									menuCounter++;
									}
									j++;
	%>
							    	</table>
						    </div>
    		
	<%
					columnCounter++;
				}
				columnCounter = 1;
			
			out.println("</div>");
		}
	
		
	%>	
	
</body>
</html>