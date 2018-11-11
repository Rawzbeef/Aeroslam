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

import fr.aeroslam.controleur.action.ActionRetirerPassager;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.objet.Passager;

@SuppressWarnings("serial")
public class VueRetirerPassager extends JPanel {
	
	private JPanel jpRetirerPassager;
	private JLabel jlRetirerPassager;
	private JButton jbRetirerPassager;
	
	public VueRetirerPassager(Aeroport aero, Vue vue) {
		ArrayList<Passager> lesPassagers = aero.getLesPassagers();
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		int compteurY = 1;
		int compteurX = 1;
		c.insets = new Insets(3, 3, 3, 3);
		for(Passager passager : lesPassagers) {
			this.jpRetirerPassager = new JPanel();
			this.jpRetirerPassager.setLayout(new BorderLayout());
			
			this.jlRetirerPassager = new JLabel(passager.getPrenomP() + " " + passager.getNomP(), SwingConstants.CENTER);
			
			this.jbRetirerPassager = new JButton("" + passager.getNumP());
			this.jbRetirerPassager.setBackground(Color.RED);
			this.jbRetirerPassager.setFont(new Font("Arial", Font.PLAIN, 8));
			this.jbRetirerPassager.addActionListener(new ActionRetirerPassager(aero, vue));
			
			this.jpRetirerPassager.add(jlRetirerPassager, BorderLayout.NORTH);
			this.jpRetirerPassager.add(jbRetirerPassager, BorderLayout.SOUTH);
			
			c.gridy = compteurY-1;
			c.gridx = compteurX-1;
			this.add(jpRetirerPassager, c);
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
