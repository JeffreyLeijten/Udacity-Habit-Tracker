package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.habittracker.data.HabitContract.HabitEntry;
import com.example.android.habittracker.data.HabitContract.HabitLogEntry;

/**
 * Created by Jeffrey on 21-7-2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "habitTracker.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + "("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_DESCRIPTION + " TEXT, "
                + HabitEntry.COLUMN_HABIT_MONDAY + " INTEGER NOT NULL DEFAULT 0, "
                + HabitEntry.COLUMN_HABIT_TUESDAY + " INTEGER NOT NULL DEFAULT 0, "
                + HabitEntry.COLUMN_HABIT_WEDNESDAY + " INTEGER NOT NULL DEFAULT 0, "
                + HabitEntry.COLUMN_HABIT_THURSDAY + " INTEGER NOT NULL DEFAULT 0, "
                + HabitEntry.COLUMN_HABIT_FRIDAY + " INTEGER NOT NULL DEFAULT 0, "
                + HabitEntry.COLUMN_HABIT_SATURDAY + " INTEGER NOT NULL DEFAULT 0, "
                + HabitEntry.COLUMN_HABIT_SUNDAY + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_HABITS_TABLE);

        String SQL_CREATE_HABITS_LOG_TABLE = "CREATE TABLE " + HabitLogEntry.TABLE_NAME + "("
                + HabitLogEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitLogEntry.COLUMN_HABIT_LOG_ID + " INTEGER NOT NULL, "
                + HabitLogEntry.COLUMN_HABIT_LOG_DATE + " TEXT NOT NULL, "
                + HabitLogEntry.COLUMN_HABIT_LOG_EXECUTED + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_HABITS_LOG_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
