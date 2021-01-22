package tn.esprit.jsf_app.presentation.mbeans;

import java.io.IOException;
import java.util.Date;
import java.util.List;


import javax.faces.bean.ManagedBean;


import tn.esprit.jsf_app.DTO.*;
import tn.esprit.jsf_app.services.EventService;


public class EventBean {
	private int EventId;
	private String Name; 
	private String Picture;
	private String Theme;
	private String Location;
	private String StartDate;
	private String EndDate;
	private List<Event> Event;
	private static final long serialVersionUID = 1L;
	
	EventService E = new EventService();
	
	public List<Event> getEvent() {
		return Event;
	}


	public void setEvent(List<Event> event) {
		Event = event;
	}


	public List<Event> getEvents() {
		Event=E.GetAll();
		return Event;
	}
	
	public String supprimer(Event e){
		E.Delete(e);
		return "event.jsf";
		
		
	}
	
	public String addEvent()  {
		E.Create(new Event(Name, Picture,Theme, Location,StartDate, EndDate));
		return "event.jsf";

	}
	
public String modifier(Event e) throws IOException{
		
		this.setEventId(e.getEventId());
		this.setName(e.getName());
		this.setPicture(e.getPicture());
		this.setTheme(e.getTheme());
		this.setLocation(e.getLocation());
		this.setStartDate(e.getStartDate());
		this.setEndDate(e.getEndDate());
		System.out.println(e.getEventId());
		
		return "edit.jsf";
		
		
	}

public String MAJEvent(){
	
	E.Update(EventId,new Event(Name, Picture,
			 Theme,
			 Location,
			 StartDate,
			 EndDate));
	Event = E.GetAll();

	return "event.jsf";
}
	
	



	public int getEventId() {
		return EventId;
	}


	public void setEventId(int eventId) {
		EventId = eventId;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getPicture() {
		return Picture;
	}


	public void setPicture(String picture) {
		Picture = picture;
	}


	public String getTheme() {
		return Theme;
	}


	public void setTheme(String theme) {
		Theme = theme;
	}


	public String getLocation() {
		return Location;
	}


	public void setLocation(String location) {
		Location = location;
	}


	public String getStartDate() {
		return StartDate;
	}


	public void setStartDate(String startDate) {
		StartDate = startDate;
	}


	public String getEndDate() {
		return EndDate;
	}


	public void setEndDate(String endDate) {
		EndDate = endDate;
	}


	public EventService getE() {
		return E;
	}


	public void setE(EventService e) {
		E = e;
	}
	
	
}