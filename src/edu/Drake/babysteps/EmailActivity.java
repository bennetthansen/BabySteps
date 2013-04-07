package edu.Drake.babysteps;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EmailActivity extends Activity {
	
	private static final String TAG = "EmailActivity";
	
	Button buttonSent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		
		//Code for send button
		buttonSent = (Button) findViewById(R.id.sendButton);
		buttonSent.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Goes to myList when clicked
			Log.v(TAG, "button pressed");
			Intent intent = new Intent(v.getContext(), MyListsActivity.class);
			startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.email, menu);
		return true;
	}

}
