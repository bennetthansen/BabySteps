package edu.Drake.babysteps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChildSettingsActivity extends Activity {
	
private static final String TAG = "ChildSettingsActivity";
	
	Button buttonC;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child_settings);
		
		buttonC = (Button) findViewById(R.id.continueButton);
		buttonC.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Goes to MyListActivity when clicked
			Log.v(TAG, "button pressed");
			Intent intent = new Intent(v.getContext(), MyListsActivity.class);
			startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.child_settings, menu);
		return true;
	}

}
