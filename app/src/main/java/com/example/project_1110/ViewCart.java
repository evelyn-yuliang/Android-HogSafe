package com.example.project_1110;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_1110.dummy.DummyContent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ViewCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        String jsonRetreived = preferences.getString("CART_ITEMS","");
        Gson gson = new Gson();
        List<DummyContent.DummyItem> cartItems = new ArrayList<DummyContent.DummyItem>();
        if(jsonRetreived.length()>0) {
            Type listType = new TypeToken<List<DummyContent.DummyItem>>() {
            }.getType();
            cartItems = gson.fromJson(jsonRetreived, listType);
        }
        DummyContent.ITEMS=cartItems;
        ItemFragment itemFragment = new ItemFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.cart_item_list_frame, itemFragment, "itemFragment")
                .commit();
        calculateCost();
    }

    protected void calculateCost(){
        double totalCost = 0.0;
        for (int i=0;i<DummyContent.ITEMS.size();i++){
            totalCost += Double.parseDouble(DummyContent.ITEMS.get(i).itemQuantity) *
                    Double.parseDouble(DummyContent.ITEMS.get(i).itemCost.replace("$", ""));
        }
        TextView t = findViewById(R.id.totalCartCost);
        t.setText("$" + totalCost);
    }

    public void  onConfirmCheckoutClick(View view){
        Toast.makeText(this, "Cart Checkout Successful!", Toast.LENGTH_SHORT).show();
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
		editor.clear();
        editor.apply();
        Intent cartSuccessActivity = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(cartSuccessActivity);
    }
}