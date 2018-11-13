package fr.aeroslam.objet;

import java.util.ArrayList;

public class Passager {

	
	
	private int numP;
	private String nomP;
	private String prenomP;
	private String rueP;
	private String numRueP;
	private int codePostalP;
	private String villeP;
	private ArrayList<VolCourrier> sesVolsCourrier;

	public Passager(int numP, String nomP, String prenomP, String rueP, String numRueP, int codePostalP, String villeP) {
		this.setNumP(numP);
		this.setNomP(nomP);
		this.setPrenomP(prenomP);
		this.setRueP(rueP);
		this.setNumRueP(numRueP);
		this.setCodePostalP(codePostalP);
		this.setVilleP(villeP);
		this.setSesVolsCourrier(new ArrayList<VolCourrier>());
	}

	/**
	 * @return the numP
	 */
	public int getNumP() {
		return numP;
	}

	/**
	 * @param numP the numP to set
	 */
	public void setNumP(int numP) {
		this.numP = numP;
	}

	/**
	 * @return the nomP
	 */
	public String getNomP() {
		return nomP;
	}

	/**
	 * @param nomP the nomP to set
	 */
	public void setNomP(String nomP) {
		this.nomP = nomP;
	}

	/**
	 * @return the prenomP
	 */
	public String getPrenomP() {
		return prenomP;
	}

	/**
	 * @param prenomP the prenomP to set
	 */
	public void setPrenomP(String prenomP) {
		this.prenomP = prenomP;
	}

	/**
	 * @return the rueP
	 */
	public String getRueP() {
		return rueP;
	}

	/**
	 * @param rueP the rueP to set
	 */
	public void setRueP(String rueP) {
		this.rueP = rueP;
	}

	/**
	 * @return the numRueP
	 */
	public String getNumRueP() {
		return numRueP;
	}

	/**
	 * @param numRueP the numRueP to set
	 */
	public void setNumRueP(String numRueP) {
		this.numRueP = numRueP;
	}

	/**
	 * @return the codePostalP
	 */
	public int getCodePostalP() {
		return codePostalP;
	}

	/**
	 * @param codePostalP the codePostalP to set
	 */
	public void setCodePostalP(int codePostalP) {
		this.codePostalP = codePostalP;
	}

	/**
	 * @return the villeP
	 */
	public String getVilleP() {
		return villeP;
	}

	/**
	 * @param villeP the villeP to set
	 */
	public void setVilleP(String villeP) {
		this.villeP = villeP;
	}

	/**
	 * @return the sesVolsCourrier
	 */
	public ArrayList<VolCourrier> getSesVolsCourrier() {
		return sesVolsCourrier;
	}

	/**
	 * @param sesVolsCourrier the sesVolsCourrier to set
	 */
	public void setSesVolsCourrier(ArrayList<VolCourrier> sesVolsCourrier) {
		this.sesVolsCourrier = sesVolsCourrier;
	}

}
