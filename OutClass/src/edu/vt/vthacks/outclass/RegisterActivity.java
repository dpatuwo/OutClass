package edu.vt.vthacks.outclass;
import com.parse.ParseObject;
import android.provider.Settings.Secure;
import android.widget.Toast;
import edu.vt.vthacks.outclass.model.User;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import com.parse.Parse;
import android.app.Activity;
import android.os.Bundle;

public class RegisterActivity extends Activity
{
    User user;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        Parse.initialize(this, "OYugFg9KyTgg2RwnV2v8pHgYa0eUClG05YPqOOp3", "GhL4mJVwtKnodiUSUMlSpCH08rCmOelMJpX9wa4S");
        user = new User();
        if(user.userExists(Secure.getString(getContentResolver(), Secure.ANDROID_ID))) {
            ParseObject p = user.getParseObjectFromID(Secure.getString(getContentResolver(), Secure.ANDROID_ID));
            Toast.makeText(getApplicationContext(), "Welcome back " + p.get("name"),
                Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ActivityMain.class);
            startActivity(intent);
        }
    }

    public void begin(View view) {
        Intent intent = new Intent(this, ActivityMain.class);
        EditText textView = (EditText) findViewById(R.id.name_field);
        String text = textView.getText().toString();
        //code for seeing whether or not a user exists and adding a user
        try
        {
            user.create(Secure.getString(getContentResolver(), Secure.ANDROID_ID), text);
            startActivity(intent);
        } catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "Error creating user.",
                Toast.LENGTH_LONG).show();
          System.out.println(e.getMessage());
        }
    }
}