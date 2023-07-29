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

@WebServlet(value = "/updateAdmin")
public class OwnerUpdateController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int adminId=Integer.parseInt(req.getParameter("adminId"));
		String adminName=req.getParameter("adminName");
		String adminEmail=req.getParameter("adminEmail");
		HttpSession httpSession=req.getSession();
		AdminService adminService=new AdminService();
		PrintWriter printWriter=resp.getWriter();
		if(httpSession.getAttribute("apple")!=null) {
		String st=adminService.updateAdmin(adminId, adminName, adminEmail);
		printWriter.write("<html><body>");
		printWriter.write(st);
		printWriter.write("</body></html>");
		RequestDispatcher dispatcher=req.getRequestDispatcher("updateAdmin.jsp");
		dispatcher.include(req, resp);
		}
		else {printWriter.write("<html><body>");
			 printWriter.
			  write("<h3 style='color:red'>you session is time out please login again</h3>");
			 printWriter.write("</body></html>");
			 RequestDispatcher dispatcher=req.getRequestDispatcher("ownerLogin.jsp");
			  dispatcher.include(req, resp);
		}
	}
}