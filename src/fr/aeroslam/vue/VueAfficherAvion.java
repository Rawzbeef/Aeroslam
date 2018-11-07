package fr.aeroslam.vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fr.aeroslam.objet.Aeroport;

@SuppressWarnings("serial")
public class VueAfficherAvion extends JPanel {

	private Aeroport aero;

	public VueAfficherAvion(Aeroport aero) {
		this.aero = aero;
		
		String[] entetes = {"Code", "Nom", "Nombre de place"};
		DefaultTableModel tableModel = new DefaultTableModel(entetes, 0);
		
		for(int i = 0; i < this.aero.getLesAvions().size(); i++) {
			int code = this.aero.getLesAvions().get(i).getCodeAvion();
			String nom = this.aero.getLesAvions().get(i).getNomAvion();
			int nbPlace = this.aero.getLesAvions().get(i).getNbPlace();
			Object[] data = {code ,nom, nbPlace};
			
			tableModel.addRow(data);
		}
		
		JTable tableau = new JTable(tableModel);
		
		this.add(new JScrollPane(tableau), BorderLayout.CENTER);
	}

}
