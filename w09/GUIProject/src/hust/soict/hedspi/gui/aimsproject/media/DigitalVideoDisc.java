package hust.soict.hedspi.gui.aimsproject.media;

public class DigitalVideoDisc extends Disc implements Playable {
	public DigitalVideoDisc(String title) {
		super(title);
	}

	public DigitalVideoDisc(String title, String category) {
		super(title, category);
	}

	public DigitalVideoDisc(String title, String category, String directory) {
		super(title, category, directory);
	}

	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super(title, category, cost, length, directory);
	}

	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
//	public void cloneFrom(DigitalVideoDisc other) {
//		setTitle(other.getTitle());
//		setCategory(other.getCategory());
//		setDirector(other.getDirector());
//		setLength(other.getLength());
//		setCost(other.getCost());
//	}
}
