package fr.aeroslam.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.aeroslam.modele.Modele;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.VueInfo;
import fr.aeroslam.vue.VueRetirerPassagerAVol;

public class ActionRetirerPassagerAVol implements ActionListener, KeyListener {

	private VueRetirerPassagerAVol vueRetirerPassagerAVol;
	private VueInfo vueInfo;
	private Aeroport aero;

	public ActionRetirerPassagerAVol(Aeroport aero, VueRetirerPassagerAVol vueRetirerPassagerAVol, VueInfo vueInfo) {
		this.aero = aero;
		this.vueRetirerPassagerAVol = vueRetirerPassagerAVol;
		this.vueInfo = vueInfo;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		vueInfo.reset();
		int numP = vueRetirerPassagerAVol.getNumP();
		int numV = vueRetirerPassagerAVol.getNumV();
		if(numP > 0 && numV > 0) {
			Modele.retirerEnregistrer(numP, numV);
			aero.getPassagerById(numP).retirerUnVol(aero.getVolCourrierById(numV));
			vueInfo.addLabelValider("Le passager à bien été retiré");
		}
		else {
			vueInfo.addLabelErreur("Un des champs est incorrect");
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			vueInfo.reset();
			int numP = vueRetirerPassagerAVol.getNumP();
			int numV = vueRetirerPassagerAVol.getNumV();
			if(numP > 0 && numV > 0) {
				Modele.retirerEnregistrer(numP, numV);
				aero.getPassagerById(numP).retirerUnVol(aero.getVolCourrierById(numV));
				vueInfo.addLabelValider("Le passager à bien été retiré");
			}
			else {
				vueInfo.addLabelErreur("Un des champs est incorrect");
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
