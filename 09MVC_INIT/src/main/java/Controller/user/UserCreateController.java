package Controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.DTO.UserDTO;
import Domain.Service.UserServiceImpl;

public class UserCreateController implements SubController {
	private HttpServletRequest req;
	private HttpServletResponse resp;

	private UserServiceImpl userService;

	public UserCreateController() throws Exception {
		userService = userService.getInstance();
		//throw new Exception("ASGASG");
	};

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] UserCreateController execute...");

		String uri = req.getMethod();
		try {
			if (uri.equals("GET")) {
				req.getRequestDispatcher("/WEB-INF/View/user/create.jsp").forward(req, resp);
				return;
			}

			String userid = req.getParameter("userid");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String role = "ROLE_USER";

			UserDTO userDTO = new UserDTO(userid, username, password, role);
			boolean isOk = isValid(userDTO);
			if (!isOk) {
				req.getRequestDispatcher("/WEB-INF/View/user/create.jsp").forward(req, resp);
				return;
			}

			// 서비스
			boolean isJoin = userService.userJoin(userDTO);
			
			if(isJoin) {
				resp.sendRedirect(req.getContextPath() + "/index.do");
			} else {
				req.getRequestDispatcher("/WEB-INF/View/user/create.jsp").forward(req, resp);
			}

			// 뷰

		} catch (Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/View/user/error.jsp").forward(req, resp);
			} catch (Exception e1) {
			}
		}
	}

	public boolean isValid(UserDTO userDTO) {
		if (userDTO.getUserid() == null || userDTO.getUserid().length() <= 4) {
			req.setAttribute("username_err", "userid의 길이는 최소 5자이상이어야합니다");
			System.out.println("[INVALID] userid의 길이는 최소 5자이상이어야합니다");
			return false;
		}
		if (userDTO.getUserid().matches("^[0-9].*")) {
			System.out.println("[INVALID] userid의 첫문자로 숫자가 들어올수 없습니다");
			req.setAttribute("username_err", "userid의 userid의 첫문자로 숫자가 들어올수 없습니다");
			return false;
		}

		return true;
	}

	// 예외처리함수
	public void exceptionHandler(Exception e) {

		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}

}
