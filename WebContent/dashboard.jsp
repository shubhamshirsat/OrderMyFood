<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="pkg.dto.Order"%>
<%@page import="java.util.ArrayList"%>

<%
		
%>    


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="w3.css">
<script src="jquery-3.1.0.min.js"></script>

<script>
var refreshId = setInterval(function()
{
    
     $('#count').load('OrderCounter');

}, 5000);
</script>

<script>
		function fetch(item)
		{	if(item == 'Logout')
			{
				window.location.href = "Logout";
			}
			else
			{
				$("#content").load(item);	
			}
		}
</script>


<script>
		function submitData()
		{
			var type = document.getElementById('type').value;
			var name = document.getElementById('menuName').value;
			var price = document.getElementById('price').value;
		
				var data = 'type='+type+'&menuName='+name+'&price='+price;
				var xhttp = new XMLHttpRequest();
			
				xhttp.onreadystatechange= function()
				{
					if(xhttp.readyState == 4 && xhttp.status == 200)
					{
						
						document.getElementById("content").innerHTML = xhttp.responseText;
					}
				};
				
				xhttp.open("POST", "ManageMenu", true);
				xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhttp.send(data);
		
		}
</script>


<script>
		function createCategory()
		{
			var category = document.getElementById('menuCategory').value;
			
		
				var data = 'menuCategory='+category+'&action=create';
				var xhttp = new XMLHttpRequest();
			
				xhttp.onreadystatechange= function()
				{
					if(xhttp.readyState == 4 && xhttp.status == 200)
					{
						
						document.getElementById("content").innerHTML = xhttp.responseText;
					}
				};
				
				xhttp.open("POST", "AddCategory", true);
				xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhttp.send(data);

		}
</script>


<script>
		function removeCategory()
		{
			var category = document.getElementById('removeType').value;
			
				var data = 'menuCategory='+category+'&action=delete';
				var xhttp = new XMLHttpRequest();
			
				xhttp.onreadystatechange= function()
				{
					if(xhttp.readyState == 4 && xhttp.status == 200)
					{
						
						document.getElementById("content").innerHTML = xhttp.responseText;
					}
				};
				
				xhttp.open("POST", "AddCategory", true);
				xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhttp.send(data);

		}
</script>




