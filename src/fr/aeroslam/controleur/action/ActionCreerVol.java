package fr.aeroslam.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.aeroslam.modele.Modele;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.VueCreerVol;
import fr.aeroslam.vue.VueInfo;

public class ActionCreerVol implements ActionListener, KeyListener {

	private VueCreerVol vueCreerVol;
	private VueInfo vueInfo;
	private Aeroport aero;

	public ActionCreerVol(Aeroport aero, VueCreerVol vueCreerVol, VueInfo vueInfo) {
		this.aero = aero;
		this.vueCreerVol = vueCreerVol;
		this.vueInfo = vueInfo;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		vueInfo.reset();
		String dateV = vueCreerVol.getDate();
		System.out.println(vueCreerVol.getAvionIndex() + " " + vueCreerVol.getDestinationIndex());
		int avionIndex = vueCreerVol.getAvionIndex();
		int destinationIndex = vueCreerVol.getDestinationIndex();
		if(dateV != null) {
			int id = Modele.creerVol(dateV, aero.getAvion(avionIndex).getCodeAvion(), aero.getDestination(destinationIndex).getCodeD());
			aero.creerVol(id , dateV, avionIndex, destinationIndex);
			vueInfo.addLabelValider("Ajout du Vol n°" + id + " effectué");
		}
		else {
			vueInfo.addLabelErreur("Date de départ non selectionné");
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			vueInfo.reset();
			String dateV = vueCreerVol.getDate();
			System.out.println(vueCreerVol.getAvionIndex() + " " + vueCreerVol.getDestinationIndex());
			int avionIndex = vueCreerVol.getAvionIndex();
			int destinationIndex = vueCreerVol.getDestinationIndex();
			if(dateV != null) {
				int id = Modele.creerVol(dateV, aero.getAvion(avionIndex).getCodeAvion(), aero.getDestination(destinationIndex).getCodeD());
				aero.creerVol(id , dateV, avionIndex, destinationIndex);
				vueInfo.addLabelValider("Ajout du Vol n°" + id + " effectué");
			}
			else {
				vueInfo.addLabelErreur("Date de départ non selectionné");
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
