package aud5Rekapitulacija;

import java.util.Arrays;
import java.util.Scanner;

public class Doodle extends SimpleArrayList {
	
	private String[] imena;
	private int[] sati;
	int cnt=0;
	
	public Doodle() {
		this.imena = new String[2];
		this.sati = new int[2];
	}
	public boolean add(String ime, int vr) {
		if (cnt < imena.length) {
			imena[cnt] = ime;
			sati[cnt] = vr;
			cnt++;
		} else {
			String[] ime2 = Arrays.copyOf(imena, imena.length*2 );
			imena = Arrays.copyOf(ime2, ime2.length );
			
			int[] sati2 = Arrays.copyOf(sati, sati.length*2 );
			sati = Arrays.copyOf(sati2, sati2.length );
			
			imena[cnt] = ime;
			sati[cnt] = vr;
			cnt++;

		}
		return true;
	}
	public int size() {
		return cnt;
	}
	public String getName(int index) {
		return imena[index];
	}
	public int getTime(int index) {
		return sati[index];
	}
	public void toTable() {
		System.out.printf("| %-10s| %-8s |\n", "Name", "Time");
		for (int i=0; i<size(); i++) {
			System.out.printf("| %-10s| %-8d |\n", getName(i), getTime(i));
		}
	}
	
	public void unos() {
		System.out.println("Enter name and time. If you want to stop, enter END .");
		while (true) {
			Scanner sc = new Scanner(System.in);
			String line = sc.nextLine();
			if (line.equals("END")) break;
			
			String[] splits = line.split(" ");
			int vree = Integer.parseInt(splits[1]);
			add(splits[0], vree);
		}
		toTable();
	}
	public static void main(String[] args) {
		Doodle d = new Doodle();
		d.unos();
	}
	
	
	
	

}
