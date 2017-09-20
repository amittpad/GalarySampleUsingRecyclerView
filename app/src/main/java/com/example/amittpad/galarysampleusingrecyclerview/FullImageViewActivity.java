package com.example.amittpad.galarysampleusingrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;

import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

public class FullImageViewActivity extends AppCompatActivity {
    private String imagePreView;
    public ArrayList<ImageListPojo> myArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PhotoView photoView=new PhotoView(this);
        photoView.setMaximumScale(16f);
        setContentView(photoView);

      imagePreView = getIntent().getExtras().getString("Position_Id");

        //Loading Image View using Picasso with PhotoView
       /* Picasso.with(this)
                .load(imagePreView)
                .resize(240, 120)
                .centerCrop()
                .into(photoView);*/

        //Loading Image View using Picasso with PhotoView
        Ion.with(photoView)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_pic)
                .animateIn(AnimationUtils.loadAnimation(this, R.anim.fade_in_animation))
                .load(imagePreView);



    }
}
