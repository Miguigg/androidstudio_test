package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String [] fruta = {" anana"," banana"," cereza"," kiwi"," limon"," manzana"," naranja"," sandia"};
    double [] precios = {1.20,1.50,2.60,5.50,2.40,1.50,1.70,6.20};
    int [] fotos = {R.drawable.anana,R.drawable.banana,R.drawable.cereza,R.drawable.kiwi,R.drawable.limon,R.drawable.manzana,R.drawable.naranja,R.drawable.sandia};
    RecyclerView frutas;
    RecyclerView otrospr;

     //para la lista de otros productos
    ArrayList<Producto> productos;
    EditText nombre;
    EditText precio;
    AdaptadorOtrospr ap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frutas = findViewById(R.id.frutas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        frutas.setLayoutManager(linearLayoutManager);
        frutas.setAdapter(new AdaptadorFrutas());

        //para la lista de otros productos
        otrospr = findViewById(R.id.datos);
        nombre = findViewById(R.id.name);
        precio = findViewById(R.id.price);
        productos = new ArrayList<Producto>();
        productos.add(new Producto("Empanadillas",1.75));
        otrospr.setLayoutManager(linearLayoutManager);
        ap = new AdaptadorOtrospr();
        otrospr.setAdapter(ap);
    }

    private class AdaptadorOtrospr extends RecyclerView.Adapter<AdaptadorOtrospr.AdaptadorOtrosprHolder>{

        @NonNull
        @Override
        public AdaptadorOtrospr.AdaptadorOtrosprHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorOtrospr.AdaptadorOtrosprHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
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

            public void imprimir(int position) {//asignamos a cada elemento la imagen y texto que le corresponde
                tv1.setText(fruta[position]);
                tv2.setText(String.valueOf(precios[position]));
                iv1.setImageResource(fotos[position]);
            }
        }
    }
}
