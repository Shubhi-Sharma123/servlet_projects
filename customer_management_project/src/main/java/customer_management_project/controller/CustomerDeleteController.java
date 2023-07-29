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

@WebServlet("/deleteProduct")
public class CustomerDeleteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId=Integer.parseInt(req.getParameter("productId"));
		ProductService productService=new ProductService();
		HttpSession httpSession=req.getSession();
		if(httpSession.getAttribute("banana")!=null) {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body>");
			if(productService.productId(productId)!=0) {
				if(productService.customerIdGetByProductId(productId)==(int)httpSession.getAttribute("banana")) {
				productService.deleteProduct(productId);
				printWriter.write("<h3 style='color:green'>product data deleted successfully</h3>");
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("deleteProduct.jsp");
				requestDispatcher.include(req, resp);
				}
				else {
					printWriter.write("<h3 style='color:red'>you have not sufficient previlage to delete this data</h3>");
					RequestDispatcher requestDispatcher=req.getRequestDispatcher("deleteProduct.jsp");
					requestDispatcher.include(req, resp);
				}
			}
			else {printWriter.write("<h3 style='color:red'>productId is not present in database or already has been deleted</h3>");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("deleteProduct.jsp");
			requestDispatcher.include(req, resp);	
			}
			printWriter.write("</html></body>");
		}
		else {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("<h3 style='color:red'>your session has timeout please login again</h3>");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("customerLogin.jsp");
			requestDispatcher.include(req, resp);
		}
	}	
}