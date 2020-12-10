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
        Intent dineIn = new Intent(this, DineIn.class);
        startActivity(dineIn);
    }

    public void onDineOutClick(View view) {
        Intent dineOut = new Intent(this, DineOut.class);
        startActivity(dineOut);
    }
}
