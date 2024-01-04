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

@WebServlet("/Deletecustomer")
public class DeleteCustomer extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		   try
		   {
			CustomerDAO c= new CustomerDAO();
			int x=c.deleteData(request.getParameter("email"));
			if(x>0)
			{
				 
					RequestDispatcher rd= request.getRequestDispatcher("index.html");
					rd.forward(request, response);
				}
			else
				out.println("no record found");
			
		}catch(Exception d)
		{
			System.out.println(d);
		}
	//	doGet(request, response);
	}

}
