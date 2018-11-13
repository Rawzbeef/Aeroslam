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

import fr.aeroslam.controleur.action.ActionRetirerDestination;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.objet.Destination;

@SuppressWarnings("serial")
public class VueRetirerDestination extends JPanel {
	
	private JPanel jpRetirerDestination;
	private JLabel jlRetirerDestination;
	private JButton jbRetirerDestination;
	
	public VueRetirerDestination(Aeroport aero, Vue vue) {
		ArrayList<Destination> lesDestinations = aero.getLesDestinations();
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		int compteurY = 1;
		int compteurX = 1;
		c.insets = new Insets(3, 3, 3, 3);
		for(Destination destination : lesDestinations) {
			this.jpRetirerDestination = new JPanel();
			this.jpRetirerDestination.setLayout(new BorderLayout());
			
			this.jlRetirerDestination = new JLabel(destination.getVilleD() + " - " + destination.getPaysD(), SwingConstants.CENTER);
			
			this.jbRetirerDestination = new JButton("" + destination.getCodeD());
			this.jbRetirerDestination.setBackground(Color.RED);
			this.jbRetirerDestination.setFont(new Font("Arial", Font.PLAIN, 8));
			this.jbRetirerDestination.addActionListener(new ActionRetirerDestination(aero, vue));
			
			this.jpRetirerDestination.add(jlRetirerDestination, BorderLayout.NORTH);
			this.jpRetirerDestination.add(jbRetirerDestination, BorderLayout.SOUTH);
			
			c.gridy = compteurY-1;
			c.gridx = compteurX-1;
			this.add(jpRetirerDestination, c);
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
