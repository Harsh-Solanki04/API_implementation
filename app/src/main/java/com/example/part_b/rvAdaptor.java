package com.example.part_b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class rvAdaptor extends RecyclerView.Adapter<rvAdaptor.rvholderRetroFit> {
    Context context;
    List<ImageResult> imageResultList;
    public rvAdaptor(Context context,List<ImageResult> imageResultList){
        this.context=context;
        this.imageResultList=imageResultList;
    }

    @NonNull
    @Override
    public rvAdaptor.rvholderRetroFit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView= LayoutInflater.from(context).inflate(R.layout.rvimage_item,parent,false);
        return new rvholderRetroFit(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull rvAdaptor.rvholderRetroFit holder, int position) {
        holder.tvTitle.setText(imageResultList.get(position).getTitle());
        Glide.with(context).
                load(imageResultList.get(position).getImage())
                .placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return imageResultList.size();
    }
    public class rvholderRetroFit extends RecyclerView.ViewHolder{
        TextView tvTitle;
        ImageView ivImage;
        public rvholderRetroFit(@NonNull View itemView){
            super(itemView);
            ivImage=itemView.findViewById(R.id.ivImage);
            tvTitle=itemView.findViewById(R.id.tvTitle);
        }
    }
}
