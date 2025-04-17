package Domain.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Domain.Dao.BookDao;
import Domain.Dao.BookDaoImpl;
import Domain.Dto.BookDto;

public class BookServiceImpl {

	//
	private BookDao bookDao;

	// 싱글톤 패턴
	private static BookServiceImpl instance;

	private BookServiceImpl() throws Exception {
		bookDao = BookDaoImpl.getInstance();
	}

	public static BookServiceImpl getInstance() throws Exception {
		if (instance == null)
			instance = new BookServiceImpl();
		return instance;
	}

	// TX 처리 + 비즈니스 유효성검사
	public boolean bookRegistration(BookDto bookDto) throws Exception {

		return bookDao.insert(bookDto) > 0;

	}

	public List<BookDto> bookPaging(int pageNum, String sortBy, String orderBy, String type, String input)
			throws Exception {
		return bookDao.selectAllBookPage(pageNum, sortBy, orderBy, type, input);
	}

	public int bookCount(String input, String type) throws Exception {
		return bookDao.bookCount(input, type);
	}

	public Map<String, Object> getBook(String bookCode) throws Exception {

		Map<String, Object> resp = new LinkedHashMap<String, Object>();

		BookDto bookDto = bookDao.select(bookCode);

		if (bookDto == null)
			resp.put("status", false);
		else {
			resp.put("status", true);
			resp.put("bookDto", bookDto);
		}

		return resp;
	}

	public boolean modifyBook(BookDto bookDto) throws Exception{
		
		return bookDao.update(bookDto) > 0;
	}

	public boolean removeBook(String bookCode) throws Exception {
		return bookDao.delete(bookCode) > 0;
	}

}
