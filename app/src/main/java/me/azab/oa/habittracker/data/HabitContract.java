package me.azab.oa.habittracker.data;

/**
 * Created by omar on 6/2/2017.
 */

import android.provider.BaseColumns;

/**
 * Contract class defines the Habit tracker database
 */
public final class HabitContract {

    // Private constructor
    private HabitContract() {
    }

    /**
     * Inner Class represent the Habit table in the database
     */
    public final static class HabitEntry implements BaseColumns {

        // Table name
        public static final String TABLE_NAME = "habits";

        // Column names
        public final static String _ID = BaseColumns._ID;
        public final static String HABIT_COLUMN_NAME = "name";
        public final static String HABIT_COLUMN_COUNT = "count";

    }
}
