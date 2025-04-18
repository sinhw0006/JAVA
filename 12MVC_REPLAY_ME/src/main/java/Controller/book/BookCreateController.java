package Controller.book;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Dto.UserDto;
import Domain.Service.BookServiceImpl;

public class BookCreateController implements SubController {

	HttpServletRequest req;
	HttpServletResponse resp;
	
	BookServiceImpl bookService;
	
	public BookCreateController() throws Exception {
		bookService = BookServiceImpl.getInstance();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		try {
			String uri = req.getMethod();
			if (uri.equals("GET")) {
				req.getRequestDispatcher("/WEB-INF/view/book/create.jsp").forward(req, resp);
				return;
			}
			
			String bookCode = req.getParameter("bookCode") != null ? (String) req.getParameter("bookCode") : ""; 
			String bookName = req.getParameter("bookName") != null ? (String) req.getParameter("bookName") : ""; 
			String publisher = req.getParameter("publisher") != null ? (String) req.getParameter("publisher") : ""; 
			String isbn = req.getParameter("isbn") != null ? (String) req.getParameter("isbn") : ""; 


			BookDto bookDto = new BookDto(bookCode, bookName, publisher, isbn);
			
			boolean isOk = isValid(bookDto);
			if(!isOk) {
				req.getRequestDispatcher("/WEB-INF/view/book/create.jsp").forward(req, resp);
				return;
			}
			
			boolean success = bookService.bookRegistration(bookDto);
			if(success) {
				req.setAttribute("message", "책 생성 성공");
				req.getRequestDispatcher("/WEB-INF/view/book/create.jsp").forward(req, resp);
				return;
			} else {
				req.setAttribute("message", "책 생성 실패");
				req.getRequestDispatcher("/WEB-INF/view/book/create.jsp").forward(req, resp);
				return;
			}
			

		} catch (Exception e) {
			exceptionHandler(e);
		}
	}

	private boolean isValid(BookDto bookDto) {
		if (bookDto.getBookCode().isEmpty() || bookDto.getBookName().isEmpty() || bookDto.getPublisher().isEmpty() || bookDto.getIsbn().isEmpty()) {
			req.setAttribute("message", "공백 입력이 존재합니다.");
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
