package CH38.Tests.Service;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import CH38.Domain.DTO.UserDTO;
import CH38.Domain.Service.UserServiceImpl;

public class ServiceTests {

	@Test
	void test() throws ClassNotFoundException, SQLException {
		UserServiceImpl userService = UserServiceImpl.getInstance();
		userService.userJoin(new UserDTO("basg", "남길동", "125125", "ROLE_USER"));
	}
}
