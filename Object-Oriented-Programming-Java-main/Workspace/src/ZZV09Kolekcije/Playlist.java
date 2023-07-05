package ZZV09Kolekcije;

import java.util.*;

public class Playlist {
	
	public List<Track> getLista() {
		return lista;
	}
	@Override
	public String toString() {
		return "Playlist [pName=" + pName + ", lista=" + lista + "]";
	}
	public Playlist(String pName) {
		super();
		this.setpName(pName);
	}
	public Playlist(String pName, int ogranicenje) {
		super();
		
		this.setpName(pName);
		this.ogranicenje = ogranicenje;
	}
	public Track trackAt(int indx) {
		return lista.get(indx-1);
	}
	public void deleteAt(int indx) {
		Track pesma = lista.get(indx-1);
		lista.remove(pesma);
	}
	public void move(int indx, int smjer) {
		if (smjer == 0) return;
		else if (smjer > 0) {
			Track pesma = lista.get(indx-1);
			lista.remove(pesma);
			int x = indx + smjer - 1;
			if (x<=0) x=0;
			if (x>lista.size()) x=lista.size();
			//System.out.println(pesma+" na indx "+ x);
			lista.add(x, pesma);
		}
		else if (smjer < 0) {
			Track pesma = lista.get(indx-1);
			lista.remove(pesma);
			int x = indx + smjer - 1;
			if (x<=0) x=0;
			if (x>lista.size()) x=lista.size();
			lista.add(x, pesma);
		}
	}
	
	
	public boolean add(Track pesma) {
		boolean dodana = true;
		//System.out.printf("Ogranicenje: %d, trajanje s ovom pesmom: %d, pjesma: "+pesma+"\n", ogranicenje,duration()+pesma.getTrajanje() );
		
			if (duration()+pesma.getTrajanje() <= ogranicenje) {
				lista.add(pesma);
			} else {
				//System.out.println("Playlista vremenski prelazi ograničenje, stoga pjesma neće biti dodana.");
				dodana = false;
			}
		
		return dodana;
	}
	public int duration() {
		int suma = 0;
		for (Track e: lista) {
			suma += e.getTrajanje();
		}
		return suma;
	}
	
	public int count() {
		return lista.size();
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public List<Track> invert() {
		Collections.reverse(lista);
		return lista;
	}

	private String pName;
	private List<Track> lista = new LinkedList<>();
	private int ogranicenje;

}
