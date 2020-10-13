package com.example.abhinav.majorexp1;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.Os;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Build;
import android.support.annotation.NonNull;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class earthquake extends AppCompatActivity {
    EditText food_supply,water_supply,clothes,Injured_people;
    EditText people_stuck,people_rescued,surr_environment;
    EditText blue_infra,Zig_infra,wifi_infra,lora_infra,_strength,_frequency;
    TextView disaster_table,basic_parameter,food_supply_tv,water_supply_tv;
    TextView clothes_supply_tv,injury_tv,people_stuck_tv,people_rescued_tv,Surrounding_enviro_tv;
    TextView Infrastructure_tv,blue_infra_tv,zig_infra_tv,wifi_infra_tv,lora_infra_tv,time_delay_tv;
    TextView strength_tv,frequency_tv;
    Button save;
    Button btn_start, btn_stop;
    TextView textView;
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onResume() {
        super.onResume();
        if(broadcastReceiver == null){
            broadcastReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {

                    textView.append(" " +intent.getExtras().get("coordinates"));

                }
            };
        }
        registerReceiver(broadcastReceiver,new IntentFilter("location_update"));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(broadcastReceiver != null){
            unregisterReceiver(broadcastReceiver);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);
        btn_start = (Button) findViewById(R.id.button);
        btn_stop = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.textView);
        disaster_table = (TextView) findViewById(R.id.disaster_table);
        basic_parameter = (TextView) findViewById(R.id.Basic_parameters);
        food_supply_tv = (TextView) findViewById(R.id.food_supply_tv);
        water_supply_tv = (TextView) findViewById(R.id.water_supply_tv);
        clothes_supply_tv = (TextView) findViewById(R.id.clothes_supply_tv);
        injury_tv = (TextView) findViewById(R.id.injury_tv);
        people_stuck_tv = (TextView) findViewById(R.id.People_stuck_tv);
        people_rescued_tv = (TextView) findViewById(R.id.people_rescued_tv);
        Surrounding_enviro_tv = (TextView) findViewById(R.id.Surrounding_environment_tv);
        Infrastructure_tv = (TextView) findViewById(R.id.infrastructure_tv);
        blue_infra_tv =(TextView) findViewById(R.id.blue_infrastructure_tv);
        zig_infra_tv = (TextView) findViewById(R.id.zig_infrastructure_tv);
        wifi_infra_tv = (TextView) findViewById(R.id.wifi_infrastructure_tv);
        lora_infra_tv = (TextView) findViewById(R.id.lora_infrastructure_tv);
        time_delay_tv = (TextView)  findViewById(R.id.time_delay_tv);
        strength_tv = (TextView) findViewById(R.id.strength_tv);
        frequency_tv = (TextView) findViewById(R.id.frequency_tv);
        food_supply = (EditText) findViewById(R.id.food_supply);
        water_supply = (EditText) findViewById(R.id.water_supply);
        clothes = (EditText) findViewById(R.id.Clothes);
        Injured_people = (EditText) findViewById(R.id.Injured);
        people_stuck = (EditText) findViewById(R.id.People_stuck);
        people_rescued = (EditText) findViewById(R.id.people_rescued);
        surr_environment = (EditText) findViewById(R.id.Surrounding_environment);
        blue_infra = (EditText) findViewById(R.id.blue_infrastructure);
        Zig_infra = (EditText) findViewById(R.id.Zig_infrastructure);
        wifi_infra = (EditText) findViewById(R.id.wifi_infrastructure);
        lora_infra = (EditText) findViewById(R.id.lora_infrastructure);
        _strength = (EditText) findViewById(R.id.strength);
        _frequency = (EditText) findViewById(R.id.frequency);
        if(!runtime_permissions())
            enable_buttons();
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(ContextCompat.checkSelfPermission(earthquake.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
                {
                   ActivityCompat.requestPermissions(earthquake.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
                }
                else
                {
                    String csv = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyCsvFile.csv");
                    CSVWriter writer = null;
                    try {

                        writer = new CSVWriter(new FileWriter(csv,true));
                        String food_s = food_supply.getText().toString();
                        String water_s = water_supply.getText().toString();
                        String cloth = clothes.getText().toString();
                        String injur_people = Injured_people.getText().toString();
                        String p_stuck = people_stuck.getText().toString();
                        String p_rescued = people_rescued.getText().toString();
                        String cordinates = textView.getText().toString();
                        String s_enviro = surr_environment.getText().toString();
                        String blue_if = blue_infra.getText().toString();
                        String zig_if = Zig_infra.getText().toString();
                        String wifi_if = wifi_infra.getText().toString();
                        String lora_if = lora_infra.getText().toString();
                        String strength_td = _strength.getText().toString();
                        String freq_td = _frequency.getText().toString();
                        String row[] = new String[]{food_s,water_s,cloth,injur_people,p_stuck,p_rescued,cordinates,s_enviro,blue_if,zig_if,wifi_if,lora_if,strength_td,freq_td};
                        writer.writeNext(row);
                        writer.close();
                        Toast.makeText(earthquake.this,"Success",Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

            }
        });
    }

    private void enable_buttons() {

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),GPS_Service.class);
                startService(i);
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),GPS_Service.class);
                stopService(i);

            }
        });

    }

    private boolean runtime_permissions() {
        if(Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},100);

            return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 100){
            if( grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                enable_buttons();
            }else {
                runtime_permissions();
            }
        }
    }

}
