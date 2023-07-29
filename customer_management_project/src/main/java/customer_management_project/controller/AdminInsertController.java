package customer_management_project.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer_management_project.service.CustomerService;

@WebServlet(value = "/insertCustomer")
public class AdminInsertController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int customerId=Integer.parseInt(req.getParameter("customerId"));
		String customerName=req.getParameter("customerName");
		String customerEmail=req.getParameter("customerEmail");
		long customerPhone=Long.parseLong(req.getParameter("customerPhone"));
		CustomerService customerService=new CustomerService();
		HttpSession httpSession=req.getSession();
		if(httpSession.getAttribute("mango")!=null) {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body>");
			if(customerService.getByCustomerId(customerId)==0) {
			customerService.addCustomer(customerId, customerName, customerEmail, customerPhone);
			printWriter.write("<h3 style='color:green'>customer inserted successfully</h3>");
			}
			else {
				printWriter.write("<h3 style='color:red'>this customerId already exeist in database</h3>");
			}
			printWriter.write("</body></html>");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("addCustomer.jsp");
			requestDispatcher.include(req, resp);	
		}
		else {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("<h3 style='color:red'>your session is time out please login again</h3>");
			printWriter.write("</body></html>");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("adminLogin.jsp");
			requestDispatcher.include(req, resp);
		}
		
	}
}