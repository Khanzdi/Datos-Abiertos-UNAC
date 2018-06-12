package com.johan.perez.DatosAbiertosUNAC.datosAPI;

import com.johan.perez.DatosAbiertosUNAC.models.Lengua;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by Kevin Ortiz on 8/4/2018.
 */

public interface DatosOpenApiService {

    @GET("y5wk-q9yj.json")
    Call<ArrayList<Lengua>> obtenerListaLenguas();
}
