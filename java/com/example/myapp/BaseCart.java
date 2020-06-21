package com.example.myapp;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;

import java.util.List;

public class BaseCart extends AppCompatButton {

    public Boolean isopen=false;
    Drawable back;
    Drawable face;
    public Boolean isreversing=true;
    public  int backId;
    public int faceId;
    public static List<Integer> Bimgs;


    public BaseCart(Context context, int id,int bId) {
        super(context);

        setId(id);



        faceId=R.drawable.s2;
        backId=bId;

        //rastgele resim eklemeyi unutma
        //3 değişken belirle
        for (int j :Bimgs){
            System.out.println(j);

        }

        for (int i=0;i<Bimgs.size();i++){
            if (id%Bimgs.size() ==i){
                faceId=Bimgs.get(i);

            }
        }


        face = AppCompatResources.getDrawable(context,faceId);

        back= AppCompatResources.getDrawable(context,backId);
        setBackground(back);
    }



    public void reverseCart(){
        if (isreversing){
            if(!isopen)//arkası cevriliyse
            {
                setBackground(face);
                isopen=true;
            }else{
                setBackground(back);
                isopen=false;
            }
        }
    }
}
