package fr.aeroslam.objet;

import java.util.ArrayList;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Passager {

	
	
	private int numP;
	private String nomP;
	private String prenomP;
	private String rueP;
	private String numRueP;
	private int codePostalP;
	private String villeP;
	private ArrayList<VolCourrier> lesVolsCourrier;

	public Passager(int numP, String nomP, String prenomP, String rueP, String numRueP, int codePostalP, String villeP) {
		this.setNumP(numP);
		this.setNomP(nomP);
		this.setPrenomP(prenomP);
		this.setRueP(rueP);
		this.setNumRueP(numRueP);
		this.setCodePostalP(codePostalP);
		this.setVilleP(villeP);
		this.setLesVolsCourrier(new ArrayList<VolCourrier>());
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
	public ArrayList<VolCourrier> getLesVolsCourrier() {
		return lesVolsCourrier;
	}

	/**
	 * @param sesVolsCourrier the sesVolsCourrier to set
	 */
	public void setLesVolsCourrier(ArrayList<VolCourrier> sesVolsCourrier) {
		this.lesVolsCourrier = sesVolsCourrier;
	}

	public boolean addUnVol(VolCourrier vol) {
		boolean bool = false;
		System.out.println(vol.getNbPlaceRestante());
		if(vol.getNbPlaceRestante() > 0) {
			this.lesVolsCourrier.add(vol);
			bool = true;
		}
		return bool;
	}
	
	public void retirerUnVol(VolCourrier vol) {
		this.lesVolsCourrier.remove(vol);
	}
	
	public Element toXml() {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("passager");
		root.addElement("code").addText("" + this.numP);
		root.addElement("nom").addText(this.nomP);
		root.addElement("prenom").addText(this.prenomP);
		root.addElement("rue").addText(this.rueP);
		root.addElement("numRue").addText(this.numRueP);
		root.addElement("codePostal").addText("" + this.codePostalP);
		root.addElement("ville").addText(this.villeP);
		return root;
	}

}
