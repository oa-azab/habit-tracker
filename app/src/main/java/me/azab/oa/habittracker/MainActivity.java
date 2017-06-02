package me.azab.oa.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import me.azab.oa.habittracker.data.HabitContract.HabitEntry;
import me.azab.oa.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDbHelper(this);
    }

    /**
     *  Add new habit to the database
     *
     * @param habitName name of the habit to be added
     * @param habitCount number of habit repeation
     */
    private void addHabit(String habitName, int habitCount){

        // Get database object to write on it
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create contentValues object
        ContentValues values = new ContentValues();
        values.put(HabitEntry.HABIT_COLUMN_NAME,habitName);
        values.put(HabitEntry.HABIT_COLUMN_COUNT,habitCount);

        // Insertion result
        long result = db.insert(HabitEntry.TABLE_NAME,null,values);
        String message = getString(R.string.error_message);
        if (result > -1) {
            message = getString(R.string.success_message) + result;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    /**
     * Method gets all records in database as cursor
     *
     * @return cursor database all records
     */
    private Cursor readAllHabits(){

        // Get database object to write on it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // to get a Cursor that contains all rows from the habit table.
        Cursor cursor = db.query(HabitEntry.TABLE_NAME, null, null, null, null, null, null);

        return cursor;
    }
}
