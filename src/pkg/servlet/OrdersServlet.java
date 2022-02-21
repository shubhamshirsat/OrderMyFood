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
 * Servlet implementation class OrdersServlet
 */
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String date= null;
		
		AdminLogic adminLogic = new AdminLogic();
		ArrayList<Order> todaysOrderList = adminLogic.getOrdersByDate(date);
		request.setAttribute("todaysOrderList", todaysOrderList);
		request.setAttribute("date", date);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ordersList.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String data = request.getParameter("data");
		System.out.println("\n\nOrder date is : "+data);
		AdminLogic adminLogic = new AdminLogic();
		
		if(data.equals("Served")||data.equals("Cancelled"))
		{
			int orderId = Integer.parseInt((String) request.getParameter("orderId"));
			System.out.println("\nOrder id: "+orderId);
			
			if(adminLogic.updateOrderStatus(data, orderId))
			{
				data = null;
				ArrayList<Order> todaysOrderList = adminLogic.getOrdersByDate(data);
				request.setAttribute("todaysOrderList", todaysOrderList);
				request.setAttribute("date", data);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ordersList.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		else
		{
			ArrayList<Order> todaysOrderList = adminLogic.getOrdersByDate(data);
			request.setAttribute("todaysOrderList", todaysOrderList);
			request.setAttribute("date", data);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ordersList.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}

}
