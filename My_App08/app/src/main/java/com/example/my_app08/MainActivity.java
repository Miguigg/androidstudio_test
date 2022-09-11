package com.example.my_app08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Spinner s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        s = findViewById(R.id.spinner);
        String [] op = {"Suma","Resta","Multiplicar"};
        ArrayAdapter<String>adptador=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,op);
        s.setAdapter(adptador);
    }
    public void calculo(View v){
        Intent intent = new Intent(this,actv_2.class);
        int v1 = Integer.parseInt(et1.getText().toString());
        int v2 = Integer.parseInt(et2.getText().toString());
        String operacion = s.getSelectedItem().toString();
        intent.putExtra("valor1",v1);
        intent.putExtra("valor2",v2);
        intent.putExtra("operacion",operacion);
        startActivity(intent);
    }
}