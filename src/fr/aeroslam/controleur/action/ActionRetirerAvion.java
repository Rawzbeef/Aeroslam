package fr.aeroslam.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import fr.aeroslam.modele.Modele;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.Vue;
import fr.aeroslam.vue.VueInfo;
import fr.aeroslam.vue.VueRetirerAvion;

public class ActionRetirerAvion implements ActionListener {

	private Aeroport aero;
	private Vue vue;
	private VueInfo vueInfo;
	
	public ActionRetirerAvion(Aeroport aero, Vue vue, VueInfo vueInfo) {
		this.aero = aero;
		this.vue = vue;
		this.vueInfo = vueInfo;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			int id = Integer.parseInt(((JButton) event.getSource()).getText());
			Modele.retirerAvion(id);
			aero.retirerAvion(id);
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueRetirerAvion(aero, vue, vueInfo)).revalidate();
		} catch (SQLException e) {
			vueInfo.addLabelErreur("Avion présent dans un vol");
		}

	}

}
