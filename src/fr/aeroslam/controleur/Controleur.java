package fr.aeroslam.controleur;

import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.Vue;
import fr.aeroslam.vue.VueConnexion;
import fr.aeroslam.vue.VueInfo;

public class Controleur {

	public static void main(String[] args) {
		Aeroport aero = new Aeroport();
		Vue vue = new Vue();
		VueInfo vueInfo = new VueInfo();

		VueConnexion vueC = new VueConnexion(aero, vue, vueInfo);
		vue.add(vueC);
		vue.setVisible(true);
	}
}
