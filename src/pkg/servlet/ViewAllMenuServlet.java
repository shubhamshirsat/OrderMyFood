package pkg.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.bl.AdminLogic;
import pkg.dto.Menu;

/**
 * Servlet implementation class ViewAllMenuServlet
 */
public class ViewAllMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AdminLogic adminLogic = new AdminLogic();
		ArrayList<Menu> menuList = adminLogic.viewAllMenu();
		
		request.setAttribute("categoryList", adminLogic.getCategoryList());
		request.setAttribute("menuList", menuList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewAllMenu.jsp");
		requestDispatcher.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

}
