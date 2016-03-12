package com.dutsonpa.drawnrectangle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    ImageView myDrawnImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        myDrawnImageView = (ImageView) this.findViewById(R.id.myDrawnImageView);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screen_width = size.x;
        int screen_height = size.y;
        Bitmap bitmap = Bitmap.createBitmap((int) screen_width, (int) screen_height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        myDrawnImageView.setImageBitmap(bitmap);

        // use Paint() and drawRect() to draw a rectangle

        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setStyle(Paint.Style.FILL_AND_STROKE);
        p.setStrokeWidth(40);
        float rectLeft = 80;
        float rectTop = 80;
        float rectRight = 200;
        float rectBottom = 200;
        canvas.drawRect(rectLeft, rectTop, rectRight, rectBottom, p);
        */
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
