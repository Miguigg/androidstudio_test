package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String [] fruta = {" anana"," banana"," cereza"," kiwi"," limon"," manzana"," naranja"," sandia"};
    double [] precios = {1.20,1.50,2.60,5.50,2.40,1.50,1.70,6.20};
    int [] fotos = {R.drawable.anana,R.drawable.banana,R.drawable.cereza,R.drawable.kiwi,R.drawable.limon,R.drawable.manzana,R.drawable.naranja,R.drawable.sandia};
    RecyclerView frutas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frutas = findViewById(R.id.frutas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        frutas.setLayoutManager(linearLayoutManager);
        frutas.setAdapter(new AdaptadorFrutas());
    }

    private class AdaptadorFrutas extends RecyclerView.Adapter<AdaptadorFrutas.AdaptadorFrutasHolder> {//clase que crea todos los objetos
        @NonNull
        @Override
        public AdaptadorFrutasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//por cada elemento del array, crea un layout como lo habiamos indicado
            return new AdaptadorFrutasHolder(getLayoutInflater().inflate(R.layout.frutas,parent,false));//le indicamos que layout tiene que usar,donde empieza a
                                                                                                                    //cogerlo
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorFrutasHolder holder, int position) {
            holder.imprimir(position);//por cada posicion del array, le indicamos como imprimirla
        }

        @Override
        public int getItemCount() {//da el numero total de frutas
            return fruta.length;
        }
        private class AdaptadorFrutasHolder extends RecyclerView.ViewHolder{//clase que imprime cada uno de estos
            TextView tv1,tv2;//para cada objeto (imagen, nombre) instancia unas variables del layout
            ImageView iv1;
            public AdaptadorFrutasHolder(@NonNull View itemView) {
                super(itemView);
                tv1 = itemView.findViewById(R.id.textView_nombre);//cojemos la referencia a cada elemento del layout
                tv2 = itemView.findViewById(R.id.textView_precio);
                iv1 = itemView.findViewById(R.id.fruta);
            }

            public void imprimir(int position) {
                tv1.setText(fruta[position]);
                tv2.setText(String.valueOf(precios[position]));
                iv1.setImageResource(fotos[position]);
            }
        }
    }
}
