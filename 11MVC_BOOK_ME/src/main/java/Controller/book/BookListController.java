package Controller.book;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hamcrest.core.Is;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Dto.UserDto;
import Domain.Service.BookServiceImpl;

public class BookListController implements SubController {

	HttpServletRequest req;
	HttpServletResponse resp;

	BookServiceImpl bookService;

	public BookListController() throws Exception {
		bookService = BookServiceImpl.getInstance();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		try {
			HttpSession session = req.getSession();
			if (session.getAttribute("input") == null) {
				session.setAttribute("sortBy", "bookName");
				session.setAttribute("orderBy", "ASC");
				session.setAttribute("type", "bookName");
				session.setAttribute("input", "");
			}

			String page = req.getParameter("page") != null ? req.getParameter("page") : "1";
			if (page.isEmpty()) {
				page = "1";
			}
			int pages = Integer.parseInt(page);
			
			String sortBy = req.getParameter("sortBy") != null ? (String) req.getParameter("sortBy")
					: (String) session.getAttribute("sortBy");
			String orderBy = req.getParameter("orderBy") != null ? (String) req.getParameter("orderBy")
					: (String) session.getAttribute("orderBy");
			String type = req.getParameter("type") != null ? (String) req.getParameter("type")
					: (String) session.getAttribute("type");
			String input = req.getParameter("input") != null ? (String) req.getParameter("input")
					: (String) session.getAttribute("input");
			
			session.setAttribute("sortBy", sortBy);
			session.setAttribute("orderBy", orderBy);
			session.setAttribute("type", type);
			session.setAttribute("input", input);

			int bookCount = bookService.bookCount(input,type);

			int pageCount = (int) Math.ceil(bookCount / 10.0);
			if (pages > pageCount)
				pages = pageCount;
			if (pages <= 0)
				pages = 1;
			List<BookDto> list = bookService.bookPaging(pages, sortBy, orderBy, type ,input);
			req.setAttribute("bookCount", bookCount);
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("books", list);
			req.setAttribute("page", pages);
			req.getRequestDispatcher("/WEB-INF/view/book/list.jsp").forward(req, resp);
			return;

		} catch (Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			} catch (Exception e1) {
			}
		}
	}

	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
