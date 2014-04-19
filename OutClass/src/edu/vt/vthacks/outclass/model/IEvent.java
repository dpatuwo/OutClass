package edu.vt.vthacks.outclass.model;

import java.util.Date;

public interface IEvent {
	public void setDescription(String description);
	public void setDate(Date date);
	public void setGeocode(String geocode);
	public void setLocation(String location);
	public void setCourse(ICourse course);
	
	public String getDescription();
	public Date getDate();
	public String getGeocode();
	public String getLocation();
	public ICourse getCourse();
}
