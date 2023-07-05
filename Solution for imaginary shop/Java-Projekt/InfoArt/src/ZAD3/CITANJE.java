package ZAD3;

import java.io.*;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.*;

import org.apache.commons.io.FileUtils;


public class CITANJE {
	
	public CITANJE() {
	}
	
	public static String path = "/Users/lavsmacbook/Desktop/InfoArt-TomislavMatanovic/ZAD3-Rjesenje"; //UNESITE PATH MAPE SA ULAZNIM DATOTEKAMA, path do mape u kojoj su datoteke
	//ovo je jedino mjesto gdje cete to morati unijeti
	
	public static String getPath() {
		return path;
	}
	
	
	private static Map<String, List<String> > mapaArtikl = new TreeMap<>();
	private static Map<String, Double > mapaCjenik;
	private static Map<String, Map<String, Double> > mapaStanja = new LinkedHashMap<>();
	private static Map<String, String> mapaPM = new TreeMap<>();
	
	//metode za citanje datoteka
	
	public void loadARTIKL() {
		File f = new File(path + "/artikli.txt");
		try {
			//Cast datoteke iz windows 1250 u utf-8
		    File desinationFile = new File(path + "/artikli2(utf-8).txt");
	        String content = FileUtils.readFileToString(f, "Windows-1250");
	        FileUtils.write(desinationFile, content, "UTF-8");
			
			
			List<String> redovi = Files.readAllLines(desinationFile.toPath());
			for (String line: redovi) {
				String[] splits = line.split("\\|");
				List<String> lista = new LinkedList<>();
				lista.add(splits[1]);
				lista.add(splits.length>2 ? splits[2] : "/");
				
				mapaArtikl.put(splits[0], lista);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadCJENIK() {
		File f = new File(path + "/cjenik.txt");
		try {
			Map<String, Double > mapaC = new TreeMap<>();
			
			//Cast datoteke iz windows 1250 u utf-8
			
		    File desinationFile = new File(path + "/cjenik2(utf-8).txt");
	        String content = FileUtils.readFileToString(f, "Windows-1250");
	        FileUtils.write(desinationFile, content, "UTF-8");
			
			
			List<String> redovi = Files.readAllLines(desinationFile.toPath());
			for (String line: redovi) {
				String[] splits = line.split("\\|");
				String replaceString = splits[1].replace(',','.');
				
				mapaC.put(splits[0], Double.parseDouble(replaceString));
			}
			this.mapaCjenik = new LinkedHashMap<>(mapaC);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadSTANJA() {
		File f = new File(path + "/stanja.txt");
		try {
			//Cast datoteke iz windows 1250 u utf-8
			
		    File desinationFile = new File(path + "/stanja2(utf-8).txt");
	        String content = FileUtils.readFileToString(f, "Windows-1250");
	        FileUtils.write(desinationFile, content, "UTF-8");
			
			
			List<String> redovi = Files.readAllLines(desinationFile.toPath());
			for (String line: redovi) {
				String[] splits = line.split("\\|");
				Map<String, Double> unutraMapa = new LinkedHashMap<>();
				if (mapaStanja.containsKey(splits[0]) ) {
					unutraMapa = mapaStanja.get(splits[0]);
				} 
				String replacedString = splits[2].replace(",", ".");
				unutraMapa.put(splits[1], Double.parseDouble(replacedString));
				mapaStanja.put(splits[0], unutraMapa);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
	
	public void loadPRODAJNA_MJESTA() {
		File f = new File(path + "/pm.txt");
		try {
			File desinationFile = new File(path + "/pm2(utf-8).txt");
	        String content = FileUtils.readFileToString(f, "Windows-1250");
	        FileUtils.write(desinationFile, content, "UTF-8");
			
			
			List<String> redovi = Files.readAllLines(desinationFile.toPath());
			for (String line: redovi) {
				String[] splits = line.split("\\|");
				mapaPM.put(splits[0], splits[1]);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
//----------------------------metodeARTIKL-------------------------------------------------------------------------
	public static String getNazivArtikl(String sifraArtikl) {
		return mapaArtikl.get(sifraArtikl).get(0);
	}

	public static String getJedinicaMjere(String sifraArtikl) {
		return mapaArtikl.get(sifraArtikl).get(1);
	}

	public static Map<String, List<String>> getMapaArtikl() {
		return mapaArtikl;
	}
//-----------------------------metodeCJENIK------------------------------------------------------------------------
	public static Double getCijenaKn(String sifraArtikl) {
		return mapaCjenik.get(sifraArtikl) != null ? mapaCjenik.get(sifraArtikl): 0;
	}
	public static Double getCijenaValuta(String sifraArtikl) throws IOException, ParseException {
		return (mapaCjenik.get(sifraArtikl) != null ? mapaCjenik.get(sifraArtikl): 0) * EXCHANGE.omjer;
	}
	public static Map<String, Double> getMapaCjenik() {
		return mapaCjenik;
	}  
//-----------------------------metodeSTANJA------------------------------------------------------------------------
	public static Set<String> getSifraPM(String sifraArtikl) {
		return mapaStanja.get(sifraArtikl).keySet();
	}

	public static Double getKolicina(String sifraArtikl, String sifraPM) {
		return mapaStanja.get(sifraArtikl).get(sifraPM);
	}

	public static Map<String, Map<String, Double>> getMapaStanja() {
		return mapaStanja;
	}
	public static double getUkpKolicinaOdredenogArtikla(String sifraArtikl) {
		double ukp = 0;
		if (!mapaStanja.containsKey(sifraArtikl)) {
		} else {
			for (String entry: mapaStanja.get(sifraArtikl).keySet()) {
				ukp += mapaStanja.get(sifraArtikl).get(entry);
			}
		}
		return ukp;
	}
	public static double getUkupnaVrijednostArtiklaSvugdjeKn(String sifraArtikl) {
		double ukp = 0;
		if (!mapaStanja.containsKey(sifraArtikl)) {
		} else {
			for (String entry: mapaStanja.get(sifraArtikl).keySet()) {
				ukp += mapaStanja.get(sifraArtikl).get(entry);
			}
		}
		return ukp * (mapaCjenik.get(sifraArtikl) != null ? mapaCjenik.get(sifraArtikl): 0);
	}
	
	public static double getUkupnaVrijednostArtiklaSvugdjeValuta(String sifraArtikl) throws IOException, ParseException {
		double ukp = 0;
		if (!mapaStanja.containsKey(sifraArtikl)) {
		} else {
			for (String entry: mapaStanja.get(sifraArtikl).keySet()) {
				ukp += mapaStanja.get(sifraArtikl).get(entry);
			}
		}
		return ukp * (mapaCjenik.get(sifraArtikl) != null ? mapaCjenik.get(sifraArtikl): 0) * EXCHANGE.omjer;
	}
	
	public static int brPMsArtiklom(String sifraArtikl) {		
		return (mapaStanja.keySet().contains(sifraArtikl) ? mapaStanja.get(sifraArtikl).keySet().size(): 0);
	}
	public static int brArtikalaNaPM(String sifraPM) {
		int ukp = 0;
		for (String entry: mapaStanja.keySet()) {
			if (mapaStanja.get(entry).containsKey(sifraPM)) {
				ukp++;
			}
		}
		return ukp;
	}
	public static double ukpVrijedPM(String sifraPM) {
		double suma = 0.0;
		for (String entry: mapaStanja.keySet()) {
				for (String s: getSifraPM(entry)) {
					if (s.equals(sifraPM)) {
						suma += mapaStanja.get(entry).get(s);
					}
					
				}
		}
		return suma;
	}
	public static double ukpVrijedPmValuta(String sifraPM) throws IOException, ParseException {
		double suma = 0.0;
		for (String entry: mapaStanja.keySet()) {
				for (String s: getSifraPM(entry)) {
					if (s.equals(sifraPM)) {
						suma += mapaStanja.get(entry).get(s);
					}
					
				}
		}
		return suma * EXCHANGE.omjer;
	}
	
//-----------------------------metodePM------------------------------------------------------------------------
	public static String getNazivPM(String sifraPM) {
		return mapaPM.get(sifraPM);
	}
	public static Map<String, String> getMapaPM() {
		return mapaPM;
	}
//-------------------------------------------------------------------------------------------------------------

	//pomocne metode za formatiranje ispisa double-a
	public static String dFormat(Double broj) throws NullPointerException, IllegalFormatException {
		String str = String.format("%,.2f", broj);
		return str;
	}
	public static String iFormat(int broj) throws NullPointerException, IllegalFormatException {
		String str = String.format("%,d", broj);
		return str;
	}
	

}
