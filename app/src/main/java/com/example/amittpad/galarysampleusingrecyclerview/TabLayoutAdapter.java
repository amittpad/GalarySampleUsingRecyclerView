package com.example.amittpad.galarysampleusingrecyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by pc31 on 24-08-2017.
 */

public class TabLayoutAdapter extends FragmentStatePagerAdapter {

        public TabLayoutAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    FullFragment obj = new FullFragment();
                    return obj;
                default:
                    return null;
            }
        }
        @Override
        public int getCount() {
            return 1;
        }

}
