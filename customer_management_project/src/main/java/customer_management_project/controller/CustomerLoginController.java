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

import customer_management_project.service.ProductService;

@WebServlet("/customerLogin")
public class CustomerLoginController  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int customerId=Integer.parseInt(req.getParameter("customerId"));
		long customerPhone=Long.parseLong(req.getParameter("customerPhone"));
		ProductService productService=new ProductService();
		HttpSession httpSession=req.getSession();
		if(productService.customerLogin(customerId, customerPhone)==1) {
			httpSession.setAttribute("banana", customerId);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("customerPortal.jsp");
			requestDispatcher.include(req, resp);
		}
		else {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("<h3 style='color:red'>invalid crediantial please try again</h3>");
			printWriter.write("</body></html>");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("customerLogin.jsp");
			requestDispatcher.include(req, resp);
		}
	}
	
}