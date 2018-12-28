package fr.acceis.forum.classe;

import java.util.ArrayList;

public class Fil {
	
	private ArrayList<Discussion> discussions;
	
	
	public Fil(ArrayList<Discussion> d) {
		discussions = d;
	}
	
	public ArrayList<Discussion> getDiscussions() {
		return discussions;
	}
	
	public void addDiscussion(Discussion d) {
		discussions.add(d);
	}
	
	public void deleteDiscussion(Discussion d) {
		if (discussions.contains(d)) {
			discussions.remove(d);
		}
	}
}
