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
        Parse.initialize(this, "OYugFg9KyTgg2RwnV2v8pHgYa0eUClG05YPqOOp3", "GhL4mJVwtKnodiUSUMlSpCH08rCmOelMJpX9wa4S");

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
}