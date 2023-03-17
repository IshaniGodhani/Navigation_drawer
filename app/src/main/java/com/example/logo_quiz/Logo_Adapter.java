package com.example.logo_quiz;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Logo_Adapter extends RecyclerView.Adapter<Logo_Adapter.View_holder> {
    Context context;
    List<String> imgList;
    int pos;

    public Logo_Adapter(Context context, List<String> imgList, int pos) {
        this.context=context;
        this.imgList=imgList;
        this.pos = pos;
    }

    @NonNull
    @Override
    public View_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_logo,parent,false);
        View_holder view_holder=new View_holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_holder holder, int position) {
        //int pos=position;
        InputStream inputstream = null;
        if(pos==1)
        {
            try
            {
                inputstream = context.getAssets().open("pre_logo/level1/"+imgList.get(position));
//                System.out.println("No of Images="+imgList.size());
//                System.out.println("imgList Position="+imgList.get(position));
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        if(pos==2)
        {
            try
            {
                inputstream = context.getAssets().open("pre_logo/level2/"+imgList.get(position));
//                System.out.println("No of Images="+imgList.size());
//                System.out.println("imgList Position="+imgList.get(position));
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        Drawable drawable = Drawable.createFromStream(inputstream, null);
        holder.logo.setImageDrawable(drawable);
        holder.logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Quiz_Activity.class);
                intent.putExtra("index",(holder.getAdapterPosition()+1));
                intent.putExtra("levelNo",pos);

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }

    public class View_holder extends RecyclerView.ViewHolder {

        ImageView logo;
        public View_holder(@NonNull View itemView) {
            super(itemView);

            logo=itemView.findViewById(R.id.logo);
        }
    }
}
