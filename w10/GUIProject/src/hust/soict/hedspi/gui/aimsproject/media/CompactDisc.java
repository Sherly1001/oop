package hust.soict.hedspi.gui.aimsproject.media;

import java.util.ArrayList;

import hust.soict.hedspi.gui.aimsproject.aims.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void addTrack(Track track) {
		int id = tracks.indexOf(track);
		if (id < 0) {
			tracks.add(track);
		} else {
			System.out.println("Track already in the disc!");
		}
	}

	public void removeTrack(Track track) {
		int id = tracks.indexOf(track);
		if (id < 0) {
			System.out.println("Track " + track.getTitle() + " not in the disc!");
		} else {
			tracks.remove(id);
		}
	}

	public void removeTrack(String title) {
		boolean removed = tracks.removeIf(s -> title.compareTo(((Track) s).getTitle()) == 0);
		if (!removed) {
			System.out.println("Track " + title + " not in the disc!");
		}
	}

	public int getLength() {
		int sum = 0;
		for (Track t : tracks) {
			sum += t.getLength();
		}
		return sum;
	}

	public void play() throws PlayerException {
		if (getLength() <= 0)
			throw new PlayerException("ERROR: CD length is non-positive!");
		for (Track t : tracks) {
			try {
				t.play();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
