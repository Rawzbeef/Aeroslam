package fr.aeroslam.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.objet.Passager;
import fr.aeroslam.objet.VolCourrier;
import fr.aeroslam.vue.VueAjouterPassagerAVol;
import fr.aeroslam.vue.VueInfo;

public class ActionAjoutPassagerAVol implements ActionListener, KeyListener {

	private VueAjouterPassagerAVol vueAjouterPassagerAVol;
	private VueInfo vueInfo;
	private Aeroport aero;

	public ActionAjoutPassagerAVol(Aeroport aero, VueAjouterPassagerAVol vueAjouterPassagerAVol, VueInfo vueInfo) {
		this.aero = aero;
		this.vueAjouterPassagerAVol = vueAjouterPassagerAVol;
		this.vueInfo = vueInfo;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		vueInfo.reset();
		Passager passager = aero.getPassager(vueAjouterPassagerAVol.getPassagerIndex());
		VolCourrier vol = aero.getVolCourrier(vueAjouterPassagerAVol.getVolCourrierIndex());
		if(vol.getNbPlaceRestante() > 0) {
			System.out.println(passager.addUnVol(vol));
			vueInfo.addLabelValider("Ajout du passager " + passager.getPrenomP() + " " + passager.getNomP() + " au vol n°" + vol.getNumVol() + " effectué");
		}
		else {
			vueInfo.addLabelErreur("L'avion du vol n°" + vol.getNumVol() + " est complet");
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			vueInfo.reset();
			Passager passager = aero.getPassager(vueAjouterPassagerAVol.getPassagerIndex());
			VolCourrier vol = aero.getVolCourrier(vueAjouterPassagerAVol.getVolCourrierIndex());
			if(vol.getNbPlaceRestante() > 0) {
				passager.addUnVol(vol);
				vueInfo.addLabelValider("Ajout du passager " + passager.getPrenomP() + " " + passager.getNomP() + " au vol n°" + vol.getNumVol() + " effectué");
			}
			else {
				vueInfo.addLabelErreur("L'avion du vol n°" + vol.getNumVol() + " est complet");
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
