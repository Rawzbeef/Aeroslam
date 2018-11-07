package fr.aeroslam.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import fr.aeroslam.modele.Modele;
import fr.aeroslam.vue.Vue;
import fr.aeroslam.vue.VueAjouterAvion;
import fr.aeroslam.vue.VueErreur;

public class ActionAjouterAvion implements ActionListener {

	private VueAjouterAvion vueAjouterAvion;
	private VueErreur vueErreur;
	private Vue vue;

	public ActionAjouterAvion(Vue vue, VueAjouterAvion vueAjouterAvion, VueErreur vueErreur) {
		this.vue = vue;
		this.vueAjouterAvion = vueAjouterAvion;
		this.vueErreur = vueErreur;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		vueErreur.removeErreur();
		String nomA = vueAjouterAvion.getNomA();
		int nbPlace = vueAjouterAvion.getNbPlace();
		if(nbPlace > 0) {
			Modele.ajouterAvion(nomA, nbPlace);
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new JPanel()).revalidate();
		}
		else {
			vueErreur.addLabel("Nombre de place incorrect");
		}
	}
}
