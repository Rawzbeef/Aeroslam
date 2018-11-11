package fr.aeroslam.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.aeroslam.modele.Modele;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.VueAjouterPassager;
import fr.aeroslam.vue.VueInfo;

public class ActionAjouterPassager implements ActionListener, KeyListener {

	private Aeroport aero;
	private VueAjouterPassager vueAjouterPassager;
	private VueInfo vueInfo;

	public ActionAjouterPassager(Aeroport aero, VueAjouterPassager vueAjouterPassager, VueInfo vueInfo) {
		this.aero = aero;
		this.vueAjouterPassager = vueAjouterPassager;
		this.vueInfo = vueInfo;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		vueInfo.reset();
		String nom = vueAjouterPassager.getNomP();
		String prenom = vueAjouterPassager.getPrenomP();
		String rue = vueAjouterPassager.getRueP();
		String numRue = vueAjouterPassager.getNumRueP();
		int cp = vueAjouterPassager.getCpP();
		String ville = vueAjouterPassager.getVilleP();
		if(cp > 0) {
			aero.ajouterPassager(Modele.ajouterPassager(nom, prenom, rue, numRue, cp, ville), nom, prenom, rue, numRue, cp, ville);
			vueInfo.addLabelValider("Ajout du passager "+ prenom + " " + nom +" effectué");
		}
		else {
			vueInfo.addLabelErreur("Code postal incorrect");
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			vueInfo.reset();
			String nom = vueAjouterPassager.getNomP();
			String prenom = vueAjouterPassager.getPrenomP();
			String rue = vueAjouterPassager.getRueP();
			String numRue = vueAjouterPassager.getNumRueP();
			int cp = vueAjouterPassager.getCpP();
			String ville = vueAjouterPassager.getVilleP();
			if(cp > 0) {
				aero.ajouterPassager(Modele.ajouterPassager(nom, prenom, rue, numRue, cp, ville), nom, prenom, rue, numRue, cp, ville);
				vueInfo.addLabelValider("Ajout du passager "+ prenom + " " + nom +" effectué");
			}
			else {
				vueInfo.addLabelErreur("Code postal incorrect");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub

	}
}
