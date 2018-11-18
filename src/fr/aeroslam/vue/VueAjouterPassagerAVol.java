package fr.aeroslam.vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import fr.aeroslam.controleur.action.ActionAjoutPassagerAVol;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.objet.Passager;
import fr.aeroslam.objet.VolCourrier;

@SuppressWarnings("serial")
public class VueAjouterPassagerAVol extends JPanel {
	
	private JLabel jlPassager;
	private JComboBox<String> jcbPassager;
	
	private JLabel jlVol;
	private JComboBox<String> jcbVol;

	private JButton jbCreer;

	public VueAjouterPassagerAVol(Aeroport aero, VueInfo vueInfo) {
		
		this.jlPassager = new JLabel("Passager :");
		ArrayList<Passager> lesPassagers = aero.getLesPassagers();
		String[] tableP = new String[aero.getLesPassagers().size()];
		String[] tableV = new String[aero.getLesVolsCourrier().size()];
		int i = 0;
		for(Passager passager : lesPassagers) {
			tableP[i] = passager.getNumP() + " - " + passager.getNomP() + " " + passager.getPrenomP();
			i++;
		}
		this.jcbPassager = new JComboBox<String>(tableP);
		
		this.jlVol = new JLabel("Vol :");
		ArrayList<VolCourrier> lesVols = aero.getLesVolsCourrier();
		i = 0;
		for(VolCourrier vol : lesVols) {
			tableV[i] = vol.getNumVol() + " | " + vol.getDestination().getVilleD() + " - " + vol.getDestination().getPaysD() + " - " + vol.getNbPlaceRestante();
			i++;
		}
		this.jcbVol = new JComboBox<String>(tableV);
		
		this.jbCreer = new JButton("Créer");
		
		ActionAjoutPassagerAVol actionAjouterDestination = new ActionAjoutPassagerAVol(aero, this, vueInfo);
		this.jbCreer.addActionListener(actionAjouterDestination);
		this.jcbPassager.addKeyListener(actionAjouterDestination);
		this.jcbVol.addKeyListener(actionAjouterDestination);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(3, 3, 3, 3);
		this.add(jlPassager, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jcbPassager, c);
		c.gridx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jlVol, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jcbVol, c);
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 2;
		this.add(vueInfo, c);
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jbCreer, c);
	}

	public int getPassagerIndex() {
		return this.jcbPassager.getSelectedIndex();
	}
	
	public int getVolCourrierIndex() {
		return this.jcbVol.getSelectedIndex();
	}
	
}
