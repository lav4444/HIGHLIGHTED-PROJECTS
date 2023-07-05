package ZZV10Datoteke;

import java.util.*;

public class TelevotingPoints {
	
	
	public TelevotingPoints(int year, String tkoDijeli, List<String> listaBod) {
		this.year = year;
		this.tkoDijeli = tkoDijeli;
		this.listaBod = listaBod;
		
	}
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTkoDijeli() {
		return tkoDijeli;
	}
	public void setTkoDijeli(String tkoDijeli) {
		this.tkoDijeli = tkoDijeli;
	}
	public List<String> getListaBod() {
		return listaBod;
	}
	public void setListaBod(List<String> listaBod) {
		this.listaBod = listaBod;
	}
	private int year;
	private String tkoDijeli;
	private List<String> listaBod = new LinkedList<>();

}
