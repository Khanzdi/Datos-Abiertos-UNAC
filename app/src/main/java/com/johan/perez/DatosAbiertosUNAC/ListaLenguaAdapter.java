package com.johan.perez.DatosAbiertosUNAC;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.johan.perez.DatosAbiertosUNAC.models.Lengua;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kevin Ortiz on 8/4/2018.
 */

public class ListaLenguaAdapter extends RecyclerView.Adapter<ListaLenguaAdapter.ViewHolder>{

    private ArrayList<Lengua> dataset;
    private Context context;
    private Retrofit retrofit;
    private static final String TAG = "OPEN_DATA";

    public ListaLenguaAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lengua, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Lengua l = dataset.get(position);
        holder.tv_nombreLengua.setText(l.getNombreDeLengua());

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        holder.tv_nombreLengua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context,ResumenLengua.class);
                String elNombre = l.getNombreDeLengua();
                String elDpto = l.getDepartamento();
                String descripcion = l.getDescripciNDeLengua();
                String split[] = descripcion.split(". '\n'");
                String laDescripcion = split[0];
                String laFlia = l.getFamiliaLingStica();
                String losHabit = l.getNMeroDeHabitantes();
                String losHablant = l.getNMeroDeHablantes();
                String laVital = l.getVitalidad();
                intent.putExtra("nombre", elNombre);
                intent.putExtra("dpto",elDpto);
                intent.putExtra("descripcion",laDescripcion);
                intent.putExtra("flia",laFlia);
                intent.putExtra("habitantes", losHabit);
                intent.putExtra("hablantes", losHablant);
                intent.putExtra("vitalidad", laVital);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaLengua(ArrayList<Lengua> listaLenguas) {
        dataset.addAll(listaLenguas);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_nombreLengua;
        public ViewHolder (View itemView) {
            super(itemView);

            tv_nombreLengua = (TextView) itemView.findViewById(R.id.tv_nombreLengua);
        }
    }
}
