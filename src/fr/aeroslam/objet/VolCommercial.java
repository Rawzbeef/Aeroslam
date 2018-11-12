package fr.aeroslam.objet;

import java.sql.Date;

public class VolCommercial extends Vol {

	public VolCommercial(int numVol, Date dateVol, Destination destination, Avion avion) {
		super(numVol, dateVol, destination, avion);
	}
}
