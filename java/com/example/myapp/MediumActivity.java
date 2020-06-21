package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MediumActivity extends AppCompatActivity {

    int[] Img120x = {R.drawable.a120dp1, R.drawable.a120dp2, R.drawable.a120dp3, R.drawable.a120dp4, R.drawable.a120dp5,
            R.drawable.a120dp6, R.drawable.a120dp7, R.drawable.a120dp8, R.drawable.a120dp9, R.drawable.a120dp10,
            R.drawable.a120dp11, R.drawable.a120dp12, R.drawable.a120dp13, R.drawable.a120dp14, R.drawable.a120dp15, R.drawable.a120dp16,
            R.drawable.a120dp17, R.drawable.a120dp18, R.drawable.a120dp19, R.drawable.a120dp20, R.drawable.a120dp21};
    int[] Img120xm={R.drawable.m120dp1,R.drawable.m120dp2,R.drawable.m120dp3,R.drawable.m120dp4,R.drawable.m120dp5,R.drawable.m120dp6,R.drawable.m120dp7,
            R.drawable.m120dp8,R.drawable.m120dp9,R.drawable.m120dp10,R.drawable.m120dp11,R.drawable.m120dp12,R.drawable.m120dp13,R.drawable.m120dp14,R.drawable.m120dp15,R.drawable.m120dp16};
    int[] Img120xS={R.drawable.s120dp1,R.drawable.s120dp2,R.drawable.s120dp3,R.drawable.s120dp4,R.drawable.s120dp5,R.drawable.s120dp6,R.drawable.s120dp7,R.drawable.s120dp8,R.drawable.s120dp9,R.drawable.s120dp10,
            R.drawable.s120dp11,R.drawable.s120dp12,R.drawable.s120dp13,R.drawable.s120dp14,R.drawable.s120dp15,R.drawable.s120dp16,R.drawable.s120dp17,R.drawable.s120dp18,R.drawable.s120dp19,R.drawable.s120dp20,
            R.drawable.s120dp21,R.drawable.s120dp22,R.drawable.s120dp23,R.drawable.s120dp24,R.drawable.s120dp25,R.drawable.s120dp26,R.drawable.s120dp27,R.drawable.s120dp28,R.drawable.s120dp29,R.drawable.s120dp30,
            R.drawable.s120dp31,R.drawable.s120dp32,R.drawable.s120dp33,R.drawable.s120dp34,R.drawable.s120dp35,R.drawable.s120dp36,R.drawable.s120dp37,R.drawable.s120dp38,R.drawable.s120dp39};
    int lastCart = -1;
    private int score=0;
    String Categori ="";
    public List<Integer> imgs;
    Button scrButton;
    private ArrayList<BaseCart> dualCard =new ArrayList<>();
    public int getScore() {
        return score;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);
        Intent intent = getIntent();
        Categori= intent.getStringExtra("seviye");
          ConstraintLayout ct = findViewById(R.id.mcst);
        LinearLayout LinL = findViewById(R.id.liner);
        scrButton= findViewById(R.id.scrbtn);
        scrButton.setTextSize(32);
        scrButton.setTextColor(Color.WHITE);
        scrButton.setText(String.valueOf(getScore()));

         imgs =new ArrayList<Integer>();
        ArrayList<LinearLayout> LinerList =new ArrayList<LinearLayout>();

        if (Categori.equals("animals")){
           imgGenerator(Img120x,6);


        }else if (Categori.equals("moons")){
            imgGenerator(Img120xm,6);

        }
        else if (Categori.equals("symbols")){
            imgGenerator(Img120xS,6);
        }


        BaseCart.Bimgs=imgs;
         final Button Carts[] = new BaseCart[12];
        for (int i=0;i<4;i++){

            LinearLayout lin = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.gravity=Gravity.CENTER_HORIZONTAL;

            lin.setLayoutParams(params);
            lin.setOrientation(LinearLayout.HORIZONTAL);



            LinerList.add(i,lin);
        }
        for (int k=0;k<12;k++){
            Carts[k] = new BaseCart(this, k,R.drawable.b120p);

            Carts[k].setFocusable(true);
            Carts[k].setClickable(true);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(5, 5, 0,0);
            Carts[k].setLayoutParams(params);

            Carts[k].setHeight(pxToDp(100));
            Carts[k].setPadding(5,5,5,5);
            Carts[k].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final BaseCart k = (BaseCart) v;
                    k.reverseCart();
                    if (dualCard.size()>0){
                        if (!dualCard.contains(k) && dualCard.get(0).faceId == k.faceId){
                            score +=1;
                            scrButton.setText(String.valueOf(getScore()));
                            if (score==6){
                                lvlEn();
                            }else{
                                dualCard.get(0).setEnabled(false);

                                dualCard.get(0).isreversing = false;

                                k.setEnabled(false);
                                k.isreversing=false;



                                System.out.println("eşleştik burdayım");
                            }

                            dualCard.remove(0);

                        }else{
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    dualCard.get(0).reverseCart();
                                    k.reverseCart();
                                    dualCard.remove(0);
                                    System.out.println("eşleşmedik burdayım");
                                }
                            }, 200);


                        }

                    }else{
                        dualCard.add(0,k);
                        System.out.println("Eklendim"+dualCard.size());
                    }



                }
            });

        }

        for (int m= 0; m < 12; m++) {
            int rg = (int) (Math.random() * 12);
            Button k = Carts[rg];
            Carts[rg] = Carts[m];
            Carts[m] = k;
        }

         int r=0;
        for (LinearLayout ly :LinerList) {

            for (int j=0;j<3;j++){


                ly.addView(Carts[j+r]);

            }
            r+=3;


        }



        for (LinearLayout ly :LinerList) {

            LinL.addView(ly);
        }
    }
    public  void lvlEn(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MediumActivity.this);

        builder.setMessage(R.string.dialog_messagge);//türk.e desktek ekle
        //butonu modifiye et

        builder.setTitle(R.string.dialog_title);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent nwi =new Intent(MediumActivity.this,MediumActivity.class);
                nwi.putExtra("mesaj",Categori);

                // startActivity(nwi);
                startActivity(getIntent());
                finish();
                overridePendingTransition(0, 0);
                score=0;
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent nwI2= new Intent(MediumActivity.this,MainActivity2.class);
                nwI2.putExtra("mesaj","medium");
                score=0;
                startActivity(nwI2);

                dialogInterface.cancel();
            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();
    }
    @Override
    public void onBackPressed() {
        Intent nwI2= new Intent(MediumActivity.this,MainActivity2.class);
        nwI2.putExtra("mesaj","medium");
        startActivity(nwI2);

        overridePendingTransition(0, 0);
        super.onBackPressed();
    }

    public  void imgGenerator(int[] array, int numberElts){


        //List<Integer> elts = new ArrayList<Integer>();
        int nwrdm = array[(int) (Math.random() * (array.length - 1))];
        if (!imgs.contains(nwrdm)){
            imgs.add(nwrdm);
        }

        for (int i=0;i<numberElts-1;i++){
            int nw = array[(int) (Math.random() * (array.length - 1))];
            while (imgs.contains(nw)) {
                nw  = array[(int) (Math.random() * (array.length - 1))];
            }
            imgs.add(nw);
        }

    }
    public static int pxToDp(int px)
    {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
}

