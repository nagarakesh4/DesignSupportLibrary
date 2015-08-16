package com.venkata.dsl;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private FloatingActionButton mFloatingActionButton;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set the toolbar
        setupToolBar();

        //set the fab
        setupFab();

        //set the tabs
        setupTabs();
    }

    public void setupToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);

        //show menu icon
        final ActionBar mActionBar = getSupportActionBar();
        mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        mActionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void setupFab() {
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        mFloatingActionButton.setOnClickListener(this);
    }

    public void setupTabs(){
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.addTab(mTabLayout.newTab().setText("Movies"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Notes"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Storage"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onClick(View view) {
        if(view.getId() == R.id.fab){
            Snackbar.make(
                    findViewById(R.id.rootLayout),
                    "You have clicked on fab to see this text on snack bar",
                    Snackbar.LENGTH_LONG).
                    setAction("Action", this)
                    .show();
        }
    }
}
