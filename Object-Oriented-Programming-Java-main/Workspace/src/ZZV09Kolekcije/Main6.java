package ZZV09Kolekcije;

import java.util.*;

public class Main6 {
	
	public static void main(String[] args) {
		Playlist p1 = PlaylistDataLoader.createPlaylist();
		Playlist p2 = PlaylistDataLoader.createPlaylist();
		List<String> words = PlaylistUtil.words(p1, p2);
		System.out.println("Words in songs");
		for(String s : words) {
			System.out.println(s);
		}
		System.out.println();
		
		Map<String, Integer> wordsCounts = PlaylistUtil.wordsOccurance(p1);
		System.out.println("Words in songs (occurances):");
		for(var entry : wordsCounts.entrySet()) {
			System.out.println(entry.getKey() + " (" + entry.getValue() + ")");
		}
		System.out.println();
		
		System.out.println("Words in songs by words length:");
		Map<Integer, Integer> perLength = PlaylistUtil.perLength(p1);
		
//		for(var lengthEntry : perLength.entrySet()) {
//			System.out.print(lengthEntry.getKey() + ": ");			
//			for(var entry : lengthEntry.getValue().entrySet()) {
//				System.out.print(entry.getKey() + " (" + entry.getValue() + ") ");
//			}
//			System.out.println();
//		}
	}

}
