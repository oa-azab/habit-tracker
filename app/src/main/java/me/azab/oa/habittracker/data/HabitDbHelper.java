package me.azab.oa.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import me.azab.oa.habittracker.data.HabitContract.HabitEntry;

/**
 * Created by omar on 6/2/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    // Database name and version
    public final static String DATABASE_NAME = "habit_store.db";
    public final static int DATABASE_VERSION = 1;

    // SQL Create statement
    public final static String CREATE_DATABASE = "CREATE TABLE " + HabitEntry.TABLE_NAME + " ( "
            + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + HabitEntry.HABIT_COLUMN_NAME + " TEXT, "
            + HabitEntry.HABIT_COLUMN_COUNT + " INTEGER NOT NULL DEFAULT 0);";

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Execute sql statement to create database
        db.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
