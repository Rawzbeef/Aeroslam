package fr.aeroslam.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import fr.aeroslam.modele.Modele;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.Vue;
import fr.aeroslam.vue.VueAjouterAvion;
import fr.aeroslam.vue.VueInfo;

public class ActionAjouterAvion implements ActionListener, KeyListener {

	private VueAjouterAvion vueAjouterAvion;
	private VueInfo vueInfo;
	private Vue vue;
	private Aeroport aero;

	public ActionAjouterAvion(Aeroport aero, Vue vue, VueAjouterAvion vueAjouterAvion, VueInfo vueInfo) {
		this.aero = aero;
		this.vue = vue;
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
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new JPanel()).revalidate();
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
				vue.getContentPane().removeAll();
				vue.getContentPane().add(new JPanel()).revalidate();
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
