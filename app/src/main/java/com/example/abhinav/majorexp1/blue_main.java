package com.example.abhinav.majorexp1;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class blue_main extends AppCompatActivity {

    Button btnbluetoothinfo,btnsendbluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_main);
        btnbluetoothinfo = (Button) findViewById(R.id.bluetooth_info);
        btnsendbluetooth = (Button) findViewById(R.id.bluetooth_send);

        btnbluetoothinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent direct_intent = new Intent(blue_main.this,bluetooth_info.class);
                startActivity(direct_intent);
            }
        });
        btnsendbluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("*/*");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                //icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                File f = new File(Environment.getExternalStorageDirectory() + File.separator + "MyCsvFile.csv");
                try {
                    f.createNewFile();
                    FileOutputStream fo = new FileOutputStream(f);
                    fo.write(bytes.toByteArray());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                share.setPackage("com.android.bluetooth");
                share.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///storage/self/primary/MyCsvFile.csv"));
                startActivity(Intent.createChooser(share, "Share Csv file"));
            }
        });
    }
}
