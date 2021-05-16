package hust.soict.hedspi.gui.aimsproject.media;

import hust.soict.hedspi.gui.aimsproject.aims.PlayerException;

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

	public void play() throws PlayerException {
		if (getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
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
