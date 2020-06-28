package com.a.smartpot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FlowerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flower);

        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //안시리움
                String data = "0 50 65";
                ((BluetoothActivity)BluetoothActivity.context).bt.send(data, true);
                Intent intent=new Intent(FlowerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //솔레이롤리아
                String data = "0 50 65";
                ((BluetoothActivity)BluetoothActivity.context).bt.send(data, true);
                Intent intent=new Intent(FlowerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //꽃베고니아
                String data = "0 70 75";
                ((BluetoothActivity)BluetoothActivity.context).bt.send(data, true);
                Intent intent=new Intent(FlowerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button button4=(Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //몬스테라
                String data = "0 50 75";
                ((BluetoothActivity)BluetoothActivity.context).bt.send(data, true);
                Intent intent=new Intent(FlowerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button button5=(Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //러브체인
                String data = "0 50 35";
                ((BluetoothActivity)BluetoothActivity.context).bt.send(data, true);
                Intent intent=new Intent(FlowerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button button6=(Button)findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //드라세나 산데리아나
                String data = "0 40 55";
                ((BluetoothActivity)BluetoothActivity.context).bt.send(data, true);
                Intent intent=new Intent(FlowerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button button7=(Button)findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FlowerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
