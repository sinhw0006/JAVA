package Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.UserDTO;
import Type.Role;


//@WebFilter("*.do")
public class PermissionFilter implements Filter{
	
	private Map<String,Role> pageGradeMap = new HashMap();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println(filterConfig.getServletContext().getContextPath());
		pageGradeMap.put("/admin.main", Role.ROLE_ADMIN);
		pageGradeMap.put("/manager.main",Role.ROLE_MANAGER);
		pageGradeMap.put("/user.main",Role.ROLE_USER);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		System.out.println("[FILTER] Perm Filter start...");
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpSession session = request.getSession();
		
		String myRole = (String)session.getAttribute("role");
		if (myRole == null) {
			response.sendRedirect(request.getContextPath()+"/login.do?msg=not authenticated...");
			return ;
		}
		
		String reqUri = request.getServletPath();
		Role pageRole = pageGradeMap.get(reqUri);
		
		Role my = null;
		switch (myRole) {
		case "ROLE_USER":
			my = Role.ROLE_USER;
			break;
		case "ROLE_MANAGER":
			my = Role.ROLE_MANAGER;
			break;
		case "ROLE_ADMIN":
			my = Role.ROLE_ADMIN;
			break;
		default:
			my = Role.ROLE_ANONYMOUS;
		}
		System.out.printf("URL : %s\nMYRole : %d\nPageRole : %d\n",reqUri,my.ordinal(),pageRole.ordinal());
		
		if(pageRole.ordinal() > my.ordinal()) {
			throw new ServletException("권한이 부족합니다.");
		}
		
		chain.doFilter(req, resp);
		System.out.println("[FILTER] Perm Filter end...");
		
	}

}
