package Aud9DatotekeAnonim;

import java.util.*;

public class Solution {
	
	public static List<List<String>> groupAnagrams(String[] input) {
		List<List<String>> sve = new LinkedList<>();
		for (int i=0; i<input.length; i++) {
			boolean moze = true;
			for (List<String> entry: sve) {
				if (entry.contains(input[i])) {
					moze = false;
				}
			}
			if (moze) {
			List<String> burazz = new LinkedList<>();
			burazz.add(input[i]);
			for (int j=0; j<input.length; j++ ) {
				if ( (i != j) && (input[i].length()==input[j].length()) ) {
					//System.out.println("ima takvih "+input[i]+" "+input[j]);
					char[] one = input[i].toCharArray();
					Arrays.sort(one);
					char[] two = input[j].toCharArray();
					Arrays.sort(two);
					//System.out.println("jel jesu "+one+" "+two);
					if (Arrays.equals(one, two)) {
						//System.out.println("ima takvih "+input[i]+" "+input[j]);
						burazz.add(input[j]);
					}
				}
			}
			sve.add(burazz);
			
		}
		}
		return sve;
	}
	public static void main(String[] args) {
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = Solution.groupAnagrams(input); 
		for(List<String> group: result) {
			System.out.println(group); 
		}
	}

}
