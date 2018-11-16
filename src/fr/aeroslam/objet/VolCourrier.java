package fr.aeroslam.objet;

import java.util.ArrayList;

public class VolCourrier extends Vol {
	
	private ArrayList<Passager> lesPassagers;

	public VolCourrier(int numVol, String dateV, Destination destination, Avion avion) {
		super(numVol, dateV, destination, avion);
		this.lesPassagers = new ArrayList<Passager>();
	}
	
	public int getNbPlaceRestante() {
		return this.getAvion().getNbPlace() - this.lesPassagers.size();
	}

	/**
	 * @return the lesPassagers
	 */
	public ArrayList<Passager> getLesPassagers() {
		return lesPassagers;
	}

	/**
	 * @param lesPassagers the lesPassagers to set
	 */
	public void setLesPassagers(ArrayList<Passager> lesPassagers) {
		this.lesPassagers = lesPassagers;
	}
	
	public void addUnPassager(Passager passager) {
		this.lesPassagers.add(passager);
		passager.addUnVol(this);
	}
}
