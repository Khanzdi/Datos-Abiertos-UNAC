package com.johan.perez.DatosAbiertosUNAC;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.johan.perez.DatosAbiertosUNAC.datosAPI.DatosOpenApiService;
import com.johan.perez.DatosAbiertosUNAC.models.Lengua;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    public final static String TAG = "datosAbiertos.....";
    private boolean aptoParaCargar;

    private RecyclerView recyclerView;
    private ListaLenguaAdapter listaLenguaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_lista);
        listaLenguaAdapter = new ListaLenguaAdapter(this);
        recyclerView.setAdapter(listaLenguaAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            obtenerDatosLengua();
                        }
                    }

                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        aptoParaCargar = true;
        obtenerDatosLengua();
    }

    private void obtenerDatosLengua() {

        DatosOpenApiService service = retrofit.create(DatosOpenApiService.class);
            Call<ArrayList<Lengua>> lenguaRespuestaCall = service.obtenerListaLenguas();

            lenguaRespuestaCall.enqueue(new Callback<ArrayList<Lengua>>() {
                @Override
                public void onResponse(Call<ArrayList<Lengua>> call, Response<ArrayList<Lengua>> response) {
                    if(response.isSuccessful()){
                        ArrayList listaL = response.body();
                        listaLenguaAdapter.adicionarListaLengua(listaL);
                    }else
                    {
                        Log.e(TAG, "onResponse: "+response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Lengua>> call, Throwable t) {
                    Log.e(TAG," onFailure: "+t.getMessage());
                }
            });
        }

}



