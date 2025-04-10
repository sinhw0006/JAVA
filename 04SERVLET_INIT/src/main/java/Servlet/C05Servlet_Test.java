package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class C05Servlet_Test extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /login.do...");
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST /login.do...");

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();

		String dbusername = (String) session.getAttribute("username");
		String dbpassword = (String) session.getAttribute("password");

		if (!username.equals(dbusername) || !password.equals(dbpassword)) {
			req.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
			return;
		}
		
		resp.sendRedirect("./main.do");
	}

}
