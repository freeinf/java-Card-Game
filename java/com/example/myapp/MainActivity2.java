package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;


import android.content.Intent;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;

import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity {
    ArrayList<String> emctList =new ArrayList<>();
    ArrayList<String> hctList = new ArrayList<>();
    ArrayList<Button> ctbtnList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent in=getIntent();
        String mesaj = in.getStringExtra("mesaj");

        emctList.add("animals");
        emctList.add("moons");
        emctList.add("symbols");
        hctList.add("numbers");
        hctList.add("symbols");
        hctList.add("emojie");
        //hctList.add("moons");
      // hctList.add("mixed");


        LinearLayout lin = findViewById(R.id.llmain2);
        Drawable draw = AppCompatResources.getDrawable(this,R.drawable.graybtn);
        assert mesaj != null;
        switch (mesaj){
            case "easy":
                for (int i =0;i<emctList.size();i++){
                    ctbtnList.add(i,new Button(this));

                    ctbtnList.get(i).setBackground(draw);
                    final String seviye=emctList.get(i);

                    switch (seviye){
                        case "animals":
                            ctbtnList.get(i).setText(R.string.animals);
                            break;
                        case "moons":
                            ctbtnList.get(i).setText(R.string.moons);
                            break;
                        case "symbols":
                            ctbtnList.get(i).setText(R.string.symbols);
                            break;
                        default:
                            break;
                    }





                    ctbtnList.get(i).setTextColor(Color.WHITE);

                    ctbtnList.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent= new Intent(MainActivity2.this,EasyActivity.class);
                            System.out.println(seviye+"--------------------------");
                            intent.putExtra("seviye",seviye);
                            startActivity(intent);
                        }
                    });
                    lin.addView(ctbtnList.get(i));
                }
                break;
            case "medium":
                for (int i = 0; i < emctList.size(); i++) {
                    Button btn = new Button(this);
                    Drawable draw3 = AppCompatResources.getDrawable(this, R.drawable.graybtn);
                    btn.setBackground(draw3);
                    final String seviye = emctList.get(i);
                    switch (seviye){
                        case "animals":
                            btn.setText(R.string.animals);
                            break;
                        case "moons":
                            btn.setText(R.string.moons);
                            break;
                        case "symbols":
                            btn.setText(R.string.symbols);
                            break;
                        default:
                            break;
                    }
                    btn.setTextColor(Color.WHITE);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(MainActivity2.this, MediumActivity.class);
                            intent.putExtra("seviye", seviye);
                            startActivity(intent);
                        }
                    });
                    lin.addView(btn);

                }
                break;
            case "hard":
                for (int i =0;i<hctList.size();i++){
                    Button btn =new Button(this);
                    Drawable draw2 = AppCompatResources.getDrawable(this,R.drawable.graybtn);
                    btn.setBackground(draw2);
                    final String seviye=hctList.get(i);
                    switch (seviye){
                        case "numbers":
                            btn.setText(R.string.numbers);
                            break;
                        case "emojie":
                            btn.setText(R.string.emojie);
                            break;
                        case "symbols":
                            btn.setText(R.string.symbols);
                            break;
                        default:
                            break;
                    }

                    btn.setTextColor(Color.WHITE);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent= new Intent(MainActivity2.this,HardActivity.class);
                            intent.putExtra("seviye",seviye);
                            startActivity(intent);
                        }
                    });
                    lin.addView(btn);

                }
                break;
            default:
                break;

        }

        /*if (mesaj.equals("easy")){
            for (int i =0;i<emctList.size();i++){
                Button btn =new Button(this);
                Drawable draw = AppCompatResources.getDrawable(this,R.drawable.graybtn);
                btn.setBackground(draw);
                final String seviye=hctList.get(i);
                btn.setText(emctList.get(i));
                btn.setTextColor(Color.WHITE);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent= new Intent(MainActivity2.this,EasyActivity.class);
                        intent.putExtra("seviye",seviye);
                        startActivity(intent);
                    }
                });
                lin.addView(btn);
            }
        }else if(mesaj.equals("medium")) {
            for (int i = 0; i < emctList.size(); i++) {
                Button btn = new Button(this);
                Drawable draw = AppCompatResources.getDrawable(this, R.drawable.graybtn);
                btn.setBackground(draw);
                final String seviye = hctList.get(i);
                btn.setText(emctList.get(i));
                btn.setTextColor(Color.WHITE);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MainActivity2.this, MediumActivity.class);
                        intent.putExtra("seviye", seviye);
                        startActivity(intent);
                    }
                });
                lin.addView(btn);

            }


        }else if (mesaj.equals("hard")){
            for (int i =0;i<hctList.size();i++){
                Button btn =new Button(this);
                Drawable draw = AppCompatResources.getDrawable(this,R.drawable.graybtn);
                btn.setBackground(draw);
                final String seviye=hctList.get(i);
                btn.setText(seviye);

                btn.setTextColor(Color.WHITE);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(MainActivity2.this,HardActivity.class);
                        intent.putExtra("seviye",seviye);
                        startActivity(intent);
                    }
                });
                lin.addView(btn);

            }
        }*/
    }

}
