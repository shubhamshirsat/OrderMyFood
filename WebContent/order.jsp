<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pkg.dto.Order"%>
<%@page import="pkg.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	Customer customer = null;
	ArrayList<Order> orderList = null;
	String refresh = "no";
	
	try
	{
		 customer = (Customer) session.getAttribute("customer");
		 orderList  = (ArrayList<Order>) session.getAttribute("orderList");
		 refresh = (String) request.getAttribute("refresh");
		 
		 
		 if(customer == null || orderList == null)
		 {
			 customer = (Customer) request.getAttribute("customer");
			 orderList  = (ArrayList<Order>) request.getAttribute("orderList");
			 refresh = (String) request.getAttribute("refresh");
		
		 }
		 
	}
	catch(Exception e)
	{
		customer = (Customer) request.getAttribute("customer");
		orderList  = (ArrayList<Order>) request.getAttribute("orderList");
		refresh = (String) request.getAttribute("refresh");
		
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice of <%=customer.getName() %></title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="w3.css">
<script src="jquery-3.1.0.min.js"></script>

<%
	if(refresh.equals("yes"))
	{
%>
		
	<script>
		var refreshId = setInterval(function()
		{
    	
     		$('#orderStatus').load('OrderStatus');

		}, 5000);
	</script>
	
<%
	}
	
%>


<script>
function myFunction() {
    window.print();
}
</script>

<style>
@media print {
  body * {
    visibility: hidden;
  }
    
  #section-to-print, #section-to-print * {
    visibility: visible;
  }
  #section-to-print 
  {
    position: absolute;
    left: 0%;
    top: 10%;
  }
}

</style>


</head>
<body>
<div class="w3-container" id="invoice"> 
<br>
	<div class="w3-third w3-padding">
	</div>
	
	<div class="w3-third w3-border" id="section-to-print">
	<table class="w3-table w3-bordered w3-centered">
	<tr>
		<td class="w3-light-grey">Order ID</td>
		<td colspan="3">OD-<%=customer.getId() %></td>
	</tr>
	<tr>
		<td class="w3-light-grey">Name</td>
		<td colspan="3"><%=customer.getName() %></td>
	</tr>
	<tr>
		<td class="w3-light-grey">Mobile</td>
		<td colspan="3"><%=customer.getMobile() %></td>
	</tr>
	<tr>
		<td class="w3-light-grey">Table No.</td>
		<td colspan="3"><%=customer.getTable() %></td>
	</tr>
	<tr class="w3-light-grey">
		<th>Menu</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>total</th>
	</tr>
	<%
		int grandTotal = 0;
		String status = "Not Available";
		Timestamp order_timestTimestamp = null;
		
		for(int i=0; i< orderList.size(); i++)
		{
			Order order = orderList.get(i);
	%>
			<tr>
				<td><%=order.getOrderName() %></td>
				<td><%=order.getOrderPrice() %></td>
				<td><%=order.getOrderQuantity() %></td>
				<td><%=order.getOrderTotal() %></td>
				<%status = order.getOrderStatus(); %>
				<%order_timestTimestamp = order.getOrder_timestamp(); %>
			</tr>
	<%
			grandTotal = grandTotal+order.getOrderTotal();
		}
	%>
	<tr>
		<th colspan="3" class="w3-light-grey">Grand Total</th>
		<th>Rs &nbsp;<%=grandTotal %>.00</th>
	</tr>
	<tr>
		<th colspan="3" class="w3-light-grey">Order Timestamp</th>
		<th><%=order_timestTimestamp %></th>
	</tr>
	<tr>
		<th colspan="3" class="w3-light-grey">Order Status</th>
		<th <%if(status.equals("Served")){out.println("class='w3-green'");}else if(status.equals("Cancelled")){out.println("class='w3-orange'");} %>><div id="orderStatus"><%if(refresh.equals("no")){out.print(status);} %></div></th>
	</tr>
	</table>
	
	</div>
	
	<br><br>
	
	

	<div class="w3-padding">
		<button onclick="window.print()">Print this page</button>
	</div>

</body>
</html>
