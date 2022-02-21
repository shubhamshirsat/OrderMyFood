package pkg.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.bl.AdminLogic;
import pkg.dto.Order;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			String username= request.getParameter("username");
			String password= request.getParameter("password");
			
			AdminLogic adminLogic = new AdminLogic();
			String page = "login.jsp";
			
			HttpSession session = request.getSession(); 
			
			if(adminLogic.authenticateUser(username, password))
			{
				page = "dashboard.jsp";
				
				ArrayList<Order> todaysOrderList = adminLogic.getOrdersByDate(null);
				request.setAttribute("todaysOrderList", todaysOrderList);
				request.setAttribute("date", null);
				session.setAttribute("user", username);
				session.setAttribute("hotelName", adminLogic.getHotelName());
			}
			else
			{
				request.setAttribute("errorMsg", "Incorrect user name or password");
			}
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);
			
	}

}
