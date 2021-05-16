package hust.soict.hedspi.gui.aimsproject.media;

import hust.soict.hedspi.gui.aimsproject.aims.PlayerException;

public class Track implements Playable {
	public String title;
	public int length;

	public Track() {

	}

	public Track(String title) {
		this.title = title;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public void play() throws PlayerException {
		if (getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	public boolean equals(Object o) {
		if (!(o instanceof Track))
			return false;
		Track track = (Track) o;
		return this.getTitle().equals(track.getTitle()) && this.getLength() == track.getLength();
	}
}
