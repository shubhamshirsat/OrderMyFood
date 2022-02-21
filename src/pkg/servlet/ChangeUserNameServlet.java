package pkg.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.bl.AdminLogic;

/**
 * Servlet implementation class ChangeUserNameServlet
 */
public class ChangeUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String currentUserName = (String) request.getParameter("currentUserName");
		String password = (String) request.getParameter("password");
		String newUserName = (String) request.getParameter("newUserName");
		
		
		AdminLogic adminLogic = new AdminLogic();
		
		if(adminLogic.changeUserName(currentUserName, password, newUserName))
		{
			request.setAttribute("ChangeMsg", "<div align=center class= w3-text-green>User name has been changed, please login again with new user-name</div>");			
		}
		else
		{
			request.setAttribute("ChangeMsg", "<div align=center class= w3-text-red>Error occurred while changing user-name</div>");
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
