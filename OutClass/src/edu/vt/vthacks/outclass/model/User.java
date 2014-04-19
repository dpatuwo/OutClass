package edu.vt.vthacks.outclass.model;

import com.parse.ParseObject;
import com.parse.ParseQuery;

public class User implements IUser {
	private String identity;
	private String name;
	ParseObject user;
	public void User()
	{
		user = new ParseObject("User");
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setIdentity(String indentity)
	{
		this.identity = indentity;
	}
	public String getName()
	{
		return this.name;
	}
	public String getIdentity()
	{
		return this.identity;
	}
	public boolean userExists(String identity)
	{
		ParseQuery<ParseObject> query = ParseQuery.getQuery("User");
		try
		{
			query.whereEqualTo("identifier", identity);
			if(query.getFirst() == null)
			{
				return false;
			}
			return true;
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
}
