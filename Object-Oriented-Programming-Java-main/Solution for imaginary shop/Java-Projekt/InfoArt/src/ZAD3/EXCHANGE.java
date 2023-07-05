package ZAD3;

import java.io.IOException;
import java.text.ParseException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EXCHANGE {
	//Služi za dohvacanje tecaja stranih valuta u realnom vremenu preko API: https://exchangeratesapi.io
	static double omjer = -1;
	static String staraValuta = null;
	static String stariDatum = null;
	
	public EXCHANGE() {
		
	}
	
	public static double tecaj(String valuta, String datum) throws IOException, ParseException {
				OkHttpClient client = new OkHttpClient().newBuilder().build();
				
				Request request = new Request.Builder()
					      .url("https://api.apilayer.com/exchangerates_data/"+datum+"?symbols="+valuta+"&base=HRK")
					      .get().addHeader("apikey", "JuXE5Pv9bWP03oSPPrw1oDOv7U3kEL5t").build();
				
				Response response = client.newCall(request).execute();
				//System.out.println(response.body().string());
	
				String str = response.body().string();
				String[] splits = str.split("\n");
				String iznosUValuti = splits[7].substring(14, 20);//na ovaj nacin sam se snasao da uzmem samo tecaj medu hrpom informacija
				//System.out.println(iznosUValuti);
				omjer = Double.parseDouble(iznosUValuti);

				return Double.parseDouble(iznosUValuti);
			
		
	}
//	public static void main(String[] args) throws IOException, ParseException {
//		System.out.println(EXCHANGE.tecaj("AUD", "2021-08-31"));
//	}

}
