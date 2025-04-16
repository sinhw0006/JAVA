package Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import Domain.Dto.BookDto;
import Domain.Dto.UserDto;


public interface BookDao {

	int insert(BookDto bookDto) throws Exception;

	int update(UserDto userDto) throws SQLException;

	int delete(UserDto userDto) throws SQLException;
	//단건조회

	UserDto select(UserDto userDto);
	//다건조회

	List<UserDto> selectAll();
	
	int bookCount(String input) throws Exception;
	
	List<BookDto> selectAllBookPage(int pageNum, String sortBy, String orderBy, String input) throws Exception;

}