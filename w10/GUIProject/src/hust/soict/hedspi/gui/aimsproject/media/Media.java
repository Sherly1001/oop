package hust.soict.hedspi.gui.aimsproject.media;

public abstract class Media {
	private String title;
	private String category;
	private float cost;

	public Media() {

	}

	public Media(String title) {
		this.title = title;
	}

	public Media(String title, String category) {
		this.title = title;
		this.category = category;
	}

	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public boolean search(String pattern) {
		boolean result = true;
		for (String token : pattern.split(" ")) {
			if (!this.getTitle().contains(token)) {
				result = false;
				break;
			}
		}
		return result;
	}

	public boolean equals(Object o) throws NullPointerException, ClassCastException {
		if (o == null)
			throw new NullPointerException();
		if (!(o instanceof Media))
			throw new ClassCastException();
		Media m = (Media) o;
		return this.getTitle() == m.getTitle() && this.getCost() == m.getCost();
	}
}
