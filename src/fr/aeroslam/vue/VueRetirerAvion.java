package fr.aeroslam.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.aeroslam.controleur.action.ActionRetirerAvion;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.objet.Avion;

@SuppressWarnings("serial")
public class VueRetirerAvion extends JPanel {
	
	private JPanel jpRetirerAvion;
	private JLabel jlRetirerAvion;
	private JButton jbRetirerAvion;
	
	public VueRetirerAvion(Aeroport aero, Vue vue) {
		ArrayList<Avion> lesAvions = aero.getLesAvions();
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		int compteurY = 1;
		int compteurX = 1;
		c.insets = new Insets(3, 3, 3, 3);
		for(Avion avion : lesAvions) {
			this.jpRetirerAvion = new JPanel();
			this.jpRetirerAvion.setLayout(new BorderLayout());
			
			this.jlRetirerAvion = new JLabel(avion.getNomAvion(), SwingConstants.CENTER);
			
			this.jbRetirerAvion = new JButton("" + avion.getCodeAvion());
			this.jbRetirerAvion.setBackground(Color.RED);
			this.jbRetirerAvion.setFont(new Font("Arial", Font.PLAIN, 0));
			this.jbRetirerAvion.addActionListener(new ActionRetirerAvion(aero, vue));
			
			this.jpRetirerAvion.add(jlRetirerAvion, BorderLayout.NORTH);
			this.jpRetirerAvion.add(jbRetirerAvion, BorderLayout.SOUTH);
			
			c.gridy = compteurY-1;
			c.gridx = compteurX-1;
			this.add(jpRetirerAvion, c);
			if(compteurX >= 5) {
				compteurX = 1;
				compteurY++;
			}
			else {
				compteurX++;
			}
		}
	}
}
