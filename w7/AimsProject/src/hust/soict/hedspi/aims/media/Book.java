package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

	public Book(String title) {
		super(title);
	}

	public Book(String title, String category) {
		super(title, category);
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost);
		this.authors = authors;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println(authorName + " already in list");
		} else {
			authors.add(authorName);
		}
	}

	public void removeAuthor(String authorName) {
		int id = authors.indexOf(authorName);
		if (id < 0) {
			System.out.println(authorName + " not in list");
		} else {
			authors.remove(id);
		}
	}
}
