<%@page import="pkg.dto.Category"%>
<%@page import="pkg.dto.Menu"%>
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
        										<th>Menu</th>
        										<th>Price(Rs)</th>
        										<th></th>
      										</tr>
    									</thead>
	<%
    								for(int k=0; k< count[j]; k++)
									{
		    							Menu menu = sortedMenuList.get(menuCounter); 
	%>
				    				<tr>
        								<td><input type="text" name="menuName" value="<%=menu.getName() %>" id="<%=menu.getName() %>" style="width: 190px;" oninput="updateMenuName('<%=menu.getName() %>')"></td>
        								<td><input type="number" name="price" value="<%=menu.getPrice() %>" id="<%=menu.getName()+menu.getPrice() %>"  style="width: 60px;" oninput="updateMenuPrice('<%=menu.getName() %>', '<%=menu.getPrice() %>')"></td>
        								<td><a href="#" style="text-decoration: none;" onclick="remove('<%=menu.getId()%>')"><i class="material-icons">delete_forever</i></a></td>
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

























<%--
===================================================================================================================================================
 
	<%
		ArrayList<Menu> menuList = (ArrayList<Menu>) request.getAttribute("menuList");
	
		ArrayList<Menu> snacksList = new ArrayList<Menu>();
		ArrayList<Menu> southIndianList = new ArrayList<Menu>();
		ArrayList<Menu> chaineesList = new ArrayList<Menu>();
		ArrayList<Menu> chatList = new ArrayList<Menu>();
		ArrayList<Menu> iceCreamList = new ArrayList<Menu>();
		ArrayList<Menu> coldDrinksList = new ArrayList<Menu>();
		
		
		for(int i=0; i< menuList.size(); i++)
		{
			Menu menu = menuList.get(i);
	
			switch(menu.getType())
			{
				case 1:
								snacksList.add(menu);
								break;
				case 2:
								southIndianList.add(menu);
    							break;
				case 3:
								chaineesList.add(menu);
    							break;
				case 4:
								chatList.add(menu);
    							break;
				case 5:
								iceCreamList.add(menu);
    							break;
				case 6:
								coldDrinksList.add(menu);
    							break;
			}
			
		}
	%>
	
	
	
	<div class="w3-row">
    		
		<div class="w3-third">
  			<h2>Snacks</h2>
            
            <table class="w3-table-all w3-centered">
    		<thead>
      			<tr class="w3-blue">
  
        			<th>Menu</th>
        			<th>Price(Rs)</th>
        			<th></th>
      			</tr>
    		</thead>
    		
    		<%
    			for(int i=0; i< snacksList.size(); i++)
				{
    				Menu menu = snacksList.get(i); 
    		%>
    				<tr>
        				<td><input type="text" name="menuName" value="<%=menu.getName() %>" id="<%=menu.getName() %>" style="width: 200px;" oninput="updateMenuName('<%=menu.getName() %>')"></td>
        				<td><input type="number" name="price" value="<%=menu.getPrice() %>" id="<%=menu.getName()+menu.getPrice() %>"  style="width: 60px;" oninput="updateMenuPrice('<%=menu.getName() %>', '<%=menu.getPrice() %>')"></td>
        				<td><a href="#" style="text-decoration: none;" onclick="remove('<%=menu.getId()%>')">X</a></td>
      				</tr>
    							
    		<%
				}
    		%>
    	
    		</table>
            
		</div>
		
	
		<div class="w3-third">
    		
    		<h2>South Indian</h2>
            
            <table class="w3-table-all w3-centered">
    		<thead>
      			<tr class="w3-blue">
  
        			<th>Menu</th>
        			<th>Price(Rs)</th>
        			<th></th>
      			</tr>
    		</thead>
    		
    		<%
    			for(int i=0; i< southIndianList.size(); i++)
				{
    				Menu menu = southIndianList.get(i); 
    		%>
    				<tr>
        				<td><input type="text" name="menuName" value="<%=menu.getName() %>" style="width: 200px;"></td>
        				<td><input type="number" name="price" value="<%=menu.getPrice() %>" style="width: 60px;"></td>
        				<td><a href="#" style="text-decoration: none;" onclick="remove('<%=menu.getId()%>')">X</a></td>
      				</tr>
    							
    		<%
				}
    		%>
    	
    		</table>
    		
		</div>
		
		
		<div class="w3-third">
  	
  			<h2>Chainees</h2>
            
            <table class="w3-table-all w3-centered">
    		<thead>
      			<tr class="w3-blue">
  
        			<th>Menu</th>
        			<th>Price(Rs)</th>
        			<th></th>
      			</tr>
    		</thead>
    		
    		<%
    			for(int i=0; i< chaineesList.size(); i++)
				{
    				Menu menu = chaineesList.get(i); 
    		%>
    				<tr>
        			    <td><input type="text" name="menuName" value="<%=menu.getName() %>" style="width: 200px;"></td>
        				<td><input type="number" name="price" value="<%=menu.getPrice() %>" style="width: 60px;"></td>
        				<td><a href="#" style="text-decoration: none;" onclick="remove('<%=menu.getId()%>')">X</a></td>
      				</tr>
    							
    		<%
				}
    		%>
    	
    		</table>
  	
		</div>
		
	</div>

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

<br>


<div class="w3-row">
    		
		<div class="w3-third">
  			<h2>Chat</h2>
            
            <table class="w3-table-all w3-centered">
    		<thead>
      			<tr class="w3-blue">
  
        			<th>Menu</th>
        			<th>Price(Rs)</th>
        			<th></th>
      			</tr>
    		</thead>
    		
    		<%
    			for(int i=0; i< chatList.size(); i++)
				{
    				Menu menu = chatList.get(i); 
    		%>
    				<tr>
  
  						<td><input type="text" name="menuName" value="<%=menu.getName() %>" style="width: 200px;"></td>
        				<td><input type="number" name="price" value="<%=menu.getPrice() %>" style="width: 60px;"></td>
        				<td><a href="#" style="text-decoration: none;" onclick="remove('<%=menu.getId()%>')">X</a></td>
      				</tr>
    							
    		<%
				}
    		%>
    	
    		</table>
            
		</div>
		
	
		<div class="w3-third">
    		
    		<h2>Ice Creams</h2>
            
            <table class="w3-table-all w3-centered">
    		<thead>
      			<tr class="w3-blue">
  
        			<th>Menu</th>
        			<th>Price(Rs)</th>
        			<th></th>
      			</tr>
    		</thead>
    		
    		<%
    			for(int i=0; i< iceCreamList.size(); i++)
				{
    				Menu menu = iceCreamList.get(i); 
    		%>
    				<tr>
  						<td><input type="text" name="menuName" value="<%=menu.getName() %>" style="width: 200px;"></td>
        				<td><input type="number" name="price" value="<%=menu.getPrice() %>" style="width: 60px;"></td>
        				<td><a href="#" style="text-decoration: none;" onclick="remove('<%=menu.getId()%>')">X</a></td>
      				</tr>
    							
    		<%
				}
    		%>
    	
    		</table>
    		
		</div>
		
		
		<div class="w3-third">
  	
  			<h2>Cold Drinks</h2>
            
            <table class="w3-table-all w3-centered">
    		<thead>
      			<tr class="w3-blue">
  
        			<th>Menu</th>
        			<th>Price(Rs)</th>
        			<th></th>
      			</tr>
    		</thead>
    		
    		<%
    			for(int i=0; i< coldDrinksList.size(); i++)
				{
    				Menu menu = coldDrinksList.get(i); 
    		%>
    				<tr>
  
        				<td><input type="text" name="menuName" value="<%=menu.getName() %>" style="width: 200px;"></td>
        				<td><input type="number" name="price" value="<%=menu.getPrice() %>" style="width: 60px;"></td>
        				<td><a href="#" style="text-decoration: none;" onclick="remove('<%=menu.getId()%>')">X</a></td>
      				</tr>
    							
    		<%
				}
    		%>
    	
    		</table>
  	
		</div>
		
	</div>


 --%>	
	
</body>
</html>