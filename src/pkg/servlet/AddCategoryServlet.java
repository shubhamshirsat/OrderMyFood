package pkg.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.bl.AdminLogic;

/**
 * Servlet implementation class AddCategoryServlet
 */
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategoryServlet() {
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
		String category = request.getParameter("menuCategory");
		String action = request.getParameter("action");
		
		AdminLogic adminLogic = new AdminLogic();
		
		if(action.equals("create"))
		{
			if(adminLogic.createCategory(category))
			{
				request.setAttribute("categoryList", adminLogic.getCategoryList());
				request.setAttribute("msg", "<div class= 'w3-third w3-panel w3-green w3-card-4 w3-margin w3-animate-zoom'><span onclick=this.parentElement.style.display='none' class=w3-closebtn>&times;</span>"+category+" category successfully created"+"</div>");
			}
			else
			{
				request.setAttribute("categoryList", adminLogic.getCategoryList());
				request.setAttribute("msg", "<div class= 'w3-third w3-panel w3-red w3-card-4 w3-margin w3-animate-zoom'><span onclick=this.parentElement.style.display='none' class=w3-closebtn>&times;</span>"+"Error occurred while creating category"+"</div>");
			}
		}
		else
		{
			int id = Integer.parseInt(category);
			
			if(adminLogic.removeCategory(id))
			{
				request.setAttribute("categoryList", adminLogic.getCategoryList());
				request.setAttribute("msg", "<div class= 'w3-third w3-panel w3-green w3-card-4 w3-margin w3-animate-zoom'><span onclick=this.parentElement.style.display='none' class=w3-closebtn>&times;</span> category successfully deleted"+"</div>");
			}
			else
			{
				request.setAttribute("categoryList", adminLogic.getCategoryList());
				request.setAttribute("msg", "<div class= 'w3-third w3-panel w3-red w3-card-4 w3-margin w3-animate-zoom'><span onclick=this.parentElement.style.display='none' class=w3-closebtn>&times;</span>"+"Error occurred while deleting category"+"</div>");
			}
		}
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("manageMenu.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
