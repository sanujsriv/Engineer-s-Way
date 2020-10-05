package com.example.hp_2000.engineer_way_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class A_OS_act extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a__os_act);
        textView=(TextView) findViewById(R.id.tv_os);
        loaddatafromassest();


    }

    public void loaddatafromassest()
    {
        try{

            InputStream is1 = getAssets().open("OS.txt");
            int size1 = is1.available();
            byte[] buffer1 = new byte[size1];
            is1.read(buffer1);
            is1.close();
            textView.setText(new String(buffer1));
        }
        catch(IOException e){


        }

    }
}
