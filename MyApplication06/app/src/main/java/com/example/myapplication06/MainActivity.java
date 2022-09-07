package com.example.myapplication06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner s1;
    private TextView t1;
    private EditText e1,e2;
    private String [] operaciones = {"sumar","restar","multiplicar","dividir"};
    String [] paises = {"argentina","bolivia","brasil"};
    int [] banderas = {R.drawable.argentina,R.drawable.bolivia,R.drawable.brasil};
    private Spinner s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s2 = findViewById(R.id.spinner2);
        s1 = findViewById(R.id.spinner);
        t1 = findViewById(R.id.textView3);
        e1 = findViewById(R.id.editTextNumber);
        e2 = findViewById(R.id.editTextNumber2);
        ArrayAdapter<String>adapter1=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,operaciones);//para meterlo en el spinner
        s1.setAdapter(adapter1);//lo cargamos
        PaisesAdapder adaptador2 = new PaisesAdapder();
        s2.setAdapter(adaptador2);
    }
    class PaisesAdapder extends BaseAdapter{

        @Override
        public int getCount() {
            return paises.length;
        }

        @Override
        public Object getItem(int i) {
            return paises[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override//se ejecuta por cada objeto del array de paises, porque en count le hemos dicho que la longitu es la del array de paises
        public View getView(int i, View view, ViewGroup viewGroup) {//para configurar la nueva vista
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            view = inflater.inflate(R.layout.item_spinner_with_image,null);//que vista (layaut) tendremos
            ImageView iv1 =view.findViewById(R.id.bandera);//importante!!!! cuando hacemos el findView tenemos que indicar que lo hacemos sobre "view"
                                                            //ya que lo hacemos sobre otro layout
            TextView te1 = view.findViewById(R.id.textView5);
            iv1.setImageResource(banderas[i]);
            te1.setText(paises[i]);
            return view;
        }
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