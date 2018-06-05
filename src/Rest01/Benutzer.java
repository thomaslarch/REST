package Rest01;

import java.util.ArrayList;

public class Benutzer {

	String name = null;
	ArrayList<String> posts = new ArrayList();
	
	public Benutzer(String name){					//Kostruktor Benutzer
	
		this.name = name;
	}
	
	
	public String allePosts(){					//Hier werden alle Posts ausgegeben
		String allPosts = "";
		
		for (int i = 0; i < posts.size(); i++){
			if (allPosts.length() == 0)			//wenn es noch keinen Post gibt
				allPosts = posts.get(i);
			else
				allPosts += " | " + posts.get(i);
		}
		return allPosts;
	}
	
	public void postHinzu(String post){			//Posts werden hinzugefügt
		posts.add(post);
	}
	
}
