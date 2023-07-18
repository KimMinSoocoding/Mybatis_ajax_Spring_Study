package ez.web.model;

public class StudentDTO {
	private int sId;
	private String sName;
	private int sAge;
	private String sGender;
	private String sEmail;
	private String sMajor;
	
	public StudentDTO() {}

	public StudentDTO(int sId, String sName, int sAge, String sGender, String sEmail, String sMajor) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sAge = sAge;
		this.sGender = sGender;
		this.sEmail = sEmail;
		this.sMajor = sMajor;
	}	

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getsAge() {
		return sAge;
	}

	public void setsAge(int sAge) {
		this.sAge = sAge;
	}

	public String getsGender() {
		return sGender;
	}

	public void setsGender(String sGender) {
		this.sGender = sGender;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsMajor() {
		return sMajor;
	}

	public void setsMajor(String sMajor) {
		this.sMajor = sMajor;
	}
	
	
}
