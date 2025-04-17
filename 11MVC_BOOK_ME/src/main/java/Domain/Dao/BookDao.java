package Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import Domain.Dto.BookDto;
import Domain.Dto.UserDto;


public interface BookDao {

	int insert(BookDto bookDto) throws Exception;
	
	int update(BookDto BookDto) throws Exception;
	
	int delete(String bookCode) throws Exception;
	//단건조회
	
	BookDto select(String bookCode) throws Exception;
	//다건조회
	
	int bookCount(String input, String type) throws Exception;
	
	List<BookDto> selectAllBookPage(int pageNum, String sortBy, String orderBy,String type, String input) throws Exception;

}