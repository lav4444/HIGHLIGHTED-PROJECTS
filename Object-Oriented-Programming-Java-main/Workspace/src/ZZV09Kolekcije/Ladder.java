package ZZV09Kolekcije;

import java.util.*;

public class Ladder {
	List<String> tablica = new LinkedList<>();
	int cnt=1;
	
	public Ladder(String ... players) {
		for (String entry: players) {
			if (!tablica.contains(entry)) {
				tablica.add(entry);
				cnt++;
			}
		}
	}
	public void join(String ... players) {
		for (String entry: players) {
			if (!tablica.contains(entry)) {
				tablica.add(entry);
				cnt++;
			}
		}
	}
	 public void gameFinished(String winner, String looser) {
		 if (!tablica.contains(winner) || !tablica.contains(looser)) {
			 System.out.println("Ne registrirani igrač!");
			 return;
		 }

		 int poz1, poz2;
		 if (tablica.indexOf(winner) > tablica.indexOf(looser) ) {
			 poz1 = tablica.indexOf(winner) - (int)(tablica.indexOf(winner)-tablica.indexOf(looser))/2;
			 if (poz1<1) poz1 = 1;
			 tablica.remove(winner);
//			 for (String entry: mapa.keySet()) {
//				 int index = mapa.get(entry);
//				 if (index >= poz1 && index<= staraW) {
//					 mapa.remove(entry);
//					 mapa.put(entry, index+1);
//					}
//			 }
			 tablica.add(poz1, winner);
			 
		 }
		 else if ( tablica.indexOf(winner) < tablica.indexOf(looser) ) {
			 poz1 = tablica.indexOf(winner) - 1;
			 if (poz1<0) poz1 = 0;
			 //System.out.println("Winner " + winner + " na poz "+ poz1);
			 tablica.remove(winner);
//			 for (String entry: mapa.keySet()) {
//				 int index = mapa.get(entry);
//				 if (index >= poz1 && index<= staraW) {
//					 mapa.remove(entry);
//					 mapa.put(entry, index+1);
//					}
//			 }
			 tablica.add(poz1, winner);
		 }
		 
		 
		 poz2 = tablica.indexOf(looser)+1;
		 if (poz2>=tablica.size()) poz2 = tablica.size() - 1;
		 tablica.remove(looser);
//		 for (String entry: mapa.keySet()) {
//			 int index = mapa.get(entry);
//			 if (index <= poz2 && index>= staraL) {
//				 mapa.remove(entry);
//				 mapa.put(entry, index-1);
//				}
//		 }
		 tablica.add(poz2, looser);
		 
		 return;
	 }
	 public int count() {
		 return tablica.size();
	 }
	 public LinkedList<String> standings() {
//		 int cnt = 0;
//		 while (cnt < tablica.size() ) {
//			 for (String entry: tablica) {
//				 if (tablica.indexOf(entry) == cnt) {
//					 System.out.printf("%3d. %s\n", cnt+1, entry);
//				 }
//				 cnt++;
//			 }
//			 System.out.println("-----------------------");
//		 }
		 return (LinkedList<String>) tablica;
		 
	 }

}
