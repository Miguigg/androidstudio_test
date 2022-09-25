package com.example.my_app10;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView list;
    ArrayList<String> nombre;
    ArrayList<Integer> edad;
    Button add,view;
    Switch sw1;
    EditText name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = new ArrayList<>();
        edad = new ArrayList<>();
        list = findViewById(R.id.list);
        nombre.add("Paco");
        edad.add(18);
        LinearLayoutManager l1 = new LinearLayoutManager(this);
        list.setLayoutManager(l1);
        list.setAdapter(new AdaptadorLista());

        add = findViewById(R.id.btn_add);
        view = findViewById(R.id.btn_view);
        sw1 = findViewById(R.id.actvCost);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClientModel c;
                if(name.getText() != null){
                    try{
                        c = new ClientModel(-1,name.getText().toString(),Integer.parseInt(age.getText().toString()),sw1.isChecked());
                        Toast.makeText(MainActivity.this,c.toString(),Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        Toast.makeText(MainActivity.this,"Error al crear "+e,Toast.LENGTH_LONG).show();
                        c = new ClientModel(-1,"err",0,false);
                    }
                    AdminSqlite helper = new AdminSqlite(MainActivity.this);
                    boolean b = helper.addOne(c);
                    Toast.makeText(MainActivity.this,"Result:" + b,Toast.LENGTH_LONG).show();
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.AdaptadorListaHolder>{
        @NonNull
        @Override
        public AdaptadorListaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorListaHolder(getLayoutInflater().inflate(R.layout.recycleview,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorListaHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return nombre.size();
        }

        private class AdaptadorListaHolder extends RecyclerView.ViewHolder{
                TextView t1,t2;
                public AdaptadorListaHolder(@NonNull View itemView) {
                    super(itemView);
                    t1 = itemView.findViewById(R.id.nombre);
                    t2 = itemView.findViewById(R.id.edad);
                }
                public void imprimir(int posicion){
                    t1.setText(nombre.get(posicion));
                    t2.setText(String.valueOf(edad.get(posicion)));
                }
            }
    }
}