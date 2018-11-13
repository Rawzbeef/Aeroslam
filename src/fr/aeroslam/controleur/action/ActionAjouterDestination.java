package fr.aeroslam.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.aeroslam.modele.Modele;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.VueAjouterDestination;
import fr.aeroslam.vue.VueInfo;

public class ActionAjouterDestination implements ActionListener, KeyListener {

	private VueAjouterDestination vueAjouterDestination;
	private VueInfo vueInfo;
	private Aeroport aero;

	public ActionAjouterDestination(Aeroport aero, VueAjouterDestination vueAjouterDestination, VueInfo vueInfo) {
		this.aero = aero;
		this.vueAjouterDestination = vueAjouterDestination;
		this.vueInfo = vueInfo;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		vueInfo.reset();
		String villeD = vueAjouterDestination.getVilleD();
		String paysD = vueAjouterDestination.getPaysD();
		if(!villeD.equals("") && !paysD.equals("")) {
			aero.ajouterDestination(Modele.ajouterDestination(villeD, paysD), villeD, paysD);
			vueInfo.addLabelValider("Ajout de la destination " + villeD + " effectué");
		}
		else {
			vueInfo.addLabelErreur("Un champ est vide !");
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			vueInfo.reset();
			String villeD = vueAjouterDestination.getVilleD();
			String paysD = vueAjouterDestination.getPaysD();
			if(!villeD.equals("") && !paysD.equals("")) {
				aero.ajouterDestination(Modele.ajouterDestination(villeD, paysD), villeD, paysD);
				vueInfo.addLabelValider("Ajout de la destination " + villeD + " effectué");
			}
			else {
				vueInfo.addLabelErreur("Un champ est vide");
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
