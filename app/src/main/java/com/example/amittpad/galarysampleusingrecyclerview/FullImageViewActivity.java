package com.example.amittpad.galarysampleusingrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

public class FullImageViewActivity extends AppCompatActivity {
    private String imagePreView;
    public ArrayList<ImageListPojo> myArrayList = new ArrayList<>();
    private ImageView btnCancel;
    private PhotoView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** To show full image with out any activity **/
//        PhotoView photoView = new PhotoView(this);
//        photoView.setMaximumScale(16f);
//        setContentView(photoView);
//
//        imagePreView = getIntent().getExtras().getString("Position_Id");
//
//        //Loading Image View using Picasso with PhotoView
//       /* Picasso.with(this)
//                .load(imagePreView)
//                .resize(240, 120)
//                .centerCrop()
//                .into(photoView);*/
//
//        //Loading Image View using Picasso with PhotoView
//        Ion.with(photoView)
//                .placeholder(R.drawable.placeholder)
//                .error(R.drawable.error_pic)
//                .animateIn(AnimationUtils.loadAnimation(this, R.anim.fade_in_animation))
//                .load(imagePreView);


        /** To show full image using activity with cancel button **/
        setContentView(R.layout.activity_full_image_view);
        imagePreView = getIntent().getExtras().getString("Position_Id");
        btnCancel = (ImageView) findViewById(R.id.btn_cancel);
        photoView=(PhotoView)findViewById(R.id.photo_view);
        photoView.setMaximumScale(10f);

        //Loading Image View using Picasso with PhotoView
        Ion.with(photoView)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_pic)
                .animateIn(AnimationUtils.loadAnimation(this, R.anim.fade_in_animation))
                .load(imagePreView);


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
