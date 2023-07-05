package ZZV09Kolekcije;

import java.util.*;
import ZZV09Kolekcije.Pair.*;

public class LadderEnhanced extends Ladder {
	
	List<String> tablica = new LinkedList<>();
	int cnt=1;
	Map<String, Pair<Integer>> mapa = new LinkedHashMap<>();
	
	public LadderEnhanced(String ... players) {
		for (String entry: players) {
			if (!tablica.contains(entry)) {
				tablica.add(entry);
				cnt++;
				mapa.put(entry, new Pair(0, 0));
			}
		}
		//System.out.println(mapa);
	}
	public int wins(String player) {
		return ( mapa.get(player).getFirst() );
	}
	public int losses(String player) {
		return ( mapa.get(player).getSecond() );
	}
	
	@Override
	public void gameFinished(String winner, String looser) {
		//System.out.println("Name: "+winner+", br. pobijeda: "+mapa.get(winner).getFirst());
		mapa.get(winner).setPair1(mapa.get(winner).getFirst() + 1);
		mapa.get(looser).setPair2(mapa.get(looser).getSecond() + 1);
		//System.out.println("2. Name: "+winner+", br. pobijeda: "+mapa.get(winner).getFirst());
		
		 if (!tablica.contains(winner) || !tablica.contains(looser)) {
			 System.out.println("Ne registrirani igrač!");
			 return;
		 }

		 int poz1, poz2;
		 if (tablica.indexOf(winner) > tablica.indexOf(looser) ) {
			 poz1 = tablica.indexOf(winner) - (int)(tablica.indexOf(winner)-tablica.indexOf(looser))/2;
			 if (poz1<1) poz1 = 1;
			 tablica.remove(winner);

			 tablica.add(poz1, winner);
			 
		 }
		 else if ( tablica.indexOf(winner) < tablica.indexOf(looser) ) {
			 poz1 = tablica.indexOf(winner) - 1;
			 if (poz1<0) poz1 = 0;
			 //System.out.println("Winner " + winner + " na poz "+ poz1);
			 tablica.remove(winner);

			 tablica.add(poz1, winner);
		 }
		 
		 
		 poz2 = tablica.indexOf(looser)+1;
		 if (poz2>=tablica.size()) poz2 = tablica.size() - 1;
		 tablica.remove(looser);
		 tablica.add(poz2, looser);
		 
		 return;
	 }
	@Override
	public LinkedList<String> standings() {
		Set<String> a = mapa.keySet();
		List<String> arr = new LinkedList<>(a);
		 return (LinkedList<String>) arr;
		 
	 }
	

}
