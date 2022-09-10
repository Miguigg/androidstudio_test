package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

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
        productos.add(new Producto("Empanadillas","1.75"));
        LinearLayoutManager linear2 = new LinearLayoutManager(this);
        otrospr.setLayoutManager(linear2);
        ap = new AdaptadorOtrospr();
        otrospr.setAdapter(ap);
    }

    //añade producto y desplaza y actualiza la vista
   public void agregar(View v){
        nombre = findViewById(R.id.name);
        precio = findViewById(R.id.price);
        if(!TextUtils.isEmpty(nombre.getText().toString()) && !TextUtils.isEmpty(precio.getText().toString()) && isNumeric(precio.getText().toString())){
            Producto newProducto = new Producto(nombre.getText().toString(),precio.getText().toString());
            productos.add(newProducto);
            nombre.setText("");
            precio.setText("");
            ap.notifyDataSetChanged();
            otrospr.scrollToPosition(productos.size()-1);//desplazamos todo el resto de elementos para dejarle un espacio a el nuevo
        }else {
            Toast.makeText(this, "Rellena ambos campos correctamente", Toast.LENGTH_LONG).show();
        }
    }
    //actualizar name price
    private void mostrarPulso(int layoutPosition) {
        nombre.setText(productos.get(layoutPosition).getNombre());
        precio.setText(productos.get(layoutPosition).getPrecio());
    }
    public void delete(View v){
        int pos = -1;
        for(int i=0;i<productos.size();i++){
            if(productos.get(i).getNombre().equals(nombre.getText().toString())){
                pos = i;
            }
        }
        if(pos != -1){
            productos.remove(pos);
            nombre.setText("");
            precio.setText("");
            ap.notifyDataSetChanged();
            Toast.makeText(this, "Producto borrado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Producto no existe", Toast.LENGTH_LONG).show();
        }
    }


    private class AdaptadorOtrospr extends RecyclerView.Adapter<AdaptadorOtrospr.AdaptadorOtrosprHolder>{

        @NonNull
        @Override
        public AdaptadorOtrospr.AdaptadorOtrosprHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorOtrosprHolder(getLayoutInflater().inflate(R.layout.otrosproductos,parent,false));//le indicamos que layout utilizaremos
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorOtrospr.AdaptadorOtrosprHolder holder, int position) {
            holder.imprimir(position);//para cada elemento llamamos al metodo imprimir del AdaptadorHolder
        }

        @Override
        public int getItemCount() {
            return productos.size();
        }//tamaño del arraylist productos


        //indicamos como renderizar cada elemento
        private class AdaptadorOtrosprHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            //referenciamos los dos textview
            TextView nombre,precio;

            public AdaptadorOtrosprHolder(@NonNull View itemView) {
                super(itemView);
                precio = itemView.findViewById(R.id.tvPrecio);
                nombre = itemView.findViewById(R.id.tvNombre);
                itemView.setOnClickListener(this);
            }
            public void imprimir(int posicion){
                nombre.setText("Producto: "+ productos.get(posicion).getNombre());
                precio.setText("Precio: "+productos.get(posicion).getPrecio());
            }

            @Override
            public void onClick(View view) {
                    mostrarPulso(getLayoutPosition());
            }
        }
    }













    //-------------------------------------------------------------------------------------------//
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
