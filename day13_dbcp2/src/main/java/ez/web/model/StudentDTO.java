package ez.web.model;

public class StudentDTO {
	private String stuNo;
	private String pw;
	private String name;
	private String tel;
	
	public StudentDTO() {}
	
	public StudentDTO(String stuNo, String pw, String name, String tel) {
		super();
		this.stuNo = stuNo;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
	}

	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "StudentDTO [stuNo=" + stuNo + ", pw=" + pw + ", name=" + name + ", tel=" + tel + "]";
	}
}
