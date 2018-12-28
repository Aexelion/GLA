package fr.acceis.forum.classe;

import java.util.Date;

public class Message {
	
	private int id;
	private String texte;
	private String auteur;
	private int id_discussion;
	//private String date;
	
	public Message(int i, String t, String aut, int id_disc) {
		id = i;
		texte = t;
		auteur = aut;
		id_discussion = id_disc;
		//date = d;
	}
	
	public String getTexte() {
		return texte;
	}
	
	public String getAuteur() {
		return auteur;
	}
	
	public int getId() {
		return id;
	}

	public int getId_discussion() {
		return id_discussion;
	}

	/*public String getDate() {
		return date;
	}*/
}
