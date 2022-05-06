package com.example.viewpagertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

//1.為ViewPagerAdapter宣告
//2.為ViewPager設定一個監聽器
//3.將需要的頁面加入ViewPagerAdapter中
//4.最後再將上述設定都套進TabLayout就完成

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager pager;
    ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        tabs = findViewById(R.id.tabs);
        pager = findViewById(R.id.viewpager);

        pagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        setupViewPager(pager);
        tabs.setupWithViewPager(pager);

    }

    public void setupViewPager(ViewPager viewPager) {
        pagerAdapter.addFragment(new Page01(), "頁面1");
        pagerAdapter.addFragment(new Page02(), "頁面2");
        pagerAdapter.addFragment(new Page03(), "頁面3");
        viewPager.setAdapter(pagerAdapter);

    }
}