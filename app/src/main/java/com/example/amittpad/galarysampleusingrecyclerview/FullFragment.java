package com.example.amittpad.galarysampleusingrecyclerview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoView;

public class FullFragment extends Fragment {
    private String imagePreView;
    ViewPager viewPager;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_full,container,false);
        viewPager=(ViewPager)view.findViewById(R.id.viewpager);
        TabLayoutAdapter obj = new TabLayoutAdapter(getFragmentManager());

        viewPager.setAdapter(obj);
        PhotoView photoView=new PhotoView(this.getActivity());
        photoView.setMaximumScale(16f);

        String getArgument = getArguments().getString("data");

         Picasso.with(this.getActivity())
                .load(getArgument)
                .resize(240, 120)
                .centerCrop()
                .into(photoView);
        return view;
    }


}
