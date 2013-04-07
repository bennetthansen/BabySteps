package edu.Drake.babysteps;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NewItemActivity extends Activity {

private static final String TAG = "NewItemActivity";
	
	Button buttonS;
	Button buttonC;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_item);
		buttonS = (Button) findViewById(R.id.saveButton);
		buttonS.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Goes to myListActivity when clicked
			Log.v(TAG, "button pressed");
			Intent intent = new Intent(v.getContext(), MyListsActivity.class);
			startActivity(intent);
			}
		});
		
		//Code for Top Cancel button
		buttonC = (Button) findViewById(R.id.cancelButton);
		buttonC.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v)
			{		
				// Goes to myListActivity when clicked
				Log.v(TAG, "button pressed");
				Intent intent2 = new Intent(v.getContext(), MyListsActivity.class);
				startActivity(intent2);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_item, menu);
		return true;
	}

}
