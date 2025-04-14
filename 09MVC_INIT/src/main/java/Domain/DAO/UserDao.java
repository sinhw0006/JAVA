package Domain.DAO;

import java.sql.SQLException;
import java.util.List;

import Domain.DTO.UserDTO;


public interface UserDao {

	int insert(UserDTO userDto) throws Exception;

	int update(UserDTO userDto) throws SQLException;

	int delete(UserDTO userDto) throws SQLException;
	//단건조회

	UserDTO select(UserDTO userDto);
	//다건조회

	List<UserDTO> selectAll();

}