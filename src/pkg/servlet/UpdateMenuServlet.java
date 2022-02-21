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
 * Servlet implementation class UpdateMenuServlet
 */
public class UpdateMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMenuServlet() {
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
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("updateMenu.jsp");
		requestDispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String menuName = request.getParameter("menuName");
		String updatedMenuPrice = request.getParameter("updatedPrice");
		String id = request.getParameter("id");
		
		String updatedMenuName;
		
		
		AdminLogic adminLogic = new AdminLogic();
		
		if(id != null)
		{
			String deleteQuery = "delete from menu where uid= '"+id+"';";
			
			adminLogic.updateMenu(deleteQuery);
		}
		else if(updatedMenuPrice == null)
		{
			updatedMenuName = request.getParameter("updatedName");
			
			String updateQuery = "update menu set menuName= '"+updatedMenuName+"' where menuName= '"+menuName+"';";
			
			if(!adminLogic.updateMenu(updateQuery))
			{
				
				request.setAttribute("errorMsg", "Unable to update data");
			}
			
		}
		else  
		{
			String updateQuery = "update menu set price= '"+updatedMenuPrice+"' where menuName= '"+menuName+"'";
			
			if(!adminLogic.updateMenu(updateQuery))
			{
				request.setAttribute("errorMsg", "Unable to update data");
			}
		}
		
		
		ArrayList<Menu> menuList = adminLogic.viewAllMenu();
		
		request.setAttribute("menuList", menuList);
		request.setAttribute("categoryList", adminLogic.getCategoryList());
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("updateMenu.jsp");
		requestDispatcher.forward(request, response);
	}

}
