package com.example.hp_2000.engineer_way_02;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    FragmentManager fm=getSupportFragmentManager();
    FragmentTransaction ft;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 2500;
    int NUM_PAGES=5;


       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           viewPager = (ViewPager) findViewById(R.id.viewpager);
            viewPagerAdapter = new ViewPagerAdapter(this);
           viewPager.setAdapter(viewPagerAdapter);

           final Handler handler = new Handler();
           final Runnable Update = new Runnable() {
               public void run() {
                   if (currentPage == NUM_PAGES-1) {
                       currentPage = 0;
                   }
                   viewPager.setCurrentItem(currentPage++, true);
               }
           };

           timer = new Timer(); // This will create a new Thread
           timer .schedule(new TimerTask() { // task to be scheduled

               @Override
               public void run() {
                   handler.post(Update);
               }
           }, DELAY_MS, PERIOD_MS);
       }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void fun_lets_start(View v)
   {
       Intent intent= new Intent(MainActivity.this,Main2Activity.class);
       startActivity(intent);

   }
   public void fun_tool(View v)
   {
       Intent intent= new Intent(MainActivity.this,Tab_activity.class);
       startActivity(intent);
   }
    public void fun_mydrive(View v)
    {

        startActivity(new Intent(MainActivity.this,Login.class));
        }

   public void fun_query(View v)
   {
       Intent intent = new Intent(MainActivity.this,Main_query.class);
       startActivity(intent);

   }
   public void fun_about(View v)
   {
      new AlertDialog.Builder(this).setTitle("Developed By:-").setIcon(R.mipmap.ic_launcher_round).setMessage("Team Members:-\n 1. Sanuj Kumar \n 2. Saransh Gupta \n\n\n Tutor: Saurabh Taneja ").setPositiveButton("OK", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
              setVisible(true);
          }
      }).create().show();

   }


    public void fun_scholo(View view)
    {
        ft=fm.beginTransaction();
        ft.replace(R.id.cont_main,new Frag_scholo(),"Frag_Scholo");
        ft.commit();
    }
    public void fun_Gadgets(View view)
    {
        ft=fm.beginTransaction();
        ft.replace(R.id.cont_main,new Frag_Gadget(),"Frag_Gadgets");
        ft.commit();

    }
    public void fun_bank(View view)
    {
        ft=fm.beginTransaction();
        ft.replace(R.id.cont_main,new Frag_Bank(),"Frag_Bank");
        ft.commit();

    }


}

