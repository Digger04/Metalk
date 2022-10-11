package com.example.metalk.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.metalk.IntroScreen.Adapter.Adapter;
import com.example.metalk.R;

import me.relex.circleindicator.CircleIndicator;

public class IntroScreen extends AppCompatActivity {

    private TextView skip;
    private ImageView next;
    private CircleIndicator circleIndicator;
    private ViewPager viewPager;
    private com.example.metalk.IntroScreen.Adapter.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        initview();
        set_viewpager();
        click_skip();
        click_next();
        setview_intro5();
    }

    private void setview_intro5() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 4) {

                    skip.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.INVISIBLE);

                }else {
                    skip.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void click_next() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() <4) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
            }
        });
    }

    private void click_skip() {
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    private void set_viewpager() {

        adapter = new Adapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);

    }

    private void initview() {
        skip = findViewById(R.id.txt_skip);
        next = findViewById(R.id.img_next);
        circleIndicator = findViewById(R.id.circleindicator);
        viewPager = findViewById(R.id.viewpager);
    }
}