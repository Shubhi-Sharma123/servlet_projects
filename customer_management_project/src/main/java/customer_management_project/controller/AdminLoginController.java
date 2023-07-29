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

import customer_management_project.service.AdminService;

@WebServlet(value = "/adminLogin")
public class AdminLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminName=req.getParameter("adminName");
		String adminEmail=req.getParameter("adminEmail");
		HttpSession httpSession=req.getSession();
		AdminService adminService=new AdminService();
		if(adminService.loginAdmin(adminName, adminEmail)==1) {
			httpSession.setAttribute("mango", 456);
//			PrintWriter printWriter=resp.getWriter();
//			printWriter.write("<html><body>");
//			printWriter.write("<h3 style='color:green'>admin login successfully</h3>");
//			printWriter.write("</body></html>");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("adminPortal.jsp");
			requestDispatcher.include(req, resp);
		}
		else {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("<h3 style='color:red'>invalid crediantial please try again</h3>");
			printWriter.write("</body></html>");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("adminLogin.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}