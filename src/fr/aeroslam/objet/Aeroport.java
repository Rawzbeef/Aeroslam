package fr.aeroslam.objet;

import java.util.ArrayList;

import fr.aeroslam.modele.Modele;

public class Aeroport {
	
	private ArrayList<Avion> lesAvions;
	
	public Aeroport() {
		this.lesAvions = Modele.initLesAvions();
		
	}

	/**
	 * @return La Liste d'Avion
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

	public void ajouterAvion(int id, String nomA, int nbPlace) {
		this.lesAvions.add(new Avion(id, nomA, nbPlace));
	}

	public void retirerAvion(int id) {
		int i = 0;
		while(i  < this.lesAvions.size() && this.lesAvions.get(i).getCodeAvion() != id) {
			i++;
		}
		if(i  < this.lesAvions.size() && this.lesAvions.get(i).getCodeAvion() == id){
			this.lesAvions.remove(i);
		}
	}

}
