package fr.aeroslam.objet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import fr.aeroslam.controleur.Controleur;
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
		while(i < this.lesAvions.size() && this.lesAvions.get(i).getCodeAvion() != id) {
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
	
	public Passager getPassagerById(int id) {
		int i = 0;
		Passager passager = null;
		while(i < this.lesPassagers.size() && this.lesPassagers.get(i).getNumP() != id) {
			i++;
		}
		if(i < this.lesPassagers.size() && this.lesPassagers.get(i).getNumP() == id) {
			passager = this.lesPassagers.get(i);
		}
		return passager;
	}
	
	public Passager getPassager(int index) {
		return lesPassagers.get(index);
	}

	public void ajouterPassager(int id, String nomP, String prenomP, String rueP, String numRueP, int cpP, String villeP) {
		this.lesPassagers.add(new Passager(id, nomP, prenomP, rueP, numRueP, cpP, villeP));
	}

	public void retirerPassager(int id) {
		int i = 0;
		while(i < this.lesPassagers.size() && this.lesPassagers.get(i).getNumP() != id) {
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
		while(i < this.lesDestinations.size() && this.lesDestinations.get(i).getCodeD() != id) {
			i++;
		}
		if(i  < this.lesDestinations.size() && this.lesDestinations.get(i).getCodeD() == id){
			this.lesDestinations.remove(i);
		}
	}
	
	public Destination getDestination(int id) {
		int i = 0;
		Destination destination = null;
		while(i < this.lesDestinations.size() && this.lesDestinations.get(i).getCodeD() != id) {
			i++;
		}
		if(i < this.lesDestinations.size() && this.lesDestinations.get(i).getCodeD() == id) {
			destination = this.lesDestinations.get(i);
		}
		return destination;
	}
	
	public Destination getDestination(int index, String lnull) {
		return this.lesDestinations.get(index);
	}
	
	public ArrayList<VolCourrier> getLesVolsCourrier() {
		ArrayList<VolCourrier> lesVolsCourrier = new ArrayList<VolCourrier>();
		for(Vol vol : this.lesVols) {
			if(vol instanceof VolCourrier) {
				lesVolsCourrier.add((VolCourrier) vol);
			}
		}
		return lesVolsCourrier;
	}
	
	public ArrayList<VolCommercial> getLesVolsCommercial() {
		ArrayList<VolCommercial> lesVolsCommercial = new ArrayList<VolCommercial>();
		for(Vol vol : this.lesVols) {
			if(vol instanceof VolCommercial) {
				lesVolsCommercial.add((VolCommercial) vol);
			}
		}
		return lesVolsCommercial;
	}
	
	public VolCourrier getVolCourrier(int index) {
		return getLesVolsCourrier().get(index);
	}
	
	public VolCourrier getVolCourrierById(int id) {
		int i = 0;
		VolCourrier vol = null;
		while(i < this.lesVols.size() && (this.lesVols.get(i).getNumVol() != id || !(this.lesVols.get(i) instanceof VolCourrier))) {
			i++;
		}
		if(i < this.lesVols.size() && this.lesVols.get(i).getNumVol() == id) {
			vol = (VolCourrier) this.lesVols.get(i);
		}
		return vol;
	}
	
	public void creerVolCourrier(int id, String dateV, int avionIndex, int destinationIndex) {
		this.lesVols.add(new VolCourrier(id, dateV, this.lesDestinations.get(destinationIndex), this.lesAvions.get(avionIndex)));
	}
	
	public void creerVolCommercial(int id, String dateV, int avionIndex, int destinationIndex) {
		this.lesVols.add(new VolCommercial(id, dateV, this.lesDestinations.get(destinationIndex), this.lesAvions.get(avionIndex)));
	}

	public void retirerVolCourrier(int id) {
		int i = 0;
		while(i < this.lesVols.size() && (this.lesVols.get(i).getNumVol() != id || !(this.lesVols.get(i) instanceof VolCourrier))) {
			i++;
		}
		if(i < this.lesVols.size() && this.lesVols.get(i).getNumVol() == id){
			this.lesVols.remove(i);
		}
	}
	
	public void retirerVolCommercial(int id) {
		int i = 0;
		while(i < this.lesVols.size() && (this.lesVols.get(i).getNumVol() != id || !(this.lesVols.get(i) instanceof VolCommercial))) {
			i++;
		}
		if(i < this.lesVols.size() && this.lesVols.get(i).getNumVol() == id){
			this.lesVols.remove(i);
		}
	}
	
	public void toXml() {
		ArrayList<VolCourrier> lesVolsCourrier = getLesVolsCourrier();
		ArrayList<VolCommercial> lesVolsCommercial = getLesVolsCommercial();
		try {
			Document document = DocumentHelper.createDocument();
			Element root = document.addElement("aeroport");
			Element avions = root.addElement("avions");
			for(Avion avion : lesAvions) {
				avions.add(avion.toXml());
			}
			Element passagers = root.addElement("passagers");
			for(Passager passager : lesPassagers) {
				passagers.add(passager.toXml());
			}
			Element destinations = root.addElement("destinations");
			for(Destination destination : lesDestinations) {
				destinations.add(destination.toXml());
			}
			Element vols = root.addElement("vols");
			Element volsCourrier = vols.addElement("volsCourriers");
			for(VolCourrier volCourrier : lesVolsCourrier) {
				volsCourrier.add(volCourrier.toXml());
			}
			Element volsCommercial = vols.addElement("volsCommerciaux");
			for(VolCommercial volCommercial : lesVolsCommercial) {
				volsCommercial.add(volCommercial.toXml());
			}
			
			String dossPath = URLDecoder.decode(new File(Controleur.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent(), "UTF-8") + "\\xml";
			File dir = new File(dossPath);
			dir.mkdirs();

			FileOutputStream fos = new FileOutputStream( dossPath + "\\Aeroport.xml");
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter writer;
			writer = new XMLWriter(fos, format);
			writer.write(document);
		} catch (UnsupportedEncodingException e) {
			System.out.println(e);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (URISyntaxException e) {
			System.out.println(e);
		}
	}
}
