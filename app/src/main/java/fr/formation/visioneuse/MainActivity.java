package fr.formation.visioneuse;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    ImageView diapo;
    ImageButton next;
    ImageButton prev;
    Sensor sensor;
    SensorManager sm;

   int[]tab ={
           R.mipmap.un,
           R.mipmap.deux,
           R.mipmap.cinq,
           R.mipmap.huit,
           R.mipmap.quatre,
           R.mipmap.sept,
           R.mipmap.six

   };
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        diapo= findViewById(R.id.ivDiapo);
        next=findViewById(R.id.ibNext);
        prev=findViewById(R.id.ibPrevious);

      sm = (SensorManager) getSystemService(SENSOR_SERVICE);
      sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);





    }
    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void previous(View view) {

        if(index>0){

        diapo.setImageResource(tab[index--]);
         }
         else{
            index=tab.length-1;
            diapo.setImageResource(tab[index]);


        }




    }
    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

      long shake = 20;

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            if (event.values[0] > shake) {

                if (index < tab.length - 1) {

                    diapo.setImageResource(tab[index++]);
                } else {
                    index = 0;
                    diapo.setImageResource(tab[index]);
                }

            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }





    public void next(View view) {

        if(index<tab.length-1){

            diapo.setImageResource(tab[index++]);
        }
        else{
            index=0;
            diapo.setImageResource(tab[index]);
        }

    }
}
