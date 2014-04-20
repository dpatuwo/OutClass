package edu.vt.vthacks.outclass;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import com.parse.Parse;
import android.app.Activity;
import android.os.Bundle;

public class RegisterActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
    }

    public void begin(View view) {
        Intent intent = new Intent(this, ActivityMain.class);
        EditText textView = (EditText) findViewById(R.id.name_field);
        String text = textView.getText().toString();
        startActivity(intent);
    }
}