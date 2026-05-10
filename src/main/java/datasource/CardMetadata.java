package datasource;

public class CardMetadata {

	private final String title;
	private final String subtitle;
	private final String description;
	private final String imageUrl;

	public CardMetadata(String title, String subtitle,
	                    String description, String imageUrl) {
		this.title = title;
		this.subtitle = subtitle;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public String getTitle() {
		return title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public String getDescription() {
		return description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

}
