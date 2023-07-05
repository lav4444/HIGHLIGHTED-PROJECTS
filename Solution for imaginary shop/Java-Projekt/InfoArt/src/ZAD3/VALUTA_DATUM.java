package ZAD3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class VALUTA_DATUM {
	//klasa sluzi za dohvat zadane valute i datuma iz datoteke Valuta-Datum.txt
	
	private String valuta;
	private String datum;
	
	private static File f = new File(CITANJE.getPath() + "/Valuta-Datum.txt");
	
	public static String getValuta() throws IOException {
		List<String> redovi = Files.readAllLines(f.toPath());

		String[] splits = redovi.get(0).trim().split(":");
		
		//System.out.println(splits[1].trim());
		return splits[1].trim();
	}
	public static String getDatum() throws IOException {
		List<String> redovi = Files.readAllLines(f.toPath());

		String[] splits = redovi.get(1).trim().split(":");
		
		//System.out.println(splits[1].trim());
		return splits[1].trim();
	}

}
