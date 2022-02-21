<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">



</head>

<body>
<input type="date" id="dateOfReports" style="float:right;" onchange="getReportsByDate()">
<br>
<br>
<br>


<div id="reports" class="w3-card-4 w3-padding-16">
<%
	String reportAvailable = (String) request.getAttribute("ReportAvailable");

	if(reportAvailable.equals("yes"))
	{
		String date = (String) request.getAttribute("Date");
		
		Integer totalOrders = (Integer) request.getAttribute("TotalOrders");
		Integer servedOrders = (Integer) request.getAttribute("ServedOrders");
		Integer cancelledOrders = (Integer) request.getAttribute("CancelledOrders");
		Integer pendingOrders = (Integer) request.getAttribute("PendingOrders");
		Integer totalcollection = (Integer) request.getAttribute("TotalCollection");

		%>				
		<h4>&nbsp;&nbsp;&nbsp;&nbsp;<%=date %></h4> 	
		
		
		 <br>
		<div class="w3-row">
		
			<div class="w3-quarter w3-container">
				<div class="w3-border w3-hover-shadow w3-center">
					<header class="w3-container w3-light-grey">
      					<h3>Total orders</h3>
    				</header>
    				<div class="w3-container">
    					<h3><%=totalOrders.intValue() %></h3>
    				</div>
				</div>
			</div>
			
			<div class="w3-quarter w3-container">
				<div class="w3-border w3-hover-shadow w3-center">
					<header class="w3-container w3-green">
      					<h3>Served Orders</h3>
    				</header>
    				<div class="w3-container">
		 				<h3><%=servedOrders.intValue() %></h3>
    				</div>
				</div>
			</div>


			<div class="w3-quarter w3-container">
				<div class="w3-border w3-hover-shadow w3-center">
					<header class="w3-container w3-orange">
      					<h3>Cancelled orders</h3>
    				</header>
    				<div class="w3-container">
						<h3><%=cancelledOrders.intValue() %></h3>
    				</div>
				</div>
			</div>


			<div class="w3-quarter w3-container">
				<div class="w3-border w3-hover-shadow w3-center">
					<header class="w3-container w3-light-grey">
      					<h3>Pending orders</h3>
    				</header>
    				<div class="w3-container">
		 				<h3><%=pendingOrders.intValue() %></h3>
    				</div>
				</div>
			</div>


		</div>
		
		<br><br><br>
		
		<div class="w3-row">
			<div class="w3-quarter w3-container">
			
				<div class="w3-border w3-hover-shadow w3-center">
					<header class="w3-container w3-blue">
      					<h3>Total collection</h3>
    				</header>
    				<div class="w3-container">
		 				<h3><%=totalcollection.intValue() %></h3>
    				</div>
				</div>
			
			</div>
		</div>
		
		

<%
	}
	else
	{
		String date = (String) request.getAttribute("dateOfReport");
		
		out.println("<center><br><br><br><div class='w3-light-grey'><h3 class='w3-text-grey'>"+date+"&nbsp;<i class='material-icons'>warning</i></h3></div><br><br><br></center>");
	}


%>
<br>
</div>




<br><br><br><br>	<!--***** Monthly Report ********-->





<div id="monthlyReports" class="w3-card-4 w3-padding-16">
<%
	String monthlyReportAvailable = (String) request.getAttribute("MonthlyReportAvailable");

	if(monthlyReportAvailable.equals("yes"))
	{
		String date = (String) request.getAttribute("Date");
		
		Integer totalOrders = (Integer) request.getAttribute("MonthlyTotalOrders");
		Integer servedOrders = (Integer) request.getAttribute("MonthlyServedOrders");
		Integer cancelledOrders = (Integer) request.getAttribute("MonthlyCancelledOrders");
		Integer pendingOrders = (Integer) request.getAttribute("MonthlyPendingOrders");
		Integer totalcollection = (Integer) request.getAttribute("MonthlyTotalCollection");
%>
		
		
		
		<h4>&nbsp;&nbsp;&nbsp;&nbsp;Monthly Report</h4><br>
		<div class="w3-row">
		
			<div class="w3-quarter w3-container">
				<div class="w3-border w3-hover-shadow w3-center">
					<header class="w3-container w3-light-grey">
      					<h3>Total orders</h3>
    				</header>
    				<div class="w3-container">
    					<h3><%=totalOrders.intValue() %></h3>
    				</div>
				</div>
			</div>
			
			<div class="w3-quarter w3-container">
				<div class="w3-border w3-hover-shadow w3-center">
					<header class="w3-container w3-green">
      					<h3>Served Orders</h3>
    				</header>
    				<div class="w3-container">
		 				<h3><%=servedOrders.intValue() %></h3>
    				</div>
				</div>
			</div>


			<div class="w3-quarter w3-container">
				<div class="w3-border w3-hover-shadow w3-center">
					<header class="w3-container w3-orange">
      					<h3>Cancelled orders</h3>
    				</header>
    				<div class="w3-container">
						<h3><%=cancelledOrders.intValue() %></h3>
    				</div>
				</div>
			</div>


			<div class="w3-quarter w3-container">
				<div class="w3-border w3-hover-shadow w3-center">
					<header class="w3-container w3-light-grey">
      					<h3>Pending orders</h3>
    				</header>
    				<div class="w3-container">
		 				<h3><%=pendingOrders.intValue() %></h3>
    				</div>
				</div>
			</div>


		</div>
		
		<br><br><br>
		
		<div class="w3-row">
			<div class="w3-quarter w3-container">
			
				<div class="w3-border w3-hover-shadow w3-center">
					<header class="w3-container w3-blue">
      					<h3>Total collection</h3>
    				</header>
    				<div class="w3-container">
		 				<h3><%=totalcollection.intValue() %></h3>
    				</div>
				</div>
			
			</div>
		</div>
		
		

<%
	}
	else
	{
		String date = (String) request.getAttribute("monthlyReport");
		
		out.println("<center><br><br><br><div class='w3-light-grey'><h3 class='w3-text-grey'>"+date+"&nbsp;<i class='material-icons'>warning</i></h3></div></center>");
	}


%>

<br>
</div>

<br><br><br><br>

</body>
</html>