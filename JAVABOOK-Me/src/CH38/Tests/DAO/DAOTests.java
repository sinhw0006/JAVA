package CH38.Tests.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import CH38.Domain.DAO.BookDAOImpl;
import CH38.Domain.DAO.UserDAOImpl;
import CH38.Domain.DTO.BookDTO;
import CH38.Domain.DTO.UserDTO;

class DAOTests {

	@Test
	void test1() throws Exception {
		UserDAOImpl userDAOImpl = UserDAOImpl.getInstance();
	}
	@Test
	void test2() throws Exception {
		UserDAOImpl userDAOImpl = UserDAOImpl.getInstance();
		userDAOImpl.insert(new UserDTO("aaa","홍길동","1234","")); 
	}
	
	@Test
	void test3() throws Exception {
		BookDAOImpl bookDAOImpl = BookDAOImpl.getInstance();
		bookDAOImpl.insert(new BookDTO("a","b","c","d"));
	}                                                       

}
