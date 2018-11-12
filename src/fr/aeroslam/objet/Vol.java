package fr.aeroslam.objet;

import java.sql.Date;

public abstract class Vol {
	
	private int numVol;
	private Date dateVol;
	private Destination destination;
	private Avion avion;

	public Vol(int numVol, Date dateVol, Destination destination, Avion avion) {
		this.setNumVol(numVol);
		this.setDateVol(dateVol);
		this.setDestination(destination);
		this.setAvion(avion);
	}

	/**
	 * @return the numVol
	 */
	public int getNumVol() {
		return numVol;
	}

	/**
	 * @param numVol the numVol to set
	 */
	public void setNumVol(int numVol) {
		this.numVol = numVol;
	}

	/**
	 * @return the dateVol
	 */
	public Date getDateVol() {
		return dateVol;
	}

	/**
	 * @param dateVol the dateVol to set
	 */
	public void setDateVol(Date dateVol) {
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
