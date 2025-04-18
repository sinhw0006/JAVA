package Controller.book;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Service.BookServiceImpl;

public class BookReadController implements SubController {
	HttpServletRequest req;
	HttpServletResponse resp;

	BookServiceImpl bookService;

	public BookReadController() throws Exception {
		bookService = BookServiceImpl.getInstance();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		try {
			
			String bookCode = req.getParameter("bookCode");
			if(!isValid(bookCode)) {
				resp.sendRedirect(req.getContextPath()+"/book/list");
				return;
			}
			Map<String, Object> serviceResp = bookService.getBook(bookCode);
			
			Boolean status = (Boolean)serviceResp.get("status");
			if(status) {
				req.setAttribute("bookDto", serviceResp.get("bookDto"));
			}
			
			req.getRequestDispatcher("/WEB-INF/view/book/read.jsp").forward(req, resp);
		} catch (Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			} catch (Exception e1) {
			}
		}
	}
	
	private boolean isValid(String bookCode) {
		if (bookCode.isEmpty()) {
			req.setAttribute("bookCode","BookCode 유효성 오류");
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
