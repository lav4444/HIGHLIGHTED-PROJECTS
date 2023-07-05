package ZAD3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

public class MAIN_PISANJE {

	public static void main(String[] args) throws IOException, ParseException {
		CITANJE novo = new CITANJE();
		
		//citanje datoteka
		novo.loadARTIKL();
		novo.loadCJENIK();
		novo.loadSTANJA();
		novo.loadPRODAJNA_MJESTA();
		
		EXCHANGE.tecaj(VALUTA_DATUM.getValuta(), VALUTA_DATUM.getDatum());//ovim pozivom dobijem tecaj(omjer), te metode onda pozivaju ovu varijablu, a ne svaki put clienta, 
		                                                                  //tako stedim vrijeme a i br poziva sa servera koji je ogranicen na 250/mjesecno
		//System.out.println(EXCHANGE.omjer);
		
		
		//poziv za pisanje datoteka
		//utf-8 je default char encoding za javu, pa to ne spominje eksplicitno
		
		File f1 = new File(CITANJE.getPath() + "/vrijednost zalihe - artikli.txt");
		PrintWriter pw1 = new PrintWriter(f1);
		
		for (String entry: novo.getMapaArtikl().keySet()) {
			
			pw1.println( entry + "\t" + novo.getNazivArtikl(entry) + "\t" + novo.dFormat(novo.getCijenaKn(entry)) + "\t" + novo.dFormat(novo.getUkpKolicinaOdredenogArtikla(entry))
			 + "\t" + novo.getJedinicaMjere(entry) + "\t" + novo.dFormat(novo.getUkupnaVrijednostArtiklaSvugdjeKn(entry)) + "\t" + 
			 novo.dFormat(novo.getUkupnaVrijednostArtiklaSvugdjeValuta(entry)) + "\t" + novo.iFormat(novo.brPMsArtiklom(entry)) );
			
		}
		pw1.close();	
		System.out.println("Prva datoteka napisana!");
		
			
		
		
		File f2 = new File(CITANJE.getPath() + "/vrijednost zalihe - PM.txt");
		PrintWriter pw2 = new PrintWriter(f2);
		
		for (String entry: novo.getMapaPM().keySet()) {

			pw2.println( entry + "\t" + novo.getNazivPM(entry) + "\t" + novo.dFormat(novo.ukpVrijedPM(entry)) + "\t" + novo.dFormat(novo.ukpVrijedPmValuta(entry))
			 + "\t" + novo.iFormat(novo.brArtikalaNaPM(entry)) );
			
		}
		pw2.close();
		System.out.println("Druga datoteka napisana!");
		
		
		
		
		
		
		
		
	}
}
