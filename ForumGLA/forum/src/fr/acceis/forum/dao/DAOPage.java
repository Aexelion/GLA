package fr.acceis.forum.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import fr.acceis.forum.classe.*;

public class DAOPage {
	
	public static ArrayList<Message> getListeMessage(int id_discussion) {
		ArrayList<Message> res = new ArrayList<Message>();
		try {
			PreparedStatement traitement = JeuDeTestJdBc.getConnection().prepareStatement("SELECT * FROM Messages WHERE id_discussion=?");
			traitement.setInt(1, id_discussion);
			ResultSet resultat = traitement.executeQuery();
			while(resultat.next()) {
				int id = resultat.getInt("id");
				String texte = resultat.getString("texte");
				String auteur = resultat.getString("auteur");
				int id_dis = resultat.getInt("id_discussion");
				Message msg = new Message(id, texte, auteur, id_dis);
				res.add(msg);
			}
		}catch (Exception e) {
			System.out.println("Erreur lors de la connection à la base de données(DAOPage.getListeMessage).");
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	public static String getSujet(int id) {
		String res = null;
		try {
			PreparedStatement traitement = JeuDeTestJdBc.getConnection().prepareStatement("SELECT sujet FROM Threads WHERE id=?");
			traitement.setInt(1, id);
			ResultSet resultat = traitement.executeQuery();
			while(resultat.next()) {
				res = resultat.getString("sujet");
			}
		}catch (Exception e) {
			System.out.println("Erreur lors de la connection à la base de données(DAOPage.getSujet).");
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	public static void addMessage(int id, String auteur, String mes) {
		try {
			PreparedStatement traitement = JeuDeTestJdBc.getConnection().prepareStatement("INSERT INTO Messages (id_discussion, auteur, texte) VALUES (?, ?, ?)");
			traitement.setInt(1, id);
			traitement.setString(2, auteur);
			traitement.setString(3, mes);
			traitement.executeUpdate();

			PreparedStatement traitement2 = JeuDeTestJdBc.getConnection().prepareStatement("UPDATE Threads SET reponse=reponse+1 WHERE id=?");
			traitement2.setInt(1, id);
			traitement2.executeUpdate(); //Incrémente le nombre de message de réponse.
		}catch (Exception e) {
			System.out.println("Erreur lors de la connection à la base de données(DAOPage.addMessage).");
			System.out.println(e.getMessage());
		}
	}

}
