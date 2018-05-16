package sistemskeOperacije;

import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import domen.Transakcije;

public class SOSacuvajKonverziju {

	public static void izvrsi(String iz, String u) {
		final String serviceConvert = "/convert";
		final String CURRENCY_LAYER_API_URL = "http://free.currencyconverterapi.com/api/v5";
		String url = CURRENCY_LAYER_API_URL + serviceConvert + '?' + "q=" + iz + '_' + u;

		String str;
		try {
			str = URLConnectionUtil.getContent(url);
			JsonParser p = new JsonParser();
			JsonObject object = p.parse(str).getAsJsonObject();
			Gson g = new GsonBuilder().setPrettyPrinting().create();
			int count = g.fromJson(object.getAsJsonObject("query").getAsJsonPrimitive("count"), int.class);
			Transakcije t = new Transakcije();
			t.setDatumVreme(new GregorianCalendar());
			t.setIzValute(iz);
			t.setuValutu(u);

			Double kurs = g.fromJson(
					object.getAsJsonObject("results").getAsJsonObject(iz + "_" + u).getAsJsonPrimitive("val"),
					double.class);
			if (count == 0)
				t.setKurs(null);
			else
				t.setKurs(kurs.toString());
			try (FileWriter writer = new FileWriter("data/log.json");) {
				writer.write(g.toJson(t));
				writer.close();
			} catch (Exception e) {
				System.out.println("Greska: " + e.getMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