/*
       Carts[k].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
final BaseCart k = (BaseCart) v;
        k.reverseCart();
        if (lastCart > 0) {
final BaseCart k2 = findViewById(lastCart);
        if (k2.faceId == k.faceId && k2.getId() != k.getId()) {
        k2.isreversing = false;
        k.isreversing = false;

        score++;

        scrButton.setText(String.valueOf(getScore()));
        if (score==6){
        AlertDialog.Builder builder = new AlertDialog.Builder(MediumActivity.this);

        builder.setMessage(R.string.dialog_messagge);//türk.e desktek ekle
        //butonu modifiye et

        builder.setTitle(R.string.dialog_title);
        builder.setPositiveButton(R.string.btn_yes, new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialogInterface, int i) {
        Intent nwi =new Intent(MediumActivity.this,MediumActivity.class);
        nwi.putExtra("mesaj",Categori);

        startActivity(getIntent());
        finish();
        overridePendingTransition(0, 0);
        score=0;
        dialogInterface.cancel();
        }
        });
        builder.setNegativeButton(R.string.btn_no, new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialogInterface, int i) {
        Intent nwI2= new Intent(MediumActivity.this,MainActivity2.class);
        nwI2.putExtra("mesaj","medium");
        score=0;
        startActivity(nwI2);

        dialogInterface.cancel();
        }
        });

        AlertDialog dialog = builder.create();

        dialog.show();


        }
        } else {

        //eşleşmediler
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
@Override
public void run() {
        k.reverseCart();
        k2.reverseCart();
        }
        }, 200);

        lastCart = -1;
        }
        } else {
        lastCart = k.getId();
        }

        }
        });*/
