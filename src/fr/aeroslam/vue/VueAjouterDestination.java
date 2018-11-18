package fr.aeroslam.vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.aeroslam.controleur.action.ActionAjouterDestination;
import fr.aeroslam.objet.Aeroport;

@SuppressWarnings("serial")
public class VueAjouterDestination extends JPanel {

	private JLabel jlVille;
	private JTextField jtfVille;
	
	private JLabel jlPays;
	private JTextField jtfPays;
	private JButton jbAjouter;

	public VueAjouterDestination(Aeroport aero, VueInfo vueInfo) {
		vueInfo.reset();
		this.jlVille = new JLabel("Ville :");
		this.jtfVille = new JTextField();
		this.jtfVille.setPreferredSize(new Dimension(150, 20));
		
		this.jlPays = new JLabel("Pays :");
		this.jtfPays = new JTextField();
		this.jtfPays.setPreferredSize(new Dimension(150, 20));
		
		this.jbAjouter = new JButton("Ajouter");
		
		ActionAjouterDestination actionAjouterDestination = new ActionAjouterDestination(aero, this, vueInfo);
		this.jbAjouter.addActionListener(actionAjouterDestination);
		this.jtfVille.addKeyListener(actionAjouterDestination);
		this.jtfPays.addKeyListener(actionAjouterDestination);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(3, 3, 3, 3);
		this.add(jlVille, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfVille, c);
		c.gridx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jlPays, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfPays, c);
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 2;
		this.add(vueInfo, c);
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jbAjouter, c);
	}

	public String getVilleD() {
		return this.jtfVille.getText();
	}

	public String getPaysD() {
		return this.jtfPays.getText();
	}
	
	

}
