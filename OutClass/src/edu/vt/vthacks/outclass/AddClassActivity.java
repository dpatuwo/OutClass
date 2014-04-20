package edu.vt.vthacks.outclass;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.ParseException;
import com.parse.ParseObject;
import edu.vt.vthacks.outclass.model.Course;
import edu.vt.vthacks.outclass.model.User;
import edu.vt.vthacks.outclass.model.UserCourse;

public class AddClassActivity extends Activity
{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_class_layout);
        queryClasses();

    }

    private void queryClasses() {
        //Code for getting users classes

         User user = new User();
         UserCourse courses = new UserCourse();
         ParseObject parseUser = user.getParseObjectFromID(Secure.getString(getContentResolver(), Secure.ANDROID_ID));
         try{
             String concat = "";
             for(ParseObject userCourse : courses.getUserCourses(parseUser))
             {
                String cSubject = ((ParseObject)userCourse.get("course")).get("course_subject").toString();
                String cTitle = ((ParseObject)userCourse.get("course")).get("course_title").toString();
                System.out.println("Sub: " + cSubject + "  Title: " + cTitle);
                concat = concat.concat(cTitle + '\n');
             }
             ((TextView)findViewById(R.id.class_list_label)).setText(concat);
         } catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
    }

    public void addClass(View view) {
        String s = ((EditText)findViewById(R.id.crn_edittext)).getText().toString();
        UserCourse u = new UserCourse();
        Course tempCourse = new Course();
        if(!tempCourse.courseExists(s)) {
            Toast.makeText(getApplicationContext(), "Please enter a valid CRN.",
                Toast.LENGTH_LONG).show();
            return;
        }
        try
        {
            u.addCourse(Secure.getString(getContentResolver(), Secure.ANDROID_ID), s);
            ((EditText)findViewById(R.id.crn_edittext)).setText("");
            Toast.makeText(getApplicationContext(), "Course added!",
                Toast.LENGTH_LONG).show();
            queryClasses();
        }
        catch (ParseException e)
        {
            Toast.makeText(getApplicationContext(), "Error adding class.",
                Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void done(View view) {
        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);
    }
}