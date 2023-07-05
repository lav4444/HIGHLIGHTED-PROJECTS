package ZZV09Kolekcije;

import java.util.*;

public class LadderEnhancedByLossesOrder extends LadderEnhanced {
	
	public LadderEnhancedByLossesOrder(String ... players) {
		for (String entry: players) {
			if (!tablica.contains(entry)) {
				tablica.add(entry);
				cnt++;
				mapa.put(entry, new Pair(0, 0));
			}
		}
		//System.out.println(mapa);
	}
	public LinkedList<String> orderByLosses() {
		List<String> novaM = new LinkedList<String>();
		int ind=0, cnt=1;
		while (cnt <= mapa.keySet().size() ) {
			//System.out.println("Map key set: "+ mapa.keySet().size() );
			for (String entry: mapa.keySet()) {
				if (mapa.get(entry).getSecond() == ind && !novaM.contains(entry)) {
					//System.out.println("EVO! :"+entry);
					novaM.add(entry);
					cnt++;
				}
			}
			ind++;
		}
		//System.out.println("Gotovo");
		return (LinkedList<String>) novaM;
		
	}

}
