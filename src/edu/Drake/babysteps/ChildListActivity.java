package edu.Drake.babysteps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChildListActivity extends Activity {
	
private static final String TAG = "ChildListActivity";
	
	Button buttonN;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child_list);
		
		buttonN = (Button) findViewById(R.id.nextButton);
		buttonN.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Goes to ChildSettingsActivity when clicked
			Log.v(TAG, "button pressed");
			Intent intent = new Intent(v.getContext(), ChildSettingsActivity.class);
			startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.child_list, menu);
		return true;
	}

}
