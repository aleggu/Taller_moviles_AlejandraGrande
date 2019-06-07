package mx.edu.ittepic.laboratorio_giroscopio;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView ejex, ejey,ejez;
    private Sensor mysensor;
    private SensorManager senman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        senman = (SensorManager) getSystemService(SENSOR_SERVICE);
        mysensor=senman.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        ejex = findViewById(R.id.ejex);
        ejey = findViewById(R.id.ejey);
        ejez = findViewById(R.id.ejez);

    }
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x,y,z;
        x = sensorEvent.values[0];
        y=  sensorEvent.values[1];
        z = sensorEvent.values[2];

        ejex.setText("  ");
        ejex.append("\n "+"Valor de X: "+ x +"\n");
        ejey.setText("  ");
        ejey.append("\n"+ "Valor de Y: "+ y +"\n");
        ejez.setText("  ");
        ejez.append("\n"+"Valor de Z: "+ z);


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @Override
    protected void onResume (){
        super.onResume();
        senman.registerListener(this,mysensor, SensorManager.SENSOR_DELAY_NORMAL );
    }

    @Override
    protected void onPause (){
        super.onPause();
        senman.unregisterListener(this);
    }

}
