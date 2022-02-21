package pkg.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.bl.AdminLogic;
import pkg.dto.Menu;

/**
 * Servlet implementation class MenuCardServlet
 */
public class MenuCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuCardServlet() {
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
		
		request.setAttribute("menuList", menuList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("menuCard.jsp");
		requestDispatcher.forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Enumeration<String> parameters = request.getParameterNames();
		HttpSession session = request.getSession();
		int i=0;
		
		while(parameters.hasMoreElements())
		{
			String menu = parameters.nextElement();
			
			session.setAttribute("menu"+i, menu);
			session.setAttribute("price"+i, request.getParameter(menu));
			
			System.out.println(menu+" = "+request.getParameter(menu));
			i++;
		}
		
		session.setAttribute("count", i);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("placeOrder.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
