package fr.aeroslam.controleur.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.aeroslam.modele.Modele;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.Vue;
import fr.aeroslam.vue.VueRetirerVolCommercial;

public class ActionRetirerVolCommercial implements ActionListener {

	private Aeroport aero;
	private Vue vue;
	
	
	public ActionRetirerVolCommercial(Aeroport aero, Vue vue) {
		this.aero = aero;
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
			int id = Integer.parseInt(((JButton) event.getSource()).getText());
			Modele.retirerVolCommercial(id);
			aero.retirerVolCommercial(id);
			vue.getContentPane().removeAll();
			vue.getContentPane().add(new VueRetirerVolCommercial(aero, vue)).revalidate();
	}
}
