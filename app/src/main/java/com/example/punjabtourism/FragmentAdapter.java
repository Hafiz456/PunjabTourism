package com.example.punjabtourism;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    int tabs;

    FragmentAdapter(FragmentManager fragmentManager, int tabsCount){
        super(fragmentManager);
        this.tabs = tabsCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Trip1();
            case 1:
                return new Trip2();
            case 2:
                return new Trip3();
            case 3:
                return new Trip4();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabs;
    }
}
