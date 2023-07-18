package web.model;

public class MemberDTO {
	private int no;
	private String id;
	private String pw;
	private String name;
	private int age;
	private String email;
	private String phone;
	private String zipcode;
	private String road_addr;
	private String jibun_addr;
	private String detail_addr;
	
	// 기본생성자
	public MemberDTO() {}
	
	// DB에서 조회한 결과를 이용할 때 no 필요 
	public MemberDTO(int no, String id, String pw, String name, int age, String email, String phone, String zipcode,
			String road_addr, String jibun_addr, String detail_addr) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.zipcode = zipcode;
		this.road_addr = road_addr;
		this.jibun_addr = jibun_addr;
		this.detail_addr = detail_addr;
	}
	
	// DB에 데이터 입력시 no 필요 없음 
	public MemberDTO(String id, String pw, String name, int age, String email, String phone, String zipcode,
			String road_addr, String jibun_addr, String detail_addr) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.zipcode = zipcode;
		this.road_addr = road_addr;
		this.jibun_addr = jibun_addr;
		this.detail_addr = detail_addr;
	}

	// getter, setter
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getRoad_addr() {
		return road_addr;
	}

	public void setRoad_addr(String road_addr) {
		this.road_addr = road_addr;
	}

	public String getJibun_addr() {
		return jibun_addr;
	}

	public void setJibun_addr(String jibun_addr) {
		this.jibun_addr = jibun_addr;
	}

	public String getDetail_addr() {
		return detail_addr;
	}

	public void setDetail_addr(String detail_addr) {
		this.detail_addr = detail_addr;
	}
	

	
	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", email="
				+ email + ", phone=" + phone + ", zipcode=" + zipcode + ", road_addr=" + road_addr + ", jibun_addr="
				+ jibun_addr + ", detail_addr=" + detail_addr + "]";
	}
	
	
}
