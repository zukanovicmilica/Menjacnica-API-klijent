package logika;

import java.util.LinkedList;

import domen.Drzava;
import sistemskeOperacije.SOKonverzijaIznosa;
import sistemskeOperacije.SOPreuzimanjeDrzava;
import sistemskeOperacije.SOSacuvajKonverziju;

public class Menjacnica {
	LinkedList<Drzava> drzave= new LinkedList<Drzava>();
	
	public LinkedList<Drzava> getDrzave() {
		return drzave;
	}

	public Menjacnica() {
		drzave= SOPreuzimanjeDrzava.izvrsi();
	}

	public void sacuvaj(String iz, String u) {
		SOSacuvajKonverziju.izvrsi(iz, u);
	}

	public String konvertuj(String iz, String u, String iznos) {
		return SOKonverzijaIznosa.izvrsi(iz, u, iznos);

	}

}
