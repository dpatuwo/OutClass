package edu.vt.vthacks.outclass;

import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;
public class MainActivity
    extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(this, "OYugFg9KyTgg2RwnV2v8pHgYa0eUClG05YPqOOp3", "GhL4mJVwtKnodiUSUMlSpCH08rCmOelMJpX9wa4S");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;


    }

}
