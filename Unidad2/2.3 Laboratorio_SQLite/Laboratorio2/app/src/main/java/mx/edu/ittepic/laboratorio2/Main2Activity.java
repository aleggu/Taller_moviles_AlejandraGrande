package mx.edu.ittepic.laboratorio2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button insertar, regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               codigoInsertar(););
            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent =new Intent(Main2Activity.this,MainActivity.class);
                startActivity(miIntent);
            }
        });

    }
    private void codigoInsertar() {
        try
        {
            SQLiteDatabase tabla= base.getWritableDatabase();
            String SQL ="INSERT INTO PACIENTE VALUES("+identificar.getText().toString()+",'"
                    +nombre.getText().toString()+"','"
                    +rfc.getText().toString()+"','"
                    +celular.getText().toString()+"','"
                    +email.getText().toString()+"','"
                    +fecha.getText().toString()+"')";

            tabla.execSQL(SQL);
            Toast.makeText(this, "USUARIO NUEVO CREADO", Toast.LENGTH_LONG).show();
            tabla.close();
        }
        catch (SQLiteException e)
        {
            Toast.makeText(this, "NO SE CREO NINGUN USUARIO", Toast.LENGTH_LONG).show();
        }
        identificar.setText("");
        nombre.setText("");
        rfc.setText("");
        celular.setText("");
        email.setText("");
        fecha.setText("");
    }
}
