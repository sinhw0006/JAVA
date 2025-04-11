package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/session/add", "/session/remove", "/session/replace" })
public class C03ListenerTest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getServletPath();
		HttpSession session = req.getSession();
		if (uri.equals("/session/add")) {
			System.out.println("[SERVLET] /session/add");
			session.setAttribute("STX", "STX_VALUE");
		} else if (uri.equals("/session/remove")) {
			System.out.println("[SERVLET] /session/remove");
			session.removeAttribute("STX");
			session.invalidate();
		} else if (uri.equals("/session/replace")) {
			System.out.println("[SERVLET] /session/relpace");
			session.setAttribute("STX", "STX_VALUE2");
		}
	}
}
