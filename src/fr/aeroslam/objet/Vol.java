package fr.aeroslam.objet;

import java.sql.Date;

public abstract class Vol {
	
	private int numVol;
	private Date dateVol;
	private String paysDestination;
	private String villeDestination;

	public Vol(int numVol, Date dateVol, String paysDestination, String villeDestination) {
		this.setNumVol(numVol);
		this.setDateVol(dateVol);
		this.setPaysDestination(paysDestination);
		this.setVilleDestination(villeDestination);
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

	/**
	 * @return the paysDestination
	 */
	public String getPaysDestination() {
		return paysDestination;
	}

	/**
	 * @param paysDestination the paysDestination to set
	 */
	public void setPaysDestination(String paysDestination) {
		this.paysDestination = paysDestination;
	}

	/**
	 * @return the villeDestination
	 */
	public String getVilleDestination() {
		return villeDestination;
	}

	/**
	 * @param villeDestination the villeDestination to set
	 */
	public void setVilleDestination(String villeDestination) {
		this.villeDestination = villeDestination;
	}
	
}
