package com.example.myapplication06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner s1;
    private TextView t1;
    private EditText e1,e2;
    private String [] operaciones = {"sumar","restar","multiplicar","dividir"};
    private String [] paises = {"argentina","bolivia","brasil","chile","colombia","peru","uruguay","venezuela"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = findViewById(R.id.spinner);
        t1 = findViewById(R.id.textView3);
        e1 = findViewById(R.id.editTextNumber);
        e2 = findViewById(R.id.editTextNumber2);
        ArrayAdapter<String>adapter1=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,operaciones);//para meterlo en el spinner
        s1.setAdapter(adapter1);//lo cargamos
    }
    public void operar(View v){
        int valor1 = Integer.parseInt(e1.getText().toString());
        int valor2 = Integer.parseInt(e2.getText().toString());
        String operacion = s1.getSelectedItem().toString();
        int res;
        switch (operacion){
            case "sumar": res = valor1 + valor2; t1.setText("resultado: "+res);  break;
            case "restar":  res = valor1 - valor2;  t1.setText("resultado: "+res);  break;
            case "multiplicar":  res = valor1 * valor2;  t1.setText("resultado: "+res);  break;
            case "dividir":
                try{
                    res = valor1 / valor2;
                    t1.setText("resultado: "+res);
                }catch (ArithmeticException e){
                    t1.setText("No se puede dividir entre 0");
                }
                break;
        }
    }
}