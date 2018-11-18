package fr.aeroslam.objet;

import java.util.ArrayList;

import org.dom4j.Element;

import fr.aeroslam.modele.Modele;

public class VolCourrier extends Vol {
	
	private ArrayList<Passager> lesPassagers;

	public VolCourrier(int numVol, String dateV, Destination destination, Avion avion) {
		super(numVol, dateV, destination, avion);
		this.lesPassagers = new ArrayList<Passager>();
	}
	
	public int getNbPlaceRestante() {
		return this.getAvion().getNbPlace() - this.lesPassagers.size();
	}

	/**
	 * @return the lesPassagers
	 */
	public ArrayList<Passager> getLesPassagers() {
		return lesPassagers;
	}

	/**
	 * @param lesPassagers the lesPassagers to set
	 */
	public void setLesPassagers(ArrayList<Passager> lesPassagers) {
		this.lesPassagers = lesPassagers;
	}
	
	public boolean addUnPassager(Passager passager) {
		boolean bool = false;
		if(this.getNbPlaceRestante() > 0) {
			this.lesPassagers.add(passager);
			passager.addUnVol(this);
			Modele.ajouterEnregistrer(this.getNumVol(), passager.getNumP());
			bool = true;
		}
		return bool;
	}

	public void retirerUnPassager(Passager passager) {
		this.lesPassagers.remove(passager);
		passager.retirerUnVol(this);
		Modele.retirerEnregistrer(passager.getNumP(), this.getNumVol());
	}
	
	@Override
	public Element toXml() {
		Element root = super.toXml();
		Element passagers = root.addElement("Passager");
		for(Passager passager : lesPassagers) {
			passagers.add(passager.toXml());
		}
		return root;
	}
}
