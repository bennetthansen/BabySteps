package edu.Drake.babysteps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class ChildListActivity extends Activity {

	Button saveButton;
	Button cancelButton;
	private ListView childList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child_list);

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
		
		ChildList child_list_data[] = new ChildList[]
				{
				new ChildList("Bennett"),
				new ChildList("LeBron"),
				};

		ChildListAdapter adapter = new ChildListAdapter(this, R.layout.child_list_item, child_list_data);

		childList = (ListView)findViewById(R.id.childList);
		View header = (View)getLayoutInflater().inflate(R.layout.child_list_header, null);
		childList.addHeaderView(header);
		childList.setAdapter(adapter);

		childList.setOnItemLongClickListener(new OnItemLongClickListener() {
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Toast toast = Toast.makeText(getApplicationContext(), "Long press received", Toast.LENGTH_SHORT);
				toast.show();
				return true;
			}
		});
		childList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//Toast toast = Toast.makeText(getApplicationContext(), Integer.toString(position), Toast.LENGTH_SHORT);
				//toast.show();
				if (position == 0) {
					Intent intent = new Intent(getApplicationContext(), ChildSettingsActivity.class);
					startActivity(intent); 
				}
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
