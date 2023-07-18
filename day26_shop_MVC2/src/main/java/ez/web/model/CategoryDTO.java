package ez.web.model;

public class CategoryDTO {
	private int catNum; // 카테고리 일련번호
	private String code; // 카테고리 코드
	private String catName; // 카테고리명
	
	public CategoryDTO() {}

	public CategoryDTO(int catNum, String code, String catName) {
		super();
		this.catNum = catNum;
		this.code = code;
		this.catName = catName;
	}

	public int getCatNum() {
		return catNum;
	}

	public void setCatNum(int catNum) {
		this.catNum = catNum;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	
}
