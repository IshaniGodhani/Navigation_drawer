package com.example.logo_quiz;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Quiz_Adapter extends PagerAdapter {
    ArrayList<String> imgList;
    ImageView imageView;
    Context context;
    Button[] button = new Button[16];
    String[] ansarr;
    String ans;
    char ans_charr[];
    ArrayList arrayList = new ArrayList<>();
    int pos=0;
    int levelNo;

    SharedPreferences sharedPreferences;

    public Quiz_Adapter(Context context, ArrayList<String> imgList, int levelNo) {
        this.context = context;
        this.imgList = imgList;
        this.levelNo=levelNo;
        sharedPreferences = context.getSharedPreferences("myPref", Context.MODE_PRIVATE);
        for(int i=0;i<imgList.size();i++)
        {
            System.out.println("Images="+imgList.get(i));
        }
    }


    @Override
    public int getCount() {
        return imgList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.logo_imgitem, container, false);
        imageView = view.findViewById(R.id.logo_img);

        int pos=position;
        InputStream inputstream = null;

        if(levelNo==1)
        {
            try {
                inputstream = context.getAssets().open("pre_logo/level1/" + imgList.get(pos));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(levelNo==2)
        {
            try {
                inputstream = context.getAssets().open("pre_logo/level2/" + imgList.get(pos));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        Drawable drawable = Drawable.createFromStream(inputstream, null);
        imageView.setImageDrawable(drawable);

            container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
