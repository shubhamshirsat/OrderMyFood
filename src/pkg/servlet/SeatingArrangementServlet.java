package pkg.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.bl.AdminLogic;

/**
 * Servlet implementation class SeatingArrangementServlet
 */
public class SeatingArrangementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatingArrangementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		AdminLogic adminLogic = new AdminLogic();
		request.setAttribute("tableList", adminLogic.getTables());
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("seatingArrangement.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String table = (String) request.getParameter("action");

		
		AdminLogic adminLogic = new AdminLogic();
		
		if(table.equals("delete"))
		{
			if(adminLogic.removeTable())
			{
				request.setAttribute("tableList", adminLogic.getTables());
			}
			else
			{
				
			}	
		}
		
		if(table.equals("add"))
		{
			if(adminLogic.addTable())
			{
				request.setAttribute("tableList", adminLogic.getTables());
			}
			else
			{
				
			}
		}
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("seatingArrangement.jsp");
		requestDispatcher.forward(request, response);
	}

}
