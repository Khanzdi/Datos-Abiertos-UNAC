package com.johan.perez.DatosAbiertosUNAC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.johan.perez.DatosAbiertosUNAC.models.Lengua;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResumenLengua extends AppCompatActivity {

    private TextView nombre, dpto, flia, habitantes, hablantes, vitalidad, descripcion;
    private Retrofit retrofit;

    private ArrayList<Lengua> dataset;
    private static final String TAG = "datosAbiertos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_lengua);

        nombre = (TextView) findViewById(R.id.tv_nombre);
        dpto = (TextView) findViewById(R.id.tv_dpto);
        flia = (TextView) findViewById(R.id.tv_flia);
        habitantes = (TextView) findViewById(R.id.tv_habitantes);
        hablantes = (TextView) findViewById(R.id.tv_hablantes);
        vitalidad = (TextView) findViewById(R.id.tv_vitalidad);
        descripcion = (TextView) findViewById(R.id.tv_descripcion);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String elNombre = (String) bundle.get("nombre");
            String elDpto = (String) bundle.get("dpto");
            String laDescripcion = (String) bundle.get("descripcion");
            String laFlia = (String) bundle.get("flia");
            String losHabit = (String) bundle.get("habitantes");
            String losHablant = (String) bundle.get("hablantes");
            String laVital = (String) bundle.get("vitalidad");
            nombre.setText(elNombre);
            dpto.setText(elDpto);
            descripcion.setMovementMethod(new ScrollingMovementMethod());
            descripcion.setText(laDescripcion);
            flia.setText(laFlia);
            habitantes.setText(losHabit);
            hablantes.setText(losHablant);
            vitalidad.setText(laVital);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.acerca) {
            Intent i = new Intent(this, AcercaDe.class );
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

}