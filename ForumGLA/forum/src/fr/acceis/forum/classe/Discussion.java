package fr.acceis.forum.classe;

public class Discussion {

	private String titre;
	private int id;
	private String mainAuteur;
	private int nbMessage;
	private int nbVues;
	
	
	public Discussion(String t, int i, String aut, int nbM, int nbV) {
		titre = t;
		id = i;
		mainAuteur = aut;
		nbMessage = nbM;
		nbVues = nbV;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public String getMainAuteur() {
		return mainAuteur;
	}

	public int getNbMessage() {
		return nbMessage;
	}

	public int getNbVues() {
		return nbVues;
	}

	public int getId() {
		return id;
	}
}
