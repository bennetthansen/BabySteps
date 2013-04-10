package edu.Drake.babysteps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MyListsActivity extends Activity {
	
	Button newListButton;
	Button listDetailButton;
	ImageView backgroundImage;
	int listCount = 0;
	static boolean first = true;
	
	// Test comment

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_lists);
		
		listDetailButton = (Button) findViewById(R.id.listDetailButton);
		listDetailButton.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent(v.getContext(), ChecklistActivity.class);
        		startActivity(intent);
        	}
        });
		listDetailButton.setVisibility(View.GONE);
		
		if (!first) {
			Bundle extras = getIntent().getExtras();
			listCount = extras.getInt("listCount");
		}
		
		backgroundImage = (ImageView) findViewById(R.id.imageView1);
		if (listCount > 0) {
			backgroundImage.setImageResource(R.drawable.mylists);
			listDetailButton.setVisibility(View.VISIBLE);
		}
		
		newListButton = (Button) findViewById(R.id.newListButton);
        newListButton.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		first = false;
        		Intent intent = new Intent(v.getContext(), ListSettingsActivity.class);
        		intent.putExtra("listCount", (int)listCount);
        		startActivity(intent);
        	}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_lists, menu);
		return true;
	}

}
