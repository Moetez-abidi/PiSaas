 package tn.esprit.jsf_app.services;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.jsf_app.DTO.Event;
import tn.esprit.jsf_app.interfaces.EventServiceRemote;

public class EventService implements EventServiceRemote{

	public String GlobalEndPoint = "empresentation-dev.eu-west-1.elasticbeanstalk.com";

	public EventService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Event> GetAll() {
		EntityManager em ;
	
			//Client client = ClientBuilder.newClient();
			//WebTarget target = client.target("http://localhost:31618/api/PubWebApi/");
			//WebTarget hello =target.path("");
			//Response response =hello.request().get();
			
			//String result=response.readEntity(String.class);
			
			//PublicationDTO[] pubs =  response.readEntity(PublicationDTO[].class);

			//response.close();
			//return pubs;
			List<Event>  lasp = new ArrayList<Event>();
	    	Client client = ClientBuilder.newClient();
	    	
	    	WebTarget web = client.target("http://"+GlobalEndPoint+"/api/EventWebApi/"); 
	    	
	    	Response response = web.request().get();
	    	
	    	String result = response.readEntity(String.class); 
	    	
	    	//System.out.println(result);
	    	JsonReader jsonReader = Json.createReader(new StringReader(result));
	    	JsonArray object =  jsonReader.readArray();
	    	
	    	 
	    	for (int i=0;i<object.size();i++)
	    	{
	    	 
	    		Event m = new Event();
	    	 //String dateString;
	       	 m.setEventId(object.getJsonObject(i).getInt("EventId")); 
	    	 m.setName(object.getJsonObject(i).getString("Name")); 
	    	 m.setPicture(object.getJsonObject(i).getString("Picture")); 
	    	 m.setTheme(object.getJsonObject(i).getString("Theme")); 
	    	 m.setLocation(object.getJsonObject(i).getString("Location"));
	    	 m.setStartDate(object.getJsonObject(i).getString("StartDate"));
	    	 m.setEndDate(object.getJsonObject(i).getString("EndDate"));
	    	
	    	 lasp.add(m);
	    	}
	    	

	return lasp;    	
	}

	@Override
	public void Delete(Event eve) {
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://"+GlobalEndPoint+"/api/EventWebApi?id="+eve.getEventId()); 
		WebTarget hello = target.path("");     	
    	Response res=(Response) hello.request().delete();
	}

	@Override
	public void Create(Event p) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://"+GlobalEndPoint+"/api/Create");
		WebTarget hello =target.path("");
		
		Response response =hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON) );
		
		
		String result=response.readEntity(String.class);
		System.out.println(result);
		
		

		response.close();
		
	}

	@Override
	public void Update(int id, Event p) {
		Event e = new Event();
		e.setEventId(p.EventId);
		e.setName(p.Name);
		e.setPicture(p.Picture);
		e.setTheme(p.Theme);
		e.setLocation(p.Location);
       e.setStartDate(p.StartDate);
       e.setEndDate(p.EndDate);
        
  		System.out.println("iddddddddd"+id);
  		System.out.println("OK");

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://"+GlobalEndPoint+"/api/Update?id="+id);
		Response response = target
		                 .request()
		                 .put(Entity.entity(e, MediaType.APPLICATION_JSON));
		   System.out.println(response);
		
	}

}
