package edu.vt.vthacks.outclass.model;

import java.util.ArrayList;
import java.util.List;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class UserCourse {
	ParseObject parseObject;
	public UserCourse()
	{
		parseObject = new ParseObject("UserCourse");
	}
	public void addCourse(String userID, String crn) throws ParseException
	{
		User user = new User();
		Course course = new Course();
		
		parseObject.put("user", user.getParseObjectFromID(userID));
		parseObject.put("course", course.getParseObjectFromCRN(crn));
		parseObject.save();
	}
	public List<ParseObject> getUserCourses(ParseObject user)
	{
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("UserCourse");
		query.whereEqualTo("user", user);
		query.include("course");
		List<ParseObject> courses = new ArrayList<ParseObject>();
		try{
			courses = query.find();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return courses;
	}
}
