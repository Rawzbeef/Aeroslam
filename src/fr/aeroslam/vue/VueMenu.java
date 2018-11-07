package fr.aeroslam.vue;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.aeroslam.controleur.action.ActionMenu;
import fr.aeroslam.objet.Aeroport;

@SuppressWarnings("serial")
public class VueMenu extends JMenuBar {

	private JMenu jmAvion;
	private JMenuItem jmiAjouterAvion;
	private JMenuItem jmiAfficherAvion;
	private JMenuItem jmiRetirerAvion;
	
	
	public VueMenu(Aeroport aero, Vue vue, VueErreur vueErreur) {
		//Avion
		this.jmAvion = new JMenu("Avion");
		
		this.jmiAjouterAvion = new JMenuItem("Ajouter");
		this.jmiAjouterAvion.addActionListener(new ActionMenu(aero, vue, vueErreur, "AjouterAvion"));
		
		this.jmiAfficherAvion = new JMenuItem("Afficher");
		this.jmiAfficherAvion.addActionListener(new ActionMenu(aero, vue, vueErreur, "AfficherAvion"));
		
		this.jmiRetirerAvion = new JMenuItem("Retirer");
		this.jmiRetirerAvion.addActionListener(new ActionMenu(aero, vue, vueErreur, "RetirerAvion"));
		
		this.jmAvion.add(jmiAjouterAvion);
		this.jmAvion.add(jmiAfficherAvion);
		this.jmAvion.add(jmiRetirerAvion);
		
		//Vol
		
		this.add(jmAvion);
	}

}
