package com.example.myapplication.ADAPTER;

import static com.example.myapplication.R.layout.main_recyclerview_circle;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.AdapterCLASS.mainCircleCLASS;
import com.example.myapplication.R;

import java.util.ArrayList;

public class mainCircleADAPTER extends RecyclerView.Adapter<mainCircleADAPTER.MyViewHolder> {

    Context context;
    ArrayList<mainCircleCLASS> circleData;

    public mainCircleADAPTER(Context context, ArrayList<mainCircleCLASS> circleData) {
        this.context = context;
        this.circleData = circleData;
    }

    @NonNull
    @Override
    public mainCircleADAPTER.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(main_recyclerview_circle,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mainCircleADAPTER.MyViewHolder holder, int position) {
        mainCircleCLASS circle1 = circleData.get(position);
        //Log.d("check heading",String.valueOf(circle1.heading));
        Log.d("check text heading",String.valueOf(holder.textHeading.getText()));
        holder.textHeading.setText(circle1.cllg_club_heading);
        holder.textTitle.setText(circle1.cllg_club_title);
        Log.d("check text heading",String.valueOf(holder.textHeading.getText()));
        holder.titleImage.setImageResource(circle1.cllg_clb_titleImage);
        //holder.background.setBackgroundResource(circle1.cllg_club_background);
    }

    @Override
    public int getItemCount() {
        return circleData.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textHeading;
        TextView textTitle;
        ImageView titleImage;
        ConstraintLayout background;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textHeading = itemView.findViewById(R.id.textView2);
            titleImage = itemView.findViewById(R.id.main_recyclerview_circle_imageview);
            textTitle = itemView.findViewById(R.id.adapter_title);
            //background = itemView.findViewById(R.id.adapter_backgroung);
        }
    }
}
