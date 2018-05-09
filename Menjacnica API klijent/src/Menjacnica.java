import java.awt.BorderLayout;
import java.awt.EventQueue;
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

import klaseJSON.Drzava;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Menjacnica extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public LinkedList<Drzava> drzave= new LinkedList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menjacnica frame = new Menjacnica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Menjacnica() {
		setResizable(false);
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		try {
			String url = URLConnectionUtil.getContent("http://free.currencyconverterapi.com/api/v3/countries");
			JsonParser p = new JsonParser();
			Gson g = new GsonBuilder().create();
			JsonObject drzaveJSON = p.parse(url).getAsJsonObject().getAsJsonObject("results");
			for (Map.Entry<String, JsonElement> entry : drzaveJSON.entrySet()) {
				Drzava d = g.fromJson(entry.getValue(), Drzava.class);
				drzave.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		JLabel lblIzValuteZemlje = new JLabel("Iz valute zemlje:");
		lblIzValuteZemlje.setBounds(40, 40, 107, 24);
		contentPane.add(lblIzValuteZemlje);
		
		JLabel lblUValutuZemlje = new JLabel("U valutu zemlje:");
		lblUValutuZemlje.setBounds(263, 40, 101, 24);
		contentPane.add(lblUValutuZemlje);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(40, 75, 131, 20);
		contentPane.add(comboBox);
		dodajListu(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(263, 75, 131, 20);
		contentPane.add(comboBox_1);
		dodajListu(comboBox_1);
		
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
		btnKonvertuj.setBounds(163, 220, 107, 23);
		contentPane.add(btnKonvertuj);
		
	}
	
	private void dodajListu(JComboBox ponudjeno) {
		for(Drzava i:drzave)
			ponudjeno.addItem(i);
	}
	
}
