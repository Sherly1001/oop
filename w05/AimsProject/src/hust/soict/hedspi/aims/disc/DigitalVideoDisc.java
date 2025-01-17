package hust.soict.hedspi.aims.disc;

//import javax.swing.text.StyledEditorKit.BoldAction;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}

	public DigitalVideoDisc(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}

	public DigitalVideoDisc(String title, String category, String directory) {
		super();
		this.title = title;
		this.category = category;
		this.director = directory;
	}

	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = directory;
		this.length = length;
		this.cost = cost;
	}

	public void cloneFrom(DigitalVideoDisc other) {
		title = other.getTitle();
		category = other.getCategory();
		director = other.getDirector();
		length = other.getLength();
		cost = other.getCost();
	}

	public boolean search(String pattern) {
		boolean result = true;
		for (String token : pattern.split(" ")) {
			if (!this.title.contains(token)) {
				result = false;
				break;
			}
		}
		return result;
	}
}
