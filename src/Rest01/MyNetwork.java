package Rest01;

import javax.ws.rs.*;


@Path("MyNetwork")
public class MyNetwork {
	
	@Path("benutzerhinzu/{benutzer}")				//Benutzer werden hinzugefügt
	@GET
	@Produces("text/plain")				
	public String benutzerhinzu(@PathParam("benutzer") String benutzer)			//benutzer ist de Uebergabeparameter
	{
		Starter.dbenutzer.add(new Benutzer(benutzer));							//Neuer benutzer wird hinzugefügt
		return "Benutzer " + benutzer +" hinzugefügt";
	}
	
	@Path("postHinzu/{benutzer}/{post}")	
	@GET
	@Produces("text/plain")
	public String postHinzu(@PathParam("benutzer") String benutzer, @PathParam("post") String post)		
	{
		for (int i = 0; i < Starter.dbenutzer.size(); i++){
			if (Starter.dbenutzer.get(i).name.equals(benutzer))
				Starter.dbenutzer.get(i).postHinzu(post);
		}
		return "Post hinzugefügt zu Benutzer: " +benutzer;
	}
	
	@Path("benutzerAusgabe")					//Die kompletten Benutzer werden angezeigt
	@GET
	@Produces("text/plain")	
	public String benutzerAusgabe(){
		String abenutzer = "";
		
		for (int i = 0; i < Starter.dbenutzer.size(); i++){		//Es wird durch alle Benutzer gezählt
			if (abenutzer.length() == 0)						//Wenn noch keiner vorhanden ist
				abenutzer = Starter.dbenutzer.get(i).name;
			else
				abenutzer += "\n" +Starter.dbenutzer.get(i).name; //Wenn schon einer vorhanden ist
		}
		return abenutzer;
	}
	
	@Path("postAusgabe/{benutzer}")								//PAusgabe eines Posts eines Benutzers
	@GET
	@Produces("text/plain")
	public String postAusgabe(@PathParam("benutzer") String benutzer)		
	{
		String posts = "";
		
		for (int i = 0; i < Starter.dbenutzer.size(); i++)
		{
			if (Starter.dbenutzer.get(i).name.equals(benutzer))		
				posts = Starter.dbenutzer.get(i).allePosts();	
			
		}
		return posts;
	}
	@Path("allePosts")								//Alle Posts aller Benutzer werden ausgegeben
	@GET
	@Produces("text/plain")
	public String allePosts()		
	{
		String posts = "";
		for (int i = 0; i < Starter.dbenutzer.size(); i++){
			posts += Starter.dbenutzer.get(i).allePosts();	//Alle Posts eines jeden Benutzers werden in posts gespeichert
			
		}
		return posts;
	}
	
	
	
	
}
