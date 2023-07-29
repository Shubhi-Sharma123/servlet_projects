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

@WebServlet("/adminLogout")
public class AdminLogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession=req.getSession();
		if(httpSession.getAttribute("mango")!=null) {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body>");
			httpSession.invalidate();
			printWriter.write("<h3 style='color:yellow'>admin logout successfully</h3>");
			printWriter.write("</body></html>");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("adminLogin.jsp");
			requestDispatcher.include(req, resp);
	}
		else {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body>");
			printWriter.write("<h3 style='color:red'>you have already logout from admin portal</h3>");
			printWriter.write("</body></html>");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("adminLogin.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}