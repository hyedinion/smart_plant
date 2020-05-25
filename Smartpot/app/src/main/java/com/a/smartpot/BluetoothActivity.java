package com.a.smartpot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BluetoothActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth);

        Button mainbutton=(Button)findViewById(R.id.main_button);
        mainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BluetoothActivity.this, FlowerActivity.class);
                startActivity(intent);
            }
        });
    }
}
