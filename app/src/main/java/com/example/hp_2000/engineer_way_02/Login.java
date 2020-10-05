package com.example.hp_2000.engineer_way_02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText ed1,ed2;
    String name,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed1 = (EditText) findViewById(R.id.edit_name);
        ed2 = (EditText) findViewById(R.id.edit_pass);

    }

    public void fun_login(View v)
    {
        name = ed1.getText().toString();
        password = ed2.getText().toString();
        SharedPreferences sp=getSharedPreferences("sp_name",MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        e.putString("name",name);
        e.putString("password",password);
        if(name.contentEquals("Sanuj") && password.contentEquals("Saransh")) {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.documentsui");
            if (launchIntent != null) {
                startActivity(launchIntent);
                Toast.makeText(this, "Welcome "+name, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Documents App Not Found!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Invalid User!", Toast.LENGTH_SHORT).show();
        }
    }
}
