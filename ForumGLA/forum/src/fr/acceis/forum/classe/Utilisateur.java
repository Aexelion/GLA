package fr.acceis.forum.classe;

public class Utilisateur {
	private String pseudo;
	private String nom;
	private String prenom;
	private int age;
	private String description;
	
	public Utilisateur(String ps, String n, String p, int a, String d) {
		pseudo = ps;
		nom = n;
		prenom = p;
		age = a;
		description = d;
	}
	public Utilisateur(String ps) {
		pseudo = ps;
		nom = null;
		prenom = null;
		age = -1;
		description = null;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public int getAge() {
		return age;
	}
	public String getDescription() {
		return description;
	}
}
