package com.example.amittpad.galarysampleusingrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Amit TPAD on 8/25/2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private ArrayList<ImageListPojo>  androidVersion;
    private Context context;

    public ImageAdapter(Context context, ArrayList<ImageListPojo> androidVersion) {
        this.androidVersion =  androidVersion;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context).load(androidVersion.get(position).getImage_url()).resize(120, 60).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return androidVersion.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        public ViewHolder(View view) {
            super(view);

            img = (ImageView)view.findViewById(R.id.iv_photo);
        }
    }
}
