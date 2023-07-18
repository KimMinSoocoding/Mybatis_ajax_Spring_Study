package ez.web.model;

import java.sql.Timestamp;

public class BookDTO {
	private int bnum;
	private String title;
	private String bookInfo;
	private String author;
	private String publisher;
	private int price;
	private Timestamp regDate;
	private int qty;
	
	public BookDTO() {}
	
	public BookDTO(int bnum, String title, String bookInfo, String author, String publisher, int price, Timestamp regDate, int qty) {
		this.bnum = bnum;
		this.title = title;
		this.bookInfo = bookInfo;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.regDate = regDate;
		this.qty = qty;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "BookDTO [bnum=" + bnum + ", title=" + title + ", bookInfo=" + bookInfo + ", author=" + author
				+ ", publisher=" + publisher + ", price=" + price + ", regDate=" + regDate + ", qty=" + qty + "]";
	}
}
