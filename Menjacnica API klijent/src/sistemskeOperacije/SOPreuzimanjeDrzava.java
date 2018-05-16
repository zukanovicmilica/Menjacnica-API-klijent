package sistemskeOperacije;

import java.util.LinkedList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import domen.Drzava;

public class SOPreuzimanjeDrzava {

	public static LinkedList<Drzava> izvrsi() {
		final String serviceCountries = "/countries";
		final String CURRENCY_LAYER_API_URL = "http://free.currencyconverterapi.com/api/v5";
		String url = CURRENCY_LAYER_API_URL + serviceCountries;
		
		try {
			String s=URLConnectionUtil.getContent(url);
			JsonParser p = new JsonParser();
			Gson g = new GsonBuilder().create();
			JsonObject drzaveJSON = p.parse(s).getAsJsonObject().getAsJsonObject("results");
			LinkedList<Drzava> drzave= new LinkedList<>();
			for (Map.Entry<String, JsonElement> entry : drzaveJSON.entrySet()) {
				Drzava d = g.fromJson(entry.getValue(), Drzava.class);
				drzave.add(d);
			}
			return drzave;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
