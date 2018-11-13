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
	
	private JMenu jmPassager;
	private JMenuItem jmiAjouterPassager;
	private JMenuItem jmiAfficherPassager;
	private JMenuItem jmiRetirerPassager;
	
	private JMenu jmDestination;
	private JMenuItem jmiAjouterDestination;
	private JMenuItem jmiAfficherDestination;
	private JMenuItem jmiRetirerDestination;
	
	
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
		
		//Passager
		this.jmPassager = new JMenu("Passager");
		
		this.jmiAjouterPassager = new JMenuItem("Ajouter");
		this.jmiAjouterPassager.addActionListener(new ActionMenu(aero, vue, vueInfo, "AjouterPassager"));
		
		this.jmiAfficherPassager = new JMenuItem("Afficher");
		this.jmiAfficherPassager.addActionListener(new ActionMenu(aero, vue, vueInfo, "AfficherPassager"));
		
		this.jmiRetirerPassager = new JMenuItem("Retirer");
		this.jmiRetirerPassager.addActionListener(new ActionMenu(aero, vue, vueInfo, "RetirerPassager"));
		
		this.jmPassager.add(jmiAjouterPassager);
		this.jmPassager.add(jmiAfficherPassager);
		this.jmPassager.add(jmiRetirerPassager);
		
		//Destination
		this.jmDestination = new JMenu("Destination");
		
		this.jmiAjouterDestination = new JMenuItem("Ajouter");
		this.jmiAjouterDestination.addActionListener(new ActionMenu(aero, vue, vueInfo, "AjouterDestination"));
		
		this.jmiAfficherDestination = new JMenuItem("Afficher");
		this.jmiAfficherDestination.addActionListener(new ActionMenu(aero, vue, vueInfo, "AfficherDestination"));
		
		this.jmiRetirerDestination = new JMenuItem("Retirer");
		this.jmiRetirerDestination.addActionListener(new ActionMenu(aero, vue, vueInfo, "RetirerDestination"));
		
		this.jmDestination.add(jmiAjouterDestination);
		this.jmDestination.add(jmiAfficherDestination);
		this.jmDestination.add(jmiRetirerDestination);
		
		//Vol
		
		this.add(jmAvion);
		this.add(jmPassager);
		this.add(jmDestination);
	}

}
