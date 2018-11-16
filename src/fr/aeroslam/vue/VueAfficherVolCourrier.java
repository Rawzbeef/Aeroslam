package fr.aeroslam.vue;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.objet.Destination;
import fr.aeroslam.objet.Vol;
import fr.aeroslam.objet.VolCourrier;

@SuppressWarnings("serial")
public class VueAfficherVolCourrier extends JPanel {

	private Aeroport aero;

	public VueAfficherVolCourrier(Aeroport aero) {
		this.aero = aero;
		
		String[] entetes = {"Code", "Date", "Destination", "Avion", "Place restante"};
		DefaultTableModel tableModel = new DefaultTableModel(entetes, 0);
		ArrayList<VolCourrier> lesVols = this.aero.getLesVolsCourrier();
		
		
		for(int i = 0; i < lesVols.size(); i++) {
			int code = lesVols.get(i).getNumVol();
			String date = lesVols.get(i).getDateVol();
			String destination = lesVols.get(i).getDestination().getVilleD() + " - " + lesVols.get(i).getDestination().getPaysD();
			String avion = lesVols.get(i).getAvion().getCodeAvion() + " - " + lesVols.get(i).getAvion().getNomAvion();
			int nbPlaceRestante = lesVols.get(i).getNbPlaceRestante();
			Object[] data = {code, date, destination, avion, nbPlaceRestante};
			
			tableModel.addRow(data);
		}
		
		JTable tableau = new JTable(tableModel);
		
		this.add(new JScrollPane(tableau), BorderLayout.CENTER);
	}

}
