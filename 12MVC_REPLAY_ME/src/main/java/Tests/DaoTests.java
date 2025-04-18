package Tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Domain.Dao.BookDao;
import Domain.Dao.BookDaoImpl;
import Domain.Dao.UserDao;
import Domain.Dao.UserDaoImpl;
import Domain.Dto.BookDto;
import Domain.Dto.UserDto;
import Domain.Service.BookServiceImpl;

class DaoTests {
	
	@Test
	@Disabled
	void test() throws Exception {
		UserDao userDao = UserDaoImpl.getInstance();
		
		userDao.insert(new UserDto("user","1234","ROLE_ADMIN"));
	}
	
	@Test
	@Disabled
	void test2() throws Exception {
		BookDao dao = BookDaoImpl.getInstance();
		dao.insert(new BookDto("1111", "C++", "한", "111-111"));
	}
	
	@Test
	void test3() throws Exception {
		BookServiceImpl.getInstance().getAllBookReply("CDJ000005458");
	}

}
