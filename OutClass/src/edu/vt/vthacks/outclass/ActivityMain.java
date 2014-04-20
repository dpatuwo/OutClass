package edu.vt.vthacks.outclass;
import android.widget.Toast;
import com.parse.ParseException;
import edu.vt.vthacks.outclass.model.User;
import android.provider.Settings.Secure;
import com.parse.ParseObject;
import android.content.DialogInterface;
import android.app.AlertDialog;
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

    public void info(View view) {
        new AlertDialog.Builder(this)
        .setTitle("App Info")
        .setMessage("Created for VTHacks by:\nTaylor Mattison\nDavid Patuwo\nAarathi Raghuraman\nCody Short\nSteve Smith")
        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
         })
        .setIcon(android.R.drawable.ic_dialog_info)
         .show();
    }

    public void settings(View view) {
        Toast.makeText(getApplicationContext(), "Settings not implemented in the Dev Version...   :(",
            Toast.LENGTH_LONG).show();
    }
}