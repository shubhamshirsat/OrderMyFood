package pkg.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.bl.AdminLogic;
import pkg.dto.Order;

/**
 * Servlet implementation class OrderCounterServlet
 */
public class OrderCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AdminLogic adminLogic = new AdminLogic();
		ArrayList<Order> todaysOrderList = adminLogic.getOrdersByDate(null);
		request.setAttribute("todaysOrderList", todaysOrderList);
		request.setAttribute("date", null);
		
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("orderCounter.jsp");
		 requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
