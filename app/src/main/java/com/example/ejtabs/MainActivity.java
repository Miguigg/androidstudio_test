package com.example.ejtabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    String diasSemana [] = {"Lunes","Martes","Miercoles","Jueves","Viernes"};
    String actv [] = {"","","","",""};
    ViewPager2 v2;
    TabLayout t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v2 = findViewById(R.id.vp2);
        t = findViewById(R.id.tab);
        v2.setAdapter(new AdaptadorAgenda());

        TabLayoutMediator tlb = new TabLayoutMediator(t, v2, new TabLayoutMediator.TabConfigurationStrategy() {//para las tabs ponemos el layout, el elemento que contiene las tabs
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                    tab.setText(diasSemana[position]);//seteamos el texto
            }
        });
        tlb.attach();
    }
    private class AdaptadorAgenda extends RecyclerView.Adapter<AdaptadorAgenda.AdaptadorAgendaHolder> {
        @NonNull
        @Override
        public AdaptadorAgendaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorAgendaHolder(getLayoutInflater().inflate(R.layout.dias,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorAgendaHolder holder, int position) {
                holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return diasSemana.length;
        }

        class AdaptadorAgendaHolder extends RecyclerView.ViewHolder{
            EditText desc;
            public AdaptadorAgendaHolder(@NonNull View itemView) {
                super(itemView);
                 desc =itemView.findViewById(R.id.descipcion);
                TextView tittle = itemView.findViewById(R.id.Title);
            }
            public void imprimir(int pos){
                desc.setText(actv[pos]);
            }
        }
    }
}