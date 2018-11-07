package fr.aeroslam.controleur;

import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.Vue;
import fr.aeroslam.vue.VueConnexion;
import fr.aeroslam.vue.VueErreur;

public class Controleur {

	public static void main(String[] args) {
		Aeroport aero = new Aeroport();
		Vue vue = new Vue();
		VueErreur vueErreur = new VueErreur();
		
		VueConnexion vueC = new VueConnexion(aero, vue, vueErreur);
		vue.add(vueC);
		vue.setVisible(true);
	}
}
