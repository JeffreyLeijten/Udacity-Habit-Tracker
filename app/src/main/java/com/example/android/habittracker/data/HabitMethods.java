package com.example.android.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.android.habittracker.data.HabitContract.HabitEntry;

/**
 * Created by Jeffrey on 21-7-2017.
 */

public final class HabitMethods {
    public static void insertHabit(Context context, String habitName, String habitDescription, boolean[] daysOfWeek) {
        // Create database helper
        HabitDbHelper mDbHelper = new HabitDbHelper(context);

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and pet attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, habitName);
        values.put(HabitEntry.COLUMN_HABIT_DESCRIPTION, habitDescription);
        values.put(HabitEntry.COLUMN_HABIT_MONDAY, daysOfWeek[0]);
        values.put(HabitEntry.COLUMN_HABIT_TUESDAY, daysOfWeek[1]);
        values.put(HabitEntry.COLUMN_HABIT_WEDNESDAY, daysOfWeek[2]);
        values.put(HabitEntry.COLUMN_HABIT_THURSDAY, daysOfWeek[3]);
        values.put(HabitEntry.COLUMN_HABIT_FRIDAY, daysOfWeek[4]);
        values.put(HabitEntry.COLUMN_HABIT_SATURDAY, daysOfWeek[5]);
        values.put(HabitEntry.COLUMN_HABIT_SUNDAY, daysOfWeek[6]);

        // Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(context, "Error with saving habit", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(context, "Habit saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    public static Cursor getHabit(Context context, int habitId){
        // Create database helper
        HabitDbHelper mDbHelper = new HabitDbHelper(context);

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_DESCRIPTION,
                HabitEntry.COLUMN_HABIT_MONDAY,
                HabitEntry.COLUMN_HABIT_TUESDAY,
                HabitEntry.COLUMN_HABIT_WEDNESDAY,
                HabitEntry.COLUMN_HABIT_THURSDAY,
                HabitEntry.COLUMN_HABIT_FRIDAY,
                HabitEntry.COLUMN_HABIT_SATURDAY,
                HabitEntry.COLUMN_HABIT_SUNDAY };

        String selection = HabitEntry._ID + "=?";

        String[] selectionArgs = {Integer.toString(habitId)};

        // Perform a query on the habits table
        Cursor cursor = db.query(
                HabitEntry.TABLE_NAME, // The table to query
                projection,            // The columns to return
                selection,             // The columns for the WHERE clause
                selectionArgs,         // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                 // The sort order

        return cursor;
    }
}
