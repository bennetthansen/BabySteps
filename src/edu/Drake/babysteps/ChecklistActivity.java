package edu.Drake.babysteps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ChecklistActivity extends Activity {
	
	Button backButton;
	Button newItemButton;
	private ListView checklist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
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
		
		Checklist checklist_data[] = new Checklist[]
				{
				new Checklist("Park", "03/04/13", "4 of 12 items"),
				new Checklist("Miami Vacation", "03/08/13", "7 of 21 items"),
				new Checklist("In-Laws", "03/14/13", "1 of 11 items"),
				new Checklist("Hiking Trip", "03/17/13", "1 of 1 items"),
				new Checklist("Day Care", "04/01/13", "3 of 9 items")
				};

		ChecklistAdapter adapter = new ChecklistAdapter(this, R.layout.checklist_item, checklist_data);

		checklist = (ListView)findViewById(R.id.checklistView);
		View header = (View)getLayoutInflater().inflate(R.layout.checklist_header, null);
        checklist.addHeaderView(header);
		checklist.setAdapter(adapter);
		
		checklist.setOnItemLongClickListener(new OnItemLongClickListener() {
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Toast toast = Toast.makeText(getApplicationContext(), "Long press received", Toast.LENGTH_SHORT);
				toast.show();
				return true;
			}
		});
		checklist.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//Intent intent = new Intent(getApplicationContext(), ChecklistActivity.class);
				//startActivity(intent);
				Toast toast = Toast.makeText(getApplicationContext(), "Press received", Toast.LENGTH_SHORT);
				toast.show();
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
