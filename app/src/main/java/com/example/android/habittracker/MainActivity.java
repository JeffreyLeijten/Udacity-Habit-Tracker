package com.example.android.habittracker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.android.habittracker.data.HabitContract.HabitEntry;

import com.example.android.habittracker.data.HabitMethods;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button insertButton = (Button) findViewById(R.id.insert_button);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertDummyHabit();
            }
        });

        Button readButton = (Button) findViewById(R.id.read_button);
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printFirstHabit();
            }
        });
    }

    public void insertDummyHabit(){
        boolean[] daysOfWeek = {true, false, false, true, true, false, true};
        HabitMethods.insertHabit(this, "Brushing Teeth", "It's brushing teeth, nothing else to it", daysOfWeek);
    }

    public void printFirstHabit(){
        Cursor cursor = HabitMethods.getHabit(this, 1);

        TextView displayView = (TextView) findViewById(R.id.result_text_view);

        try {
            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
            int descriptionColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_DESCRIPTION);
            int mondayColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_MONDAY);
            int tuesdayColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_TUESDAY);
            int wednesdayColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_WEDNESDAY);
            int thursdayColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_THURSDAY);
            int fridayColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_FRIDAY);
            int saturdayColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_SATURDAY);
            int sundayColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_SUNDAY);

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentDescription = cursor.getString(descriptionColumnIndex);
                int currentMonday = cursor.getInt(mondayColumnIndex);
                int currentTuesday = cursor.getInt(tuesdayColumnIndex);
                int currentWednesday = cursor.getInt(wednesdayColumnIndex);
                int currentThursday = cursor.getInt(thursdayColumnIndex);
                int currentFriday = cursor.getInt(fridayColumnIndex);
                int currentSaturday = cursor.getInt(saturdayColumnIndex);
                int currentSunday = cursor.getInt(sundayColumnIndex);

                // Display the values from each column of the current row in the cursor in the TextView
                displayView.setText((currentID + "\n" +
                        currentName + "\n" +
                        currentDescription + "\n" +
                        "Monday: " + currentMonday + "\n" +
                        "Tuesday: " + currentTuesday + "\n" +
                        "Wednesday: " + currentWednesday + "\n" +
                        "Thursday: " + currentThursday + "\n" +
                        "Friday: " + currentFriday + "\n" +
                        "Saturday: " + currentSaturday + "\n" +
                        "Sunday: " + currentSunday));
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }
}
