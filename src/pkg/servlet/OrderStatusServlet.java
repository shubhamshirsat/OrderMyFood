package pkg.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.bl.AdminLogic;
import pkg.dto.Customer;
import pkg.dto.Order;

/**
 * Servlet implementation class OrderStatusServlet
 */
public class OrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		
		int orderId = customer.getId();
		AdminLogic adminLogic = new AdminLogic();
		ArrayList<Order> orderList = adminLogic.getOrderDetails(orderId, request);
		
		String status = "";
		
		for(int i=0; i< orderList.size(); i++)
		{
			Order order = orderList.get(i);
			status = order.getOrderStatus();
		}
		
		if(status.equals("Pending"))
		{
			request.setAttribute("refreshAgain", "yes");
		}
		else
		{
			request.setAttribute("refreshAgain", "no");
		}
		
		request.setAttribute("refresh", "yes");
		request.setAttribute("orderStatus", status);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("orderStatus.jsp");
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
