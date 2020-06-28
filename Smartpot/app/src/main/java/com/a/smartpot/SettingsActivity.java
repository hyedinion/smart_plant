package com.a.smartpot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        ((BluetoothActivity)BluetoothActivity.context).bt.send("2", true);

        final EditText et2=(EditText)findViewById(R.id.edit2);
        final EditText et3=(EditText)findViewById(R.id.edit3);
        Button button=(Button)findViewById(R.id.button);

        ((BluetoothActivity)BluetoothActivity.context).bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() { //데이터 수신
            public void onDataReceived(byte[] data, String message) {
                Toast.makeText(SettingsActivity.this, message, Toast.LENGTH_SHORT).show();
                String[] array = message.split(" ");
                for(int i =0; i<array.length; i++){
                    if (i==0){
                        et2.setText(array[1]);
                    }
                    else {
                        et3.setText(array[0]);
                    }
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "0 "+et2.getText().toString()+" "+et3.getText().toString()+" ";
                ((BluetoothActivity)BluetoothActivity.context).bt.send(data, true);//습도
                Intent intent=new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

}
