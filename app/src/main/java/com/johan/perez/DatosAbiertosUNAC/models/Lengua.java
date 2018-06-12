package com.johan.perez.DatosAbiertosUNAC.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Kevin Ortiz on 8/4/2018.
 */

public class Lengua {

    @SerializedName("departamento")
    @Expose
    private String departamento;
    @SerializedName("descripci_n_de_lengua")
    @Expose
    private String descripciNDeLengua;
    @SerializedName("familia_ling_stica")
    @Expose
    private String familiaLingStica;
    @SerializedName("n_mero_de_habitantes")
    @Expose
    private String nMeroDeHabitantes;
    @SerializedName("n_mero_de_hablantes")
    @Expose
    private String nMeroDeHablantes;
    @SerializedName("nombre_de_lengua")
    @Expose
    private String nombreDeLengua;
    @SerializedName("vitalidad")
    @Expose
    private String vitalidad;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDescripciNDeLengua() {
        return descripciNDeLengua;
    }

    public void setDescripciNDeLengua(String descripciNDeLengua) {
        this.descripciNDeLengua = descripciNDeLengua;
    }

    public String getFamiliaLingStica() {
        return familiaLingStica;
    }

    public void setFamiliaLingStica(String familiaLingStica) {
        this.familiaLingStica = familiaLingStica;
    }

    public String getNMeroDeHabitantes() {
        return nMeroDeHabitantes;
    }

    public void setNMeroDeHabitantes(String nMeroDeHabitantes) {
        this.nMeroDeHabitantes = nMeroDeHabitantes;
    }

    public String getNMeroDeHablantes() {
        return nMeroDeHablantes;
    }

    public void setNMeroDeHablantes(String nMeroDeHablantes) {
        this.nMeroDeHablantes = nMeroDeHablantes;
    }

    public String getNombreDeLengua() {
        return nombreDeLengua;
    }

    public void setNombreDeLengua(String nombreDeLengua) {
        this.nombreDeLengua = nombreDeLengua;
    }

    public String getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(String vitalidad) {
        this.vitalidad = vitalidad;
    }
}


