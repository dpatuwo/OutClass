package edu.vt.vthacks.outclass.model;

public interface ICourse {
	public void setTitle(String title);
	public void setNumber(int number);
	public void setSubject(String subject);
	
	public String getTitle();
	public int getNumber();
	public String getSubject();
}
