package com.example.project_1110;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onDineInClick(View view) {
        Intent dineIn = new Intent(this, DineIn.class);
        startActivity(dineIn);
    }

    public void onDineOutClick(View view) {
        Intent dineOut = new Intent(this, DineOut.class);
        startActivity(dineOut);
    }

    public void onSearchClick(View view) {
        Intent search = new Intent(this, SecondActivity.class);
        startActivity(search);
    }
}