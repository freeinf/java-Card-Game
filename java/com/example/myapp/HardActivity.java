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
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HardActivity extends AppCompatActivity {
    int[] Img60xn = {R.drawable.c0, R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6,
            R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c9, R.drawable.c10, R.drawable.c11, R.drawable.c12, R.drawable.c13, R.drawable.c14, R.drawable.c15, R.drawable.c16, R.drawable.c17,
            R.drawable.c18, R.drawable.c19, R.drawable.c20, R.drawable.c21, R.drawable.c22, R.drawable.c23, R.drawable.c24, R.drawable.c25, R.drawable.c26, R.drawable.c27, R.drawable.c28, R.drawable.c29,
            R.drawable.c30, R.drawable.c40, R.drawable.c41, R.drawable.c42, R.drawable.c43, R.drawable.c44, R.drawable.c45, R.drawable.c46, R.drawable.c47, R.drawable.c48, R.drawable.c49, R.drawable.c50,
            R.drawable.c51, R.drawable.c52, R.drawable.c53, R.drawable.c54, R.drawable.c55, R.drawable.c56, R.drawable.c57, R.drawable.c58, R.drawable.c59, R.drawable.c60,
            R.drawable.c61, R.drawable.c62, R.drawable.c63, R.drawable.c64, R.drawable.c65, R.drawable.c66, R.drawable.c67, R.drawable.c68, R.drawable.c69,};
     int[] Img60xS={R.drawable.s60dp,R.drawable.s60dp2,R.drawable.s60dp3,R.drawable.s60dp4,R.drawable.s60dp5,R.drawable.s60dp6,R.drawable.s60dp7,R.drawable.s60dp8,R.drawable.s60dp9,R.drawable.s60dp10,
            R.drawable.s60dp11,R.drawable.s60dp12,R.drawable.s60dp13,R.drawable.s60dp14,R.drawable.s60dp15,R.drawable.s60dp16,R.drawable.s60dp17,R.drawable.s60dp18,R.drawable.s60dp19,R.drawable.s60dp20,
            R.drawable.s60dp21,R.drawable.s60dp22,R.drawable.s60dp23,R.drawable.s60dp24,R.drawable.s60dp25,R.drawable.s60dp26,R.drawable.s60dp27,R.drawable.s60dp28,R.drawable.s60dp29,R.drawable.s60dp30,
            R.drawable.s60dp31,R.drawable.s60dp32,R.drawable.s60dp33,R.drawable.s60dp34,R.drawable.s60dp35,R.drawable.s60dp36,R.drawable.s60dp37,R.drawable.s60dp38,R.drawable.s60dp39};
    int[]  img60xe={R.drawable.e60dp,R.drawable.e60dp1,R.drawable.e60dp2,R.drawable.e60dp3,R.drawable.e60dp4,R.drawable.e60dp5,R.drawable.e60dp6,R.drawable.e60dp7,R.drawable.e60dp8,R.drawable.e60dp9,
            R.drawable.e60dp10,R.drawable.e60dp11,R.drawable.e60dp12,R.drawable.e60dp13,R.drawable.e60dp14,R.drawable.e60dp15,R.drawable.e60dp16,R.drawable.e60dp17,R.drawable.e60dp18,R.drawable.e60dp19,
            R.drawable.e60dp20,R.drawable.e60dp21,R.drawable.e60dp22,R.drawable.e60dp23,R.drawable.e60dp24,R.drawable.e60dp25,R.drawable.e60dp26,R.drawable.e60dp27,R.drawable.e60dp28,R.drawable.e60dp29, R.drawable.e60dp30,R.drawable.e60dp31,R.drawable.e60dp32,R.drawable.e60dp33,R.drawable.e60dp34};
    int[]  img60xh={R.drawable.h60xm,R.drawable.h60xm1,R.drawable.h60xm2,R.drawable.h60xm3,R.drawable.h60xm4,R.drawable.h60xm5,R.drawable.h60xm6,R.drawable.h60xm7,R.drawable.h60xm8,R.drawable.h60xm9,
            R.drawable.h60xm10,R.drawable.h60xm11,R.drawable.h60xm12,R.drawable.h60xm13,R.drawable.h60xm14,R.drawable.h60xm15,R.drawable.h60xm16,R.drawable.h60xm18,R.drawable.h60xm19,
            R.drawable.h60xm20,R.drawable.h60xm21,R.drawable.h60xm22,R.drawable.h60xm23,R.drawable.h60xm24,R.drawable.h60xm25,R.drawable.h60xm26,R.drawable.h60xm27,R.drawable.h60xm28,R.drawable.h60xm29,
            R.drawable.h60xm30,R.drawable.h60xm31,R.drawable.h60xm32};
    int lastCart = -1;
    private int score=0;
    Button scrButton;
    public int getScore() {
        return score;
    }
    String Categori ="";
    private ArrayList<BaseCart> dualCard =new ArrayList<>();
    public List<Integer> imgs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);
        Intent intent = getIntent();
        Categori= intent.getStringExtra("seviye");
        ConstraintLayout ct = findViewById(R.id.hcst);
        LinearLayout LinL = findViewById(R.id.hliner);
        imgs =new ArrayList<Integer>();
        ArrayList<LinearLayout> LinerList =new ArrayList<LinearLayout>();
        scrButton= findViewById(R.id.scrbtn);
        scrButton.setTextSize(32);
        scrButton.setTextColor(Color.WHITE);
        scrButton.setText(String.valueOf(getScore()));

        if (Categori.equals("numbers")){
            imgGenerator(Img60xn,16);

        }else if (Categori.equals("symbols")){
            imgGenerator(Img60xS,16);

        }else if (Categori.equals("emojie")){
            imgGenerator(img60xe,16);

        }else if (Categori.equals("mixed")){
            imgGenerator(img60xh,16);

        }


            BaseCart.Bimgs=imgs;
            final Button Carts[] = new BaseCart[32];
            for (int i=0;i<8;i++){//8 satır var

                LinearLayout lin = new LinearLayout(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity= Gravity.CENTER_HORIZONTAL;

                lin.setLayoutParams(params);
                lin.setOrientation(LinearLayout.HORIZONTAL);



                LinerList.add(i,lin);
            }
            for (int k=0;k<32;k++){//32 kart oluşturuyor
                Carts[k] = new BaseCart(this, k,R.drawable.b60dp6);

                Carts[k].setFocusable(true);
                Carts[k].setClickable(true);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
              //  params.setMargins(5, 5, 0,0);
                Carts[k].setLayoutParams(params);

                Carts[k].setWidth(pxToDp(50));
               // Carts[k].setPadding(5,5,5,5);
                Carts[k].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final BaseCart k = (BaseCart) v;
                        k.reverseCart();
                        if (dualCard.size()>0){
                            if (!dualCard.contains(k) && dualCard.get(0).faceId == k.faceId){
                                score +=1;
                                scrButton.setText(String.valueOf(getScore()));
                                if (score==16){
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
        for (int m= 0; m < 32; m++) {
            int rg = (int) (Math.random() * 32);
            Button k = Carts[rg];
            Carts[rg] = Carts[m];
            Carts[m] = k;
        }
            int r=0;
            for (LinearLayout ly :LinerList) {

                for (int j=0;j<4;j++){


                    ly.addView(Carts[j+r]);

                }
                r+=4;


            }



            for (LinearLayout ly :LinerList) {

                LinL.addView(ly);
            }


    }
    public  void lvlEn(){
        AlertDialog.Builder builder = new AlertDialog.Builder(HardActivity.this);

        builder.setMessage(R.string.dialog_messagge);//türk.e desktek ekle
        //butonu modifiye et

        builder.setTitle(R.string.dialog_title);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent nwi =new Intent(HardActivity.this,MediumActivity.class);
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
                Intent nwI2= new Intent(HardActivity.this,MainActivity2.class);
                nwI2.putExtra("mesaj","hard");
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
        Intent nwI2= new Intent(HardActivity.this,MainActivity2.class);
        nwI2.putExtra("mesaj","hard");
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