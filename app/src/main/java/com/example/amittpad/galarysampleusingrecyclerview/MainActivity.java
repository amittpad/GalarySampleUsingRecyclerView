package com.example.amittpad.galarysampleusingrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String image_urls[] = {
            "http://i.imgur.com/ovr0NAF.jpg",
            "http://i.imgur.com/n6RfJX2.jpg",
            "http://i.imgur.com/qpr5LR2.jpg",
            "http://i.imgur.com/pSHXfu5.jpg",
            "http://i.imgur.com/3wQcZeY.jpg",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList androidVersion = prepareData();
        ImageAdapter adapter = new ImageAdapter(getApplicationContext(),androidVersion);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList prepareData() {

        ArrayList<ImageListPojo> android_version = new ArrayList<>();
        for (int i = 0; i < image_urls.length; i++) {
            ImageListPojo androidVersion = new ImageListPojo();
            androidVersion.setImage_url(image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}
