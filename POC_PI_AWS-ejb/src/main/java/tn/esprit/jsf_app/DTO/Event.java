package tn.esprit.jsf_app.DTO;

public class Event {
	
	public int EventId;
	public String Name; 
	public String Picture;
	public String Theme;
	public String Location;
	public String StartDate;
	public String EndDate;
	private static final long serialVersionUID = 1L;
	public Event() {
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "Event [EventId=" + EventId + ", Name=" + Name + ", Picture=" + Picture + ", Theme=" + Theme
				+ ", Location=" + Location + ", StartDate=" + StartDate + ", EndDate=" + EndDate + "]";
	}
	public Event( String name, String picture, String theme, String location, String startDate,
			String endDate) {
		
		Name = name;
		Picture = picture;
		Theme = theme;
		Location = location;
		StartDate = startDate;
		EndDate = endDate;
	}
	public Event(int eventId, String name, String picture, String theme, String location) {
		super();
		EventId = eventId;
		Name = name;
		Picture = picture;
		Theme = theme;
		Location = location;
		
	}
	
}
