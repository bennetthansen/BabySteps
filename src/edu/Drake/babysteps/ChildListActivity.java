package edu.Drake.babysteps;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ChildListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child_list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.child_list, menu);
		return true;
	}

}
