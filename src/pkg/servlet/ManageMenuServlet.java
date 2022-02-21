package pkg.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.bl.AdminLogic;
import pkg.dto.Menu;

/**
 * Servlet implementation class AddMenuServlet
 */
public class ManageMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ManageMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AdminLogic adminLogic = new AdminLogic();
		request.setAttribute("categoryList", adminLogic.getCategoryList());
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("manageMenu.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		AdminLogic adminLogic = new AdminLogic();
		String page = "manageMenu.jsp";
		
			try 
			{
				int type= Integer.parseInt(request.getParameter("type"));
				String menuName= request.getParameter("menuName");
				int price = Integer.parseInt(request.getParameter("price"));

				System.out.println("Type: "+type);
				System.out.println("Menu: "+menuName);
				System.out.println("Price: "+price);
				
				Menu menu = new Menu();
				
				menu.setType(type);
				menu.setName(menuName);
				menu.setPrice(price);
				
				if(adminLogic.isMenuAdded(menu))
				{
					request.setAttribute("categoryList", adminLogic.getCategoryList());
					request.setAttribute("msg", "<div class='w3-third w3-panel w3-green w3-card-4 w3-margin w3-animate-zoom'><span onclick=this.parentElement.style.display='none' class=w3-closebtn>&times;</span>"+menuName+" is successfully added to the menu."+"</div>");
				}
				else
				{
					request.setAttribute("categoryList", adminLogic.getCategoryList());
					request.setAttribute("msg", "<div class='w3-third w3-panel w3-red w3-card-4 w3-margin w3-animate-zoom'><span onclick=this.parentElement.style.display='none' class=w3-closebtn>&times;</span>"+"Error occurred while adding menu"+"</div>");
				}
			} 
			catch (NumberFormatException e) 
			{
				request.setAttribute("categoryList", adminLogic.getCategoryList());
				request.setAttribute("msg", "<div class='w3-third w3-panel w3-red w3-card-4 w3-margin w3-animate-zoom'><span onclick=this.parentElement.style.display='none' class=w3-closebtn>&times;</span>"+"Error:<br>Menu could not be added<br>Please create a category first!"+"</div>");
				e.printStackTrace();
			}
				
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);
	}

}
