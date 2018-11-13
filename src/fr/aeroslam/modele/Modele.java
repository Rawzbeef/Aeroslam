package fr.aeroslam.modele;
import java.sql.*;
import java.util.ArrayList;

import fr.aeroslam.objet.Avion;
import fr.aeroslam.objet.Destination;
import fr.aeroslam.objet.Passager;


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
			System.out.println("L'initalisation des avions à échoué");
		}
		deconnexionBD();
		return lesAvions;
	}
	
	public static ArrayList<Passager> initLesPassagers() {
		connexionBD();
		ArrayList<Passager> lesPassagers = new ArrayList<Passager>();
		try {
			statement = connexion.prepareStatement("SELECT * FROM Passager");
			resultat = statement.executeQuery();
			while(resultat.next()) {
				lesPassagers.add(new Passager(resultat.getInt(1), resultat.getString(2), resultat.getString(3), resultat.getString(4), resultat.getString(5), resultat.getInt(6), resultat.getString(7)));
			}
			resultat.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("L'initalisation des passagers à échoué");
		}
		deconnexionBD();
		return lesPassagers;
	}
	
	public static ArrayList<Destination> initLesDestinations() {
		connexionBD();
		ArrayList<Destination> lesDestinations = new ArrayList<Destination>();
		try {
			statement = connexion.prepareStatement("SELECT * FROM Destination");
			resultat = statement.executeQuery();
			while(resultat.next()) {
				lesDestinations.add(new Destination(resultat.getInt(1), resultat.getString(2), resultat.getString(3)));
			}
			resultat.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("L'initalisation des destinations à échoué");
		}
		deconnexionBD();
		return lesDestinations;
	}

	public static int ajouterAvion(String nomA, int nbPlace) {
		int id = 0;
		connexionBD();
		try {
			statement = connexion.prepareStatement("INSERT INTO Avion (nomA, nbPlace) Values (?, ?);", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, nomA);
			statement.setInt(2, nbPlace);
			statement.executeUpdate();
			resultat = statement.getGeneratedKeys();
			if(resultat.next())
				id = resultat.getInt(1);
			resultat.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("L'ajout de l'avion a échoué.");
		}
		deconnexionBD();
		return id;
	}
	
	public static int ajouterPassager(String nomP, String prenomP, String rueP, String numRueP, int cpP, String villeP) {
		int id = 0;
		connexionBD();
		try {
			statement = connexion.prepareStatement("INSERT INTO `passager`(`nomP`, `prenomP`, `rueP`, `numRueP`, `cpP`, `villeP`) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, nomP);
			statement.setString(2, prenomP);
			statement.setString(3, rueP);
			statement.setString(4, numRueP);
			statement.setInt(5, cpP);
			statement.setString(6, villeP);
			statement.executeUpdate();
			resultat = statement.getGeneratedKeys();
			if(resultat.next())
				id = resultat.getInt(1);
			resultat.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("L'ajout du passager a échoué.");
		}
		deconnexionBD();
		return id;
	}
	
	public static int ajouterDestination(String villeD, String paysD) {
		int id = 0;
		connexionBD();
		try {
			statement = connexion.prepareStatement("INSERT INTO `destination`(`villeD`, `paysD`) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, villeD);
			statement.setString(2, paysD);
			statement.executeUpdate();
			resultat = statement.getGeneratedKeys();
			if(resultat.next())
				id = resultat.getInt(1);
			resultat.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("L'ajout du passager a échoué.");
		}
		deconnexionBD();
		return id;
	}	
	
	public static void retirerAvion(int id) {
		connexionBD();
		try {
			statement = connexion.prepareStatement("DELETE FROM `avion` WHERE codeA = ?;");
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("La suppression à échoué.");
		}
		deconnexionBD();
	}
	
	public static void retirerPassager(int id) {
		connexionBD();
		try {
			statement = connexion.prepareStatement("DELETE FROM `passager` WHERE codeP = ?;");
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("La suppression à échoué.");
		}
		deconnexionBD();
	}
	
	public static void retirerDestination(int id) {
		connexionBD();
		try {
			statement = connexion.prepareStatement("DELETE FROM `destination` WHERE codeD = ?;");
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("La suppression à échoué.");
		}
		deconnexionBD();
	}
	
	public static int getNbAvion() {
		connexionBD();
		int nbAvion = 0;
		try {
			statement = connexion.prepareStatement("SELECT Count(codeA) FROM Avion;");
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

	
}
