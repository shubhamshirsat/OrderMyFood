package pkg.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.bl.AdminLogic;
import pkg.dto.Customer;

/**
 * Servlet implementation class ViewOrderDetails
 */
public class ViewOrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrderDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		
		int orderId = customer.getId();
		
		AdminLogic adminLogic = new AdminLogic();
		
		request.setAttribute("orderList", adminLogic.getOrderDetails(orderId, request));
		request.setAttribute("customer", adminLogic.getCustomerDetailsByOrderId(orderId));
		request.setAttribute("refresh", "yes");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("order.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int orderId = Integer.parseInt((String) request.getParameter("orderId"));
		
		AdminLogic adminLogic = new AdminLogic();
		
		request.setAttribute("refresh", "no");
		request.setAttribute("orderList", adminLogic.getOrderDetails(orderId, request));
		request.setAttribute("customer", adminLogic.getCustomerDetailsByOrderId(orderId));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("order.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
