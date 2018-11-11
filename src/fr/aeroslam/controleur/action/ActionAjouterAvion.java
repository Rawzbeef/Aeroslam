package fr.aeroslam.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.aeroslam.modele.Modele;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.VueAjouterAvion;
import fr.aeroslam.vue.VueInfo;

public class ActionAjouterAvion implements ActionListener, KeyListener {

	private VueAjouterAvion vueAjouterAvion;
	private VueInfo vueInfo;
	private Aeroport aero;

	public ActionAjouterAvion(Aeroport aero, VueAjouterAvion vueAjouterAvion, VueInfo vueInfo) {
		this.aero = aero;
		this.vueAjouterAvion = vueAjouterAvion;
		this.vueInfo = vueInfo;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		vueInfo.reset();
		String nomA = vueAjouterAvion.getNomA();
		int nbPlace = vueAjouterAvion.getNbPlace();
		if(nbPlace > 0) {
			aero.ajouterAvion(Modele.ajouterAvion(nomA, nbPlace), nomA, nbPlace);
			vueInfo.addLabelValider("Ajout de l'avion " + nomA + "effectué");
		}
		else {
			vueInfo.addLabelErreur("Nombre de place incorrect");
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			vueInfo.reset();
			String nomA = vueAjouterAvion.getNomA();
			int nbPlace = vueAjouterAvion.getNbPlace();
			if(nbPlace > 0) {
				aero.ajouterAvion(Modele.ajouterAvion(nomA, nbPlace), nomA, nbPlace);
				vueInfo.addLabelValider("Ajout de l'avion " + nomA + "effectué");
			}
			else {
				vueInfo.addLabelErreur("Nombre de place incorrect");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
