package fr.aeroslam.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.*;

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
		//Avions
		case "AjouterAvion":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueAjouterAvion(aero, vueInfo)).revalidate();
			break;
		case "AfficherAvion":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueAfficherAvion(aero)).revalidate();
			break;
		case "RetirerAvion":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueRetirerAvion(aero, vue)).revalidate();
			break;
		//Passager
		case "AjouterPassager":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueAjouterPassager(aero, vueInfo)).revalidate();
			break;
		case "AfficherPassager":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueAfficherPassager(aero)).revalidate();
			break;
		case "RetirerPassager":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueRetirerPassager(aero, vue)).revalidate();
			break;
		//Destination
		case "AjouterDestination":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueAjouterDestination(aero, vueInfo)).revalidate();
			break;
		case "AfficherDestination":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueAfficherDestination(aero)).revalidate();
			break;
		case "RetirerDestination":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueRetirerDestination(aero, vue)).revalidate();
			break;
		//Vol
		case "CreerVol":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueCreerVol(aero, vueInfo)).revalidate();
			break;
		case "AfficherVolCourrier":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueAfficherVolCourrier(aero)).revalidate();
			break;
		case "AfficherVolCommercial":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueAfficherVolCommercial(aero)).revalidate();
			break;
		//X
		case "X":
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueConnexion(aero, vue, vueInfo)).revalidate();
			break;
		}
	}
}
