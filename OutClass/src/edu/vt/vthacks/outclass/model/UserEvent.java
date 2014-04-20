package edu.vt.vthacks.outclass.model;

import java.util.ArrayList;
import java.util.List;
import android.provider.Settings.Secure;
import android.widget.TextView;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import edu.vt.vthacks.outclass.R;

public class UserEvent
{
    ParseObject parseObject = new ParseObject("UserEvent");


    public List<ParseObject> getUserEvents(ParseObject user)
    {

        UserCourse courses = new UserCourse();
        ArrayList<ParseObject> events = new ArrayList<ParseObject>();
        try
        {
            for (ParseObject userCourse : courses.getUserCourses(user))
            {
                String cSubject =
                    ((ParseObject)userCourse.get("course")).get("course_title")
                        .toString();
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
                query.whereEqualTo("course_title", cSubject);
                events.addAll(query.find());
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return events;

    }
}
