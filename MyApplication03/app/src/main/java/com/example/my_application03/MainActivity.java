package com.example.my_application03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    private String jugador = "X";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
    }
    public void presion(View v){
        Button b = (Button) v;//la clase view es padre de Button, por tanto cuando se pulse el boton
                                //v tomara el valor de este y le hacemos un cast para poder usar sus
                                //metodos
        if(b.getText().toString().equals("")){//si un jugador no habia metido ya un elemento hay
            b.setText(jugador);
            verificarWin(jugador);
            cambiarJugador();
        }
    }

    private void verificarWin(String jugador) {
        String casilla1 = b1.getText().toString();
        String casilla2 = b2.getText().toString();
        String casilla3 = b3.getText().toString();
        String casilla4 = b4.getText().toString();
        String casilla5 = b5.getText().toString();
        String casilla6 = b6.getText().toString();
        String casilla7 = b7.getText().toString();
        String casilla8 = b8.getText().toString();
        String casilla9 = b9.getText().toString();
        if(casilla1.equals(jugador) && casilla2.equals(jugador) && casilla3.equals(jugador)){
            fin(jugador);
        }
        if(casilla3.equals(jugador) && casilla6.equals(jugador) && casilla9.equals(jugador)){
            fin(jugador);
        }
        if(casilla3.equals(jugador) && casilla5.equals(jugador) && casilla7.equals(jugador)){
            fin(jugador);
        }
        if(casilla1.equals(jugador) && casilla5.equals(jugador) && casilla9.equals(jugador)){
            fin(jugador);
        }
        if(casilla2.equals(jugador) && casilla5.equals(jugador) && casilla8.equals(jugador)){
            fin(jugador);
        }
        if(casilla6.equals(jugador) && casilla5.equals(jugador) && casilla4.equals(jugador)){
            fin(jugador);
        }
        if(casilla9.equals(jugador) && casilla8.equals(jugador) && casilla7.equals(jugador)){
            fin(jugador);
        }

    }

    private void fin(String jugador) {
        Toast.makeText(this,"Ganó el jugador con "+ jugador,Toast.LENGTH_LONG).show();
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
    }

    private void cambiarJugador() {
        if(jugador.equals("X")){
            jugador = "O";
        }else{
            jugador = "X";
        }
    }
}