package customer_management_project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer_management_project.service.OwnerService;


@WebServlet(value = "/ownerlogin")
public class OwnerLoginController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int ownerId=Integer.parseInt(req.getParameter("ownerId"));
		String ownerPassword=req.getParameter("ownerPassword");
		int ownerPasscode=Integer.parseInt(req.getParameter("ownerPasscode"));
		OwnerService ownerService=new OwnerService();
		int statuscode=ownerService.ownerLogin(ownerId, ownerPassword, ownerPasscode);
			HttpSession httpSession=req.getSession();
		if(statuscode==1) {
			httpSession.setAttribute("apple", 123);
			
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("ownerPortal.jsp");
			requestDispatcher.include(req, resp);
		}
		else {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("<h3 style='color:red' >invalid credential</h3>");
			printWriter.write("</body></html>");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("ownerLogin.jsp");
			requestDispatcher.include(req, resp);
		}	
	}
}