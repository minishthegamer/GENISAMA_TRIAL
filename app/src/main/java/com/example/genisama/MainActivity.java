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

        final ImageView image = findViewById(R.id.theImage);
        Button button = findViewById(R.id.theButton);

        Bitmap bm = Bitmap.createBitmap (400, 400, Bitmap.Config.RGB_565);

        bm.setPixel(200, 200, Color.rgb(3, 100, 34));

        image.setImageBitmap(bm);
        System.out.println("Hi");

        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                image.setVisibility(View.INVISIBLE);
            }
        });
    }
}