package com.proyecto.roger.mascotas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar miActionBar;
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    ImageButton ib;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        ib = (ImageButton) findViewById(R.id.estrellita);
        ib.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MascotasFavoritas.class);
                startActivity(i);
            }
        });


        listaMascotas = (RecyclerView) findViewById(R.id.miRV);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaContactos() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.gato, "GATO1", R.mipmap.ic_bone, R.mipmap.ic_rating, 0));
        mascotas.add(new Mascota(R.drawable.gatico9, "GATO2", R.mipmap.ic_bone, R.mipmap.ic_rating, 1));
        mascotas.add(new Mascota(R.drawable.gatico9, "GATO3", R.mipmap.ic_bone, R.mipmap.ic_rating, 2));
        mascotas.add(new Mascota(R.drawable.gatico9, "GATO4", R.mipmap.ic_bone, R.mipmap.ic_rating, 3));
        mascotas.add(new Mascota(R.drawable.gatico9, "GATO5", R.mipmap.ic_bone, R.mipmap.ic_rating, 4));
        mascotas.add(new Mascota(R.drawable.gatico9, "GATO6", R.mipmap.ic_bone, R.mipmap.ic_rating, 5));
        mascotas.add(new Mascota(R.drawable.gatico9, "GATO7", R.mipmap.ic_bone, R.mipmap.ic_rating, 6));
        mascotas.add(new Mascota(R.drawable.gatico9, "GATO8", R.mipmap.ic_bone, R.mipmap.ic_rating, 7));
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.proyecto.roger.mascotas/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.proyecto.roger.mascotas/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
