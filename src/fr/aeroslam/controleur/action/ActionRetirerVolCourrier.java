package fr.aeroslam.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import fr.aeroslam.modele.Modele;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.Vue;
import fr.aeroslam.vue.VueInfo;
import fr.aeroslam.vue.VueRetirerVolCourrier;

public class ActionRetirerVolCourrier implements ActionListener {

	private Aeroport aero;
	private Vue vue;
	private VueInfo vueInfo;
	
	
	public ActionRetirerVolCourrier(Aeroport aero, Vue vue, VueInfo vueInfo) {
		this.aero = aero;
		this.vue = vue;
		this.vueInfo = vueInfo;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
			try {
				int id = Integer.parseInt(((JButton) event.getSource()).getText());
				Modele.retirerVolCourrier(id);
				aero.retirerVolCourrier(id);
				vue.getContentPane().removeAll();
				vue.getContentPane().add(new VueRetirerVolCourrier(aero, vue, vueInfo)).revalidate();
			} catch (SQLException e) {
				vueInfo.addLabelErreur("Il reste un passager dans ce vol");
			}
			
	}

}
