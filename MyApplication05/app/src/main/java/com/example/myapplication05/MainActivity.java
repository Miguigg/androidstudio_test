package com.example.myapplication05;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void tocaCarta(View v){
        ImageButton img = (ImageButton) v;
        img.setVisibility(View.INVISIBLE);
    }
    public void showCards(View v){
        ImageButton b1 = findViewById(R.id.imageButton);
        ImageButton b2 = findViewById(R.id.imageButton2);
        ImageButton b3 = findViewById(R.id.imageButton3);

        ImageButton [] listButtons = {b1,b2,b3};
        for(int i=0;i<listButtons.length;i++){
            listButtons[i].setVisibility(View.VISIBLE);
        }
    }
}