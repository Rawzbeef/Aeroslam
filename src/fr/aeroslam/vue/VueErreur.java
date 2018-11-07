package fr.aeroslam.vue;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VueErreur extends JPanel {

	private String text;
	public static final int RED = 1;

	public VueErreur() {
		this.text = "<html>";
	}

	public void addLabel(String string) {
		this.removeAll();
		this.revalidate();
		this.text +=  string + "<br>";
		JLabel label = new JLabel(this.text + "</html>");
		this.setBackground(new Color(250, 115, 115));
		this.add(label);
	}
	
	public void removeErreur() {
		this.removeAll();
		this.text = "<html>";
		this.setBackground(new Color(250, 115, 115, 0));
		this.revalidate();
	}
	
	public void removeErreur(int color) {
		
	}
}
