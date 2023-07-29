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
import customer_management_project.dto.Product;
import customer_management_project.service.ProductService;

@WebServlet("/insertProduct")
public class CustomerInsertController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId = Integer.parseInt(req.getParameter("productId"));
		String productName = req.getParameter("productName");
		double productPrice = Double.parseDouble(req.getParameter("productPrice"));
		boolean productAvailable = Boolean.parseBoolean(req.getParameter("productAvailable"));
		Product product = new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setProductAvailable(productAvailable);
		ProductService productService = new ProductService();
		HttpSession httpSession = req.getSession();
		if (httpSession.getAttribute("banana") != null) {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body>");
			
			if (productService.productId(productId) == 0) {
				int customerId=(int) httpSession.getAttribute("banana");
				productService.insertProduct(product,customerId);
				printWriter.write("<h3 style='color:green'>product data inserted successfully</h3>");
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("addProduct.jsp");
				requestDispatcher.include(req, resp);
			}
			else {
				printWriter.write("<h3 style='color:red'>this productId is already present in database please choose different productId</h3>");
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("addProduct.jsp");
				requestDispatcher.include(req, resp);
			}	
		}
		else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("<h3 style='color:red'>your session has time out please login as customer </h3>");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("customerLogin.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}