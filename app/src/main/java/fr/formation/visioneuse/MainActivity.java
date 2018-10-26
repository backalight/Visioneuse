package fr.formation.visioneuse;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView diapo;
    ImageButton next;
    ImageButton prev;

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
