package mx.edu.ittepic.juegopulsor;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    float num_boton, num, clic, numerogenerado;
    String guardarnum, guardar_p;
    TextView numero_random;
    Button numero;
    CountDownTimer generar;
    DecimalFormat formato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        formato = new DecimalFormat("#.0");//formato
        num = (float) (Math.random() * 3); //generar el numero entre 1 y 3
        if (num < 1.0) {
            num++;
        }
        num_boton = 0;
        guardarnum = formato.format(num);//convertir el numero al formato de 0.1
        numerogenerado=Float.parseFloat(guardarnum);

        numero_random = findViewById(R.id.txt_numero_random);
        numero_random.setText(guardarnum);

        numero = findViewById(R.id.boton_numero);
        generar = new CountDownTimer(1000, 400) {
            @Override
            public void onTick(long millisUntilFinished) {
                num_boton += 0.1;
                guardar_p = formato.format(num_boton);
                numero.setText(guardar_p);
                if (num_boton >= 2.9) {
                    num_boton = 0;
                }
            }

            @Override
            public void onFinish() {
                generar.start();
            }
        };generar.start();

        numero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clic= Float.parseFloat(guardar_p);
                if(numerogenerado==clic)
                {
                    generar.cancel();
                    Toast.makeText(MainActivity.this, "Haz ganado!!", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    num= (float) (Math.random() * 3); //generar el numero entre 1 y 3
                    if(num<1.0)
                    {
                        num++;
                    }
                    guardarnum=formato.format(num);//convertir el numero al formato de 0.1
                    numero_random.setText(guardarnum);
                }
            }
        });

    }
}
