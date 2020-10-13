package com.example.abhinav.majorexp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class types_of_comm extends AppCompatActivity {

    TextView _txt01,_txt02,_txt03;
    ImageButton _img_direct,_img_bluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_of_comm);

        _txt01 = (TextView) findViewById(R.id.comm_txt_01);
        _txt02 = (TextView) findViewById(R.id.comm_txt_02);
        _txt03 = (TextView) findViewById(R.id.comm_txt_03);
        _img_direct = (ImageButton) findViewById(R.id.wifi_direct_icon);
        _img_bluetooth = (ImageButton) findViewById(R.id.bluetooth_icon);

        _img_direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent direct_intent = new Intent(types_of_comm.this,wifi_direct_main.class);
                startActivity(direct_intent);
            }
        });
        _img_bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent blue_intent = new Intent(types_of_comm.this,blue_main.class);
                    startActivity(blue_intent);
            }
        });
    }
}
