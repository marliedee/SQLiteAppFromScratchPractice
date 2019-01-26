package org.pursuit.sqliteappfromscratch.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.pursuit.sqliteappfromscratch.model.Notes;

import java.util.ArrayList;
import java.util.List;

public class SQLiteSingleton extends SQLiteOpenHelper {

    private static SQLiteSingleton databaseInstance;
    private static final String NAME = "NOTES_DATABASE.db";
    private static final int SCHEMA_VERSION = 1;
    private static final String TABLE_NAME = "NOTES";

    private SQLiteSingleton(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static synchronized SQLiteSingleton getInstance(Context context){

        if (databaseInstance==null){
            databaseInstance = new SQLiteSingleton(context.getApplicationContext(),NAME,null,SCHEMA_VERSION);
        }
        return databaseInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT, message TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Not in use.
    }

    public void addNotes(Notes notes) {
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE name = '" + notes.getName() +
                        "' AND message = '" + notes.getMessage() +
                        "';", null);
        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(name, message) VALUES('" +
                    notes.getName() + "', '" +
                    notes.getMessage() + "');");
        }
        cursor.close();
    }

    public List<Notes> getNoteList() {
        List<Notes> noteList = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + ";", null);
        if(cursor != null) {
            if(cursor.moveToFirst()) {
                do {
                    Notes note = new Notes(
                            cursor.getString(cursor.getColumnIndex("name")),
                            cursor.getString(cursor.getColumnIndex("message")));
                    noteList.add(note);
                } while (cursor.moveToNext());
            }
        }
        return noteList;
    }

}