<script>

	function updateMenuName(menuName)
	{
		var updatedName= document.getElementById(menuName).value;
		
			var data = 'menuName='+menuName+'&updatedName='+updatedName;
			
			var xhttp = new XMLHttpRequest();
		
			xhttp.onreadystatechange= function()
			{
				if(xhttp.readyState == 4 && xhttp.status == 200)
				{
					
					document.getElementById("content").innerHTML = xhttp.responseText;
				}
			};
			
			xhttp.open("POST", "UpdateMenu", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send(data); 
	}
	
	function updateMenuPrice(menuName, price)
	{
		var updatedPrice= document.getElementById(menuName+price).value;
		
		var data = 'menuName='+menuName+'&updatedPrice='+updatedPrice;
		
		var xhttp = new XMLHttpRequest();
	
		xhttp.onreadystatechange= function()
		{
			if(xhttp.readyState == 4 && xhttp.status == 200)
			{
				
				document.getElementById("content").innerHTML = xhttp.responseText;
			}
		};
		
		xhttp.open("POST", "UpdateMenu", true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send(data); 
		
	}
	
	function  remove(menuId)
	{
		var data = "id="+menuId;
		
		var xhttp = new XMLHttpRequest();
		
		xhttp.onreadystatechange= function()
		{
			if(xhttp.readyState == 4 && xhttp.status == 200)
			{
				
				document.getElementById("content").innerHTML = xhttp.responseText;
			}
		};
		
		xhttp.open("POST", "UpdateMenu", true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send(data);
		
	}
</script>


<script>
		function addTable()
		{
			var data = 'action=add';
			
			var xhttp = new XMLHttpRequest();
			
			xhttp.onreadystatechange= function()
			{
				if(xhttp.readyState == 4 && xhttp.status == 200)
				{
					
					document.getElementById("content").innerHTML = xhttp.responseText;
				}
			};
			
			xhttp.open("POST", "SeatingArrangement", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send(data);
		}
</script>


<script>
		function removeTable()
		{
			var data = 'action=delete';
			
			var xhttp = new XMLHttpRequest();
			
			xhttp.onreadystatechange= function()
			{
				if(xhttp.readyState == 4 && xhttp.status == 200)
				{
					
					document.getElementById("content").innerHTML = xhttp.responseText;
				}
			};
			
			xhttp.open("POST", "SeatingArrangement", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send(data);
		}
</script>

<script>
		function getOrdersByDate()
		{
			var data = "data="+document.getElementById("dateOfOrders").value;
		
			var xhttp = new XMLHttpRequest();
			
			xhttp.onreadystatechange= function()
			{
				if(xhttp.readyState == 4 && xhttp.status == 200)
				{
					
					document.getElementById("content").innerHTML = xhttp.responseText;
				}
			};
			
			xhttp.open("POST", "Orders", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send(data);
		}
</script>

<script>
		function updateOrderStatus(orderStatus,orderId)
		{
			var status = document.getElementById(orderStatus).value;
			
			var data = "data="+status+"&orderId="+orderId;
			
			var xhttp = new XMLHttpRequest();
			
			xhttp.onreadystatechange= function()
			{
				if(xhttp.readyState == 4 && xhttp.status == 200)
				{
					
					document.getElementById("content").innerHTML = xhttp.responseText;
				}
			};
			
			xhttp.open("POST", "Orders", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send(data);
		}
</script>

<script>
		function viewOrderDetails(orderId)
		{
			var data = "orderId="+orderId;
			
			var xhttp = new XMLHttpRequest();
			
			xhttp.onreadystatechange= function()
			{
				if(xhttp.readyState == 4 && xhttp.status == 200)
				{
					
					document.getElementById("content").innerHTML = xhttp.responseText;
				}
			};
			
			xhttp.open("POST", "ViewOrder", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send(data);
		}
</script>

<script>
		function getReportsByDate()
		{
			var data = "data="+document.getElementById("dateOfReports").value;
		
			var xhttp = new XMLHttpRequest();
			
			xhttp.onreadystatechange= function()
			{
				if(xhttp.readyState == 4 && xhttp.status == 200)
				{
					
					document.getElementById("content").innerHTML = xhttp.responseText;
				}
			};
			
			xhttp.open("POST", "Reports", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send(data);
		}
</script>


<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<body class="w3-animate-left">

<nav class="w3-text-white w3-sidenav w3-collapse w3-card-2 w3-animate-left " style="width:250px; color:#fff; background-color:#373538;" id="mySidenav">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-closenav w3-large w3-hide-large">Close &times;</a><br><br><br>
  
  <table border="0">
  <tr>
  	<td><i class="material-icons">&#xe547;</i></td>
  	<td><a href="#" onclick="fetch('Orders')">Orders <div id="count" class="w3-badge w3-sand"></div></a></td>
  </tr>
  <tr>
  	<td><i class="material-icons">&#xe56c;</i></td>
  	<td><a href="#" onclick="fetch('ViewAllMenu')"> View All Menu</a></td>
  </tr>
  <tr>
  	<td><i class="material-icons">&#xe254;</i></td>
  	<td><a href="#" onclick="fetch('UpdateMenu')">Update Menu</a></td>
  </tr>
  <tr>
  	<td><i class="material-icons">&#xe02e;</i></td>
  	<td><a href="#" onclick="fetch('ManageMenu')">Manage Menu</a></td>
  </tr>
  <tr>
  	<td><i class="material-icons">&#xe903;</i></td>
  	<td><a href="#" onclick="fetch('SeatingArrangement')"> Seating Arrangement&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
  </tr>
  <tr>
  	<td><i class="material-icons">&#xe24b;</i></td>
  	<td><a href="#" onclick="fetch('Reports')"> Reports</a></td>
  </tr>
  <tr>
  	<td><i class="material-icons">&#xe8b8;</i></td>
  	<td><a href="#" onclick="fetch('Settings')"> Settings</a></td>
  </tr>
  <tr>
  	<td><i class="material-icons">&#xe8ac;</i></td>
  	<td><a href="#" onclick="fetch('Logout')"> Log out</a></td>
  </tr>
  </table>
    
</nav>

<div class="w3-main" style="margin-left:250px" id="main">

 	<header class="w3-container w3-sand">
  		<span class="w3-opennav w3-xlarge w3-hide-large" onclick="w3_open()">&#9776;</span>
  		<h4 style="float: left;">Hotel <%=(String) session.getAttribute("hotelName") %></h4>
  		<h3 style="float: right;"><%=(String) session.getAttribute("user")%><i class="material-icons">&#xe7fd;</i> </h3>
	</header> 

	<div class="w3-container w3-margin" id="content" >
	
	<%
		String msg = (String) request.getAttribute("NameChangeMsg");
		if(msg != null)
		{
			out.println(msg);
		}
	%>
	
	</div>

<!-- 	<footer class="w3-container w3-teal">
  		<h5>Footer</h5>
  		<p>Footer information goes here</p>
	</footer>
       -->
</div>


<script>
function w3_open() 
{
    document.getElementById("mySidenav").style.display = "block";
}
function w3_close() 
{
    document.getElementById("mySidenav").style.display = "none";
}
</script>




</body>
</html>