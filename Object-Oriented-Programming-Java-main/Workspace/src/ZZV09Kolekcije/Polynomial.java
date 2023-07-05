package ZZV09Kolekcije;

import java.util.*;

public class Polynomial {
	
	public Map<Integer, Integer> getMapa() {
		return mapa;
	}

	Map<Integer, Integer> mapa = new TreeMap<>();
	
	public Polynomial(Integer...integers) {
		for (int i=0; i< integers.length/2; i++) {
			mapa.put(integers[i+1], integers[i]);
		}
	}
	
	public Map<Integer, Integer> plus (Polynomial drugi) {
		Map<Integer, Integer> zbroj = new TreeMap<>(drugi.getMapa());
		for (Integer entry: mapa.keySet()) {
			if (drugi.getMapa().keySet().contains(entry) ) {
				int sadrz = mapa.get(entry);
				drugi.getMapa().remove(entry);
				zbroj.put(entry, sadrz+drugi.getMapa().get(entry));
			}
			else {
				zbroj.put(entry, mapa.get(entry));
			}
			
		}
		NavigableMap dmap = ((TreeMap<Integer, Integer>) zbroj).descendingMap();
		
		return dmap;
	}

}
