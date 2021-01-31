package com.example.project_1110;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

    public void onViewCartClick(View view){
        Intent viewCartActivity = new Intent(getApplicationContext(),ViewCart.class);
        startActivity(viewCartActivity);
    }
}