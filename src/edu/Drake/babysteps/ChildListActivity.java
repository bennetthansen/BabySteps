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

	Button addChildButton;
	Button editChildButton;
	Button saveButton;
	Button cancelButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child_list);

		addChildButton = (Button) findViewById(R.id.addChildButton);
		addChildButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Goes to ChildSettingsActivity when clicked
				Intent intent = new Intent(v.getContext(), ChildSettingsActivity.class);
				startActivity(intent);
			}
		});
		
		editChildButton = (Button) findViewById(R.id.editChildButton);
		editChildButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Goes to ChildSettingsActivity when clicked
				Intent intent = new Intent(v.getContext(), ChildSettingsActivity.class);
				startActivity(intent);
			}
		});

		saveButton = (Button) findViewById(R.id.saveButton);
		saveButton.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		cancelButton = (Button) findViewById(R.id.cancelButton);
		cancelButton.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				finish();
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
