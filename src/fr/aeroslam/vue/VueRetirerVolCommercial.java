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

import fr.aeroslam.controleur.action.ActionRetirerVolCommercial;
import fr.aeroslam.controleur.action.ActionRetirerVolCourrier;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.objet.VolCommercial;
import fr.aeroslam.objet.VolCourrier;

@SuppressWarnings("serial")
public class VueRetirerVolCommercial extends JPanel {
	
	private JPanel jpRetirerVolCommercial;
	private JLabel jlRetirerVolCommercial;
	private JButton jbRetirerVolCommercial;
	
	public VueRetirerVolCommercial(Aeroport aero, Vue vue) {
		ArrayList<VolCommercial> lesVolsCommercial = aero.getLesVolsCommercial();
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		int compteurY = 1;
		int compteurX = 1;
		c.insets = new Insets(3, 3, 3, 3);
		for(VolCommercial vol : lesVolsCommercial) {
			this.jpRetirerVolCommercial = new JPanel();
			this.jpRetirerVolCommercial.setLayout(new BorderLayout());
			
			this.jlRetirerVolCommercial = new JLabel(vol.getDateVol() + " " + vol.getDestination().getVilleD() + " - " + vol.getDestination().getPaysD(), SwingConstants.CENTER);
			
			this.jbRetirerVolCommercial = new JButton("" + vol.getNumVol());
			this.jbRetirerVolCommercial.setBackground(Color.RED);
			this.jbRetirerVolCommercial.setFont(new Font("Arial", Font.PLAIN, 8));
			this.jbRetirerVolCommercial.addActionListener(new ActionRetirerVolCommercial(aero, vue));
			
			this.jpRetirerVolCommercial.add(jlRetirerVolCommercial, BorderLayout.NORTH);
			this.jpRetirerVolCommercial.add(jbRetirerVolCommercial, BorderLayout.SOUTH);
			
			c.gridy = compteurY-1;
			c.gridx = compteurX-1;
			this.add(jpRetirerVolCommercial, c);
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
