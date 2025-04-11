package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/app/add", "/app/remove", "/app/replace" })
public class C02ListenerTest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getServletPath();
		if (uri.equals("/app/add")) {
			System.out.println("[SERVLET] /app/add");
			req.getServletContext().setAttribute("CTX_KEY", "CTX_VALUE");
		} else if (uri.equals("/app/remove")) {
			System.out.println("[SERVLET] /app/remove");
			req.getServletContext().removeAttribute("CTX_KEY");
		} else if (uri.equals("/app/replace")) {
			System.out.println("[SERVLET] /app/relpace");
			req.getServletContext().setAttribute("CTX_KEY", "CTX_VALUE2");
		}
	}
}
