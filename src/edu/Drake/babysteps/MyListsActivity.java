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
import android.widget.TextView;
import android.widget.Toast;

public class MyListsActivity extends Activity {

	Button newListButton;
	//ListView lv = null;
	private ListView listView1;
	public static boolean noLists = true;
	TextView tutorialText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_lists);
		
		tutorialText = (TextView) findViewById(R.id.tutorialTextView);

		newListButton = (Button) findViewById(R.id.newListButton);
		newListButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				noLists = false;
				Intent intent = new Intent(v.getContext(), ListSettingsActivity.class);
				startActivity(intent);
			}
		});

		PackingList packing_list_data[] = new PackingList[]
				{
				new PackingList("Park", "03/04/13", "4 of 12 items"),
				new PackingList("Miami Vacation", "03/08/13", "7 of 21 items"),
				new PackingList("In-Laws", "03/14/13", "1 of 11 items"),
				new PackingList("Hiking Trip", "03/17/13", "1 of 1 items"),
				new PackingList("Day Care", "04/01/13", "3 of 9 items")
				};

		PackingListAdapter adapter = new PackingListAdapter(this, R.layout.list_item, packing_list_data);

		if (!noLists) {
			tutorialText.setVisibility(TextView.INVISIBLE);
			listView1 = (ListView)findViewById(R.id.listView1);
			listView1.setAdapter(adapter);
			listView1.setOnItemLongClickListener(new OnItemLongClickListener() {
				public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
					/*Context context = getApplicationContext();
				CharSequence text = "Hello toast!";
				int duration = Toast.LENGTH_SHORT;*/

					Toast toast = Toast.makeText(getApplicationContext(), "Long press received", Toast.LENGTH_SHORT);
					toast.show();
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_lists, menu);
		return true;
	}

}