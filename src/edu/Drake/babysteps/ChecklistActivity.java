package edu.Drake.babysteps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChecklistActivity extends Activity {
	
	Button backButton;
	Button newItemButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checklist);
		
		backButton = (Button) findViewById(R.id.backButton);
		backButton.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		finish();
        	}
        });
		
		newItemButton = (Button) findViewById(R.id.newItemButton);
		newItemButton.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent(v.getContext(), NewItemActivity.class);
        		startActivity(intent);
        	}
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.checklist, menu);
		return true;
	}

}
