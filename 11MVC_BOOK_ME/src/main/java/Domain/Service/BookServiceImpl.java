package Domain.Service;

import java.util.List;

import Domain.Dao.BookDao;
import Domain.Dao.BookDaoImpl;
import Domain.Dto.BookDto;

public class BookServiceImpl {

	//
	private BookDao bookDao;
	
	//싱글톤 패턴
	private static BookServiceImpl instance;
	private BookServiceImpl() throws Exception{	
		bookDao = BookDaoImpl.getInstance();
	}
	public static BookServiceImpl getInstance() throws Exception{
		if(instance==null)
			instance = new BookServiceImpl();
		return instance;
	}
	
	
	//TX 처리 + 비즈니스 유효성검사
	public boolean bookRegistration(BookDto bookDto) throws Exception{

		return bookDao.insert(bookDto)>0;
		
	}
	
	public List<BookDto> bookPaging(int pageNum, String sortBy, String orderBy, String input) throws Exception {
		return bookDao.selectAllBookPage(pageNum, sortBy, orderBy, input);
	}
	
	public int bookCount(String input) throws Exception {
		return bookDao.bookCount(input);
	}
	
	
}
