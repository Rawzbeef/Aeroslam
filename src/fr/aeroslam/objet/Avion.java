package fr.aeroslam.objet;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

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

	/**
	 * @return un Objet Element correspondant à la version XML de l'avion.
	 */
	public Element toXml() {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("avion");
		root.addElement("code").addText("" + this.codeAvion);
		root.addElement("nom").addText(this.nomAvion);
		root.addElement("nombrePlace").addText("" + this.nbPlace);
		return root;
	}
}
