package com.mylocalkart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by sourin on 7/18/15.
 */

public class HomeScreen extends AppCompatActivity implements View.OnTouchListener{

    private LinearLayout llMobilesAndTablets;
    private LinearLayout llKitchenAppliances;
    private LinearLayout llHomeAppliances;
    private LinearLayout llTvAndVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initialise();
    }

    private void initialise() {
        llMobilesAndTablets = (LinearLayout)findViewById(R.id.llMobilesAndTablets);
        llKitchenAppliances = (LinearLayout)findViewById(R.id.llKitchenAppliances);
        llHomeAppliances = (LinearLayout)findViewById(R.id.llHomeAppliances);
        llTvAndVideoPlayer = (LinearLayout)findViewById(R.id.llTvAndVideoPlayer);
        llMobilesAndTablets.setOnTouchListener(this);
        llKitchenAppliances.setOnTouchListener(this);
        llHomeAppliances.setOnTouchListener(this);
        llTvAndVideoPlayer.setOnTouchListener(this);
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

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP){
            switch(view.getId()){
                case R.id.llMobilesAndTablets:
                    Toast.makeText(getApplicationContext(), "Mobiles and Tablets", Toast.LENGTH_LONG).show();
                    break;
                case R.id.llKitchenAppliances:
                    Toast.makeText(getApplicationContext(), "Kitchen Appliances", Toast.LENGTH_LONG).show();
                    break;
                case R.id.llHomeAppliances:
                    Toast.makeText(getApplicationContext(), "Home Appliances", Toast.LENGTH_LONG).show();
                    break;
                case R.id.llTvAndVideoPlayer:
                    Toast.makeText(getApplicationContext(), "TV & Video Player", Toast.LENGTH_LONG).show();
                    break;
            }
        }
        return true;
    }
}
