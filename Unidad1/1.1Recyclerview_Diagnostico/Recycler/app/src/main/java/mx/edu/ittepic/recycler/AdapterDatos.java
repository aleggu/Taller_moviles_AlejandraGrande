package mx.edu.ittepic.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter <AdapterDatos.ViewHolderDatos> implements View.OnClickListener {
    private Context mostrar;
    ArrayList<Alumnos> listAlumnos;
    private View.OnClickListener listener;
    ImageView foto, foto2;


    public AdapterDatos(ArrayList<Alumnos> listAlumnos ,Context mostrar) {
        this.listAlumnos = listAlumnos;
        this.mostrar=mostrar;
    }

    //enlaza el adaptador con el item list
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    //establece la comunicacion entre el adaptador  view holder datos
    @Override
    public void onBindViewHolder(ViewHolderDatos holder, final int position) {
        holder.etiNombre.setText(listAlumnos.get(position).getNombre());
        holder.etiControl.setText(listAlumnos.get(position).getNocontrol());
        holder.etiCarrera.setText(listAlumnos.get(position).getCarrera());


        holder.foto.setImageResource(listAlumnos.get(position).getImagen());
        holder.foto2.setImageResource(listAlumnos.get(position).getBasura());


       holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mostrar, "Seleccionaste:  " +listAlumnos.get(position).getNombre(), Toast.LENGTH_LONG).show();
            }
        });

        holder.foto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mostrar, "Borraste:  " +listAlumnos.get(position).getNombre(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public int getItemCount() {
        return listAlumnos.size();
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null)
        {
            listener.onClick(v);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView etiNombre, etiCarrera, etiControl;
        ImageView foto, foto2;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            etiNombre = itemView.findViewById(R.id.idNombre);
            etiCarrera = itemView.findViewById(R.id.idCarrera);
            etiControl = itemView.findViewById(R.id.idControl);
            foto = itemView.findViewById(R.id.idImagen);
           foto2 =itemView.findViewById(R.id.idBasura);

        }

    }
}
