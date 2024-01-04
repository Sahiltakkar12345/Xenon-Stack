package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.CustomerDAO;
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		try 
		{
	PrintWriter out= response.getWriter();
	String a= request.getParameter("email");
	String b= request.getParameter("pass");
	String c= request.getParameter("name");
	String d= request.getParameter("address");
	String e= request.getParameter("mobile");

	CustomerDAO y= new CustomerDAO();
	int x= y.insertData(a,b,c,d,e);
	if(x>0)//if record is inserted x=1
		
		{
		RequestDispatcher rd= request.getRequestDispatcher("index.html");
		rd.forward(request, response);
		}
		}catch(Exception d1) {System.out.println(d1);}
		System.out.println("Data saved successfully");
		}
}
