package fr.aeroslam.modele;
import java.sql.*;
import java.util.ArrayList;

import fr.aeroslam.objet.Avion;


public class Modele {
	// Attributs privés
	private static Connection connexion  = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultat = null;
	
	private static boolean isAdmin = false;

	// Méthodes statiques
	
	public static void connexionBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/AeroSlam", "root", "");
		} catch (ClassNotFoundException e) {
			System.out.println("Le driver est introuvable.");
		} catch (SQLException e) {
			System.out.println("la connexion a échoué.");
		}
		
	}
	
	public static void deconnexionBD() {
		try {
			connexion.close();
		} catch (SQLException e) {
			System.out.println("la deconnexion à échoué.");
		}
	}
	
	public static boolean connexionAdmin(String identifiant, String mdp) {
		connexionBD();
		try {
			statement = connexion.prepareStatement("SELECT Count(codeAdmin) FROM Administrateur WHERE identifiantAdmin = ? AND mdpAdmin = ?");
			statement.setString(1, identifiant);
			statement.setString(2, mdp);
			resultat = statement.executeQuery();
			resultat.next();
			if(resultat.getInt(1) == 1) 
				isAdmin = true;
			resultat.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("La connexion à échoué.");
		}
		deconnexionBD();
		return isAdmin;
	}

	public static boolean isAdmin() {
		return isAdmin;
	}

	public static void setIsAdmin(boolean isAdmin) {
		Modele.isAdmin = isAdmin;
	}
	
	public static ArrayList<Avion> initLesAvions() {
		connexionBD();
		ArrayList<Avion> lesAvions = new ArrayList<Avion>();
		try {
			statement = connexion.prepareStatement("SELECT * FROM Avion");
			resultat = statement.executeQuery();
			while(resultat.next()) {
				lesAvions.add(new Avion(resultat.getInt(1), resultat.getString(2), resultat.getInt(3)));
			}
			resultat.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("L'initalisation de l'avions à échoué");
		}
		deconnexionBD();
		return lesAvions;
	}

	public static void ajouterAvion(String nomA, int nbPlace) {
		connexionBD();
		try {
			statement = connexion.prepareStatement("INSERT INTO Avion (nomA, nbPlace) Values (?, ?);");
			statement.setString(1, nomA);
			statement.setInt(2, nbPlace);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("L'ajout a échoué.");
		}
		deconnexionBD();
	}
	
	public static int getNbAvion() {
		connexionBD();
		int nbAvion = 0;
		try {
			statement = connexion.prepareStatement("SELECT Count(codeA) FROM Avion");
			resultat = statement.executeQuery();
			resultat.next();
			nbAvion = resultat.getInt(1);
			resultat.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("La requete pour compter l'avion");
		}
		deconnexionBD();
		return nbAvion;
	}
	
	/*
	public static void ajouterContact(String nom, String prenom, String email, String commentaire) {
		connexionBD();
		try {
			statement = connexion.createStatement();
			statement.executeUpdate("INSERT INTO contact (Nom, Prenom, Email, Commentaire) Values ('"+nom+"', '"+prenom+"', '"+email+"', '"+commentaire+"');");
			statement.close();
		} catch (SQLException e) {
			System.out.println("L'ajout a échoué.");
		}
		deconnexionBD();
		
	}
	
	public static ArrayList<Contact> getLesContacts() {
		connexionBD();
		ArrayList<Contact> lesContacts = new ArrayList<Contact>();
		try {
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM Contact;");
			while(resultat.next()) {
				Contact contact = new Contact(resultat.getInt(1), resultat.getString(2), resultat.getString(3), resultat.getString(4), resultat.getString(5));
				lesContacts.add(contact);
			}
			resultat.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("La récupération a échoué.");
		}
		deconnexionBD();
		return lesContacts;
	}
	*/	
		
		
		
}
