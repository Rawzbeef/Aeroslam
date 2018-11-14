package fr.aeroslam.objet;

import java.util.ArrayList;

import fr.aeroslam.modele.Modele;

public class Aeroport {
	
	private ArrayList<Avion> lesAvions;
	private ArrayList<Passager> lesPassagers;
	private ArrayList<Destination> lesDestinations;
	private ArrayList<Vol> lesVols;
	
	public Aeroport() {
		this.lesAvions = Modele.initLesAvions();
		this.lesPassagers = Modele.initLesPassagers();
		this.lesDestinations = Modele.initLesDestinations();
		this.lesVols = Modele.initLesVols(this);
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
	
	public Avion getAvion(int id) {
		int i = 0;
		Avion avion = null;
		while(i < this.lesAvions.size() && this.lesAvions.get(i).getCodeAvion() != id) {
			i++;
		}
		if(i < this.lesAvions.size() && this.lesAvions.get(i).getCodeAvion() == id) {
			avion = this.lesAvions.get(i);
		}
		return avion;
	}
	
	public Avion getAvion(int id, String lnull) {
		return this.lesAvions.get(id);
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

	public void ajouterDestination(int id, String villeD, String paysD) {
		this.lesDestinations.add(new Destination(id, villeD, paysD));
	}

	public void retirerDestination(int id) {
		int i = 0;
		while(i  < this.lesDestinations.size() && this.lesDestinations.get(i).getCodeD() != id) {
			i++;
		}
		if(i  < this.lesDestinations.size() && this.lesDestinations.get(i).getCodeD() == id){
			this.lesDestinations.remove(i);
		}
	}
	
	public Destination getDestination(int index) {
		int i = 0;
		Destination destination = null;
		while(i < this.lesDestinations.size() && this.lesDestinations.get(i).getCodeD() != index) {
			i++;
		}
		if(i < this.lesDestinations.size() && this.lesDestinations.get(i).getCodeD() == index) {
			destination = this.lesDestinations.get(i);
		}
		return destination;
	}
	
	public Destination getDestination(int id, String lnull) {
		return this.lesDestinations.get(id);
	}
	
	public ArrayList<Vol> getLesVols() {
		return lesVols;
	}
	
	public void creerVol(int id, String dateV, int avionIndex, int destinationIndex) {
		//System.out.println(this.lesAvions.get(avionIndex).getNomAvion());
		this.lesVols.add(new VolCourrier(id, dateV, this.lesDestinations.get(destinationIndex), this.lesAvions.get(avionIndex)));
	}

}
