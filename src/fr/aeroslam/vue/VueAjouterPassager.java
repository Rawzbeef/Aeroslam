package fr.aeroslam.vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.aeroslam.controleur.action.ActionAjouterPassager;
import fr.aeroslam.objet.Aeroport;

@SuppressWarnings("serial")
public class VueAjouterPassager extends JPanel {
	
	private JLabel jlNom;
	private JTextField jtfNom;
	private JLabel jlPrenom;
	private JTextField jtfPrenom;
	private JLabel jlRue;
	private JTextField jtfRue;
	private JLabel jlNumRue;
	private JTextField jtfNumRue;
	private JLabel jlCp;
	private JTextField jtfCp;
	private JLabel jlVille;
	private JTextField jtfVille;
	private JButton jbAjouter;

	public VueAjouterPassager(Aeroport aero, VueInfo vueInfo) {
		this.jlNom = new JLabel("Nom :");
		this.jtfNom = new JTextField();
		this.jtfNom.setPreferredSize(new Dimension(150, 20));
		
		this.jlPrenom = new JLabel("Prénom :");
		this.jtfPrenom = new JTextField();
		this.jtfPrenom.setPreferredSize(new Dimension(150, 20));
		
		this.jlRue = new JLabel("Nom de rue :");
		this.jtfRue = new JTextField();
		this.jtfRue.setPreferredSize(new Dimension(150, 20));
		
		this.jlNumRue = new JLabel("Numéro de rue :");
		this.jtfNumRue = new JTextField();
		this.jtfNumRue.setPreferredSize(new Dimension(150, 20));
		
		this.jlCp = new JLabel("Code postal :");
		this.jtfCp = new JTextField();
		this.jtfCp.setPreferredSize(new Dimension(150, 20));
		
		this.jlVille = new JLabel("Ville :");
		this.jtfVille = new JTextField();
		this.jtfVille.setPreferredSize(new Dimension(150, 20));
		
		this.jbAjouter = new JButton("Ajouter");
		
		ActionAjouterPassager actionAjouterPassager = new ActionAjouterPassager(aero, this, vueInfo);
		this.jbAjouter.addActionListener(actionAjouterPassager);
		this.jtfNom.addKeyListener(actionAjouterPassager);
		this.jtfPrenom.addKeyListener(actionAjouterPassager);
		this.jtfRue.addKeyListener(actionAjouterPassager);
		this.jtfNumRue.addKeyListener(actionAjouterPassager);
		this.jtfCp.addKeyListener(actionAjouterPassager);
		this.jtfVille.addKeyListener(actionAjouterPassager);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.LINE_START;
		
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
		this.add(jlPrenom, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfPrenom, c);
		c.gridx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jlRue, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfRue, c);
		c.gridx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jlNumRue, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfNumRue, c);
		c.gridx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jlCp, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfCp, c);
		c.gridx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jlVille, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfVille, c);
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 2;
		this.add(vueInfo, c);
		c.gridy++;
		this.add(jbAjouter, c);
	}
	
	public String getNomP() {
		return this.jtfNom.getText();
	}
	
	public String getPrenomP() {
		return this.jtfPrenom.getText();
	}
	
	public String getRueP() {
		return this.jtfRue.getText();
	}
	
	public String getNumRueP() {
		return this.jtfNumRue.getText();
	}
	
	public int getCpP() {
		int cp = 0;
		try {
			cp = Integer.parseInt(this.jtfCp.getText());
		} catch (NumberFormatException e) {
			cp = -1;
		}
		return cp;
	}
	
	public String getVilleP() {
		return this.jtfVille.getText();
	}
}
