package ZZV09Kolekcije;

public class Track {
	
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	@Override
	public String toString() {
		return author + ": " + name;
	}
	public Track(String name, String author, int trajanje) {
		super();
		this.name = name;
		this.author = author;
		this.trajanje = trajanje;
	}
	public int getTrajanje() {
		return trajanje;
	}
	private final String name, author;
	private final int trajanje;

}
