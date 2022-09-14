package com.example.my_app09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.note);
        et2 = findViewById(R.id.texto);
    }

    public void grabar (View v){
        String nombreNota = et1.getText().toString();
        String valor = et2.getText().toString();
        try{
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nombreNota, Context.MODE_PRIVATE));//para guardar en archivo
            archivo.write(valor);//guarda
            archivo.flush();//limpia buffer
            archivo.close();
            et1.setText("");
            et2.setText("");
        }catch (IOException e){
            Toast.makeText(this,"No se puede abrir archivo",Toast.LENGTH_LONG).show();
        }
    }

    public void recuperar(View v){
        String nombreArchivo = et1.getText().toString();
        String content = "";
        try{
            InputStreamReader archivo = new InputStreamReader(openFileInput(nombreArchivo));//cogemos el archivo
            BufferedReader br = new BufferedReader(archivo);//cojemos el buffer
            String linea = br.readLine();
            while(linea!=null){
                    content=content+linea+"\n";
                    linea=br.readLine();
            }
            br.close();
            archivo.close();
            et2.setText(content);
        }catch (IOException e){
            Toast.makeText(this,"No se puede abrir archivo",Toast.LENGTH_LONG).show();
        }
    }
}