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

import customer_management_project.dto.Admin;
import customer_management_project.service.AdminService;

@WebServlet(value ="/insertAdmin")
public class OwnerInsertController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int adminId=Integer.parseInt(req.getParameter("adminId"));
		String adminName=req.getParameter("adminName");
		String adminEmail=req.getParameter("adminEmail");
		HttpSession httpSession=req.getSession();
		PrintWriter printWriter=resp.getWriter();
		if(httpSession.getAttribute("apple")!=null)
		{
		AdminService adminService=new AdminService();
		Admin admin=new Admin();
		admin.setAdminId(adminId);
		admin.setAdminName(adminName);
		admin.setAdminEmail(adminName);
		String st=adminService.insertAdmin(admin);
		printWriter.write("<html><body>");
		printWriter.write(st);
		printWriter.write("</body></html>");
		RequestDispatcher dispatcher=req.getRequestDispatcher("addAdmin.jsp");
		dispatcher.include(req, resp);
		
		  } else {printWriter.write("<html><body>");
			  printWriter.
		  write("<h3 style='color:red'>you session is time out please login again</h3>" ); 
			  printWriter.write("</body></html>");  
			  RequestDispatcher dispatcher=req.getRequestDispatcher("ownerLogin.jsp");
		  dispatcher.include(req, resp); }
		 
	}

}