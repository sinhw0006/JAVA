package Tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Domain.Dao.UserDao;
import Domain.Dao.UserDaoImpl;
import Domain.Dto.UserDto;

class DaoTests {
	
	@Test
	@Disabled
	void test() throws Exception {
		UserDao userDao = UserDaoImpl.getInstance();
		
		userDao.insert(new UserDto("user","1234","ROLE_ADMIN"));
	}
	
	@Test
	void test2() throws Exception {
		UserDao userDao = UserDaoImpl.getInstance();
		
		userDao.select("user1");
	}

}
