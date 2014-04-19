package edu.vt.vthacks.outclass;

import com.parse.Parse;

import edu.vt.vthacks.outclass.model.User;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class TestActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		 	super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_test);
		  Parse.initialize(this, "OYugFg9KyTgg2RwnV2v8pHgYa0eUClG05YPqOOp3", "GhL4mJVwtKnodiUSUMlSpCH08rCmOelMJpX9wa4S");
		  User user = new User();
		  if(user.userExists("tellmethisdoesn'texist"))
		  {
			  System.out.println("user exists");
		  }
		  else
		  {
			  System.out.println("user does not exist");
		  }
	}
}
