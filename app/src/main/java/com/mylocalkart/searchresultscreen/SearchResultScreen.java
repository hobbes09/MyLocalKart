package com.mylocalkart.searchresultscreen;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mylocalkart.R;

public class SearchResultScreen extends AppCompatActivity implements ActionBar.TabListener{

    ImageView ivSearch;
    LinearLayout llFragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result_screen);
        customizeActionBar();
        initialize();
    }

    private void initialize(){
        llFragmentContainer = (LinearLayout)findViewById(R.id.llFragmentContainer);
    }

    private void customizeActionBar() {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.actionbar_search, null);
        ivSearch = (ImageView)mCustomView.findViewById(R.id.ivSearch);
        ivSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Search tool instantiated", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        // Adding tabs
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //ImageView ivTabAB;
        TextView tvTabAB;

        ActionBar.Tab resultTab = mActionBar.newTab();
        resultTab.setCustomView(R.layout.actionbar_tab);
        //ivTabAB = (ImageView)resultTab.getCustomView().findViewById(R.id.ivTabAB);
        //ivTabAB.setImageResource(R.drawable.search_icon);  // To be changed
        tvTabAB = (TextView)resultTab.getCustomView().findViewById(R.id.tvTabAB);
        tvTabAB.setText("Results");
        resultTab.setTabListener(this);
        mActionBar.addTab(resultTab);

        ActionBar.Tab filterTab = mActionBar.newTab();
        filterTab.setCustomView(R.layout.actionbar_tab);
        //ivTabAB = (ImageView)filterTab.getCustomView().findViewById(R.id.ivTabAB);
        //ivTabAB.setImageResource(R.drawable.search_icon);  // To be changed
        tvTabAB = (TextView)filterTab.getCustomView().findViewById(R.id.tvTabAB);
        tvTabAB.setText("Filter");
        filterTab.setTabListener(this);
        mActionBar.addTab(filterTab);

        ActionBar.Tab sortTab = mActionBar.newTab();
        sortTab.setCustomView(R.layout.actionbar_tab);
        //ivTabAB = (ImageView)sortTab.getCustomView().findViewById(R.id.ivTabAB);
        //ivTabAB.setImageResource(R.drawable.search_icon);  // To be changed
        tvTabAB = (TextView)sortTab.getCustomView().findViewById(R.id.tvTabAB);
        tvTabAB.setText("Sort");
        sortTab.setTabListener(this);
        mActionBar.addTab(sortTab);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        switch(tab.getPosition()){
            case 0:
                Toast.makeText(getApplicationContext(), "Search results Selected", Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SearchResultTabFragment searchResultTabFragment = new SearchResultTabFragment();
                fragmentTransaction.add(R.id.llFragmentContainer, searchResultTabFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "Filter Selected", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "Sort Selected", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_result_screen, menu);
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
}
