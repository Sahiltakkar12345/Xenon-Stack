package DAO;
import java.io.PrintWriter;
import java.sql.*;
import Controller.LoginServlet;
import Database.DatabaseConfig;


public class CustomerDAO 
{
	DatabaseConfig dc;
	PreparedStatement ps;
	public CustomerDAO()
	{
		dc=new DatabaseConfig();
		
	}
public int insertData(String a,String b,String c,String d,String e) throws Exception 
{
	ps= dc.getStatement("insert into customer values (?,?,?,?,?)");
	ps.setString(1, a);
	ps.setString(2, b);
	ps.setString(3,c);
	ps.setString(4, d);
	ps.setString(5, e);
	return ps.executeUpdate();
}
	
public int deleteData(String a) throws Exception 
{
	ps= dc.getStatement("delete from  customer where email=?");
	ps.setString(1, a);
	return ps.executeUpdate();
}

public int updateData(String pass,String email) throws Exception 
{
	ps= dc.getStatement("update customer set pass=? where email=?");
	ps.setString(1, pass);
	ps.setString(2, email);
	return ps.executeUpdate();
}
}