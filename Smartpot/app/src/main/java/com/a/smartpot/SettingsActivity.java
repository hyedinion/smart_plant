package com.a.smartpot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        final EditText et1=(EditText)findViewById(R.id.edit1);
        final EditText et2=(EditText)findViewById(R.id.edit2);
        final EditText et3=(EditText)findViewById(R.id.edit3);
        Button button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BluetoothActivity)BluetoothActivity.context).bt.send(et1.getText().toString(), true);//온도
                ((BluetoothActivity)BluetoothActivity.context).bt.send(et2.getText().toString(), true);//조도
                ((BluetoothActivity)BluetoothActivity.context).bt.send(et3.getText().toString(), true);//습도
                Intent intent=new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

}
