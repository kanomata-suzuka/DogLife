package Model;

public class Schedule {

	private String dogName;
	private String title;
	private String date;
	private String detail;

	public Schedule(String dogName, String title, String date, String detail) {
		this.dogName = dogName;
		this.title = title;
		this.date = date;
		this.detail = detail;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}