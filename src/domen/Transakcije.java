package domen;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Transakcije {

	private String datumVreme;
	private String izValute;
	private String uValutu;
	private String kurs;

	public String getDatumVreme() {
		return datumVreme;
	}

	public void setDatumVreme(String datumVreme) {
		this.datumVreme = datumVreme;
	}

	public String getIzValute() {
		return izValute;
	}

	public void setIzValute(String izValute) {
		this.izValute = izValute;
	}

	public String getuValutu() {
		return uValutu;
	}

	public void setuValutu(String uValutu) {
		this.uValutu = uValutu;
	}

	public String getKurs() {
		return kurs;
	}

	public void setKurs(String kurs) {
		this.kurs = kurs;
	}

}
