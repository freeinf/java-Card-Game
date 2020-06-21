package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] levelList={"easy","medium","hard"};

    private Intent nwi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final  Button btnstart = findViewById(R.id.btnstrt);
        final Button easy = findViewById(R.id.btneasy);
        final Button medium = findViewById(R.id.btnmedium);
        final Button hard = findViewById(R.id.btnhard);


        //easy.setGravity(Gravity.CENTER_HORIZONTAL);
       // easy.setGravity(Gravity.CENTER_HORIZONTAL);






     btnstart.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             btnstart.setVisibility(View.INVISIBLE);
             Handler hd =new Handler();
             hd.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     easy.setY(btnstart.getY());
                     medium.setY(btnstart.getY()+100);
                     hard.setY(btnstart.getY()+200);
                     easy.setVisibility(View.VISIBLE);
                     medium.setVisibility(View.VISIBLE);
                     hard.setVisibility(View.VISIBLE);
                     //  stg.setVisibility(View.VISIBLE);

                     ///animation ekle

                 }
             },300);



             easy.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {


                     Intent i= new Intent(MainActivity.this,MainActivity2.class);
                     i.putExtra("mesaj","easy");


                     startActivity(i);

                 }
             });
             medium.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     Intent i1= new Intent(MainActivity.this,MainActivity2.class);
                     i1.putExtra("mesaj","medium");

                     startActivity(i1);

                 }
             });
             hard.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     Intent i2= new Intent(MainActivity.this,MainActivity2.class);
                     i2.putExtra("mesaj","hard");

                     startActivity(i2);

                 }
             });
         }
     });

    }


}