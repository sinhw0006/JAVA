package C09;

import java.time.LocalDate;

public class OrderDto3 {
	private String addr;
	private LocalDate date;
	private Integer sum;
	
	public OrderDto3() {}

	public OrderDto3(String addr, LocalDate date, Integer sum) {
		super();
		this.addr = addr;
		this.date = date;
		this.sum = sum;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "OrderDto3 [addr=" + addr + ", date=" + date + ", sum=" + sum + "]";
	}

}
