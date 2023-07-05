package ZZV09Kolekcije;

import java.util.*;

public class PlaylistUtil {
	
	static int najRijec=1;
	
	public static List<String> words(Playlist...playlists) {
		List<String> sveRijeci = new LinkedList<>();
		for (Playlist p: playlists) {
			for (Track t: p.getLista()) {
				String[] rjeciN = t.getName().split(" ");
				for (String s: rjeciN) {
					sveRijeci.add(s);
				}
			}
		}
		return sveRijeci;
	}
	
	public static Map<String, Integer> wordsOccurance(Playlist...playlists) {
		Map<String, Integer> sveRijeci = new LinkedHashMap<>();
		for (Playlist p: playlists) {
			for (Track t: p.getLista()) {
				String[] rjeciN = t.getName().split(" ");
				for (String s: rjeciN) {
					if (!sveRijeci.keySet().contains(s)) {
						sveRijeci.put(s, 1);
					} else {
						int stara = sveRijeci.get(s);
						sveRijeci.remove(s);
						sveRijeci.put(s, stara+1);
					}
				}
			}
		}
		return sveRijeci;
	}
	public static int najduza(Playlist playlist) {
			for (Track t: playlist.getLista()) {
				String[] rjeciN = t.getName().split(" ");
				for (String s: rjeciN) {
					if (s.length() > najRijec) {
						najRijec = s.length();
					}
				}
			}
			return najRijec;
		
	}
	

	
	public static Map<Integer, Integer> perLength(Playlist playlist) {
		Map<Integer, Integer> sveRijeci = new LinkedHashMap<>();
		int size = 1;
		int naajj = najduza(playlist);
		while (size <= naajj) {
			for (Track t: playlist.getLista() ) {
				String[] rjeciN = t.getName().split(" ");
				for (String s: rjeciN) {
					if (s.length() == size) {
						if (sveRijeci.containsKey(size)) {
							int brP = sveRijeci.get(size);
							sveRijeci.remove(size);
							sveRijeci.put(size, brP+1);
						}
						else {
							sveRijeci.put(size, 1);
						}
							
					}
				}
			}
			size++;
		}	
		System.out.println(sveRijeci);
		return sveRijeci;
	}

}
