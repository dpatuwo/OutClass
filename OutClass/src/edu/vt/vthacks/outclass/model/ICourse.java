package edu.vt.vthacks.outclass.model;

public interface ICourse {
	public void setSubject(String subject);
	public void setNumber(int number);
	public void setTitle(String title);
	public void setCRN(int crn);
	
	public String getSubject();
	public String getNumber();
	public String getTitle();
	public int getCRN();
}
