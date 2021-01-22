package tn.esprit.jsf_app.services;

import java.util.List;
import java.io.StringReader;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.jsf_app.DTO.Rayon;
import tn.esprit.jsf_app.interfaces.RayonServiceLoc;

public class RayonService implements RayonServiceLoc {

	public RayonService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Rayon> getAll() {
		// TODO Auto-generated method stub
		EntityManager em ;
		List<Rayon>  lasp = new ArrayList<Rayon>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:6415/api/Rayons"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	
    	 
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		Rayon m = new Rayon();
    	 //String dateString;
       	 m.setId(object.getJsonObject(i).getInt("RayonID")); 
    	 m.setProductName(object.getJsonObject(i).getString("ProductName")); 
    	 m.setRayonType(object.getJsonObject(i).getString("RayonType")); 
    	 lasp.add(m);
    	}
    	

return lasp;   
	}

	@Override
	public void Create(Rayon p) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:6415/api/RayonPost");
		WebTarget hello =target.path("");
		
		Response response =hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON) );
		
		
		String result=response.readEntity(String.class);
		System.out.println(result);
		
		

		response.close();
	}

	@Override
	public void DelRequest(int id) {
		// TODO Auto-generated method stub
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:6415/api/Rayons/"+id); 
		WebTarget hello = target.path("");     	
    	Response res=(Response) hello.request().delete();
	}

	@Override
	public void Update(int id, Rayon pv) {
		// TODO Auto-generated method stub
		
	}

}
