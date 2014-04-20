package edu.vt.vthacks.outclass.model;

import java.util.ArrayList;
import java.util.List;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class UserEvent {
	ParseObject parseObject = new ParseObject("UserEvent");
	public void addEvent(String userID, String crn) throws ParseException
	{
		User user = new User();
		Course course = new Course();
		
		parseObject.put("user", user.getParseObjectFromID(userID));
		parseObject.put("event", course.getParseObjectFromCRN(crn));
		parseObject.save();
	}
	public List<ParseObject> getUserEvents(ParseObject user)
	{
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("UserEvent");
		query.whereEqualTo("user", user);
		query.include("event");
		List<ParseObject> events = new ArrayList<ParseObject>();
		try{
			events = query.find();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return events;
	}
}
