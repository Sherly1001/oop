package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;

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

	public DigitalVideoDisc(String title) {
		super();
		setTitle(title);
	}

	public DigitalVideoDisc(String title, String category) {
		super(title, category);
	}

	public DigitalVideoDisc(String title, String category, String directory) {
		super(title, category);
		setDirector(directory);
	}

	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super(title, category, cost);
		setDirector(directory);
		setLength(length);
	}

	public void cloneFrom(DigitalVideoDisc other) {
		setTitle(other.getTitle());
		setCategory(other.getCategory());
		setDirector(other.getDirector());
		setLength(other.getLength());
		setCost(other.getCost());
	}
}
