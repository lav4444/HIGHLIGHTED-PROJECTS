package ZZV09Kolekcije;

public class Main5 {
	
	public static void main(String[] args) {
		Playlist p = PlaylistDataLoader.createPlaylist();
				
		printPlaylist(p);
		p.move(3, -2); //Drunken sailor becomes the first in the playlist
		p.move(2, 3); //Dirty old down goes at the end
		p.deleteAt(4); //removing Whiskey You're the Devil
		printPlaylist(p);
		p.invert();
		printPlaylist(p);
	}

	private static void printPlaylist(Playlist p) {
		System.out.format("%s playlist contains %d songs with total duration %ds %n",
				p.getpName(), p.count(), p.duration());		
		for(int i=1, len = p.count(); i <= len; i++) {
			System.out.format("%d. %s%n", i, p.trackAt(i));
		}
		System.out.println();
	}


}
