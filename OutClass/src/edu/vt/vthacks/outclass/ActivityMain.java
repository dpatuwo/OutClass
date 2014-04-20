package edu.vt.vthacks.outclass;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import com.parse.Parse;
import android.app.Activity;
import android.os.Bundle;

public class ActivityMain extends Activity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createGroup(View view) {
        Intent intent = new Intent(this, CreateGroupActivity.class);
        startActivity(intent);
    }

    public void viewScheduledGroup(View view) {
        Intent intent = new Intent(this, ScheduledGroupActivity.class);
        startActivity(intent);
    }

    public void yourGroups(View view) {
        Intent intent = new Intent(this, YourGroupsActivity.class);
        startActivity(intent);
    }

    public void addClass(View view) {
        Intent intent = new Intent(this, AddClassActivity.class);
        startActivity(intent);
    }
}