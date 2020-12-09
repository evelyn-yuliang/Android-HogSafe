package com.example.project_1110;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DineIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);
    }

    public void onViewMenuClick(View view) {
        Intent viewMenu = new Intent(this, MenuView.class);
        startActivity(viewMenu);
    }

    public void startTable(View view) {
        Intent viewMenu = new Intent(this, BookTable.class);
        startActivity(viewMenu);
    }


    public void onJoinTable(View view) {
        Log.d("test","here");
        Intent viewMenu = new Intent(this, JoinTable.class);
        startActivity(viewMenu);
    }
}