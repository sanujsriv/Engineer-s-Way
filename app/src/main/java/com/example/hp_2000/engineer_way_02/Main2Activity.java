package com.example.hp_2000.engineer_way_02;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fm=getSupportFragmentManager();
    FragmentTransaction ft;
    View b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View b= findViewById(R.id.nav_imp_ques);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main2, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

       if (id == R.id.nav_imp_ques){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override


    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
     int id = item.getItemId();

        if (id == R.id.nav_prev_year) {
            Intent intent= new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://abesit.in/library/question-paper-bank"));
            startActivity(intent);
        } else if (id == R.id.nav_bank) {
            ft=fm.beginTransaction();
            ft.replace(R.id.container,new Frag_Bank(),"Frag_Bank");
                        ft.commit();
                    }
        else if (id == R.id.nav_syllabus) {
            //Intent intent= new Intent();
            //intent.setAction(Intent.ACTION_VIEW);
            //intent.setData(Uri.parse("https://aktu.ac.in/syllabus.html"));
            //startActivity(intent);

            ft=fm.beginTransaction();
            ft.replace(R.id.container,new Frag_Syll(),"Frag_Syllabus");
            ft.commit();
        }else if (id == R.id.nav_project) {
            ft=fm.beginTransaction();
            ft.replace(R.id.container,new Frag_Project(),"Frag_Project");
            ft.commit();
        }else if (id == R.id.nav_scholo) {
            ft=fm.beginTransaction();
            ft.replace(R.id.container,new Frag_scholo(),"Frag_scholo");
            ft.commit();
        }else if (id == R.id.nav_references) {
            ft=fm.beginTransaction();
            ft.replace(R.id.container,new Frag_Refer(),"Frag_Refer");
            ft.commit();
        }else if (id == R.id.nav_SciNews) {
            Intent intent= new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.gadgetsnow.com/computing"));
            startActivity(intent);
        }else if (id == R.id.nav_tech) {
            Intent intent= new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.computer.org/web/computingnow"));
            startActivity(intent);
        }else if (id == R.id.nav_gadget) {
            ft=fm.beginTransaction();
            ft.replace(R.id.container,new Frag_Gadget(),"Frag_Gadget");
            ft.commit();
        }else if (id == R.id.nav_imp_ques) {
            View menuitem=findViewById(R.id.tv1);

            showpop(menuitem);



        }else if (id == R.id.nav_learn) {ft=fm.beginTransaction();
            ft.replace(R.id.container,new Frag_what_to(),"Frag_what_to");
            ft.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        return true;
    }
    public void showpop(View view){
        PopupMenu p=new PopupMenu(this,view);
        getMenuInflater().inflate(R.menu.mymenu,p.getMenu());
        p.setGravity(Gravity.CENTER);

p.show();
        p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
              int  id=item.getItemId();
                if(id == R.id.cg){
                    Intent intent=new Intent(Main2Activity.this,CG_act.class);
                    startActivity(intent);
                }
                if(id == R.id.daa){
                    Intent intent=new Intent(Main2Activity.this,DAA_act.class);
                    startActivity(intent);
                }
                if(id == R.id.dld){
                    Intent intent=new Intent(Main2Activity.this,DLD_act.class);
                    startActivity(intent);
                }
                if(id == R.id.gt){
                    Intent intent=new Intent(Main2Activity.this,GT_act.class);
                    startActivity(intent);
                }
                if(id == R.id.ds){
                    Intent intent=new Intent(Main2Activity.this,DS_act.class);
                    startActivity(intent);
                }
                if(id == R.id.os){
                    Intent intent=new Intent(Main2Activity.this,A_OS_act.class);
                    startActivity(intent);
                }

                return false;
            }
        });
    }

    public void fun_rtgs(View v)
    {
        ft=fm.beginTransaction();
        ft.replace(R.id.container,new Frag_bank_rtgs(),"Frag_rtgs");
        ft.addToBackStack("Frag_bank");
        ft.commit();
    }
    public void fun_faq(View v)
    {
        ft=fm.beginTransaction();
        ft.replace(R.id.container,new Frag_bank_faq(),"Frag_faq");
        ft.addToBackStack("Frag_bank");
        ft.commit();
    }
    public void fun_neft(View v)
    {
        ft=fm.beginTransaction();
        ft.replace(R.id.container,new Frag_bank_neft(),"Frag_neft");
        ft.addToBackStack("Frag_bank");
        ft.commit();
    }
    public void fun_imt(View v)
    {
        ft=fm.beginTransaction();
        ft.replace(R.id.container,new Frag_bank_imt(),"Frag_imt");
        ft.addToBackStack("Frag_bank");
        ft.commit();
    }
    public void fun_beg(View v)
    {
        ft=fm.beginTransaction();
        ft.replace(R.id.container,new project_beg(),"Frag_beg");
        ft.addToBackStack("Frag_Project");
        ft.commit();

    }
    public void fun_interm(View v)
    {

        ft=fm.beginTransaction();
        ft.replace(R.id.container,new project_interm(),"Frag_interm");
        ft.addToBackStack("Frag_Project");
        ft.commit();
    }
    public void fun_adv(View v)
    {
        ft=fm.beginTransaction();
        ft.replace(R.id.container,new project_adv(),"Frag_adv");
        ft.addToBackStack("Frag_Project");
        ft.commit();

    }

}
