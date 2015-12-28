package com.yushilei.qiushibaike;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.yushilei.qiushibaike.adapters.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, SlidingPaneLayout.PanelSlideListener, NavigationView.OnNavigationItemSelectedListener {
    private TabLayout tab;
    private ViewPager pager;
    private MyAdapter adapter;
    private List<String> list;

    private SlidingPaneLayout slidingPaneLayout;
    private NavigationView navigationView;

    private boolean isCanScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.main_sliding_pane_layout);
        navigationView = (NavigationView) findViewById(R.id.main_navigation_view);
        pager = (ViewPager) findViewById(R.id.main_view_pager);
        tab = (TabLayout) findViewById(R.id.main_tab_layout);

        list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(String.format("第%02d页", i));
        }
        adapter = new MyAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);

        pager.setOnTouchListener(this);
        slidingPaneLayout.setPanelSlideListener(this);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d("MainActivity", "onTouch");
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics out = new DisplayMetrics();
        display.getMetrics(out);
        int totalWidth = out.widthPixels;
        float eX = event.getX();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (eX >= totalWidth / 5) {
                    isCanScroll = true;
                } else {
                    isCanScroll = false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (isCanScroll) {
                    pager.requestDisallowInterceptTouchEvent(true);
                } else {
                    pager.requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return false;
    }

    @Override
    public void onPanelSlide(View panel, float slideOffset) {
        Log.d("MainActivity", "aslideOffset=" + slideOffset);
        int width = navigationView.getWidth();
        ViewCompat.setTranslationX(navigationView, -width / 2 * (1 - slideOffset));

    }

    @Override
    public void onPanelOpened(View panel) {

    }

    @Override
    public void onPanelClosed(View panel) {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_qiushi:
                break;
            case R.id.action_qiuyouquan:
                break;
            case R.id.action_self:
                break;
            case R.id.action_quit:
                ActivityCompat.finishAffinity(this);
                break;
        }
        slidingPaneLayout.closePane();
        return true;
    }
}
