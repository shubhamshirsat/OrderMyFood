package pkg.utility;

import java.util.ArrayList;

import pkg.dto.Order;

public class Reports
{
	public int getTotalOrders(ArrayList<Order> ordersList)
	{
		int totalOrders = 0;
		
		if(!ordersList.isEmpty())
		{

			int prev = 0;
			int curr = 0;
							
			for(int i = ordersList.size()-1; i >= 0 ; i--)
			{
				Order order = ordersList.get(i);
				curr = order.getOrderId();
				
				if(prev==curr)
				{
			
				}
				else
				{
					totalOrders++;
				}
				
				prev = order.getOrderId();
			}
		}

		return totalOrders;
	}
	
	
	public int getTotalServedOrders(ArrayList<Order> ordersList)
	{
		int totalServedOrders = 0;
		
		if(!ordersList.isEmpty())
		{

			int prev = 0;
			int curr = 0;
							
			for(int i = ordersList.size()-1; i >= 0 ; i--)
			{
				Order order = ordersList.get(i);
				curr = order.getOrderId();
				
				if(prev==curr)
				{
			
				}
				else
				{
					if(order.getOrderStatus().equals("Served"))
					{
						totalServedOrders++;	
					}
				}
				
				prev = order.getOrderId();
			}
		}
		
		
		return totalServedOrders;
	}
	
	public int getTotalCancelledOrders(ArrayList<Order> ordersList)
	{
		int totalCancelledOrders = 0;
		
		if(!ordersList.isEmpty())
		{

			int prev = 0;
			int curr = 0;
							
			for(int i = ordersList.size()-1; i >= 0 ; i--)
			{
				Order order = ordersList.get(i);
				curr = order.getOrderId();
				
				if(prev==curr)
				{
			
				}
				else
				{
					if(order.getOrderStatus().equals("Cancelled"))
					{
						totalCancelledOrders++;	
					}
				}
				
				prev = order.getOrderId();
			}
		}
		
		
		return totalCancelledOrders;
	}
	
	
	public int getTotalPendingOrders(ArrayList<Order> ordersList)
	{
		int totalPendingOrders = 0;
		
		if(!ordersList.isEmpty())
		{

			int prev = 0;
			int curr = 0;
							
			for(int i = ordersList.size()-1; i >= 0 ; i--)
			{
				Order order = ordersList.get(i);
				curr = order.getOrderId();
				
				if(prev==curr)
				{
			
				}
				else
				{
					if(order.getOrderStatus().equals("Pending"))
					{
						totalPendingOrders++;	
					}
				}
				
				prev = order.getOrderId();
			}
		}
		
		return totalPendingOrders;
	}
	
	
	
	public int getTotalCollection(ArrayList<Order> ordersList)
	{

		int totalCollection = 0;
		
		if(!ordersList.isEmpty())
		{

			int prev = 0;
			int curr = 0;
							
			for(int i = ordersList.size()-1; i >= 0 ; i--)
			{
				Order order = ordersList.get(i);
				curr = order.getOrderId();
				
				if(order.getOrderStatus().equals("Served"))
				{
					totalCollection += order.getOrderTotal();
				}
				
				prev = order.getOrderId();
			}
		}
		
		return totalCollection;
	}
}
