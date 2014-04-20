package edu.vt.vthacks.outclass.model;

import android.widget.Toast;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class Event {
	public void createEvent(String location, String date, String description, String course_subj) throws ParseException
	{
		ParseObject event = new ParseObject("Event");
		event.put("location", location);
		event.put("date", date);
		event.put("description", description);
		event.put("course_subj", course_subj);
		event.save();

	}
	public List<ParseObject> getCourseEvents(String crn)
	{
		Course course = new Course();
		ParseObject tempCourse = course.getParseObjectFromCRN(crn);
		String subject = (String)tempCourse.get("course_subject");
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
		query.whereEqualTo("course_subj", subject);
		List<ParseObject> events = new ArrayList<ParseObject>();
		try{
			events = query.find();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return events;
	}
	public ParseObject getParseObjectFromObjectID(String ID)
	{
		
	}

}
