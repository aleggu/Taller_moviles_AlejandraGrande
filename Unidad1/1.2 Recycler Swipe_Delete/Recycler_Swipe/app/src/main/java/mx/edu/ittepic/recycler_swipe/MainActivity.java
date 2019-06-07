package mx.edu.ittepic.recycler_swipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Alumnos> listAlumnos;
    RecyclerView recyclerAlumnos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAlumnos=new ArrayList<Alumnos>();

        recyclerAlumnos=findViewById(R.id.RecyclerId);
        recyclerAlumnos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,  false));

        llenarPersonajes();


        AdapterDatos adapter= new AdapterDatos(listAlumnos, this);
        recyclerAlumnos.setAdapter(adapter);
    }
    private void llenarPersonajes() {
        listAlumnos.add(new Alumnos("Alejandra Grande", "15400787", "Tics", R.drawable.user, R.drawable.basura));
        listAlumnos.add(new Alumnos("Leo Estrada<3", "15401028", "Tics", R.drawable.user, R.drawable.basura));
        listAlumnos.add(new Alumnos("Arleth Acosta", "15400762", "Sistemas", R.drawable.user, R.drawable.basura));
        listAlumnos.add(new Alumnos("Sinahi Ruiz", "15400804", "Sistemas", R.drawable.user, R.drawable.basura));
        listAlumnos.add(new Alumnos("Erick De Leon", "15400781", "Administracion", R.drawable.user, R.drawable.basura));
        listAlumnos.add(new Alumnos("Emilia Medina", "15400789", "Cultura de belleza", R.drawable.user, R.drawable.basura));

    }
}
