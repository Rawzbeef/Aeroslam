package fr.aeroslam.objet;

import java.util.ArrayList;

public abstract class Vol {
	
	private int numVol;
	private String dateVol;
	private Destination destination;
	private Avion avion;

	public Vol(int numVol, String dateV, Destination destination, Avion avion) {
		this.setNumVol(numVol);
		this.setDateVol(dateV);
		this.setDestination(destination);
		this.setAvion(avion);
	}

	public int getNumVol() {
		return numVol;
	}

	public void setNumVol(int numVol) {
		this.numVol = numVol;
	}

	public String getDateVol() {
		return dateVol;
	}

	public void setDateVol(String dateVol) {
		this.dateVol = dateVol;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

}
