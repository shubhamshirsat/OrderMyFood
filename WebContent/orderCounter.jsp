<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="pkg.dto.Order"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <%
    
    ArrayList<Order> todaysOrderList = (ArrayList<Order>) request.getAttribute("todaysOrderList");
	int count = 0;
    
 	for(int i=0; i<todaysOrderList.size(); i++)
 	{
 		Order order = todaysOrderList.get(i);
 		if(order.getOrderStatus().equals("Pending"))
 		{
 			count++;
 		}
 	}
 	
 	out.println(count);
 %>
 --%> 
 
 	<%
		ArrayList<Order> todaysOrderList = (ArrayList<Order>) request.getAttribute("todaysOrderList");
 	
 		int pendingOrderCounter = 0;
 		
	%>

	
	<%
			if(!todaysOrderList.isEmpty())
			{
	
				int prev = 0;
				int curr = 0;
								
				for(int i = todaysOrderList.size()-1; i >= 0 ; i--)
				{
					Order order = todaysOrderList.get(i);
					curr = order.getOrderId();
					
					if(prev==curr)
					{
				
					}
					else
					{
						if(order.getOrderStatus().equals("Pending"))
						{
							pendingOrderCounter++;	
						}
					}
					
					prev = order.getOrderId();
				}
			}
			out.println(pendingOrderCounter);
	%>
 
 
 
</body>
</html>