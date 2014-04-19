package edu.vt.vthacks.outclass.model;

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
	public void getUserCourses(ParseObject user)
	{
		
	}
}
