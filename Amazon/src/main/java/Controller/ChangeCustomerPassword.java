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

@WebServlet("/Changecustomerpassword")
public class ChangeCustomerPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			PrintWriter out= response.getWriter();
			String a= request.getParameter("email");
			String b= request.getParameter("pass");
			
			CustomerDAO c= new CustomerDAO();
			int x=c.updateData(b,a);
			if(x>0)
			{
					RequestDispatcher rd= request.getRequestDispatcher("index.html");
					rd.forward(request, response);		 
			}
		}catch(Exception d) {System.out.println(d);}
	//	doGet(request, response);
	}

}
