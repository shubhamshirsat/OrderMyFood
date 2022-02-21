<%@page import="pkg.dto.Category"%>
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



</head>
<body>

<br><br><br>

<div class="w3-container">

  
  <ul class="w3-navbar w3-sand">
  	<li><a href="javascript:void(0)" class="tablink w3-light-grey" onclick="show(event, 'addNewMenu');">Add A Menu</a></li>
    <li><a href="javascript:void(0)" class="tablink"  onclick="show(event, 'category');">Create A New Category</a></li>
    <li><a href="javascript:void(0)" class="tablink"  onclick="show(event, 'removeCategory');">Remove Category</a></li>
  </ul>
  
	<div class="w3-card-4" style="height: 350px;">
	
		<!-- =============================================================================================================== -->

	  	<div id="addNewMenu" class="w3-container menu" >
	  	
	  	<!-- ============================== Add A New Menu ================================================== -->
	  	
	  		<div class="w3-third w3-padding">
	  			<h3>Add A Menu</h3>
	  		</div>
    		<div class="w3-third">
				 <br><br><br>
				 <%
				 	ArrayList<Category> categoryList = (ArrayList<Category>) request.getAttribute("categoryList");
				 %>
  				 <select class="w3-select w3-border" name="type" id="type" required>
	    			<option value="" disabled selected>Choose your option</option>
	    			<%
	    				for(int i=0; i<categoryList.size(); i++)
	    				{
	    					Category category = categoryList.get(i);
	    			%>
	    					<option value="<%=category.getCategoryId()%>"><%=category.getCategoryName() %></option>	
	    			<% 			
	    				}
	    			%>
  			  	</select>
	
  				<label class="w3-label w3-text-blue">Name of Menu</label>
  				<input class="w3-input w3-border " type="text" name="menuName" id="menuName" required>
  			
	  			<label class="w3-label w3-text-blue">Price(Rs.)</label>
  				<input class="w3-input w3-border " type="text" name="price" id="price" required>
	
				<br><div align="center"><button class="w3-btn w3-indigo" onclick="submitData()">Add Menu</button></div>
				<br>
				</div>
				<div class="w3-third"></div>
				
  			</div>
	
  	

		<!-- =============================================================================================================== -->

			
									<!-- <<<<<<<<<<<<<<<<<<<<<<<< Tabs >>>>>>>>>>>>>>>>>>>>>>>>>> -->


		<!-- ================================ Create A New Category ================================================= -->
		
			<div id="category" class="w3-container menu" style="display:none">
      						
    				<div class="w3-third w3-padding">
		  				<h3>Create A Category</h3>
	  				</div>
	  				<div class="w3-third w3-padding">
	  					<br><br><br>
	  					
		  				<label class="w3-label w3-text-blue">Category Name</label>
  						<input class="w3-input w3-border " type="text" id="menuCategory">
	
						<br><div align="center"><button class="w3-btn w3-indigo" onclick="createCategory()">Create Category</button></div>
	  				</div>
	  				<div class="w3-third"></div>
			</div>

  		
  			<!-- =============================================================================================================== -->
  		
  		
  		
  		<div id="removeCategory" class="w3-container menu" style="display:none">
  		<div class="w3-third w3-padding">
	  			<h3>Remove Category</h3>
	  		</div>
    		<div class="w3-third">
				 <br><br><br>
  				 <select class="w3-select w3-border" name="type" id="removeType" required>
	    			<option value="" disabled selected>Choose your option</option>
	    			<%
	    				for(int i=0; i<categoryList.size(); i++)
	    				{
	    					Category category = categoryList.get(i);
	    			%>
	    					<option value="<%=category.getCategoryId()%>"><%=category.getCategoryName() %></option>	
	    			<% 			
	    				}
	    			%>
  			  	</select>
	
				<br><br><div align="center"><button class="w3-btn w3-indigo" onclick="removeCategory()">Remove</button></div>
				<br><br>
				</div>
				<div class="w3-third"></div>
				
  			</div>
  		
  		
  		
  		
  		
  		
<!-- ============================================================================================================ -->  		
  	</div>
  	
  		<div class="w3-third w3-padding"></div>
  		
		  	<%	
  				String msg = (String) request.getAttribute("msg");
				
				if(msg != null)
				{
					out.println(msg);
				}
			%>
			
		<div class="w3-third"></div>

<script>

		function show(evt, division) 
		{
  			var i, x, tablinks;
  			x = document.getElementsByClassName("menu");
  			for (i = 0; i < x.length; i++) 
  			{
  	    		x[i].style.display = "none";
  			}
  			
  			tablinks = document.getElementsByClassName("tablink");
  
  			for (i = 0; i < x.length; i++) 
  			{
      			tablinks[i].className = tablinks[i].className.replace(" w3-light-grey", "");
  			}
  			
  			document.getElementById(division).style.display = "block";
  			evt.currentTarget.className += " w3-light-grey";
		}
</script>

 	 		 
</div>

</body>
</html>