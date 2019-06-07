package mx.edu.ittepic.json_recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    ArrayList<NumerosVo> listaAlumnos;
    String cadena="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recycler = findViewById(R.id.RecyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listaAlumnos = new ArrayList<NumerosVo>();
        llenar();
        leer();



    }

    private void leer() {
        for (int i=0; i<5;i++)
        {

        }


    }

    private void llenar() {
        String url ="https://api.myjson.com/bins/1hhlni";

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            public void onResponse(JSONObject response) {
                try
                {
                    JSONArray array = response.getJSONArray("alumnos");
                    for (int i=0; i<=20;i++) {
                        JSONObject object = array.getJSONObject(i);
                        String numero = object.getString("Nctrl");
                        String nombre = object.getString("Name");
                        String cal1 = object.getString("u1");
                        String cal2 = object.getString("u2");
                        String cal3 = object.getString("u3");
                        cadena = " Numero " + numero + "\n Nombre " + nombre + "\n Cal 1 " + cal1 + "\n Cal 2 " + cal2 + "\n Cal 3 " + cal3 + "";

                        listaAlumnos.add(new NumerosVo(numero, nombre, cal1,cal2,cal3));
                    }
                    Adapter adapter= new Adapter(listaAlumnos);
                    recycler.setAdapter(adapter);

                }catch(JSONException e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);

    }
}

