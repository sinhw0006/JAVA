package DTO;

public class UserDTO {
	private String userid;
	private String username;
	private String userpassword;
	private String userrole;
	
	public UserDTO() {}
	
	public UserDTO(String userid, String username, String userpassword, String userrole) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.userrole = userrole;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", username=" + username + ", userpassword=" + userpassword + ", userrole="
				+ userrole + "]";
	}
	
}
