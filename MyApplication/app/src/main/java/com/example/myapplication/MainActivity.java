package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2;
    private TextView tView;
    private CheckBox r1,r2;
    private Switch s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //referencias a los objetos de la aplicacion
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tView = findViewById(R.id.tv);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        s1 = findViewById(R.id.switch1);
        s2 = findViewById(R.id.switch2);
    }
    public void pressButton(View v){//mostramos el mensaje con el boton next porque cambiamos el onclickW
        Toast.makeText(this,"Boton presionado",Toast.LENGTH_LONG).show();
    }
    public void sumar(View v){
        String temp1 = et1.getText().toString();
        String temp2 = et2.getText().toString();
        int v1 = Integer.parseInt(temp1);
        int v2 = Integer.parseInt(temp2);
        if(r1.isChecked()){
            int resultado = v1+v2;
            tView.setText("El resultado es " + resultado);
        }else if(r2.isChecked()){
            int resultado = v1-v2;
            tView.setText("El resultado es " + resultado);
        }
    }
    public void verificar(View v){
        if(s1.isChecked()) {
            Toast.makeText(this, "Dados moviles activos", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Dados moviles inactivos", Toast.LENGTH_LONG).show();
        }
        if(s2.isChecked()) {
            Toast.makeText(this, "Wifi activa", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Wifi inactiva", Toast.LENGTH_LONG).show();
        }
    }
    public void verificarDatos(View v){
        if(s1.isChecked()) {
            Toast.makeText(this, "Dados se acaban de activar", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Dados se acaban de desactivar", Toast.LENGTH_LONG).show();
        }
    }
}
