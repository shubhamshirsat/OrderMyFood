package pkg.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.bl.AdminLogic;

/**
 * Servlet implementation class SettingsServlet
 */
public class SettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SettingsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("settings.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String hotelName = (String) request.getParameter("hotelName");
		
		AdminLogic adminLogic = new AdminLogic();
		HttpSession session = request.getSession();
		
		if(adminLogic.changeHotelName(hotelName))
		{
			request.setAttribute("NameChangeMsg", "Hotel Name is changed to "+hotelName);
		}
		else
		{
			request.setAttribute("NameChangeMsg", "Error occurred while changing hotel name");
		}
		
		session.setAttribute("hotelName", adminLogic.getHotelName());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
		requestDispatcher.forward(request, response);
	}

}
