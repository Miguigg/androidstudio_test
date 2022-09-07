package com.example.myapplication04;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView t1;
    private String pais;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.textView);
        int adivina = (int)(Math.random()*8);
        switch (adivina){
            case 0: pais="argentina";break;
            case 1: pais="bolivia";break;
            case 2: pais="brasil";break;
            case 3: pais="chile";break;
            case 4: pais="colombia";break;
            case 5: pais="peru";break;
            case 6: pais="uruguay";break;
            case 7: pais="venezuela";break;
        }
        t1.setText("Selecciona la bandera de "+pais);
    }
    public void press (View v){
        ImageButton botonPulsado = (ImageButton) v;
        String tagBoton = botonPulsado.getTag().toString();
        if(tagBoton.equals(pais)){
            Toast.makeText(this,"Correcto!!!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Error!!",Toast.LENGTH_LONG).show();
        }
        fin();
    }

    private void fin() {
        ImageButton img1 = findViewById(R.id.imageButton);
        ImageButton img2 = findViewById(R.id.imageButton2);
        ImageButton img3 = findViewById(R.id.imageButton3);
        ImageButton img4 = findViewById(R.id.imageButton4);
        ImageButton img5 = findViewById(R.id.imageButton5);
        ImageButton img6 = findViewById(R.id.imageButton6);
        ImageButton img7 = findViewById(R.id.imageButton7);
        ImageButton img9 = findViewById(R.id.imageButton9);
        ImageButton [] listOfImg = {img1,img2,img3,img4,img5,img6,img7,img9};
        for(int i= 0 ; i<listOfImg.length;i++){
            listOfImg[i].setEnabled(false);
        }
    }
}