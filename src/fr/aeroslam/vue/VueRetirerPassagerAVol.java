package fr.aeroslam.vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.aeroslam.controleur.action.ActionAjoutPassagerAVol;
import fr.aeroslam.controleur.action.ActionAjouterAvion;
import fr.aeroslam.controleur.action.ActionRetirerPassagerAVol;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.objet.Passager;
import fr.aeroslam.objet.VolCourrier;

@SuppressWarnings("serial")
public class VueRetirerPassagerAVol extends JPanel {
	
	private JLabel jlNumP;
	private JTextField jtfNumP;
	
	private JLabel jlNumV;
	private JTextField jtfNumV;
	
	private JButton jbAjouter;

	public VueRetirerPassagerAVol(Aeroport aero, VueInfo vueInfo) {
		vueInfo.reset();
		this.jlNumP = new JLabel("Id du passager :");
		this.jtfNumP = new JTextField();
		this.jtfNumP.setPreferredSize(new Dimension(150, 20));
		
		this.jlNumV = new JLabel("Id du vol :");
		this.jtfNumV = new JTextField();
		this.jtfNumV.setPreferredSize(new Dimension(150, 20));
		
		this.jbAjouter = new JButton("Ajouter");
		
		ActionRetirerPassagerAVol actionRetirerPassagerAVol = new ActionRetirerPassagerAVol(aero, this, vueInfo);
		this.jbAjouter.addActionListener(actionRetirerPassagerAVol);
		this.jtfNumP.addKeyListener(actionRetirerPassagerAVol);
		this.jtfNumV.addKeyListener(actionRetirerPassagerAVol);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(3, 3, 3, 3);
		this.add(jlNumP, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfNumP, c);
		c.gridx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jlNumV, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfNumV, c);
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 2;
		this.add(vueInfo, c);
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jbAjouter, c);
	}

	public int getNumP() {
		int numP = 0;
		try {
			numP = Integer.parseInt(this.jtfNumP.getText());
		} catch (NumberFormatException e) {
			numP = -1;
		}
		return numP;
	}
	
	public int getNumV() {
		int numV = 0;
		try {
			numV = Integer.parseInt(this.jtfNumV.getText());
		} catch (NumberFormatException e) {
			numV = -1;
		}
		return numV;
	}
	
}
