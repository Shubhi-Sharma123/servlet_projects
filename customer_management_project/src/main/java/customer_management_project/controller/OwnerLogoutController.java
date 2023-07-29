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
@WebServlet(value = "/ownerLogout")
public class OwnerLogoutController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession=req.getSession();
		if(httpSession.getAttribute("apple")!=null)
		{httpSession.invalidate();
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body>");
		printWriter.write("<h3 style='color:green'>Logout successfully</h3>");
		printWriter.write("</body></html>");
		RequestDispatcher dispatcher=req.getRequestDispatcher("ownerLogin.jsp");
		dispatcher.include(req, resp);
		}
		else {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body>");
		printWriter.write("<h3 style='color:red'>you have already logout please from owner portal</h3>");
		printWriter.write("</body></html>");
		RequestDispatcher dispatcher=req.getRequestDispatcher("ownerLogin.jsp");
		dispatcher.include(req, resp);
		}
	}
}