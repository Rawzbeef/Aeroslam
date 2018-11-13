package fr.aeroslam.vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fr.aeroslam.objet.Aeroport;

@SuppressWarnings("serial")
public class VueAfficherDestination extends JPanel {

	private Aeroport aero;

	public VueAfficherDestination(Aeroport aero) {
		this.aero = aero;
		
		String[] entetes = {"Code", "Ville", "Pays"};
		DefaultTableModel tableModel = new DefaultTableModel(entetes, 0);
		
		for(int i = 0; i < this.aero.getLesDestinations().size(); i++) {
			int code = this.aero.getLesDestinations().get(i).getCodeD();
			String ville = this.aero.getLesDestinations().get(i).getVilleD();
			String pays = this.aero.getLesDestinations().get(i).getPaysD();
			Object[] data = {code, ville, pays};
			
			tableModel.addRow(data);
		}
		
		JTable tableau = new JTable(tableModel);
		
		this.add(new JScrollPane(tableau), BorderLayout.CENTER);
	}

}
