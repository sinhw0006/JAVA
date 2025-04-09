package Utils;

public class teacherInfoDTO {
	private String teacher_code;
	private String class_name;
	private String teacher_name;
	private Integer sum;

	public teacherInfoDTO() {
	};

	public teacherInfoDTO(String teacher_code, String class_name, String teacher_name, Integer sum) {
		super();
		this.teacher_code = teacher_code;
		this.class_name = class_name;
		this.teacher_name = teacher_name;
		this.sum = sum;
	}

	public String getTeacher_code() {
		return teacher_code;
	}

	public void setTeacher_code(String teacher_code) {
		this.teacher_code = teacher_code;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "teacherInfoDTO [teacher_code=" + teacher_code + ", class_name=" + class_name + ", teacher_name="
				+ teacher_name + ", sum=" + sum + "]";
	}

}
