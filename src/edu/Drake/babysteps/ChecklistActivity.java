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
	Button optionsButton;
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
		
		optionsButton = (Button) findViewById(R.id.optionsButton);
		optionsButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(getApplicationContext(), "Opitons button clicked", Toast.LENGTH_SHORT);
				toast.show();
			}
		});

		Checklist checklist_data[] = new Checklist[]
				{
				new Checklist("Diapers", "8"),
				new Checklist("Pacifier", "1"),
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
