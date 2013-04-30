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
//import android.widget.NumberPicker;

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
				showSimplePopUp();
				return true;
			}
		});
		
		Button showPopUpButton = (Button) findViewById(R.id.showPopUpButton);
		showPopUpButton.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				showSimplePopUp();
				return true;
			}
		});
	}

	private void showSimplePopUp() {

		AlertDialog.Builder firstPopUp = new AlertDialog.Builder(this);
		//create a textview for centered title
		TextView titleMsg = new TextView(this);
		titleMsg.setText("Quantity");
		titleMsg.setGravity(Gravity.CENTER_HORIZONTAL);
		titleMsg.setTextSize(20);
		titleMsg.setTextColor(Color.parseColor("#15a7e1"));
		
		firstPopUp.setCustomTitle(titleMsg);
		//firstPopUp.setMessage("This is a Simple Pop Up");
		
	     /*NumberPicker qp = (NumberPicker) findViewById(R.id.npicker);
	     String[] n = new String[100];
	     for(int i=0; i<n.length; i++)
	            n[i] = Integer.toString(i);

	     qp.setMinValue(1);
	     qp.setMaxValue(n.length-1);
	     qp.setWrapSelectorWheel(false);
	     qp.setDisplayedValues(n);
	     qp.setValue(0);
	     firstPopUp.setView(qp); */

		firstPopUp.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				// Do nothing but close the dialog. Will become the ok button
			}
		});

		firstPopUp.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				//Nothing but close. Will be the cancel button
			}
		});

		// Remember, create doesn't show the dialog
		AlertDialog helpDialog = firstPopUp.create();
		helpDialog.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_item, menu);
		return true;
	}

}
