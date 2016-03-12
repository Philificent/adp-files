package com.dutsonpa.activitycallback;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* This activity is called whenever the application is started
        * any variables you need as well as static assets should be
        * created in this method
        */
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
        // This method runs either before onStop() or onResume()
    }
    @Override
    protected void onResume() {
        super.onResume();
        // This method happens right before the activity is officially running
    }
    @Override
    protected void onPause() {
        super.onPause();
        /* This method runs when the application is about to be terminated for
        * memory, or when the activity is changed or interrupted by another
        * activity such as a phone call. This is the method to use to save
        * data and changes
        */
    }
    @Override
    protected void onStop() {
        super.onStop();
        // This method runs when the activity is stopped but not yet destroyed
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Last call before the activity and any data it has will be destroyed
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
}
