package com.example.project_1110;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_1110.DineIn;
import com.example.project_1110.DineOut;
import com.example.project_1110.R;

public class TakeoutDinein extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.takeoutdinein);

    }

    public void onDineInClick(View view) {
        Intent MainActivity = new Intent(this, MainActivity.class);
        startActivity(MainActivity);
    }

    public void onDineOutClick(View view) {
        Intent MainActivity2 = new Intent(this, MainActivity2.class);
        startActivity(MainActivity2);
    }
}
