<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br><br><br>

<div class="w3-container">

  
  <ul class="w3-navbar w3-sand">
  	<li><a href="javascript:void(0)" class="tablink w3-light-grey" onclick="show(event, 'changePassword');">Change Password</a></li>
    <li><a href="javascript:void(0)" class="tablink"  onclick="show(event, 'changeUserName');">Change User Name</a></li>
    <li><a href="javascript:void(0)" class="tablink"  onclick="show(event, 'changePictures');">Change Name</a></li>
  </ul>
  
	<div class="w3-card-4" style="height: 350px;">
	
		<!-- =============================================================================================================== -->

	  	<div id="changePassword" class="w3-container menu" >
	  	
	  	<!-- ============================== Change password ================================================== -->
	  	
	  		<div class="w3-third w3-padding">
	  			<h3>Change Password</h3>
	  		</div>
    		<div class="w3-third">
			<br><br><br>
			<form action="ChangePassword" method="post">

				<label class="w3-label w3-text-blue">Current Password</label>
  				<input class="w3-input w3-border " type="password" name="currentPassword" id="currentPassword" required>
  				
  				<label class="w3-label w3-text-blue">New Password</label>
  				<input class="w3-input w3-border " type="password" name="newPassword" id="newPassword" required>
  				
  				<label class="w3-label w3-text-blue">Confirm New Password</label>
  				<input class="w3-input w3-border " type="password" name="confirmNewPassword" id="confirmNewPassword" required>
  				
  				<br><div align="center"><input type="submit" class="w3-btn w3-indigo"></div>
  				
  			</form>

			<br>
			</div>
			<div class="w3-third"></div>
				
  			</div>
	
  	

		<!-- =============================================================================================================== -->

			
									<!-- <<<<<<<<<<<<<<<<<<<<<<<< Tabs >>>>>>>>>>>>>>>>>>>>>>>>>> -->


		<!-- ================================ Change user name ================================================= -->
		
			<div id="changeUserName" class="w3-container menu" style="display:none">
      						
    				<div class="w3-third w3-padding">
		  				<h3>Change User Name</h3>
	  				</div>
	  				<div class="w3-third">
	  				<br><br><br>
					<form action="ChangeUserName" method="post">

						<label class="w3-label w3-text-blue">Current User Name</label>
  						<input class="w3-input w3-border " type="text" name="currentUserName" id="currentUserName" required>
  				
		  				<label class="w3-label w3-text-blue">Password</label>
  						<input class="w3-input w3-border " type="password" name="password" id="password" required>
  				
  						<label class="w3-label w3-text-blue">New User Name</label>
  						<input class="w3-input w3-border " type="text" name="newUserName" id="newUserName" required>
  				
  						<br><div align="center"><input type="submit" class="w3-btn w3-indigo"></div>
  				
  					</form>
	
	  				</div>
	  				<div class="w3-third"></div>
			</div>

  		
  			<!-- =============================================================================================================== -->
  		
  		
  		
  		<div id="changePictures" class="w3-container menu" style="display:none">
  		<div class="w3-third w3-padding">
	  			<h3>Change Hotel Name</h3>
	  		</div>
    		<div class="w3-third">
    		<br><br><br>
				<form action="Settings" method="post">

						<label class="w3-label w3-text-blue">Change Hotel Name</label>
  						<input class="w3-input w3-border " type="text" name="hotelName" required>
  						
  						<br><div align="center"><input type="submit" class="w3-btn w3-indigo"></div>
				</form>
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


		<%
			String changeMsg= (String) request.getAttribute("ChangeMsg");
		
			if(changeMsg != null)
			{
				out.print(changeMsg);
			}
		%>
 	 		 
</div>

</body>
</html>