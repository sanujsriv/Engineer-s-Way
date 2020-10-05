package com.example.hp_2000.engineer_way_02;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main_query extends AppCompatActivity {

    FragmentManager fm=getSupportFragmentManager();
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_query);
    }

    public void fun_scholo(View view)
    {
        ft=fm.beginTransaction();
        ft.replace(R.id.container_q,new Frag_scholo(),"Frag_Scholo");
        ft.commit();
    }
    public void fun_Gadgets(View view)
    {
        ft=fm.beginTransaction();
        ft.replace(R.id.container_q,new Frag_Gadget(),"Frag_Gadgets");
        ft.commit();

    }
    public void fun_bank(View view)
    {
        ft=fm.beginTransaction();
        ft.replace(R.id.container_q,new Frag_Bank(),"Frag_Bank");
        ft.commit();

    }

}
