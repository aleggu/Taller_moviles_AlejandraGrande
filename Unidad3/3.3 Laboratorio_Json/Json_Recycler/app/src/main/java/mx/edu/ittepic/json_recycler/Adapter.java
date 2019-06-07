package mx.edu.ittepic.json_recycler;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderAlumnos> {
    ArrayList<NumerosVo> listaAlumnos;

    public Adapter(ArrayList<NumerosVo> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    @Override
    public ViewHolderAlumnos onCreateViewHolder(ViewGroup parent, int i) {
        View view=LayoutInflater.from(parent .getContext()).inflate(R.layout.item_list, null,false);
        return new ViewHolderAlumnos(view);
    }

    @Override
    public void onBindViewHolder( ViewHolderAlumnos holder, int i) {
        holder.numeros.setText(listaAlumnos.get(i).getNumerocontrol());
        holder.nombre.setText(listaAlumnos.get(i).getNombre());
        holder.calu1.setText(listaAlumnos.get(i).getCal1());
        holder.calu2.setText(listaAlumnos.get(i).getCal2());
        holder.calu3.setText(listaAlumnos.get(i).getCal3());
        int c1,c2,c3;
        int contador=0;
        c1=Integer.parseInt(listaAlumnos.get(i).cal1);
        c2=Integer.parseInt(listaAlumnos.get(i).cal2);
        c3=Integer.parseInt(listaAlumnos.get(i).cal3);

        if(c1==0)
        {
            contador++;
        }
        if(c2==0)
        {
            contador++;
        }
        if(c3==0)
        {
            contador++;
        }
        if(contador==3)
        {
            holder.lineal.setBackgroundColor(Color.parseColor("#F96464"));
        }
        if (contador==0)
        {
            holder.lineal.setBackgroundColor(Color.parseColor("#96FD75"));
        }
        if (contador==1)
        {
            holder.lineal.setBackgroundColor(Color.parseColor("#F0FD75"));
        }
        if (contador==2)
        {
            holder.lineal.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

    }

    @Override
    public int getItemCount() {
        return listaAlumnos.size();
    }

    public class ViewHolderAlumnos extends RecyclerView.ViewHolder {
        TextView numeros, nombre, calu1, calu2,calu3;
        LinearLayout lineal;
        public ViewHolderAlumnos( View itemView) {
            super(itemView);
            numeros=itemView.findViewById(R.id.numero);
            nombre=itemView.findViewById(R.id.nombre);
            calu1=itemView.findViewById(R.id.u1);
            calu2=itemView.findViewById(R.id.u2);
            calu3=itemView.findViewById(R.id.u3);
            lineal=itemView.findViewById(R.id.contenido);

        }

    }
}
