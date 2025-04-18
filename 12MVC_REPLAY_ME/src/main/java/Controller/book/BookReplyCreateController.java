package Controller.book;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import Controller.SubController;
import Domain.Dto.BookReplyDto;
import Domain.Service.BookServiceImpl;

public class BookReplyCreateController implements SubController {
	HttpServletRequest req;
	HttpServletResponse resp;

	BookServiceImpl bookService;

	public BookReplyCreateController() throws Exception {
		bookService = BookServiceImpl.getInstance();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		try {
			HttpSession session = req.getSession();
			String bookCode = req.getParameter("bookCode");
			String username = (String) req.getSession().getAttribute("username");
			String contents = req.getParameter("contents");
			LocalDateTime createAt = LocalDateTime.now();

			BookReplyDto replyDto = new BookReplyDto(0, bookCode, username, contents, createAt);

			if (!isValid(replyDto)) {
				;
			}
			boolean isAdded = bookService.bookReplyAdd(replyDto);

			long cnt = bookService.bookReplyCount(bookCode);

			Map<String, Object> entity = new LinkedHashMap();
			entity.put("list", replyDto);
			entity.put("count", cnt);

			resp.setContentType("application/json; charset=UTF-8");
			resp.setCharacterEncoding("UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule());
			objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			String jsonDate = objectMapper.writeValueAsString(entity);
			PrintWriter out = resp.getWriter();
			out.write(jsonDate);

		} catch (Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			} catch (Exception e1) {
			}
		}
	}

	private boolean isValid(BookReplyDto replyDto) {
		// TODO Auto-generated method stub
		return true;
	}

	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}

}
