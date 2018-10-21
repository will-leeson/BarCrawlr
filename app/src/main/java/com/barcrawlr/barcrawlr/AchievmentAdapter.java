package com.barcrawlr.barcrawlr;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AchievmentAdapter extends RecyclerView.Adapter<AchievmentAdapter.AchievementViewHolder>{
    private Context context;
    private ArrayList<Achievement> achievments;

    public AchievmentAdapter(Context context, ArrayList<Achievement> dataset){
        this.context = context;
        this.achievments = dataset;
    }

    public static class AchievementViewHolder extends RecyclerView.ViewHolder{
        public TextView nameView;
        public ImageView imageView;

        public AchievementViewHolder(View v) {
            super(v);
            nameView = v.findViewById(R.id.achievement_text);
            imageView = v.findViewById(R.id.achievement_image);
        }
    }

    @Override
    public int getItemCount(){
        return achievments.size();
    }

    @Override
    public AchievmentAdapter.AchievementViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.achievement_cell, parent, false);
        AchievementViewHolder vh = new AchievementViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AchievementViewHolder holder, int position){
        holder.nameView.setText(achievments.get(position).getName());
        holder.imageView.setImageBitmap(achievments.get(position).getImage());
    }


}
