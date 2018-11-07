package fr.aeroslam.objet;

import java.util.ArrayList;

import fr.aeroslam.modele.Modele;

public class Aeroport {
	
	private ArrayList<Avion> lesAvions;
	
	public Aeroport() {
		this.lesAvions = Modele.initLesAvions();
		
	}

	/**
	 * @return the lesAvions
	 */
	public ArrayList<Avion> getLesAvions() {
		return lesAvions;
	}

	/**
	 * @param lesAvions the lesAvions to set
	 */
	public void setLesAvions(ArrayList<Avion> lesAvions) {
		this.lesAvions = lesAvions;
	}

}
