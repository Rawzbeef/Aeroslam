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
			System.out.println("L'ajout a échoué.");
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
