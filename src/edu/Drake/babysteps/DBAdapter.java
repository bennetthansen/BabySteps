package edu.Drake.babysteps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
	public static final String KEY_ROWID = "id";
	public static final String KEY_LISTNAME = "listname";
	public static final String KEY_ITEMS = "items";
	public static final String KEY_CHILDREN = "children";
	private static final String TAG = "DBAdapter";

	private static final String DATABASE_NAME = "BabystepsDB";
	private static final String DATABASE_TABLE = "lists";
	private static final int DATABASE_VERSION = 2;

	private static final String DATABASE_CREATE = "create table if not exists lists "
			+ "(id integer primary key autoincrement, "
			+ "listname VARCHAR not null, items VARCHAR, children VARCHAR);";

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
				db.execSQL(DATABASE_CREATE);
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
	public long insertRecord(String listname, String items, String children) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_LISTNAME, listname);
		initialValues.put(KEY_ITEMS, items);
		initialValues.put(KEY_CHILDREN, children);
		return db.insert(DATABASE_TABLE, null, initialValues);
	}

	// deletes a particular record
	public boolean deleteContact(long rowId) {
		return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	// retrieves all the records
	public Cursor getAllRecords() {
		return db.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_LISTNAME,
				KEY_ITEMS, KEY_CHILDREN }, null, null, null, null, null);
	}

	// retrieves a particular record
	public Cursor getRecord(long rowId) throws SQLException {
		Cursor mCursor = db.query(true, DATABASE_TABLE, new String[] {
				KEY_ROWID, KEY_LISTNAME, KEY_ITEMS, KEY_CHILDREN }, KEY_ROWID
				+ "=" + rowId, null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	// updates a record
	public boolean updateRecord(long rowId, String listname, String items,
			String children) {
		ContentValues args = new ContentValues();
		args.put(KEY_LISTNAME, listname);
		args.put(KEY_ITEMS, items);
		args.put(KEY_CHILDREN, children);
		return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}