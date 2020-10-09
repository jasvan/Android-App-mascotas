package com.example.semana3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.MascotasViewHolder>{
    ArrayList<Mascotas> mascotasx;
    private int puntos;
    Activity activity;
    public MascotasAdaptador(ArrayList<Mascotas> mascotas, Activity activity ){
        this.mascotasx = mascotas;
        this.activity = activity;
    }
    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotasViewHolder holder, int position) {
        final Mascotas mascotas = mascotasx.get(position);
        holder.imgFoto.setImageResource(mascotas.getFoto());
        holder.tvNombre.setText(mascotas.getNombre());


        holder.btnHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Diste pasear a " + mascotas.getNombre(),Toast.LENGTH_SHORT).show();
                puntos = mascotas.getPuntos();
                mascotas.setPuntos(++puntos);
                holder.tvPuntos.setText(String.valueOf(puntos));

            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotasx.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{
        private ImageButton btnHueso;
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvPuntos;

        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);
            btnHueso = (ImageButton) itemView.findViewById(R.id.btnHueso);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvPuntos = (TextView) itemView.findViewById(R.id.tvPuntos);

        }
    }
}
