<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%
    	Integer count = (Integer) session.getAttribute("count");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="w3.css">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>

	<script>
    	$(document).ready(function() {
	        function disableBack() { window.history.forward() }
	
        	window.onload = disableBack();
        	window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
    	});
	</script>
			

<script>

		var gt = 0;
		
		function total(price, id)
		{
			var quantity = document.getElementById(id).value;
			
			var total = price * quantity;
			
			document.getElementById('total'+id).value = total;
			
			grandTotal();
		}
		
		function grandTotal()
		{			
			var i;
			var total = [];
			var sum = 0;
			
			for(i = 0; i< <%=count%> ; i++)
			{
				total[i] = document.getElementById('total'+i).value;
				
				sum += parseInt(total[i]);
			}
			
			document.getElementById('grandTotal').innerHTML = sum;
		}
</script>

</head>
<body>
<br><br>

<form action="PlaceOrder" method="post">
<div class="w3-container">

	<div class="w3-row w3-border">
	<br>
		<div class="w3-twothird">
		
			  <table>
			  	
			  	<tr>
			  		<th>
			  			Menu
			  		</th>
			  		<th>
			  		</th>
			  		<th>
			  			Price
			  		</th>
			  		<th>
			  			Quntity
			  		</th>
			  		<th>
			  			Total
			  		</th>
			  	</tr>
			  
			  	<%
					
					for(int i=0; i< count.intValue(); i++)
					{
						
							out.println("<tr>");
							out.println("<td><input type='hidden' name='"+(String) session.getAttribute("menu"+i)+"' value='"+(String) session.getAttribute("menu"+i)+"'>"+(String) session.getAttribute("menu"+i)+"</td>");
							out.println("<td>&nbsp;</td><td><input type='text' name='price"+i+"' readonly='readonly' class='w3-input' style='border: 0px; width:50px;' value='"+(String) session.getAttribute("price"+i)+"'></td>");
							out.println("<td><input class='w3-input w3-border' type='number' min='0' name='quantity"+i+"' value='0' id='"+i+"' onchange='total("+session.getAttribute("price"+i)+","+i+")' onkeyup='total("+session.getAttribute("price"+i)+","+i+")'></td>");
							out.println("<td><input class='w3-input w3-border' type='number' name='ttl"+i+"' id='total"+i+"' value='0' readonly='readonly'></td>");
							out.println("</tr>");		
						
					}
				%>
	
				</table>
			  
		</div>

		
		<div class="w3-third w3-container">
			<br>		
			<h2>Grand Total = <span id="grandTotal"></span></h2><br><br><br>
			<input type="submit" value="Place Order" class="w3-btn w3-indigo" style="float: right;">
			<br><br><br>
		</div>
	</div>
	<%
		String msg = (String) request.getAttribute("errorMsg");
	
		if(msg != null)
		{
			out.println(msg);
		}
	%>
	</div>
	
</form>

<br><br>
</body>
</html>