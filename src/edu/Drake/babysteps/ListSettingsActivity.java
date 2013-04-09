package edu.Drake.babysteps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ListSettingsActivity extends Activity {
	
	Button saveButton;
	Button cancelButton;
	int listCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_settings);
		
		Bundle extras = getIntent().getExtras();
		listCount = extras.getInt("listCount");
		
		saveButton = (Button) findViewById(R.id.button1);
        saveButton.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		listCount++;
        		Intent intent = new Intent(v.getContext(), MyListsActivity.class);
        		intent.putExtra("listCount", (int)listCount);
        		startActivity(intent);
        	}
        });
        
        cancelButton = (Button) findViewById(R.id.button2);
        cancelButton.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		finish();
        	}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_settings, menu);
		return true;
	}

}
