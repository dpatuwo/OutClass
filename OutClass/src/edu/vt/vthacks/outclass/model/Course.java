package edu.vt.vthacks.outclass.model;

public class Course implements ICourse{

	private String cSubject;
	private int cNumber;
	private String cTitle;
	private int cCRN;
	@Override
	public void setSubject(String subject) {
		cSubject = subject;
	}

	@Override
	public void setNumber(int number) {
		cNumber = number;
	}

	@Override
	public void setTitle(String title) {
		cTitle = title;
	}

	@Override
	public void setCRN(int crn) {
		cCRN = crn;
	}

	@Override
	public String getSubject() {
		return cSubject;
	}

	@Override
	public String getNumber() {
		return ""+cNumber;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return cTitle;
	}

	@Override
	public int getCRN() {
		return cCRN;
	}

}
