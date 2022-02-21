package pkg.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class Customer 
{
	int id;
	String name;
	String mobile;
	String table;
	Date login_date;
	Timestamp login_timestamp;
	
	public Timestamp getLogin_timestamp() {
		return login_timestamp;
	}

	public void setLogin_timestamp(Timestamp login_timestamp) {
		this.login_timestamp = login_timestamp;
	}

	public Date getLogin_date() 
	{
		return login_date;
	}
	
	public void setLogin_date(Date login_date) 
	{
		this.login_date = login_date;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	
	
}
