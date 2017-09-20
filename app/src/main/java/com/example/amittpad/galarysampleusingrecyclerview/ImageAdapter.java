package com.example.amittpad.galarysampleusingrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by Amit TPAD on 8/25/2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private ArrayList<ImageListPojo>  myArrayList;
    private Context context;

    public ImageAdapter(Context context, ArrayList<ImageListPojo> myArrayList) {
        this.myArrayList =  myArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_child, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Using Picasso loading image
        /*Picasso.with(context)
                .load(myArrayList.get(position).getImage_url())
                .resize(240, 120)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_pic)
                .into(holder.img);*/

        //Using Ion loading image
        Ion.with(holder.img)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_pic)
                .animateIn(AnimationUtils.loadAnimation(context, R.anim.fade_in_animation))
                .load(myArrayList.get(position).getImage_url());

        //Using Glide loding image
           /* Glide.with(context)
                    .load(myArrayList.get(position).getImage_url())
                    .thumbnail(0.5f)
                    .placeholder(R.drawable.placeholder)
                    .crossFade()
                    .into(holder.img);*/

    }


    @Override
    public int getItemCount() {
        return myArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        public ViewHolder(View view) {
            super(view);

            img = (ImageView)view.findViewById(R.id.iv_photo);
        }
    }

}
