package pkg.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

import pkg.bl.AdminLogic;
import pkg.dto.Customer;
import pkg.dto.Order;

/**
 * Servlet implementation class PlaceOrderServlet
 */
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrderServlet() 
    {
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
		Enumeration<String> parameters = request.getParameterNames();

		System.out.println("\n\n=======================================================\n");
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		
		ArrayList<String> orderdetails = null;
		AdminLogic adminLogic = new AdminLogic();
		
		String page = "placeOrder.jsp";
		
		while(parameters.hasMoreElements())
		{
			orderdetails = new ArrayList<String>();
			for(int i =0; i< 4 && parameters.hasMoreElements() ;i++)
			{
				String menu = parameters.nextElement();
				orderdetails.add(request.getParameter(menu));
			}
			
			System.out.println("Array list size is = "+orderdetails.size());
			String insertQuery = "insert into orderdetails(order_id, order_name, order_price, order_quantity, order_total, order_table, order_status, order_date, order_timestamp) values('"+customer.getId()+"','"+orderdetails.get(0)+"','"+Integer.parseInt((String)orderdetails.get(1))+"','"+Integer.parseInt(orderdetails.get(2))+"','"+Integer.parseInt(orderdetails.get(3))+"','"+customer.getTable()+"','Pending',curdate(), current_timestamp);";			
		
			if(adminLogic.placeOrder(insertQuery))
			{
				System.out.println("\n\nOrder placed successfully...");
				page = "order.jsp";
				request.setAttribute("refresh", "yes");
				
				session.setAttribute("orderList", adminLogic.getOrderDetails(customer.getId(), request));
			}
			else
			{
				System.out.println("\n\nUnable to place order");
				request.setAttribute("errorMsg", "<div class= 'w3-panel w3-red w3-card-4 w3-margin w3-animate-zoom'><span onclick=this.parentElement.style.display='none' class=w3-closebtn>&times;</span>"+"Error occured while placing order :("+"</div>");
			}
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
		requestDispatcher.forward(request, response);
	}

}
