package edu.Drake.babysteps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

public class MyListsActivity extends Activity {

	Button newListButton;
	//ListView lv = null;
	private ListView listView1;
	TextView tutorialText;
	public static ArrayList<PackingList> packing_list_data = new ArrayList<PackingList>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_lists);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String name = extras.getString("name");
			String date = new SimpleDateFormat("MM/dd/yy").format(new Date());
			packing_list_data.add(new PackingList(name, date, "0 of 0"));
		}

		tutorialText = (TextView) findViewById(R.id.tutorialTextView);

		newListButton = (Button) findViewById(R.id.newListButton);
		newListButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), ListSettingsActivity.class);
				startActivity(intent);
			}
		});

		/*PackingList packing_list_data[] = new PackingList[]
				{
				new PackingList("Park", "03/04/13", "4 of 12 items"),
				new PackingList("Miami Vacation", "03/08/13", "7 of 21 items"),
				new PackingList("In-Laws", "03/14/13", "1 of 11 items"),
				new PackingList("Hiking Trip", "03/17/13", "1 of 1 items"),
				new PackingList("Day Care", "04/01/13", "3 of 9 items")
				};*/

		PackingListAdapter adapter = new PackingListAdapter(this, R.layout.list_item, packing_list_data);

		if (!packing_list_data.isEmpty()) {
			tutorialText.setVisibility(TextView.INVISIBLE);
			listView1 = (ListView)findViewById(R.id.listView1);
			listView1.setAdapter(adapter);
			listView1.setOnItemLongClickListener(new OnItemLongClickListener() {
				public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
					/*Context context = getApplicationContext();
				CharSequence text = "Hello toast!";
				int duration = Toast.LENGTH_SHORT;*/

					//Displays dialog when held down
					showlistPopUp();

					return true;
				}
			});
			listView1.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					Intent intent = new Intent(getApplicationContext(), ChecklistActivity.class);
					startActivity(intent);
				}
			});
		}
		else {
			tutorialText.setVisibility(TextView.VISIBLE);
		}

		/*this.lv = getListView();
		String[] packing_lists = getResources().getStringArray(R.array.packing_lists);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.listName, packing_lists));
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(getApplicationContext(), ChecklistActivity.class);
				startActivity(intent);
			}
		});*/
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

				//Toast.makeText(getApplicationContext(), "U clicked "+optionsList[which], Toast.LENGTH_LONG).show();
			}
		});

		AlertDialog listDialog = listPopUp.create();
		listDialog.show();

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

		holdPopUp.setItems(optionsList, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// The 'which' argument contains the index position
				// of the selected item

				//Toast.makeText(getApplicationContext(), "U clicked "+optionsList[which], Toast.LENGTH_LONG).show();
			}
		});

		// Remember, create doesn't show the dialog
		AlertDialog helpDialog = holdPopUp.create();
		helpDialog.show();

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_lists, menu);
		return true;
	}

}