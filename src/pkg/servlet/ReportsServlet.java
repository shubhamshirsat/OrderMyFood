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
import pkg.utility.Reports;

/**
 * Servlet implementation class ReportsServlet
 */
public class ReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub

		String date= null;
		
		AdminLogic adminLogic = new AdminLogic();
		ArrayList<Order> todaysOrderList = adminLogic.getOrdersByDate(date);
		ArrayList<Order> monthWiseOrderList = adminLogic.getOrdersByMonth(date);
		
		Reports reports = new Reports();
		
		if(todaysOrderList.isEmpty())
		{
			request.setAttribute("ReportAvailable", "no");
			request.setAttribute("dateOfReport", "No Reports Available Today");
			
				if(monthWiseOrderList.isEmpty())
				{
					request.setAttribute("MonthlyReportAvailable", "no");
					request.setAttribute("monthlyReport", "No Reports Available For This Month");
				}
				else
				{
					request.setAttribute("MonthlyReportAvailable", "yes");
					
					request.setAttribute("MonthlyTotalOrders", reports.getTotalOrders(monthWiseOrderList));
					request.setAttribute("MonthlyServedOrders", reports.getTotalServedOrders(monthWiseOrderList));
					request.setAttribute("MonthlyCancelledOrders", reports.getTotalCancelledOrders(monthWiseOrderList));
					request.setAttribute("MonthlyPendingOrders", reports.getTotalPendingOrders(monthWiseOrderList));
					request.setAttribute("MonthlyTotalCollection", reports.getTotalCollection(monthWiseOrderList));
					
				}
		}
		else
		{
			request.setAttribute("ReportAvailable", "yes");
			request.setAttribute("MonthlyReportAvailable", "yes");
			request.setAttribute("Date", "Today's Report");
			
			request.setAttribute("TotalOrders", reports.getTotalOrders(todaysOrderList));
			request.setAttribute("ServedOrders", reports.getTotalServedOrders(todaysOrderList));
			request.setAttribute("CancelledOrders", reports.getTotalCancelledOrders(todaysOrderList));
			request.setAttribute("PendingOrders", reports.getTotalPendingOrders(todaysOrderList));
			request.setAttribute("TotalCollection", reports.getTotalCollection(todaysOrderList));	
			
			
			/********* Monthly Report *********/
			
			request.setAttribute("MonthlyTotalOrders", reports.getTotalOrders(monthWiseOrderList));
			request.setAttribute("MonthlyServedOrders", reports.getTotalServedOrders(monthWiseOrderList));
			request.setAttribute("MonthlyCancelledOrders", reports.getTotalCancelledOrders(monthWiseOrderList));
			request.setAttribute("MonthlyPendingOrders", reports.getTotalPendingOrders(monthWiseOrderList));
			request.setAttribute("MonthlyTotalCollection", reports.getTotalCollection(monthWiseOrderList));
	
		}
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("reports.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	
		String date = (String) request.getParameter("data");
		

		AdminLogic adminLogic = new AdminLogic();
		
		ArrayList<Order> dayWiseOrderList = adminLogic.getOrdersByDate(date);
		ArrayList<Order> monthWiseOrderList = adminLogic.getOrdersByMonth(date);
		
		Reports reports = new Reports();
		
		if(dayWiseOrderList.isEmpty())
		{
			request.setAttribute("ReportAvailable", "no");
			request.setAttribute("dateOfReport", "No Reports Available On Date "+date);
			
			if(monthWiseOrderList.isEmpty())
			{
				request.setAttribute("MonthlyReportAvailable", "no");
				request.setAttribute("monthlyReport", "No Reports Available For This Month");
			}
			else
			{
				request.setAttribute("MonthlyReportAvailable", "yes");
				
				request.setAttribute("MonthlyTotalOrders", reports.getTotalOrders(monthWiseOrderList));
				request.setAttribute("MonthlyServedOrders", reports.getTotalServedOrders(monthWiseOrderList));
				request.setAttribute("MonthlyCancelledOrders", reports.getTotalCancelledOrders(monthWiseOrderList));
				request.setAttribute("MonthlyPendingOrders", reports.getTotalPendingOrders(monthWiseOrderList));
				request.setAttribute("MonthlyTotalCollection", reports.getTotalCollection(monthWiseOrderList));
				
			}
			
		}
		else
		{
			request.setAttribute("ReportAvailable", "yes");
			request.setAttribute("MonthlyReportAvailable", "yes");
			request.setAttribute("Date", "Report on date "+date);
			
			request.setAttribute("TotalOrders", reports.getTotalOrders(dayWiseOrderList));
			request.setAttribute("ServedOrders", reports.getTotalServedOrders(dayWiseOrderList));
			request.setAttribute("CancelledOrders", reports.getTotalCancelledOrders(dayWiseOrderList));
			request.setAttribute("PendingOrders", reports.getTotalPendingOrders(dayWiseOrderList));
			request.setAttribute("TotalCollection", reports.getTotalCollection(dayWiseOrderList));
			
					/********* Monthly Report *********/
			
			request.setAttribute("MonthlyTotalOrders", reports.getTotalOrders(monthWiseOrderList));
			request.setAttribute("MonthlyServedOrders", reports.getTotalServedOrders(monthWiseOrderList));
			request.setAttribute("MonthlyCancelledOrders", reports.getTotalCancelledOrders(monthWiseOrderList));
			request.setAttribute("MonthlyPendingOrders", reports.getTotalPendingOrders(monthWiseOrderList));
			request.setAttribute("MonthlyTotalCollection", reports.getTotalCollection(monthWiseOrderList));
			
		}
		
				
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("reports.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
