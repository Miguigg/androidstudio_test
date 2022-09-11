package com.example.my_app08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class actv_2 extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actv2);
        t1 = findViewById(R.id.textView);
        Bundle datos = getIntent().getExtras();
        int v1 = datos.getInt("valor1");
        int v2 = datos.getInt("valor2");
        String op = datos.getString("operacion");
        int toret;
        switch (op){
            case "Suma": toret = v1+v2; t1.setText("Resultado: "+toret); ;break;
            case "Resta":toret = v1-v2;t1.setText("Resultado: "+toret);break;
            case "Multiplicar":toret = v1*v2;t1.setText("Resultado: "+toret);break;
        }
    }
    public void volver(View v){
        finish();
    }
}