package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String [] fruta = {"anana","banana","cereza","kiwi","limon","manzana","naranja","sandia"};
    double [] precios = {1.20,1.50,2.60,5.50,2.40,1.50,1.70,6.20};
    int [] fotos = {R.drawable.anana,R.drawable.banana,R.drawable.cereza,R.drawable.kiwi,R.drawable.limon,R.drawable.manzana,R.drawable.naranja,R.drawable.sandia};
    RecyclerView frutas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}