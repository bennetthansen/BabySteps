package edu.Drake.babysteps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
	public static final String KEY_LISTID = "listid";
	public static final String KEY_ITEMID = "itemid";
	public static final String KEY_LISTNAME = "listname";
	public static final String KEY_ITEMNAME = "itemname";
	public static final String KEY_WEATHER = "weather";
	public static final String KEY_TEMPERATURE = "temperature";
	public static final String KEY_QUANTITY = "quantity";
	public static final String KEY_CHILDREN = "children";
	private static final String TAG = "DBAdapter";

	private static final String DATABASE_NAME = "BabyStepsDB";
	private static final String DATABASE_LISTTABLE = "lists";
	private static final String DATABASE_ITEMTABLE = "items";
	private static final int DATABASE_VERSION = 1;

	private static final String LISTTABLE_CREATE = "create table if not exists lists "
			+ "(listid integer primary key autoincrement, "
			+ "listname VARCHAR not null, weather VARCHAR, temperature VARCHAR, children VARCHAR);";
	
	private static final String ITEMTABLE_CREATE = "create table if not exists items " 
			+ "(itemid integer primary key autoincrement, "
			+ "itemname VARCHAR not null, listname VARCHAR notnull, quantity INTEGER);";

	private final Context context;

	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;

	public DBAdapter(Context ctx) {
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			try {
				db.execSQL(LISTTABLE_CREATE);
				db.execSQL(ITEMTABLE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS contacts");
			onCreate(db);
		}
	}

	// opens the database
	public DBAdapter open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}

	// closes the database
	public void close() {
		DBHelper.close();
	}

	// insert a record into the database
	public long makeList(String listname, String weather,
				String temperature, String children) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_LISTNAME, listname);
		initialValues.put(KEY_WEATHER, weather);
		initialValues.put(KEY_TEMPERATURE, temperature);
		initialValues.put(KEY_CHILDREN, children);
		return db.insert(DATABASE_LISTTABLE, null, initialValues);
	}

	// deletes a list
	public boolean deletelist(long listId) {
		return db.delete(DATABASE_LISTTABLE, KEY_LISTID + "=" + listId, null) > 0;
	}
	
	// deletes items on a list
	public boolean deleteitem(long itemId) {
		return db.delete(DATABASE_ITEMTABLE, KEY_ITEMID + "=" + itemId, null) > 0;
	}

	// retrieves all the records
	public Cursor getAllRecords() {
		return db.query(DATABASE_LISTTABLE, new String[] { KEY_LISTID, KEY_LISTNAME,
				KEY_WEATHER, KEY_TEMPERATURE, KEY_CHILDREN }, null,
				null, null, null, null);
	}

	// retrieves a particular record
	public Cursor getRecord(long listId) throws SQLException {
		Cursor mCursor = db.query(true, DATABASE_LISTTABLE, new String[] {
				KEY_LISTID, KEY_LISTNAME, KEY_WEATHER, KEY_TEMPERATURE,
				KEY_CHILDREN }, KEY_LISTID + "=" + listId, null, null,
				null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	// updates a record
	public boolean updateRecord(long rowId, String listname, String weather,
			String temperature, String items, String children) {
		ContentValues args = new ContentValues();
		args.put(KEY_LISTNAME, listname);
		args.put(KEY_WEATHER, weather);
		args.put(KEY_TEMPERATURE, temperature);
		args.put(KEY_CHILDREN, children);
		return db.update(DATABASE_LISTTABLE, args, KEY_LISTID + "=" + rowId, null) > 0;
	}
}