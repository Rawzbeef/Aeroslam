package fr.aeroslam.objet;

public class Avion {
	
	private int codeAvion;
	private String nomAvion;
	private int nbPlace;
	
	
	public Avion(int codeAvion, String nomAvion, int nbPlace) {
		this.setCodeAvion(codeAvion);
		this.setNomAvion(nomAvion);
		this.setNbPlace(nbPlace);
	}


	public int getCodeAvion() {
		return codeAvion;
	}


	public void setCodeAvion(int codeAvion) {
		this.codeAvion = codeAvion;
	}


	/**
	 * @return the nomAvion
	 */
	public String getNomAvion() {
		return nomAvion;
	}


	/**
	 * @param nomAvion the nomAvion to set
	 */
	public void setNomAvion(String nomAvion) {
		this.nomAvion = nomAvion;
	}


	/**
	 * @return the nbPlace
	 */
	public int getNbPlace() {
		return nbPlace;
	}


	/**
	 * @param nbPlace the nbPlace to set
	 */
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
}
