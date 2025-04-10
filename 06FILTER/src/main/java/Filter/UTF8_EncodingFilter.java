package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("*.do")
public class UTF8_EncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		req.setCharacterEncoding("UTF-8");
		
		chain.doFilter(req, resp);
		
		resp.setContentType("text/html; charset=UTF-8");
		
	}

}
