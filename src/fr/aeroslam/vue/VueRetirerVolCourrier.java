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

import fr.aeroslam.controleur.action.ActionRetirerVolCourrier;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.objet.VolCourrier;

@SuppressWarnings("serial")
public class VueRetirerVolCourrier extends JPanel {
	
	private JPanel jpRetirerVolCourrier;
	private JLabel jlRetirerVolCourrier;
	private JButton jbRetirerVolCourrier;
	
	public VueRetirerVolCourrier(Aeroport aero, Vue vue, VueInfo vueInfo) {
		ArrayList<VolCourrier> lesVolsCourrier = aero.getLesVolsCourrier();
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		int compteurY = 1;
		int compteurX = 1;
		c.insets = new Insets(3, 3, 3, 3);
		for(VolCourrier vol : lesVolsCourrier) {
			this.jpRetirerVolCourrier = new JPanel();
			this.jpRetirerVolCourrier.setLayout(new BorderLayout());
			
			this.jlRetirerVolCourrier = new JLabel(vol.getDateVol() + " " + vol.getDestination().getVilleD() + " - " + vol.getDestination().getPaysD(), SwingConstants.CENTER);
			
			this.jbRetirerVolCourrier = new JButton("" + vol.getNumVol());
			this.jbRetirerVolCourrier.setBackground(Color.RED);
			this.jbRetirerVolCourrier.setFont(new Font("Arial", Font.PLAIN, 8));
			this.jbRetirerVolCourrier.addActionListener(new ActionRetirerVolCourrier(aero, vue, vueInfo));
			
			this.jpRetirerVolCourrier.add(jlRetirerVolCourrier, BorderLayout.NORTH);
			this.jpRetirerVolCourrier.add(jbRetirerVolCourrier, BorderLayout.SOUTH);
			
			c.gridy = compteurY-1;
			c.gridx = compteurX-1;
			this.add(jpRetirerVolCourrier, c);
			if(compteurX >= 5) {
				compteurX = 1;
				compteurY++;
			}
			else {
				compteurX++;
			}
		}
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 5;
		this.add(vueInfo);
	}
}
