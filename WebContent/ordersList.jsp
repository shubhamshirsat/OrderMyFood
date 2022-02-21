<%@page import="pkg.dto.Order"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  -->

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script src="w3.js"></script>

</head>
<body>
<input type="date" id="dateOfOrders" style="float:right;" onchange="getOrdersByDate()">
<div  class="w3-threequarter" id="orders">
<h3>Orders update</h3>

	<%
		ArrayList<Order> todaysOrderList = (ArrayList<Order>) request.getAttribute("todaysOrderList");
	%>

	
	<%
			if(!todaysOrderList.isEmpty())
			{
	
				int prev = 0;
				int curr = 0;
				int count = 0;
				
				for(int i = todaysOrderList.size()-1; i >= 0 ; i--)
				{
					Order order = todaysOrderList.get(i);
					curr = order.getOrderId();
					
					if(prev==curr)
					{
						if(count == 0)
						{
							out.println("<div class='w3-padding w3-card-4'><table class='w3-table-all'>");
		%>
							<tr <%if(order.getOrderStatus().equals("Cancelled")){out.println("class='w3-orange'");}else if(order.getOrderStatus().equals("Served")){out.println("class='w3-green'");} %>>
							<td><a href="#" onclick="viewOrderDetails('<%=order.getOrderId() %>')"><b>OD-<%=order.getOrderId() %></b></td>
							<td><%=order.getOrderTable() %></td>
							<td><%=order.getOrder_timestamp() %></td>
							<td><select class="w3-select" id="status<%=order.getOrderId()%>" onchange="updateOrderStatus('status<%=order.getOrderId()%>','<%=order.getOrderId() %>')" <%if(!order.getOrderStatus().equals("Pending")){out.println("disabled='disabled'");} %>>
								<option value="" disabled selected><%=order.getOrderStatus() %></option>
								<option>Served</option>
								<option>Cancelled</option>
								</select>
							</td>
							<td>
							<button class="w3-btn" onclick="w3.toggleShow('#tog<%=order.getOrderId()%>')">+</button>
							</td>
							</tr>
							</table>
							<br>
							<div id="tog<%=order.getOrderId() %>" style="display: none;" class="w3-animate-left">
							<table class="w3-table-all w3-padding">
							<tr>
								<th>Menu</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Total</th>
							</tr>
		<%					
						}
	%>
						
						<tr>					
						<td><%=order.getOrderName() %></td>
						<td><%=order.getOrderQuantity() %></td>
						<td><%=order.getOrderPrice() %></td>
						<td><%=order.getOrderTotal() %></td>
						</tr>
						
						
						
	<%
						count++;
					}
					else
					{
						if(count >0)
						{
							count =0;
							out.println("</table></div></div><br>");
						}
						
						if(count == 0)
						{
							out.println("<div class='w3-padding w3-card-4'><table class='w3-table'>");
							%>
							<tr>
							<td <%if(order.getOrderStatus().equals("Cancelled")){out.println("class='w3-orange'");}else if(order.getOrderStatus().equals("Served")){out.println("class='w3-green'");} %>><a href="#" onclick="viewOrderDetails('<%=order.getOrderId() %>')"><b>OD-<%=order.getOrderId() %></b></td>
							<td><%=order.getOrderTable() %></td>
							<td><%=order.getOrder_timestamp() %></td>
							<td><select id="status<%=order.getOrderId()%>" onchange="updateOrderStatus('status<%=order.getOrderId()%>','<%=order.getOrderId() %>')" <%if(!order.getOrderStatus().equals("Pending")){out.println("disabled='disabled'");} %>>
								<option value="" disabled selected><%=order.getOrderStatus() %></option>
								<option>Served</option>
								<option>Cancelled</option>
								</select>
							</td>
							<td>
							<button href="#" style="border: none;" onclick="w3.toggleShow('#tog<%=order.getOrderId()%>')"><i class="material-icons">unfold_more</i></button>
							</td>
							</tr>
							</table>
							<br>
							<div id="tog<%=order.getOrderId()%>" style="display: none;" class="w3-animate-left">
							<table class="w3-table-all w3-padding">
							<tr>
								<th>Menu</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Total</th>
							</tr>
								
		<%					
							
						}
	%>
						<tr>					
						<td><%=order.getOrderName() %></td>
						<td><%=order.getOrderQuantity() %></td>
						<td><%=order.getOrderPrice() %></td>
						<td><%=order.getOrderTotal() %></td>
						</tr>
						
	<%
						count++;
					}
					
					prev = order.getOrderId();
				}
			}
			else
			{
				String date = (String) request.getAttribute("date");
				if(date == null)
				{
					out.println("<center><br><br><br><br><br><br><div class='w3-light-grey'><h3 class='w3-text-grey'>No Orders Available Today &nbsp;<i class='material-icons'>warning</i></h3></div></center>");
				}
				else
				{
					out.println("<center><br><br><br><br><br><br><div class='w3-light-grey'><h3 class='w3-text-grey'>No Orders Available On Date "+date+"&nbsp;<i class='material-icons'>warning</i></h3></div></center>");
				}
			}
	
	%>
</div>


</body>
</html>
