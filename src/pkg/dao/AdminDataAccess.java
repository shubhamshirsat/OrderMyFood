package pkg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.regexp.internal.RE;

import pkg.dto.Category;
import pkg.dto.Customer;
import pkg.dto.Menu;
import pkg.dto.Order;
import pkg.dto.Table;
import pkg.utility.DBConnection;

public class AdminDataAccess 
{
	
	public boolean authenticateUser(String username, String password)
	{
		Connection connection = DBConnection.getConnectionObject();
		boolean isAuthenticated = false;
		
		try
		{
			Statement statement = connection.createStatement();
			
			String selectQuery="select * from CREDENTIALS";
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
					
			while(resultSet.next())
			{
				if(username.equals(resultSet.getString("username")) && password.equals(resultSet.getString("password")))
				{
					isAuthenticated = true;
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}	
		}
		
		
	return isAuthenticated;
	}
	
	
	public boolean isMenuAdded(Menu menu)
	{
		
			Connection connection = DBConnection.getConnectionObject();
			boolean isMenuAdded = false;
			
			try
			{
				Statement statement = connection.createStatement();
				
				String insertQuery = "insert into menu (type, menuName, price) values('"+menu.getType()+"', '"+menu.getName()+"', '"+menu.getPrice()+"')";
				
				int count = statement.executeUpdate(insertQuery);
				
				if(count > 0)
				{
					isMenuAdded = true;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					connection.close();
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}	
			}
			
		return isMenuAdded;
	}

	
	public ArrayList<Menu> viewAllMenu()
	{
		Connection connection = DBConnection.getConnectionObject();
		
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		
		
		try
		{
			Statement statement = connection.createStatement();
			String selectQuery = "select * from menu;";
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next())
			{
				Menu menu = new Menu();
				
				menu.setId(resultSet.getInt("uid"));
				menu.setType(resultSet.getInt("type"));
				menu.setName(resultSet.getString("menuName"));
				menu.setPrice(resultSet.getInt("price"));
				
				menuList.add(menu);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}	
		}

		
		return menuList;
	}
	
