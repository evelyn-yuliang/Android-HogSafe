package com.example.project_1110;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MenuView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_view);
        ItemFragment itemFragment = new ItemFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.menu_item_list_frame, itemFragment, "itemFragment")
                .commit();
    }
}