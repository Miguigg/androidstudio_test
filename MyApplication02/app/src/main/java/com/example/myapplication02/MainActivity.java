package com.example.myapplication02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView v1,v2,v3,v4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v1 =findViewById(R.id.imageView);
        v2 =findViewById(R.id.imageView2);
        v3 =findViewById(R.id.imageView3);
        v4 =findViewById(R.id.imageView4);


    }
    public void tirarDados(View v){
        int valor1 = 1+(int)(Math.random()*6);
        int valor2 = 1+(int)(Math.random()*6);
        int valor3 = 1+(int)(Math.random()*6);
        switch (valor1){
            case 1: v1.setImageResource(R.drawable.dado1);//aparecen las imagenes que metemos en res/drawable
            break;
            case 2: v1.setImageResource(R.drawable.dado2);
            break;
            case 3: v1.setImageResource(R.drawable.dado3);
            break;
            case 4: v1.setImageResource(R.drawable.dado4);
            break;
            case 5: v1.setImageResource(R.drawable.dado5);
            break;
            case 6: v1.setImageResource(R.drawable.dado6);
            break;
        }
        switch (valor2){
            case 1: v2.setImageResource(R.drawable.dado1);//aparecen las imagenes que metemos en res/drawable
                break;
            case 2: v2.setImageResource(R.drawable.dado2);
                break;
            case 3: v2.setImageResource(R.drawable.dado3);
                break;
            case 4: v2.setImageResource(R.drawable.dado4);
                break;
            case 5: v2.setImageResource(R.drawable.dado5);
                break;
            case 6: v2.setImageResource(R.drawable.dado6);
                break;
        }
    }
}