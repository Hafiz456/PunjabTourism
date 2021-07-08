package com.example.punjabtourism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class UpcomingTrips extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentAdapter fragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_trips);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Trip 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Trip 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Trip 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Trip 4"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(fragmentAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}