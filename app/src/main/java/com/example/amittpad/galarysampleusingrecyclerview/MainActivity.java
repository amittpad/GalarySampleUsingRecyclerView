package com.example.amittpad.galarysampleusingrecyclerview;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String image_urls[] = {
            "https://www.w3schools.com/css/img_fjords.jpg",
            "https://static.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg",
            "http://www.qygjxz.com/data/out/8/4421389-android-wallpaper.png",
            "https://www.androidcentral.com/sites/androidcentral.com/files/styles/w550h500/public/wallpapers/dc-superhero-suits-a8o.jpg?itok=KSU3SFs-",
            "http://www.planwallpaper.com/static/images/11-sea-beach-sand-wallpaper_sf9i1b6.jpg",
            "http://www.planwallpaper.com/static/images/303836.jpg",
            "http://www.planwallpaper.com/static/images/colorful-triangles-background.jpg",
            "http://www.planwallpaper.com/static/images/i-should-buy-a-boat.jpg"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList myArrayList = prepareData();
        ImageAdapter adapter = new ImageAdapter(getApplicationContext(),myArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                for (int i=0;i<position;i++){
                    Intent intent = new Intent(MainActivity.this,FullImageViewActivity.class);
                    String sImage =image_urls[position];
                    intent.putExtra("Position_Id",sImage);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                   /* Intent intent = new Intent(MainActivity.this,FullFragment.class);
                    Fragment argumentFragment = new Fragment();//Get Fragment Instance
                    Bundle data = new Bundle();//Use bundle to pass data
                    String sImage =image_urls[position];
                    data.putString("data", sImage);//put string, int, etc in bundle with a key value
                    argumentFragment.setArguments(data);//Finally set argument bundle to fragment
                    startActivity(intent);
*/
                }


            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

    private ArrayList prepareData() {

        ArrayList<ImageListPojo> my_arraylist = new ArrayList<>();
        for (int i = 0; i < image_urls.length; i++) {
            ImageListPojo imageListPojos = new ImageListPojo();
            imageListPojos.setImage_url(image_urls[i]);
            my_arraylist.add(imageListPojos);
        }
        return my_arraylist;
    }
}
