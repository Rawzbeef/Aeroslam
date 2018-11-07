package fr.aeroslam.vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.aeroslam.controleur.action.ActionRetirerAvion;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.objet.Avion;

@SuppressWarnings("serial")
public class VueRetirerAvion extends JPanel {
	
	private JPanel jpRetirerAvion;
	private JButton jbRetirerAvion;
	
	public VueRetirerAvion(Aeroport aero) {
		ArrayList<Avion> lesAvions = aero.getLesAvions();
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		int compteurY = 1;
		int compteurX = 1;
		c.insets = new Insets(3, 3, 3, 3);
		for(Avion avion : lesAvions) {
			this.jbRetirerAvion = new JButton("" + avion.getCodeAvion());
			this.jbRetirerAvion.addActionListener(new ActionRetirerAvion());
			this.jbRetirerAvion.setPreferredSize(new Dimension(50, 25));
			c.gridy = compteurY-1;
			c.gridx = compteurX-1;
			this.add(jbRetirerAvion, c);
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
