package pkg.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class Order 
{
	int ordeCounter;
	int orderId;
	String orderName;
	int orderPrice;
	int orderQuantity;
	int orderTotal;
	String orderTable;
	String orderStatus;
	Date order_date;
	Timestamp order_timestamp;
	
	
	public Date getOrder_date() 
	{
		return order_date;
	}
	
	public void setOrder_date(Date order_date) 
	{
		this.order_date = order_date;
	}
	
	public Timestamp getOrder_timestamp() 
	{
		return order_timestamp;
	}
	
	public void setOrder_timestamp(Timestamp order_timestamp) 
	{
		this.order_timestamp = order_timestamp;
	}
	
	public int getOrdeCounter() 
	{
		return ordeCounter;
	}
	public void setOrdeCounter(int ordeCounter) {
		this.ordeCounter = ordeCounter;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public int getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getOrderTable() {
		return orderTable;
	}
	public void setOrderTable(String table) {
		this.orderTable = table;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
