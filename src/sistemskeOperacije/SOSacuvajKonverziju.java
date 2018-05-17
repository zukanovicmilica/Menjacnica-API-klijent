package sistemskeOperacije;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import domen.Transakcije;

public class SOSacuvajKonverziju {

	public static void izvrsi(String iz, String u, String kurs) {
		Transakcije t = new Transakcije();
		t.setIzValute(iz);
		t.setuValutu(u);
		t.setKurs(kurs);
	
		Date vreme= new Date();
		SimpleDateFormat prikaz = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss.SSSSSS");
		String date = prikaz.format(vreme);

		t.setDatumVreme(date);
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

		JsonArray prethodneKonverzije=null;

		String str = gson.toJson(t);
		JsonObject object = gson.fromJson(str, JsonObject.class);

		try (FileReader reader = new FileReader("data/log.json")) {
			prethodneKonverzije = gson.fromJson(reader, JsonArray.class);			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try (FileWriter writer = new FileWriter("data/log.json")) {
			if(prethodneKonverzije==null)
				prethodneKonverzije=new JsonArray();
			prethodneKonverzije.add(object);
			writer.write(gson.toJson(prethodneKonverzije));			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
