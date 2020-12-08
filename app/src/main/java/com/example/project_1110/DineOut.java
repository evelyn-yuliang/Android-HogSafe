package com.example.project_1110;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DineOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_out);
    }

    public void onViewMenuClick(View view) {
        Intent viewMenu = new Intent(this, MenuView.class);
        startActivity(viewMenu);
    }

}