package fr.aeroslam.controleur.action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.aeroslam.modele.Modele;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.Vue;
import fr.aeroslam.vue.VueErreur;
import fr.aeroslam.vue.VueMenu;


public class ActionConnexion implements ActionListener {
	
	private Vue vue;
	private VueErreur vueErreur;
	
	private JTextField jtfIdentifiant;
	private JTextField jtfMdp;
	private Aeroport aero;

	

	public ActionConnexion(Aeroport aero, Vue vue, VueErreur vueErreur, JTextField jtfIdentifiant, JTextField jtfMdp) {
		this.aero = aero;
		this.vue = vue;
		this.vueErreur = vueErreur;
		this.jtfIdentifiant = jtfIdentifiant;
		this.jtfMdp = jtfMdp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vueErreur.removeErreur();
		if(Modele.connexionAdmin(jtfIdentifiant.getText(), jtfMdp.getText())) {
			vue.getContentPane().removeAll();
			vue.setJMenuBar(new VueMenu(aero, vue, vueErreur));
			vue.getContentPane().add(new JPanel()).revalidate();
		}
		else {
			vueErreur.addLabel("Identifiants incorrect");
			vue.getContentPane().revalidate();
		}
		
	}

}
