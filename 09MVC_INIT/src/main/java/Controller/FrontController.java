package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.user.UserCreateController;

@WebServlet("/")
public class FrontController extends HttpServlet {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	// 서브컨트롤러 저장 자료구조("/endPoint":서브컨트롤러객체)
	private Map<String, SubController> map = new HashMap();

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			map.put("/index.do", new HomeController());
			// 인증
			map.put("/user/create", new UserCreateController()); // C

			// 도서
		} catch (Exception e) {
			throw new ServletException("서브 컨트롤러 등록오류");
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			this.req = req;
			this.resp = resp;
			System.out.println("[FC] Service...");
			String endPoint = req.getServletPath();
			System.out.println("[FC] EndPoint .." + endPoint);
			SubController controller = map.get(endPoint);
			controller.execute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			exceptionHandler(e, req);
			req.getRequestDispatcher("/WEB-INF/View/error.jsp").forward(req, resp);
		}
	}
	
	// 예외처리함수
		public void exceptionHandler(Exception e, HttpServletRequest req) {
			req.setAttribute("status", false);
			req.setAttribute("message", e.getMessage());
			req.setAttribute("exception", e);
		}
}
