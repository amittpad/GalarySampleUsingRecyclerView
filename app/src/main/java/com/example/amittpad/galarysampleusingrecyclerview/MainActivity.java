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
            "http://www.planwallpaper.com/static/images/i-should-buy-a-boat.jpg",
            "http://cdn.wccftech.com/wp-content/uploads/2017/02/Oreo-Two-Cookies.jpg",
            "https://www.gammerson.com/wp-content/uploads/2017/03/Google-Android-O-e1490972227545.jpg",
            "http://cdn02.androidauthority.net/wp-content/uploads/2017/08/animation-battery.gif",
            "http://fscl01.fonpit.de/userfiles/6727621/image/2016/ANDROID-M-N-O-P/AndroidPIT-android-O-Oreo-2065.jpg",
            "http://images.anandtech.com/doci/10587/Anroid_Nougat-Cover_678x452.png",
            "http://www.retrosweets.co.uk/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/w/h/wheel-lollipop.jpg",
            "http://data1.ibtimes.co.in/cache-img-0-450/en/full/570675/1436615678_micromax-launch-canvas-play-android-lollipop-soon.jpg",
            "https://i.kinja-img.com/gawker-media/image/upload/s--ITmezh3R--/c_scale,fl_progressive,q_80,w_800/fshb2xuu10edhssnikxd.jpg",

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
