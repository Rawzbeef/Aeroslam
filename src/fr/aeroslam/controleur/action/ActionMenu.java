package fr.aeroslam.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.Vue;
import fr.aeroslam.vue.VueAfficherAvion;
import fr.aeroslam.vue.VueAjouterAvion;
import fr.aeroslam.vue.VueInfo;
import fr.aeroslam.vue.VueRetirerAvion;

public class ActionMenu implements ActionListener {

	private Vue vue;
	private String nomBouton;
	private VueInfo vueInfo;
	private Aeroport aero;

	public ActionMenu(Aeroport aero, Vue vue, VueInfo vueInfo, String nomBouton) {
		this.aero = aero;
		this.vue = vue;
		this.vueInfo = vueInfo;
		this.nomBouton = nomBouton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(nomBouton) {
		case "AjouterAvion":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueAjouterAvion(aero, vueInfo, vue)).revalidate();
			break;
		case "AfficherAvion":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueAfficherAvion(aero)).revalidate();
			break;
		case "RetirerAvion":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueRetirerAvion(aero, vue)).revalidate();
			break;
		}
	}
}
