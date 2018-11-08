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
	
	
	public VueMenu(Aeroport aero, Vue vue, VueInfo vueInfo) {
		//Avion
		this.jmAvion = new JMenu("Avion");
		
		this.jmiAjouterAvion = new JMenuItem("Ajouter");
		this.jmiAjouterAvion.addActionListener(new ActionMenu(aero, vue, vueInfo, "AjouterAvion"));
		
		this.jmiAfficherAvion = new JMenuItem("Afficher");
		this.jmiAfficherAvion.addActionListener(new ActionMenu(aero, vue, vueInfo, "AfficherAvion"));
		
		this.jmiRetirerAvion = new JMenuItem("Retirer");
		this.jmiRetirerAvion.addActionListener(new ActionMenu(aero, vue, vueInfo, "RetirerAvion"));
		
		this.jmAvion.add(jmiAjouterAvion);
		this.jmAvion.add(jmiAfficherAvion);
		this.jmAvion.add(jmiRetirerAvion);
		
		//Vol
		
		this.add(jmAvion);
	}

}
