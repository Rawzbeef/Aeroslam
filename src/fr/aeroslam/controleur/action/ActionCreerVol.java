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
		int avionIndex = vueCreerVol.getAvionIndex();
		int destinationIndex = vueCreerVol.getDestinationIndex();
		if(dateV != null) {
			if(this.vueCreerVol.isCourrier()) {
				int id = Modele.creerVolCourrier(dateV, aero.getAvion(avionIndex,"").getCodeAvion(), aero.getDestination(destinationIndex,"").getCodeD());
				aero.creerVolCourrier(id , dateV, avionIndex, destinationIndex);
				vueInfo.addLabelValider("Ajout du vol courrier n°" + id + " effectué");
			}
			else if(this.vueCreerVol.isCommercial()) {
				int id = Modele.creerVolCommercial(dateV, aero.getAvion(avionIndex,"").getCodeAvion(), aero.getDestination(destinationIndex,"").getCodeD());
				aero.creerVolCommercial(id , dateV, avionIndex, destinationIndex);
				vueInfo.addLabelValider("Ajout du vol commercial n°" + id + " effectué");
			}
			else {
				vueInfo.addLabelErreur("Le type de vol n'est pas sélectionné");
			}
		}
		else {
			vueInfo.addLabelErreur("Date de départ non sélectionné");
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			vueInfo.reset();
			String dateV = vueCreerVol.getDate();
			int avionIndex = vueCreerVol.getAvionIndex();
			int destinationIndex = vueCreerVol.getDestinationIndex();
			if(dateV != null) {
				if(this.vueCreerVol.isCourrier()) {
					int id = Modele.creerVolCourrier(dateV, aero.getAvion(avionIndex,"").getCodeAvion(), aero.getDestination(destinationIndex,"").getCodeD());
					aero.creerVolCourrier(id , dateV, avionIndex, destinationIndex);
					vueInfo.addLabelValider("Ajout du vol courrier n°" + id + " effectué");
				}
				else if(this.vueCreerVol.isCommercial()) {
					int id = Modele.creerVolCommercial(dateV, aero.getAvion(avionIndex,"").getCodeAvion(), aero.getDestination(destinationIndex,"").getCodeD());
					aero.creerVolCommercial(id , dateV, avionIndex, destinationIndex);
					vueInfo.addLabelValider("Ajout du vol commercial n°" + id + " effectué");
				}
				else {
					vueInfo.addLabelErreur("Le type de vol n'est pas sélectionné");
				}
			}
			else {
				vueInfo.addLabelErreur("Date de départ non sélectionné");
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
