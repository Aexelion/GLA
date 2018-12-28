package fr.acceis.forum.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.acceis.forum.classe.JeuDeTestJdBc;
import fr.acceis.forum.classe.Utilisateur;

public class DAOUser{

	public static boolean existUser(String user) {
		
		boolean res = false;
		try {
			PreparedStatement traitement = JeuDeTestJdBc.getConnection().prepareStatement("SELECT login FROM Utilisateurs WHERE login=?");
			traitement.setString(1, user);
			ResultSet resultat = traitement.executeQuery();
			res = resultat.next();
		} catch(Exception e) {
			System.out.println("Erreur lors de la connection à la base de données(DAOUser.existUser).");
			System.out.println(e.getMessage());
		}
		return res;
	}

	public static boolean match(String user, String pass) {
		
		boolean res = false;
		try {
			PreparedStatement traitement = JeuDeTestJdBc.getConnection().prepareStatement("SELECT login FROM Utilisateurs WHERE login=? AND password=?");
			traitement.setString(1, user);
			traitement.setString(2, pass);
			ResultSet resultat = traitement.executeQuery();
			res = resultat.next();
		} catch(Exception e) {
			System.out.println("Erreur lors de la connection à la base de données (DAOUser.match).");
			System.out.println(e.getMessage());
		}
		return res;
	}

	public static boolean addUser(String user, String pass) {
		boolean res = false;
		if (user != null && pass != null && user.length() > 0 && pass.length() > 4) {
			if (existUser(user)) {
				res = false;
			} else {
				try {
					PreparedStatement traitement = JeuDeTestJdBc.getConnection().prepareStatement("INSERT INTO Utilisateurs (login, password) VALUES(?, ?)");
					traitement.setString(1, user);
					traitement.setString(2, pass);
					traitement.executeUpdate();
					res = true;
				} catch(Exception e) {
					System.out.println("Erreur lors de la connection à la base de données (DAOUser.addUser).");
					System.out.println(e.getMessage());
				}
			}
		}
		return res;
	}

	public static boolean delUser(String user) {
		return false;
	}
	
	public static Utilisateur getUser(String user) {
		Utilisateur res = null;
		try {
			PreparedStatement traitement = JeuDeTestJdBc.getConnection().prepareStatement("SELECT * FROM Description WHERE pseudo=?");
			traitement.setString(1, user);
			ResultSet resultat = traitement.executeQuery();
			if(resultat.next()) {
				String pseudo = resultat.getString("pseudo");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				int age = resultat.getInt("age");
				String description = resultat.getString("description");
				res = new Utilisateur(pseudo, nom, prenom, age, description);
			}
		} catch(Exception e) {
			System.out.println("Erreur lors de la connection à la base de données (DAOUser.getUser).");
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	public static boolean setDescription(String pseudo, String nom, String prenom, int age, String descr) {
		boolean res = false;
		if (existDesc(pseudo)) {
			try {
				PreparedStatement traitement = JeuDeTestJdBc.getConnection().prepareStatement("UPDATE Description SET nom = ?, prenom = ?, age = ?, description= ? WHERE pseudo = ?");
				traitement.setString(5, pseudo);
				traitement.setString(1, nom);
				traitement.setString(2, prenom);
				traitement.setInt(3, age);
				traitement.setString(4, descr);
				traitement.executeUpdate();
				res = true;
			} catch(Exception e) {
				System.out.println("Erreur lors de la connection à la base de données (DAOUser.setDescription).");
				System.out.println(e.getMessage());
			}
		} else {
			try {
				PreparedStatement traitement = JeuDeTestJdBc.getConnection().prepareStatement("INSERT INTO Description (pseudo, nom, prenom, age, description) VALUES(?, ?, ?, ?, ?)");
				traitement.setString(1, pseudo);
				traitement.setString(2, nom);
				traitement.setString(3, prenom);
				traitement.setInt(4, age);
				traitement.setString(5, descr);
				traitement.executeUpdate();
				res = true;
			} catch(Exception e) {
				System.out.println("Erreur lors de la connection à la base de données (DAOUser.setDescription).");
				System.out.println(e.getMessage());
			}
		}
		return res;
	}
	
	public static boolean existDesc(String pseudo) {
		boolean res = false;
		try {
			PreparedStatement traitement = JeuDeTestJdBc.getConnection().prepareStatement("SELECT pseudo FROM Description WHERE pseudo=?");
			traitement.setString(1, pseudo);
			ResultSet resultat = traitement.executeQuery();
			res = resultat.next();
		} catch(Exception e) {
			System.out.println("Erreur lors de la connection à la base de données(DAOUser.existDesc).");
			System.out.println(e.getMessage());
		}
		return res;

	}
	
}
