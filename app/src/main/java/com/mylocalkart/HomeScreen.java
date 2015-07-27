package com.mylocalkart;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity; // extended from android.support.v4.app.FragmentActivity
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by sourin on 7/18/15.
 */

public class HomeScreen extends AppCompatActivity{

    private static int NUM_ADS = 5;

    private ViewPager vpAds;
    private PagerAdapter mAdScreenSlidePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_home_screen);
        initialise();
    }

    private void initialise() {
        vpAds = (ViewPager)findViewById(R.id.vpAds);
        mAdScreenSlidePagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        vpAds.setAdapter(mAdScreenSlidePagerAdapter);
        vpAds.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When changing pages, reset the action bar actions since they
                // are dependent
                // on which page is currently active. An alternative approach is
                // to have each
                // fragment expose actions itself (rather than the activity
                // exposing actions),
                // but for simplicity, the activity provides the actions in this
                // sample.
                invalidateOptionsMenu();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A simple pager adapter that represents objects, in sequence.
     */
    public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return AdScreenSlidePageFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUM_ADS;
        }
    }

}
