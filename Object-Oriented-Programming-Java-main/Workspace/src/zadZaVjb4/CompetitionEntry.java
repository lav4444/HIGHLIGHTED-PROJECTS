package zadZaVjb4;

public class CompetitionEntry {
	
	@Override
	public boolean equals(Object obj) {
		//provjere?
		CompetitionEntry other = (CompetitionEntry) obj;
		if (!ucitelj.equals(other.ucitelj))
			return false;
		return true;
	}
	
	public Teacher getUcitelj() {
		return ucitelj;
	}
	public Dessert getDesert() {
		return desert;
	}
	public Student[] getStudenti() {
		return studenti;
	}
	public int[] getOcjene() {
		return ocjene;
	}
	public CompetitionEntry(Teacher ucitelj, Dessert desert) {
		super();
		this.ucitelj = ucitelj;
		this.desert = desert;
	}
	private Teacher ucitelj;
	private Dessert desert;
	private Student[] studenti = new Student[3];
	private int[] ocjene = new int[3];
	
	int cnt = 0;
	
	public boolean addRating(Student std, int rating) {
		boolean moze = true;

		if (cnt >= 3) {
				moze = false;
		} else {
				studenti[cnt] = std;
				ocjene[cnt] = rating;
				cnt++;
		}
			
			
		
		return moze;
}
	public double getRating() {
		int suman=0;
		if (ocjene == null) {
			suman = 69*3;
		} else {
			for (int i=0; i<ocjene.length; i++) {
				
				suman += ocjene[i];
			}
		}
		if (cnt==0) return 0;
		else {
			return (double) ( (suman*1.0) / cnt*1.0 );
		}
	}

}
