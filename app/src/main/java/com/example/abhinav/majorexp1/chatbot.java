package com.example.abhinav.majorexp1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class chatbot extends AppCompatActivity {
    TextView _txtNetwork;
    Button _btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);
        _txtNetwork = (TextView) findViewById(R.id.txtNet);
        _btnEmail = (Button) findViewById(R.id.btnSendEmail);
        _btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                if (intent.resolveActivity(getPackageManager())
                        != null)
                {
                    startActivity(intent);
                }
            }
        });
    }
}
