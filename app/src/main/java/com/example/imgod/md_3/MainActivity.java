package com.example.imgod.md_3;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabs;
    private ViewPager viewpager;

    private List<Fragment> fragments;
    private List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabs = (TabLayout) findViewById(R.id.tabs);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        toolbar.setTitle("ToolBar");
        setSupportActionBar(toolbar);

        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        fragments.add(TabFragment.newInstance("Tab1"));
        fragments.add(TabFragment.newInstance("Tab2"));
        fragments.add(TabFragment.newInstance("Tab3"));
        titles.add("Tab1");
        titles.add("Tab2");
        titles.add("Tab3");
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments, titles);
        viewpager.setAdapter(viewPagerAdapter);

        tabs.setupWithViewPager(viewpager);//这行代码位置
    }
}
