package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/join.do")
public class C04Servlet_Test extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /join.do...");
		req.getRequestDispatcher("/WEB-INF/join.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST /join.do...");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		
		resp.sendRedirect(req.getContextPath()+"/login.do");
	}
	
}
