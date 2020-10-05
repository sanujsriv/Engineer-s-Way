package com.example.hp_2000.engineer_way_02;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Tab_activity extends AppCompatActivity {

           /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_activity);
        setTitle("Tools");

              Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPagerAdapter with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

            }

    public void fun_clip(View view)

    {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("be.bdwm.clipsync");
        if(launchIntent!=null)
        {
            startActivity(launchIntent);
        }
        else
        {
            Intent intent= new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=be.bdwm.clipsync&hl=en&referrer=utm_source%3Dgoogle%26utm_medium%3Dorganic%26utm_term%3Dclipsync&pcampaignid=APPU_1_IuL-WcL6EYjXvASo8ZCYAg"));
            startActivity(intent);

        }
    }
       public void fun_imgr(View view)

    {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.sybu.imageresizer");
        if(launchIntent!=null)
        {
            startActivity(launchIntent);
        }
        else
        {
            Intent intent= new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.sybu.imageresizer&hl=en&referrer=utm_source%3Dgoogle%26utm_medium%3Dorganic%26utm_term%3Dimage+resizer+and+compressor+app&pcampaignid=APPU_1_EOP-WbGdCMn7vgTW9Zto"));
            startActivity(intent);
        }

    }
    public void fun_qr(View view)
    {
        Intent intent= new Intent(Tab_activity.this,QR_Scanner.class);
        startActivity(intent);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    Frag_Tab_clip clip= new Frag_Tab_clip();
                    return clip;
                case 1:
                    Frag_Tab_QR qr= new Frag_Tab_QR();
                    return qr;
                case 2:
                    Frag_Tab_Resizer rs= new Frag_Tab_Resizer();
                    return rs;
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Clip Sync";
                case 1:
                    return "All Scanner";
                case 2:
                    return "Image Resizer";
            }
            return null;
        }
    }
}
