package ZZV09Kolekcije;

public class Main3 {
	
	public static void main(String[] args) {		
		LadderEnhanced ladder = new LadderEnhanced("Brian", "Mia", "Sophia", "John", "Charlotte", "Pierre", "Bruno");
		ladder.gameFinished("Mia", "John");
		ladder.gameFinished("Bruno", "Brian");
		ladder.gameFinished("Charlotte", "Brian");
		ladder.gameFinished("Mia", "John");
		ladder.gameFinished("Sophia", "John");	
//		System.out.println("PanPek");
		printStandings(ladder);		
	}

	private static void printStandings(LadderEnhanced ladder) {
		int pos=0;
		//System.out.println("PanPek");
		for(String player : ladder.standings()) {
			System.out.format("%d. %s has %d wins and %d losses %n", ++pos, player, 
					ladder.wins(player), ladder.losses(player));
		}
		System.out.println();		
	}

}
