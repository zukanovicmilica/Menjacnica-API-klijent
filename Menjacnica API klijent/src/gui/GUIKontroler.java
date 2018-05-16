package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domen.Drzava;
import logika.Menjacnica;

public class GUIKontroler extends JFrame {

	private MenjacnicaGUI mg;
	private Menjacnica m= new Menjacnica();
	private JPanel contentPane;
	
	public Menjacnica getM() {
		return m;
	}


	public void setM(Menjacnica m) {
		this.m = m;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GUIKontroler kontroler=new GUIKontroler();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI mg = new MenjacnicaGUI(kontroler);
					mg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void dodajListu(JComboBox ponudjeno) {
		LinkedList<Drzava> drzave = new LinkedList<Drzava>();
		drzave= m.getDrzave();
		for (Drzava i : drzave)
			ponudjeno.addItem(i);
	}
}
