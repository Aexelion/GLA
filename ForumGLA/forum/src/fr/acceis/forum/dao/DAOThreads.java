package fr.acceis.forum.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import fr.acceis.forum.classe.JeuDeTestJdBc;
import fr.acceis.forum.classe.Discussion;
import fr.acceis.forum.classe.Fil;

public class DAOThreads {
	
	public static Fil getFil() {
		Fil res = new Fil(new ArrayList<Discussion>());
		try {
			PreparedStatement traitement = JeuDeTestJdBc.getConnection().prepareStatement("SELECT * FROM Threads");
			ResultSet resultat = traitement.executeQuery();
			while(resultat.next()) {
				int id = resultat.getInt("id");
				String titre = resultat.getString("sujet");
				String auteur = resultat.getString("auteur");
				int nbMessage = resultat.getInt("reponse");
				int nbVues = resultat.getInt("vues");
				Discussion tmp = new Discussion(titre, id, auteur, nbMessage, nbVues);
				res.addDiscussion(tmp);
			}
		} catch(Exception e) {
			System.out.println("Erreur lors de la connection à la base de données (DAOThreads.getFil).");
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	public static void addDiscussion(String sujet, String auteur) {
		try {
			PreparedStatement traitement = JeuDeTestJdBc.getConnection().prepareStatement("INSERT INTO Threads (sujet, auteur, reponse, vues) VALUES(?, ?, -1, 0)");
			traitement.setString(1, sujet);
			traitement.setString(2, auteur);
			traitement.executeUpdate();
		}catch (Exception e) {
			System.out.println("Erreur lors de la connection à la base de données(DAOThread.addDiscussion).");
			System.out.println(e.getMessage());
		}
	}
	
	public static int idDiscussion(String sujet, String auteur, int reponse) {
		int res = -1;
		try {
			PreparedStatement traitement = JeuDeTestJdBc.getConnection().prepareStatement("SELECT id FROM Threads WHERE sujet=? AND auteur=? AND reponse=?");
			traitement.setString(1, sujet);
			traitement.setString(2, auteur);
			traitement.setInt(3, reponse);
			ResultSet resultat = traitement.executeQuery();
			if(resultat.next()) {
				res = resultat.getInt("id");
			}
		}catch (Exception e) {
			System.out.println("Erreur lors de la connection à la base de données(DAOThread.idDiscussion).");
			System.out.println(e.getMessage());
		}
		return res;
	}
}
