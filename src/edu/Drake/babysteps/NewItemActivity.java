package edu.Drake.babysteps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;



public class NewItemActivity extends Activity {

	Button saveButton;
	Button cancelButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_item);

		saveButton = (Button) findViewById(R.id.saveButton);
		saveButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		//Code for Top Cancel button
		cancelButton = (Button) findViewById(R.id.cancelButton);
		cancelButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {		
				finish();
			}
		});

		TextView number = (TextView) findViewById(R.id.itemNumber);
		number.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				holdItemDownPopUp();
				return true;
			}
		});

		Button showPopUpButton = (Button) findViewById(R.id.showPopUpButton);
		showPopUpButton.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				//calls the list menu function
				showlistPopUp();
				return true;
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
				switch (which)
				{
				case 0:
					break;
				case 1:
					emailPopUp();
					break;
				case 2:
					deletePopup();
					break;
				
				}
				
				//Toast.makeText(getApplicationContext(), "U clicked "+optionsList[which], Toast.LENGTH_LONG).show();
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
	
	private void deletePopup() {
		
		AlertDialog.Builder deletePopUp = new AlertDialog.Builder(this);
		//create a textview for centered title
		TextView titleMsg = new TextView(this);
		titleMsg.setText("Are you sure you want to delete this list?");
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
	
	private void emailPopUp() {

		AlertDialog.Builder holdPopUp = new AlertDialog.Builder(this);
		final CharSequence[] optionsList = {"Yahoo!", "Gmail"};
		/*
		final Item[] optionsList = {
				new Item("yahoo", android.R.drawable.ic_menu_add), 
				new Item("gmail", android.R.drawable.ic_menu_delete)
				};
		*/
		holdPopUp.setItems(optionsList, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// The 'which' argument contains the index position
				// of the selected item

				
			}
		});

		// Remember, create doesn't show the dialog
		AlertDialog helpDialog = holdPopUp.create();
		helpDialog.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_item, menu);
		return true;
	}

}
