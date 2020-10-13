package com.example.abhinav.majorexp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class after_login extends AppCompatActivity {

    ImageButton _earthquake,_drought,_flood,_landslide,_chatbot,_communication;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        _earthquake = (ImageButton) findViewById(R.id.earth_quake);
        _drought = (ImageButton) findViewById(R.id.drought);
        _flood = (ImageButton) findViewById(R.id.flood);
        _landslide = (ImageButton) findViewById(R.id.land_slide);
        _chatbot = (ImageButton) findViewById(R.id.chat_bot);
        _communication = (ImageButton) findViewById(R.id.communication_tab);

        _earthquake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent earthquake_intent = new Intent(after_login.this , earthquake.class);
                startActivity(earthquake_intent);
            }
        });
        _drought.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drought_intent = new Intent(after_login.this , earthquake.class);
                startActivity(drought_intent);
            }
        });
        _flood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flood_intent = new Intent(after_login.this,earthquake.class);
                startActivity(flood_intent);
            }
        });
        _landslide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent landslide_intent = new Intent(after_login.this,earthquake.class);
                startActivity(landslide_intent);
            }
        });
        _chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chatbot_intent = new Intent(after_login.this,chatbot.class);
                startActivity(chatbot_intent);
            }
        });
        _communication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent communication_intent = new Intent(after_login.this,types_of_comm.class);
                startActivity(communication_intent);
            }
        });
    }
}
