package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import domen.Drzava;
import domen.Transakcije;
import sistemskeOperacije.SOKonverzijaIznosa;
import sistemskeOperacije.SOPreuzimanjeDrzava;
import sistemskeOperacije.SOSacuvajKonverziju;
import sistemskeOperacije.URLConnectionUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */

	public MenjacnicaGUI(GUIKontroler kontroler) {
		setResizable(false);
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		JLabel lblIzValuteZemlje = new JLabel("Iz valute zemlje:");
		lblIzValuteZemlje.setBounds(40, 40, 107, 24);
		contentPane.add(lblIzValuteZemlje);

		JLabel lblUValutuZemlje = new JLabel("U valutu zemlje:");
		lblUValutuZemlje.setBounds(263, 40, 101, 24);
		contentPane.add(lblUValutuZemlje);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(40, 75, 131, 20);
		contentPane.add(comboBox);
		kontroler.dodajListu(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(263, 75, 131, 20);
		contentPane.add(comboBox_1);
		kontroler.dodajListu(comboBox_1);

		JLabel lblIznos = new JLabel("Iznos:");
		lblIznos.setBounds(40, 143, 46, 14);
		contentPane.add(lblIznos);

		JLabel lblIznos_1 = new JLabel("Iznos:");
		lblIznos_1.setBounds(263, 143, 46, 14);
		contentPane.add(lblIznos_1);

		textField = new JTextField();
		textField.setBounds(40, 168, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(263, 168, 131, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnKonvertuj = new JButton("Konvertuj");
		btnKonvertuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Drzava dr = (Drzava) comboBox.getSelectedItem();
				String iz = dr.getCurrencyId();
				dr = (Drzava) comboBox_1.getSelectedItem();
				String u = dr.getCurrencyId();
				String iznos = textField.getText();
				textField_1.setText(kontroler.getM().konvertuj(iz, u, iznos));
				kontroler.getM().sacuvaj(iz, u);
			}
		});
		btnKonvertuj.setBounds(163, 220, 107, 23);
		contentPane.add(btnKonvertuj);

	}

}
