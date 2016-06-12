package com.proyecto.roger.mascotas;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;


public class MascotasFavoritas extends AppCompatActivity {

    ImageButton ib;
    ImageButton ratear;
    ImageView iv;
    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ib = (ImageButton) findViewById(R.id.estrellita);
        ib.setAlpha(0f);


        iv = (ImageView)findViewById(R.id.patita);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listaMascotas = (RecyclerView) findViewById(R.id.miRV);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.gato,"GATO1",R.mipmap.ic_bone,R.mipmap.ic_rating,0));
        mascotas.add(new Mascota(R.drawable.gato,"GATO2",R.mipmap.ic_bone,R.mipmap.ic_rating,1));
        mascotas.add(new Mascota(R.drawable.gato,"GATO3",R.mipmap.ic_bone,R.mipmap.ic_rating,2));
        mascotas.add(new Mascota(R.drawable.gato,"GATO4",R.mipmap.ic_bone,R.mipmap.ic_rating,2));
        mascotas.add(new Mascota(R.drawable.gato,"GATO5",R.mipmap.ic_bone,R.mipmap.ic_rating,2));
    }
}
