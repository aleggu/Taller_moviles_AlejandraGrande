package mx.edu.ittepic.recycler;

    import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText control, nombre,carrera;
    Button insertar;
    ConexionSQLiteHelper conn;
    ArrayList<Alumnos> listAlumnos;
    RecyclerView recyclerAlumnos;

    SQLiteDatabase db=conn.getWritableDatabase();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conn=new ConexionSQLiteHelper(MainActivity.this,"bd_alumnos",null,1);
        control=findViewById(R.id.EditNumero);
        nombre=findViewById(R.id.EditNombre);
        carrera=findViewById(R.id.EditCarrera);
        insertar=findViewById(R.id.Botoninsertar);
        listAlumnos=new ArrayList<Alumnos>();
        recyclerAlumnos=findViewById(R.id.RecyclerId);
        recyclerAlumnos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,  false));

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertarUsuario();
            }
        });

        AdapterDatos adapter= new AdapterDatos(listAlumnos, this);
        recyclerAlumnos.setAdapter(adapter);
        }

    private void InsertarUsuario() {

        String gcontrol="", gnombre="", gcarrera="";

        gcontrol=control.getText().toString();
        gnombre=nombre.getText().toString();
        gcarrera=carrera.getText().toString();



        String insert="INSERT INTO "+Utilidades.TABLA_ALUMNOS +" ( " +Utilidades.CAMPO_NOCONTROL+","+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_CARRERA+")" +
                " VALUES ('"+gcontrol+"','"+gnombre+"','"+gcarrera+"')";
        db.execSQL(insert);

        db.close();

    }


}
