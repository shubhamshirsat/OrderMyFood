package pkg.bl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import pkg.dao.AdminDataAccess;
import pkg.dto.Category;
import pkg.dto.Customer;
import pkg.dto.Menu;
import pkg.dto.Order;
import pkg.dto.Table;

public class AdminLogic 
{
	public boolean authenticateUser(String username, String password)
	{
			AdminDataAccess adminDataAccess = new AdminDataAccess();
			return adminDataAccess.authenticateUser(username, password);
	}
	
	public boolean isMenuAdded(Menu menu)
	{
			AdminDataAccess adminDataAccess = new AdminDataAccess();
			return adminDataAccess.isMenuAdded(menu);
	}
	
	public ArrayList<Menu> viewAllMenu()
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.viewAllMenu();
	}
	
	public boolean updateMenu(String updateQuery)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.updateMenu(updateQuery);
	}
	
	public boolean saveCustomer(Customer customer)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.saveCustomer(customer);
	}
	
	public Customer getCustomer(String key)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.getCustomer(key);
	}
	
	public boolean placeOrder(String query)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.placeOrder(query);
	}
	
	public ArrayList<Order> getOrderDetails(int orderID, HttpServletRequest request)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.getOrderDetails(orderID, request);
	}
	
	public boolean addTable() 
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.addTable();
	}
	
	
	public ArrayList<Table> getTables()
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.getTables();
	}
	
	public boolean removeTable()
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.removeTable();
	}
	
	public boolean createCategory(String category)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.createCategory(category);
	}
	
	public ArrayList<Category> getCategoryList()
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.getCategoryList();
	}
	
	public boolean removeCategory(int id)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.removeCategory(id);
	}
	
	public ArrayList<Order> getOrdersByDate(String date)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.getOrdersByDate(date);
	}
	
	public boolean updateOrderStatus(String status, int orderId)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.updateOrderStatus(status, orderId);
	}
	
	public Customer getCustomerDetailsByOrderId(int orderId)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.getCustomerDetailsByOrderId(orderId);
	}
	
	public ArrayList<Order> getOrdersByMonth(String date)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.getOrdersByMonth(date);
	}
	
	public boolean changePassword(String currentPassword, String newPassword)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.changePassword(currentPassword, newPassword);
	}
	
	public boolean changeUserName(String currentUserName, String password, String newUserName)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.changeUserName(currentUserName, password, newUserName);
	}
	
	public boolean changeHotelName(String newHotelName)
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.changeHotelName(newHotelName);
	}
	
	public String getHotelName()
	{
		AdminDataAccess adminDataAccess = new AdminDataAccess();
		return adminDataAccess.getHotelName();
	}
	
}
