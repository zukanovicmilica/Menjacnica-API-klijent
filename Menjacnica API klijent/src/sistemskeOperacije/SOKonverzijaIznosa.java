package sistemskeOperacije;

import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import domen.Drzava;
import domen.Transakcije;

public class SOKonverzijaIznosa {

	public static Double izvrsi(String iz, String u) {
		final String serviceConvert = "/convert";
		final String CURRENCY_LAYER_API_URL = "http://free.currencyconverterapi.com/api/v5";
		String url = CURRENCY_LAYER_API_URL + serviceConvert + '?' + "q=" + iz + '_' + u;
		
		try {
			String str = URLConnectionUtil.getContent(url);
			JsonParser p = new JsonParser();
			JsonObject object = p.parse(str).getAsJsonObject();
			Gson g = new GsonBuilder().setPrettyPrinting().create();
			int count = g.fromJson(object.getAsJsonObject("query").getAsJsonPrimitive("count"), int.class);
			if (count == 0) {
				JOptionPane.showMessageDialog(null, "Nemoguce je izvrsiti transakciju!", "Greska",
						JOptionPane.ERROR_MESSAGE);
				return (double) 0;
			}
			Double kurs = g.fromJson(object.getAsJsonObject("results").getAsJsonObject(iz+"_"+u).getAsJsonPrimitive("val"),
					double.class);
			return kurs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (double) 0;
	}
}
