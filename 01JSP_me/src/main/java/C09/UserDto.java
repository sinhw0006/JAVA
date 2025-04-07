package C09;

public class UserDto {
	private String userid;
	private String addr;
	private String password;
	private String role;

	// 생성자/getterandsetter/toSTring
	public UserDto() {
	};

	public UserDto(String userid, String addr, String password, String role) {
		super();
		this.userid = userid;
		this.addr = addr;
		this.password = password;
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDto [userid=" + userid + ", addr=" + addr + ", password=" + password + ", role=" + role + "]";
	}

}
