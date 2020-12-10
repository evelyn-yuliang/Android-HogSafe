package com.example.project_1110;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.Calendar;

public class BookTable extends AppCompatActivity {

    EditText etName, etAge;
    public static final String USER_PREF = "USER_PREF" ;
    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_COUNT = "KEY_COUNT";
    public static final String KEY_EMAIL = "KEY_EMAIL";
    public static final String KEY_TIME = "KEY_TIME";

    EditText name;
    EditText count;
    EditText time;
    EditText email;
    CheckBox buyOut;
    Button eventButton;

    String personName;
    String personCount;
    String personTime;
    String personEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booktable_form);
        name =  (EditText) findViewById(R.id.bookName);
        count = (EditText) findViewById(R.id.bookCount);
        time = (EditText) findViewById(R.id.bookTime);
        email = (EditText) findViewById(R.id.bookemailID);
        buyOut = (CheckBox) findViewById(R.id.buyOutCheckBox);

        eventButton = (Button) findViewById(R.id.planEvent);
        eventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 personName = name.getText().toString();
                 personCount = count.getText().toString();
                 personTime = time.getText().toString();
                 personEmail = email.getText().toString();

                Boolean buyOut_CheckBox = buyOut.isChecked();
                addEvent(personName,personCount,personTime,personEmail,buyOut_CheckBox);
            }
        });
    }


    public void addEvent(String name, String count, String time, String email, Boolean buyOut_Choice) {
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2020, 11, 10, 7, 30);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2020, 11, 10, 11, 30);
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.ALL_DAY, buyOut_Choice)
                .putExtra(CalendarContract.Events.TITLE, "Lunch at restaurant")
                .putExtra(CalendarContract.Events.DESCRIPTION,"Let's meet at restaurant,'Don't forget to wear mask!!'")
                .putExtra(Intent.EXTRA_EMAIL,email)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "Ottawa")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,beginTime.getTimeInMillis())
                .putExtra(CalendarContract.ACTION_EVENT_REMINDER,"5")
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void bookTable(View view) {
        Intent viewMenu = new Intent(this, MenuView.class);
        startActivity(viewMenu);


        Toast.makeText(this, "Booked Table!", Toast.LENGTH_SHORT).show();


    }
}
