package logika;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import domen.Drzava;
import sistemskeOperacije.SOKonverzijaIznosa;
import sistemskeOperacije.SOPreuzimanjeDrzava;
import sistemskeOperacije.SOSacuvajKonverziju;
import sistemskeOperacije.URLConnectionUtil;

public class Menjacnica {
	LinkedList<Drzava> drzave= new LinkedList<Drzava>();
	
	public LinkedList<Drzava> getDrzave() {
		return drzave;
	}

	public Menjacnica() {
		drzave= SOPreuzimanjeDrzava.izvrsi();
	}

	public String konvertuj(String iz, String u, String iznos) {
		Double kurs= new Double(SOKonverzijaIznosa.izvrsi(iz, u));
		Double d = new Double(kurs * Double.parseDouble(iznos));
		SOSacuvajKonverziju.izvrsi(iz, u, kurs.toString());
		return d.toString();
	}

}
