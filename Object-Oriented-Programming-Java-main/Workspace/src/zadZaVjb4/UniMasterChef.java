package zadZaVjb4;

public class UniMasterChef {
	
	private int brPrijava;
	
	public UniMasterChef(int brPrijava) {
		this.brPrijava = brPrijava;

	}
	
	public boolean addEntry(CompetitionEntry plusOne) {
		boolean moze = true;
		for (int i = 0; i<natjecatelji.length; i++) {
			if (natjecatelji[i] == null) {
				break;
			}
			if (natjecatelji[i].getUcitelj() == plusOne.getUcitelj() ) {
				moze = false;
				break;
			}
		}
		if (moze && natjecatelji.length<brPrijava) {
			natjecatelji[ natjecatelji.length ] = plusOne;
			return true;
		} else return false;
	}
	private CompetitionEntry[] natjecatelji = new CompetitionEntry[brPrijava];
	
	public void getBestDessert() {
		double max = 0;
		
		CompetitionEntry ovaj = natjecatelji[0];
		if (natjecatelji.length != 0) {
		for (int i = 0; i < natjecatelji.length; i++) {
			if (natjecatelji[i] == null) continue;
			if ( natjecatelji[i].getRating() > max ) {
				max = natjecatelji[i].getRating();
				ovaj = natjecatelji[i];
			}
		}
		System.out.println("Najbolji dessert je od profesora "+ ovaj.getUcitelj()+", pripremio nam je "+ovaj.getDesert()+" te ostvario "+max+" bodova");
		}	
	}
	static Person[] getInvolvedPeople(CompetitionEntry aka) {
		Person[] ljudeki = new Person[4];
		ljudeki[0] = aka.getUcitelj();
		int j=1;
		for (int i=0; i<aka.getStudenti().length; i++) {
			ljudeki[j] = aka.getStudenti()[i];
			j++;
		}
		return ljudeki;
	}

}
