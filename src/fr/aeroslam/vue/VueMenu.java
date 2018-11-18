package fr.aeroslam.vue;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.aeroslam.controleur.action.ActionMenu;
import fr.aeroslam.objet.Aeroport;

@SuppressWarnings("serial")
public class VueMenu extends JMenuBar {
	//Avion
	private JMenu jmAvion;
	private JMenuItem jmiAjouterAvion;
	private JMenuItem jmiAfficherAvion;
	private JMenuItem jmiRetirerAvion;
	//Passager
	private JMenu jmPassager;
	private JMenuItem jmiAjouterPassager;
	private JMenuItem jmiAfficherPassager;
	private JMenuItem jmiRetirerPassager;
	private JMenuItem jmiRetirerPassagerAVol;
	//Destination
	private JMenu jmDestination;
	private JMenuItem jmiAjouterDestination;
	private JMenuItem jmiAfficherDestination;
	private JMenuItem jmiRetirerDestination;
	//Vol
	private JMenu jmVol;
	private JMenuItem jmiCreerVol;
	private JMenuItem jmiAfficherVolCourrier;
	private JMenuItem jmiAfficherVolCommercial;
	private JMenuItem jmiAjouterPassagerAVol;
	private JMenuItem jmiRetirerVolCourrier;
	private JMenuItem jmiRetirerVolCommercial;
	//X + dédicace à Déniz
	private JMenuItem jmiXDeniz;
	private JMenu jmFichier;
	private JMenuItem jmiExportToXml;
	
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
		
		this.jmiRetirerPassagerAVol = new JMenuItem("Retirer le passager d'un vol");
		this.jmiRetirerPassagerAVol.addActionListener(new ActionMenu(aero, vue, vueInfo, "RetirerPassagerAVol"));
		
		this.jmPassager.add(jmiAjouterPassager);
		this.jmPassager.add(jmiAfficherPassager);
		this.jmPassager.add(jmiRetirerPassager);
		this.jmPassager.add(jmiRetirerPassagerAVol);
		
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
		this.jmVol = new JMenu("Vol");
		
		this.jmiCreerVol = new JMenuItem("Créer");
		this.jmiCreerVol.addActionListener(new ActionMenu(aero, vue, vueInfo, "CreerVol"));
		
		this.jmiAfficherVolCourrier = new JMenuItem("Afficher les vol courrier");
		this.jmiAfficherVolCourrier.addActionListener(new ActionMenu(aero, vue, vueInfo, "AfficherVolCourrier"));
		
		this.jmiAfficherVolCommercial = new JMenuItem("Afficher les vol commercial");
		this.jmiAfficherVolCommercial.addActionListener(new ActionMenu(aero, vue, vueInfo, "AfficherVolCommercial"));
		
		this.jmiAjouterPassagerAVol = new JMenuItem("Ajouter un passager");
		this.jmiAjouterPassagerAVol.addActionListener(new ActionMenu(aero, vue, vueInfo, "AjouterPassagerAVol"));
		
		this.jmiRetirerVolCourrier = new JMenuItem("Supprimer un vol courrier");
		this.jmiRetirerVolCourrier.addActionListener(new ActionMenu(aero, vue, vueInfo, "RetirerVolCourrier"));
		
		this.jmiRetirerVolCommercial = new JMenuItem("Supprimer un vol commercial");
		this.jmiRetirerVolCommercial.addActionListener(new ActionMenu(aero, vue, vueInfo, "RetirerVolCommercial"));
		
		this.jmVol.add(jmiCreerVol);
		this.jmVol.add(jmiAfficherVolCourrier);
		this.jmVol.add(jmiAfficherVolCommercial);
		this.jmVol.add(jmiAjouterPassagerAVol);
		this.jmVol.add(jmiRetirerVolCourrier);
		this.jmVol.add(jmiRetirerVolCommercial);
		
		//Fichier
		this.jmFichier = new JMenu("Fichier");
		
		this.jmiExportToXml = new JMenuItem("Export to xml");
		this.jmiExportToXml.addActionListener(new ActionMenu(aero, vue, vueInfo, "ExportToXml"));
		
		this.jmFichier.add(jmiExportToXml);
		
		//X
		this.jmiXDeniz = new JMenuItem("X");
		this.jmiXDeniz.addActionListener(new ActionMenu(aero, vue, vueInfo, "X"));
		
		this.add(jmFichier);
		this.add(jmAvion);
		this.add(jmPassager);
		this.add(jmDestination);
		this.add(jmVol);
		
		//this.add(Box.createHorizontalGlue());
		
		//this.add(jmiXDeniz);
	}

}
