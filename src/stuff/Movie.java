package stuff;

public class Movie {
	private String title;
	private int year;
	private float stars;
	private String genre;
	
	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public float getStars() {
		return stars;
	}

	public String getGenre() {
		return genre;
	}

	public Movie(String title, int year, float stars, String genre) {
		this.title = title;
		this.year = year;
		this.stars = stars;
		this.genre = genre;
	}
}
