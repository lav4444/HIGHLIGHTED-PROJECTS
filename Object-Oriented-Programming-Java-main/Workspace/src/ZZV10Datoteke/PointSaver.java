package ZZV10Datoteke;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.FileWriter;

public class PointSaver {
	
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

	private int year;
	private String tkoDijeli;
	private List<String> listaBod = new LinkedList<>();
	private static final int[] points = {12, 10, 8, 7, 6, 5, 4, 3, 2, 1};

	public static void saveJuryPoints(int year, String tkoDijeli, List<String> listaBod) throws IOException {
//		this.year = year;
//		this.tkoDijeli = tkoDijeli;
//		this.listaBod = listaBod;
		String fileName = "/"+year+"/voting/"+tkoDijeli+"-jury.txt";
		savePoints(fileName, listaBod);
		
	}
	public static void saveTelevotingPoints(int year, String tkoDijeli, List<String> listaBod) throws IOException {
//		this.year = year;
//		this.tkoDijeli = tkoDijeli;
//		this.listaBod = listaBod;
		String fileName = "/"+year+"/voting/"+tkoDijeli+"-televoting";
		savePoints(fileName, listaBod);
		
	}
	
	public static void savePoints(String fileName, List<String> ocjene ) throws IllegalFormatFlagsException ,UnsupportedEncodingException, FileNotFoundException, IOException {
		Path p = Path.of("/Users/lavsmacbook/Desktop/data"+fileName+".txt");
		p.toFile().getParentFile().mkdirs();
			
		try {
			PrintWriter pw = new PrintWriter(p.toFile());
			for (int i=0; i<points.length; i++) {
            	pw.println(String.format("%2d %s", points[i], ocjene.get(i)));
            }
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
            
	
	
	
	}
}
