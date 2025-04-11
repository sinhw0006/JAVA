package Servlet;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Type.Role;

@WebFilter("/login.do")
public class LoginRedirectFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String userRole = (String) session.getAttribute("role");
		
		if (userRole != null) {
			switch (userRole) {
			case "ROLE_ADMIN":
				resp.sendRedirect("./admin.main");
				break;
			case "ROLE_MANAGER":
				resp.sendRedirect("./manager.main");
				break;
			case "ROLE_USER":
				resp.sendRedirect("./user.main");
				break;
			}
			return;
		}
		chain.doFilter(request, response);
	}	
}
