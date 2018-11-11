package fr.aeroslam.vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fr.aeroslam.objet.Aeroport;

@SuppressWarnings("serial")
public class VueAfficherPassager extends JPanel {

	private Aeroport aero;

	public VueAfficherPassager(Aeroport aero) {
		this.aero = aero;

		String[] entetes = {"Code", "Nom", "Prenom", "Nom de rue", "Numéro de rue", "Code Postal", "Ville"};
		DefaultTableModel tableModel = new DefaultTableModel(entetes, 0);

		for(int i = 0; i < this.aero.getLesPassagers().size(); i++) {
			int code = this.aero.getLesPassagers().get(i).getNumP();
			String nom = this.aero.getLesPassagers().get(i).getNomP();
			String prenom = this.aero.getLesPassagers().get(i).getPrenomP();
			String rue = this.aero.getLesPassagers().get(i).getRueP();
			String numRue = this.aero.getLesPassagers().get(i).getNumRueP();
			int cp = this.aero.getLesPassagers().get(i).getCodePostalP();
			String ville = this.aero.getLesPassagers().get(i).getVilleP();
			Object[] data = {code ,nom, prenom, rue, numRue, cp, ville};

			tableModel.addRow(data);
		}

		JTable tableau = new JTable(tableModel);

		this.add(new JScrollPane(tableau), BorderLayout.CENTER);
	}

}
