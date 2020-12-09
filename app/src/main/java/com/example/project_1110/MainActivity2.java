package com.example.project_1110;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity2 extends AppCompatActivity {

    private AutoCompleteTextView aTextView;
    private EditText editText;
    private String myResponse;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    private AutoSuggestAdapter autoSuggestAdapter;
    private Handler handler;
    private String countryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        aTextView = findViewById(R.id.autoCompleteTextView);
        editText = findViewById(R.id.editText);

        autoSuggestAdapter = new AutoSuggestAdapter(this, android.R.layout.simple_dropdown_item_1line);
        aTextView.setThreshold(2);
        aTextView.setAdapter(autoSuggestAdapter);
        aTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String str = parent.getAdapter().getItem(position).toString();
                countryId = autoSuggestAdapter.getCountryId(position);

                Toast.makeText(MainActivity2.this, countryId, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity2.this, str, Toast.LENGTH_SHORT).show();
            }
        });

        //Log.d("debug", "onCreate: "+autoSuggestAdapter.getItem(position_check));
        aTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                handler.removeMessages(100);
                handler.sendEmptyMessageDelayed(100, 300);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                if (msg.what == 100) {
                    if (!TextUtils.isEmpty(aTextView.getText())) {
                        //makeApiCall(autoCompleteTextView.getText().toString());
                        showCity(aTextView.getText().toString());
                    }
                }
                return false;
            }
        });

    }

    private void showCity(String s) {

        OkHttpClient client = new OkHttpClient();
        String url = "https://developers.zomato.com/api/v2.1/cities?q=" + s;
        Log.d("debug", "getRequest: " + url);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("user-key", "ff7f3ee52545d59dda1f760824402c5f")
                .addHeader("Accept", "application/json")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    List<String> stringList = new ArrayList<>();
                    List<String> stringIdList = new ArrayList<>();
                    try {
                        myResponse = response.body().string();
                        jsonObject = new JSONObject(myResponse);
                        jsonArray = jsonObject.getJSONArray("location_suggestions");
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject item = jsonArray.getJSONObject(i);
                            String cat = (String) item.get("name");
                            String id = Integer.toString((Integer) item.get("id"));
                            stringList.add(cat);
                            stringIdList.add(id);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    autoSuggestAdapter.setData(stringList);
                    autoSuggestAdapter.setId(stringIdList);
                }

                MainActivity2.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        autoSuggestAdapter.notifyDataSetChanged();

                    }
                });

            }
        });

    }

    public void onSearchClick(View view) {


        String s = editText.getText().toString();
        OkHttpClient client = new OkHttpClient();
        String url = "https://developers.zomato.com/api/v2.1/search?entity_id=" + countryId + "&entity_type=city&q=" + s;
        Log.d("debug", "getRequest: " + url);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("user-key", "ff7f3ee52545d59dda1f760824402c5f")
                .addHeader("Accept", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {

                    myResponse = response.body().string();
                    Log.d("debug", "onResponse: "+myResponse);


                    MainActivity2.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            //Intent secondActivity = new Intent(this, SecondActivity.class);
                            Intent secondActivity = new Intent(getApplicationContext(),SecondActivity.class);
                            //Bundle bundle = new Bundle();
                            //bundle.putParcelableArrayList("Restaurant",myResponse);
                            secondActivity.putExtra("RestaurantsList",myResponse);
                            secondActivity.putExtra("DineIn",false);
                            startActivity(secondActivity);

                        }
                    });


                }
            }


        });


    }

}