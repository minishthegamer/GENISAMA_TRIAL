package com.example.genisama;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Height and width specifications for bitmap
        int width = 100;
        int height = 100;

        final ImageView image = findViewById(R.id.theImage);
        Button button = findViewById(R.id.theButton);

        Bitmap bmFirst = Bitmap.createBitmap (width, height, Bitmap.Config.RGB_565);

        //For every pixel in every fourth row, color it blue
        for(int i = 0; i < width; i++) {
            for (int n = 0; n < height; n += 4) {
                bmFirst.setPixel(i, n, Color.rgb(0, 0, 255));
            }
        }

        Bitmap bmSecond = Bitmap.createBitmap (width, height, Bitmap.Config.RGB_565);

        //For every pixel in every fourth column, color it green
        for(int i = 0; i < width; i+= 4) {
            for (int n = 0; n < height; n ++) {
                bmSecond.setPixel(i, n, Color.rgb(0, 255, 0));
            }
        }

        Bitmap bmThird = Bitmap.createBitmap (width, height, Bitmap.Config.RGB_565);

        //Creates a square 1/4 the size of the bitmap in the middle of the bitmap
        for(int i = 0; i < width; i++) {
            for (int n = 0; n < height; n++) {
                if (i > (width / 4) && i < (width - (width / 4)) && n > (height / 4) && n < (height - (height / 4))) {
                    bmThird.setPixel(i, n, Color.rgb(255, 0, 0));
                }
            }
        }

        //Sets the image to the bitmap
        image.setImageBitmap(bmFirst);

        //Button listener that changes the screen to a different bitmap each click
        button.setOnClickListener( new View.OnClickListener() {
            int clicks = 0;
            public void onClick(View view) {
                if(clicks == 0) {
                    clicks++;
                    image.setImageBitmap(bmSecond);
                }
                else if (clicks == 1) {
                    clicks++;
                    image.setImageBitmap(bmThird);
                }
                else if (clicks == 2){
                    clicks = 0;
                    image.setImageBitmap(bmFirst);
                }
            }
        });
    }
}