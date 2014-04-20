package edu.vt.vthacks.outclass;
import android.widget.Toast;
import com.parse.ParseException;
import edu.vt.vthacks.outclass.model.Event;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Date;
import android.content.Intent;
import java.util.List;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.parse.ParseObject;
import edu.vt.vthacks.outclass.model.User;
import edu.vt.vthacks.outclass.model.UserCourse;

public class CreateGroupActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_group_layout);
        queryClasses();
    }

    private void queryClasses() {
        //Code for getting users classes
        List<String> spinnerArray =  new ArrayList<String>();
         User user = new User();
         UserCourse courses = new UserCourse();
         ParseObject parseUser = user.getParseObjectFromID(Secure.getString(getContentResolver(), Secure.ANDROID_ID));
         try{
             for(ParseObject userCourse : courses.getUserCourses(parseUser))
             {
                String cTitle = ((ParseObject)userCourse.get("course")).get("course_title").toString();
                String cSubject = ((ParseObject)userCourse.get("course")).get("course_subject").toString();
                spinnerArray.add(cTitle);
             }
         } catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         Spinner sItems = (Spinner) findViewById(R.id.class_spinner);
         sItems.setAdapter(adapter);
    }

    public void create(View view) {
        Spinner spin = (Spinner)findViewById(R.id.class_spinner);
        System.out.println(spin.getSelectedItem().toString());
        Event e = new Event();
        try
        {
            EditText location = (EditText)findViewById(R.id.location_editText);
            EditText description = (EditText)findViewById(R.id.description_editText);
            String subject = ((Spinner)findViewById(R.id.class_spinner)).getSelectedItem().toString();
            String date = ((DatePicker)findViewById(R.id.datePicker)).getMonth() + "/" + ((DatePicker)findViewById(R.id.datePicker)).getDayOfMonth() + "/" + (((DatePicker)findViewById(R.id.datePicker)).getYear() - 2000);
            e.createEvent(location.getText().toString(), date, description.getText().toString(), subject);
            Toast.makeText(getApplicationContext(), "Event created!",
                Toast.LENGTH_LONG).show();
        }
        catch (ParseException e1)
        {
            Toast.makeText(getApplicationContext(), "Failed to create event.",
                Toast.LENGTH_LONG).show();
            e1.printStackTrace();
        }

        Intent i = new Intent(getApplicationContext(), ActivityMain.class);
        startActivity(i);
    }
}