	public boolean updateMenu(String updateQuery)
	{
		Connection connection = DBConnection.getConnectionObject();
		boolean isMenuUpdated = false;
		
		
		try
		{
			Statement statement = connection.createStatement();
						
			int count = statement.executeUpdate(updateQuery);
			
			System.out.println("row affected: "+count);
			System.out.println("Your update query is: "+updateQuery);
			
			if(count > 0)
			{
				isMenuUpdated = true;
			}
			
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}	
		}
		
		
		return isMenuUpdated;
	}
	
	
	public boolean saveCustomer(Customer customer)  
	{
		boolean isSaved = false;
		Connection connection = DBConnection.getConnectionObject();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String insertQuery = "insert into customer (name, mobile, table_no,login_date,login_timestamp) values('"+customer.getName()+"','"+customer.getMobile()+"','"+customer.getTable()+"',curdate(), current_timestamp);";		
			
			int count = statement.executeUpdate(insertQuery);
			
			if(count > 0)
			{
				isSaved = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}	
		}
		
		
		return isSaved;
	}
	
	public Customer getCustomer(String key)
	{
		Connection connection = DBConnection.getConnectionObject();
		Customer customer = null;
	
		try
		{
			Statement statement = connection.createStatement();
			
			String selectQuery = "select * from customer where mobile = "+key;
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next())
			{
				customer = new Customer();

				customer.setId(resultSet.getInt("cust_id"));
				customer.setName(resultSet.getString("name"));
				customer.setMobile(resultSet.getString("mobile"));
				customer.setTable(resultSet.getString("table_no"));
				customer.setLogin_date(resultSet.getDate("login_date"));
				customer.setLogin_timestamp(resultSet.getTimestamp("login_timestamp"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}	
		}
		
		
		return customer;
	}

	
	public boolean placeOrder(String query)
	{
		Connection connection = DBConnection.getConnectionObject();
		boolean isPlaced = false;
		int count;
		
		try
		{
			Statement statement = connection.createStatement();
			
			count = statement.executeUpdate(query);
			
			if(count >0)
			{
				isPlaced = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}	
		}
		
		return isPlaced;
	}
	
	
	public ArrayList<Order> getOrderDetails(int orderID, HttpServletRequest request)
	{
		ArrayList<Order> orderList = new ArrayList<Order>();
		Connection connection = DBConnection.getConnectionObject();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String selectQuery = "select * from orderdetails where order_id = '"+orderID+"';";
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next())
			{
				Order order = new Order();
				
				order.setOrdeCounter(resultSet.getInt("order_counter"));
				order.setOrderId(resultSet.getInt("order_id"));
				order.setOrderName(resultSet.getString("order_name"));
				order.setOrderPrice(resultSet.getInt("order_price"));
				order.setOrderQuantity(resultSet.getInt("order_quantity"));
				order.setOrderTotal(resultSet.getInt("order_total"));
				order.setOrderTable(resultSet.getString("order_table"));
				order.setOrderStatus(resultSet.getString("order_status"));		
				order.setOrder_date(resultSet.getDate("order_date"));
				order.setOrder_timestamp(resultSet.getTimestamp("order_timestamp"));
				orderList.add(order);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}	
		}
		
		
		return orderList;
	}
	
	public boolean addTable()
	{
		boolean isTableAdded = false;
		Connection connection = DBConnection.getConnectionObject();
		int last = 0;
		
		try
		{
			Statement statement = connection.createStatement();
			
			String selectQuery = "select table_name from seats;";
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next())
			{
				last = resultSet.getInt("table_name");
			}
			
			String insertQuery = "insert into seats (table_name, table_status) values('"+(last+1)+"','Available')";
			
			int count = statement.executeUpdate(insertQuery);
			
			if(count > 0)
			{
				isTableAdded = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}	
		}
		
		return isTableAdded;
	}
	
	public ArrayList<Table> getTables()
	{
		Connection connection = DBConnection.getConnectionObject();
		ArrayList<Table> tableList = new ArrayList<Table>();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String selectQuery = "select table_name, table_status from seats";
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next())
			{
				Table table = new Table();
				
				table.setTable(resultSet.getInt("table_name"));
				table.setStatus(resultSet.getString("table_status"));
				
				tableList.add(table);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}	
		}
		
		return tableList;
	}
	
	
	public boolean removeTable()
	{
		boolean isTableRemoved = false;
		Connection connection = DBConnection.getConnectionObject();
		int last = 0;
		
		try
		{
			Statement statement = connection.createStatement();
			
			String selectQuery = "select table_name from seats;";
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next())
			{
				last = resultSet.getInt("table_name");
			}
			
			String deleteQuery = "delete from seats where table_name = '"+last+"';";
			
			int count = statement.executeUpdate(deleteQuery);
			
			if(count > 0)
			{
				isTableRemoved = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}	
		}
		
		
		return isTableRemoved;
	}
	
	public boolean createCategory(String category)
	{
		boolean isCategoryCreated = false;
		
		Connection connection = DBConnection.getConnectionObject();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String insertQuery = "insert into category(category_name) values('"+category+"');";
			
			int row = statement.executeUpdate(insertQuery);
			
			if(row > 0)
			{
				isCategoryCreated = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}	
		}
		
		return isCategoryCreated;
	}
	
	
	public ArrayList<Category> getCategoryList()
	{
		ArrayList<Category> categoryList = new ArrayList<Category>();
		
		Connection connection = DBConnection.getConnectionObject();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String selectQuery = "select * from category";
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next())
			{
				Category category = new Category();
				
				category.setCategoryId(resultSet.getInt("category_id"));
				category.setCategoryName(resultSet.getString("category_name"));
				
				categoryList.add(category);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}	
		}
		
		return categoryList;
	}
	
	public boolean removeCategory(int id)
	{
		boolean isRemoved = false;
		
		Connection connection = DBConnection.getConnectionObject();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String deleteCategoryQuery = "delete from category where category_id='"+id+"';";
			String deleteAllCategoryMenu = "delete from menu where type='"+id+"';";
			
			int categoryCount = statement.executeUpdate(deleteCategoryQuery);
			int categoryMenuCount = statement.executeUpdate(deleteAllCategoryMenu);
			
			if(categoryCount > 0 && categoryMenuCount > 0)
			{
				isRemoved = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			
		}
		
		return isRemoved;
	}
	
	
	public ArrayList<Order> getOrdersByDate(String date)
	{
		ArrayList<Order> todaysOrderList = new ArrayList<Order>();
		Connection connection = DBConnection.getConnectionObject();
		String selectQuery;
		
		
		if(date == null)
		{
			selectQuery = "select * from orderdetails where order_date = CURDATE();";
		}
		else
		{
			selectQuery = "select * from orderdetails where order_date = '"+date+"';";
		}
		
		try
		{
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next())
			{
				Order order = new Order();
				
				order.setOrdeCounter(resultSet.getInt("order_counter"));
				order.setOrderId(resultSet.getInt("order_id"));
				order.setOrderName(resultSet.getString("order_name"));
				order.setOrderPrice(resultSet.getInt("order_price"));
				order.setOrderQuantity(resultSet.getInt("order_quantity"));
				order.setOrderTotal(resultSet.getInt("order_total"));
				order.setOrderTable(resultSet.getString("order_table"));
				order.setOrderStatus(resultSet.getString("order_status"));
				order.setOrder_date(resultSet.getDate("order_date"));
				order.setOrder_timestamp(resultSet.getTimestamp("order_timestamp"));
				
				System.out.println("Order name: "+order.getOrderName()+"\n\n");
				
				todaysOrderList.add(order);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			
		}
		
		return todaysOrderList;
	}
	
	public boolean updateOrderStatus(String status, int orderId)
	{
		boolean isStatusUpdated = false;
		Connection connection = DBConnection.getConnectionObject();
		
		try
		{
			Statement statement = connection.createStatement();
			String updateQuery = "update orderdetails set order_status='"+status+"' where order_id='"+orderId+"';";
			
			int count = statement.executeUpdate(updateQuery);
			
			if(count>0)
			{
				isStatusUpdated = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			
		}
		
		return isStatusUpdated;
	}
	
	public Customer getCustomerDetailsByOrderId(int orderId)
	{
		Customer customer = null;
		Connection connection = DBConnection.getConnectionObject();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String selectQuery = "select * from customer where cust_id = "+orderId;
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next())
			{
				customer = new Customer();

				customer.setId(resultSet.getInt("cust_id"));
				customer.setName(resultSet.getString("name"));
				customer.setMobile(resultSet.getString("mobile"));
				customer.setTable(resultSet.getString("table_no"));
				customer.setLogin_date(resultSet.getDate("login_date"));
				customer.setLogin_timestamp(resultSet.getTimestamp("login_timestamp"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			
		}
		
		return customer;
	}
	
	
	public ArrayList<Order> getOrdersByMonth(String date)
	{
		ArrayList<Order> monthlyOrderList = new ArrayList<Order>();
		Connection connection = DBConnection.getConnectionObject();
		String selectQuery;
		
		
		if(date == null)
		{
			selectQuery = "select * from orderdetails where month(order_date)=month(now());";
		}
		else
		{
			selectQuery = "select * from orderdetails where month(order_date)=month('"+date+"')";
		}
		
		try
		{
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next())
			{
				Order order = new Order();
				
				order.setOrdeCounter(resultSet.getInt("order_counter"));
				order.setOrderId(resultSet.getInt("order_id"));
				order.setOrderName(resultSet.getString("order_name"));
				order.setOrderPrice(resultSet.getInt("order_price"));
				order.setOrderQuantity(resultSet.getInt("order_quantity"));
				order.setOrderTotal(resultSet.getInt("order_total"));
				order.setOrderTable(resultSet.getString("order_table"));
				order.setOrderStatus(resultSet.getString("order_status"));
				order.setOrder_date(resultSet.getDate("order_date"));
				order.setOrder_timestamp(resultSet.getTimestamp("order_timestamp"));
				
				System.out.println("Order name: "+order.getOrderName()+"\n\n");
				
				monthlyOrderList.add(order);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			
		}
		
		return monthlyOrderList;
	}
	
	public boolean changePassword(String currentPassword, String newPassword)
	{
		boolean isPasswordChanged = false;
		
		Connection connection = DBConnection.getConnectionObject();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String updateQuery = "update credentials set password='"+newPassword+"' where password='"+currentPassword+"'";
			
			int count = statement.executeUpdate(updateQuery);
			
			if(count>0)
			{
				isPasswordChanged = true;
			}
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally 
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}
		
		return isPasswordChanged;
	}
	
	
	public boolean changeUserName(String currentUserName, String password, String newUserName)
	{
		boolean isUserNameIsChanged = false;
		Connection connection = DBConnection.getConnectionObject();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String updateQuery = "update credentials set username='"+newUserName+"' where username='"+currentUserName+"' AND password='"+password+"'";
			
			int count = statement.executeUpdate(updateQuery);
			
			if(count>0)
			{
				isUserNameIsChanged = true;
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}
		
		return isUserNameIsChanged;
	}
	
	
	public boolean changeHotelName(String newHotelName)
	{
		boolean isNameChanged = false;
		Connection connection = DBConnection.getConnectionObject();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String updateQuery = "update credentials set hotel='"+newHotelName+"'";
			
			int count = statement.executeUpdate(updateQuery);
			
			if(count>0)
			{
				isNameChanged = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}
		
		return isNameChanged;
	}
	
	
	public String getHotelName()
	{
		String hotelName = "Unavailable";
		Connection connection = DBConnection.getConnectionObject();
		
		try
		{
			Statement statement = connection.createStatement();
			String selectQuery = "select hotel from credentials";
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next())
			{
				hotelName = resultSet.getString("hotel");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}
		
		return hotelName;
	}
	
}
