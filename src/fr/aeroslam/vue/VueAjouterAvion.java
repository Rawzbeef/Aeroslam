package fr.aeroslam.vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.aeroslam.controleur.action.ActionAjouterAvion;
import fr.aeroslam.objet.Aeroport;

@SuppressWarnings("serial")
public class VueAjouterAvion extends JPanel {

	private JLabel jlNom;
	private JTextField jtfNom;
	
	private JLabel jlNbPlace;
	private JTextField jtfNbPlace;
	
	private JButton jbAjouter;

	public VueAjouterAvion(Aeroport aero, VueInfo vueInfo) {
		this.jlNom = new JLabel("Nom :");
		this.jtfNom = new JTextField();
		this.jtfNom.setPreferredSize(new Dimension(150, 20));
		
		this.jlNbPlace = new JLabel("Nombre de places :");
		this.jtfNbPlace = new JTextField();
		this.jtfNbPlace.setPreferredSize(new Dimension(150, 20));
		
		this.jbAjouter = new JButton("Ajouter");
		
		ActionAjouterAvion actionAjouterAvion = new ActionAjouterAvion(aero, this, vueInfo);
		this.jbAjouter.addActionListener(actionAjouterAvion);
		this.jtfNom.addKeyListener(actionAjouterAvion);
		this.jtfNbPlace.addKeyListener(actionAjouterAvion);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(3, 3, 3, 3);
		this.add(jlNom, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfNom, c);
		c.gridx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jlNbPlace, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfNbPlace, c);
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 2;
		this.add(vueInfo, c);
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jbAjouter, c);
	}

	public String getNomA() {
		return this.jtfNom.getText();
	}

	public int getNbPlace() {
		int nbPlace = 0;
		try {
			nbPlace = Integer.parseInt(this.jtfNbPlace.getText());
		} catch (NumberFormatException e) {
			nbPlace = -1;
		}
		return nbPlace;
	}
	
	

}
