package edu.Drake.babysteps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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
				
				showlistPopUp();
				
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

				if (position != 0) {
					holdItemDownPopUp();
				}

				return true;
			}
		});
		checklist.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if (position == 0) {
					Intent intent = new Intent(getApplicationContext(), NewItemActivity.class);
					startActivity(intent); 
				}
			}
		});

	}

	private void showlistPopUp() {
		AlertDialog.Builder listPopUp = new AlertDialog.Builder(this);
		final CharSequence[] optionsList = {"Edit", "Email", "Delete"};

		listPopUp.setItems(optionsList, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// The 'which' argument contains the index position
				// of the selected item
				switch (which) {
				case 0:
					break;
				case 1:
					emailPopUp();
					break;
				case 2:
					deletePopup();
					break;
				}

			}
		});

		AlertDialog listDialog = listPopUp.create();
		listDialog.show();

	}
	
	private void holdItemDownPopUp() {

		AlertDialog.Builder holdPopUp = new AlertDialog.Builder(this);
		final CharSequence[] optionsList = {"Edit", "Delete"};

		holdPopUp.setItems(optionsList, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// The 'which' argument contains the index position
				// of the selected item
				switch (which)
				{
				case 0:
					break;
				case 1:
					deletePopup();
					break;

				}
				//Toast.makeText(getApplicationContext(), "U clicked "+optionsList[which], Toast.LENGTH_LONG).show();
			}
		});

		// Remember, create doesn't show the dialog
		AlertDialog helpDialog = holdPopUp.create();
		helpDialog.show();
	}
	
	private void emailPopUp() {

		AlertDialog.Builder holdPopUp = new AlertDialog.Builder(this);
		final CharSequence[] optionsList = {"Yahoo!", "Gmail"};

		holdPopUp.setItems(optionsList, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// The 'which' argument contains the index position
				// of the selected item

				Toast.makeText(getApplicationContext(), "Email successfully sent", Toast.LENGTH_LONG).show();
			}
		});

		// Remember, create doesn't show the dialog
		AlertDialog helpDialog = holdPopUp.create();
		helpDialog.show();
		
	}

	private void deletePopup() {

		AlertDialog.Builder deletePopUp = new AlertDialog.Builder(this);
		//create a textview for centered title
		TextView titleMsg = new TextView(this);
		titleMsg.setText("Are you sure you want to delete this item?");
		titleMsg.setGravity(Gravity.CENTER_HORIZONTAL);
		titleMsg.setTextSize(20);
		titleMsg.setTextColor(Color.parseColor("#15a7e1"));
		deletePopUp.setCustomTitle(titleMsg);

		deletePopUp.setPositiveButton("Delete", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				// Do nothing but close the dialog. Will become the delete button
			}
		});

		deletePopUp.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				//Nothing but close. Will be the cancel button
			}
		});

		// Remember, create doesn't show the dialog
		AlertDialog createDialog = deletePopUp.create();
		createDialog.show();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.checklist, menu);
		return true;
	}

}
