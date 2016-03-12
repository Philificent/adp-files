package com.dutsonpa.mylocation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button buttonFineLocation;
    Button buttonCoarseLocation;
    MyLocationService myLocationService;
    TextView textViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResults = (TextView)findViewById(R.id.textViewResults);
        myLocationService = new MyLocationService(MainActivity.this);

        // set up GPS button click
        buttonFineLocation = (Button) findViewById(R.id.buttonFineLocation);
        buttonFineLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Location fineLocation = myLocationService.getLocation(LocationManager.GPS_PROVIDER);

                if (fineLocation != null) {
                    double latitude = fineLocation.getLatitude();
                    double longitude = fineLocation.getLongitude();
                    textViewResults.setText("GPS: \nLatitude: " + latitude + "\nLongitude: "
                            + longitude);
                } else {
                    // The GPS is not currently enabled, the user needs to enable it
                    showProviderDialog("GPS");
                    textViewResults.setText("Please enable the GPS to receive location");
                }
            }
        });

        // set up Network Provider button click
        buttonCoarseLocation = (Button) findViewById(R.id.buttonCoarseLocation);
        buttonCoarseLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location coarseLocation = myLocationService
                        .getLocation(LocationManager.NETWORK_PROVIDER);
                if (coarseLocation != null) {
                    double latitude = coarseLocation.getLatitude();
                    double longitude = coarseLocation.getLongitude();
                    textViewResults.setText("Network Provided: \nLatitude: " + latitude
                            + "\nLongitude: " + longitude);
                } else {
                    // There is not network provider, the user needs to enable it
                    showProviderDialog("NETWORK");
                    textViewResults.setText("Please enable WiFi to receive location");
                }
            }
        });
    }

    public void showProviderDialog(String provider) {

        // Build an AlertDialog
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this)
                .setTitle(provider + " SETTINGS")
                .setMessage(provider
                        + " is not enabled. Would you like to enable it in the settings menu?")
                .setPositiveButton("Settings",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(
                                        Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                MainActivity.this.startActivity(intent);
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

        // Show the AlertDialog
        AlertDialog alertDialog = alertDialogBuilder.show();
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
