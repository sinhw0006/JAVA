package Utils;

public class CountVoteDTO {
	private String m_no;
	private String v_name;
	private String count;
	
	public CountVoteDTO() {};
	
	public CountVoteDTO(String m_no, String v_name, String count) {
		super();
		this.m_no = m_no;
		this.v_name = v_name;
		this.count = count;
	}
	public String getM_no() {
		return m_no;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CountVoteDTO [m_no=" + m_no + ", v_name=" + v_name + ", count=" + count + "]";
	}
	
}
