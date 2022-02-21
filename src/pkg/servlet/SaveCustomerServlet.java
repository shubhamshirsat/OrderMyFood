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
import pkg.dto.Menu;

/**
 * Servlet implementation class SaveCustomerServlet
 */
public class SaveCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCustomerServlet() {
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String mobile = request.getParameter("mobile");
		String table = "Table "+request.getParameter("table");
		
		System.out.println("Customer Name : "+firstName+" "+lastName);
		System.out.println("Customer Mob  : "+mobile);
		System.out.println("Selected Table: "+table);
		
		Customer customer = new Customer();
		
		customer.setName(firstName+" "+lastName);
		customer.setMobile(mobile);
		customer.setTable(table);
		
		AdminLogic adminLogic = new AdminLogic();
		String page = "index.jsp";
		
		if(adminLogic.saveCustomer(customer))
		{
			ArrayList<Menu> menuList = adminLogic.viewAllMenu();
			
			request.setAttribute("menuList", menuList);
			
			page = "menuCard.jsp";
			
			HttpSession session = request.getSession();
			session.setAttribute("customer", adminLogic.getCustomer(mobile));
			
		}
		else
		{
			request.setAttribute("errorMsg", "Unable to proceed ..");
		}
		
		request.setAttribute("categoryList", adminLogic.getCategoryList());
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
		requestDispatcher.forward(request, response);
		
	}

}
