package C09;

import java.time.LocalDate;

public class OrderDto2 {
	private LocalDate date;
	private Integer avg;
	
	public OrderDto2() {}

	public OrderDto2(LocalDate date, Integer avg) {
		super();
		this.date = date;
		this.avg = avg;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getAvg() {
		return avg;
	}

	public void setAvg(Integer avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "OrderDto2 [date=" + date + ", avg=" + avg + "]";
	};
	
	
	
}
