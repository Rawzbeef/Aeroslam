package fr.aeroslam.objet;

import java.util.ArrayList;

import fr.aeroslam.modele.Modele;

public class Aeroport {
	
	private ArrayList<Avion> lesAvions;
	private ArrayList<Passager> lesPassagers;
	private ArrayList<Destination> lesDestinations;
	
	public Aeroport() {
		this.lesAvions = Modele.initLesAvions();
		this.lesPassagers = Modele.initLesPassagers();
		this.lesDestinations = Modele.initLesDestinations();
	}
	
	public ArrayList<Avion> getLesAvions() {
		return lesAvions;
	}
	
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
		if(i < this.lesAvions.size() && this.lesAvions.get(i).getCodeAvion() == id){
			this.lesAvions.remove(i);
		}
	}
	
	public ArrayList<Passager> getLesPassagers() {
		return lesPassagers;
	}

	public void ajouterPassager(int id, String nomP, String prenomP, String rueP, String numRueP, int cpP, String villeP) {
		this.lesPassagers.add(new Passager(id, nomP, prenomP, rueP, numRueP, cpP, villeP));
	}

	public void retirerPassager(int id) {
		int i = 0;
		while(i  < this.lesPassagers.size() && this.lesPassagers.get(i).getNumP() != id) {
			i++;
		}
		if(i  < this.lesPassagers.size() && this.lesPassagers.get(i).getNumP() == id){
			this.lesPassagers.remove(i);
		}
	}
	
	public ArrayList<Destination> getLesDestinations() {
		return lesDestinations;
	}
}
