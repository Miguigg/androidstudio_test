package com.example.my_app08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int[] photos = {R.drawable.es6vhgxz7ip51,R.drawable.k6isym308ip51,R.drawable.nq8ifla08ip51,R.drawable.oi5cikd08ip51,R.drawable.p5wcia708ip51,R.drawable.wx6w2jg08ip51};
    EditText et1,et2;
    Spinner s;
    ViewPager2 vp;
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
        vp=findViewById(R.id.vp);

        vp.setAdapter(new AdaptadorPatito());
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

    private class AdaptadorPatito extends RecyclerView.Adapter<AdaptadorPatito.AdaptadorPatitoHolder> {
        @NonNull
        @Override
        public AdaptadorPatitoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorPatitoHolder(getLayoutInflater().inflate(R.layout.info,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorPatitoHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return photos.length;
        }

        class AdaptadorPatitoHolder extends RecyclerView.ViewHolder{
            ImageView iv;
            public AdaptadorPatitoHolder(@NonNull View itemView) {
                super(itemView);
                iv = itemView.findViewById(R.id.iv);
            }
            public void imprimir(int pos){
                iv.setImageResource(photos[pos]);
            }
        }
    }
}