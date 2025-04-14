package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Domain.DAO.UserDao;
import Domain.DAO.UserDaoImpl;
import Domain.DTO.UserDTO;

class DAOTest {

	@Test
	void test1() throws Exception {
		UserDao userDao = UserDaoImpl.getInstance();
		userDao.insert(new UserDTO("user1235", "Hi", "1234", "ROLE_USER"));
	}
	@Test
	void test2() {
		
	}
	@Test
	void test3() {
		
	}
	@Test
	void test4() {
		
	}

}
