package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Jeffrey on 21-7-2017.
 */

public final class HabitContract {
    private HabitContract(){}

    public final class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_DESCRIPTION = "description";
        public static final String COLUMN_HABIT_MONDAY = "monday";
        public static final String COLUMN_HABIT_TUESDAY = "tuesday";
        public static final String COLUMN_HABIT_WEDNESDAY = "wednesday";
        public static final String COLUMN_HABIT_THURSDAY = "thursday";
        public static final String COLUMN_HABIT_FRIDAY = "friday";
        public static final String COLUMN_HABIT_SATURDAY = "saturday";
        public static final String COLUMN_HABIT_SUNDAY = "sunday";
    }

    public final class HabitLogEntry implements BaseColumns {

        public static final String TABLE_NAME = "habitlogs";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_LOG_ID = "habitid";
        public static final String COLUMN_HABIT_LOG_DATE = "date";
        public static final String COLUMN_HABIT_LOG_EXECUTED = "executed";
    }
}
