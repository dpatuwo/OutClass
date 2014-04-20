package edu.vt.vthacks.outclass;
import android.widget.ListView;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import com.parse.Parse;
import android.app.Activity;
import android.os.Bundle;

public class YourGroupsActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_groups_layout);
    }

    public void getDetails(View view) {
        Intent intent = new Intent(this, ViewDetails.class);
        ListView textView = (ListView) findViewById(R.id.viewGroups_listView);
        startActivity(intent);
    }
}