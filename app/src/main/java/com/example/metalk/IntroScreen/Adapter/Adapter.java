package com.example.metalk.IntroScreen.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.metalk.IntroScreen.Fragment.Fragment_intro1;
import com.example.metalk.IntroScreen.Fragment.Fragment_intro2;
import com.example.metalk.IntroScreen.Fragment.Fragment_intro3;
import com.example.metalk.IntroScreen.Fragment.Fragment_intro4;
import com.example.metalk.IntroScreen.Fragment.Fragment_intro5;

public class Adapter extends FragmentStatePagerAdapter {
    public Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public Adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new Fragment_intro1();
            case 1:
                return new Fragment_intro2();
            case 2:
                return new Fragment_intro3();
            case 3:
                return new Fragment_intro4();
            case 4:
                return new Fragment_intro5();
            default:
                return new Fragment_intro1();
        }

    }

    @Override
    public int getCount() {
        return 5;
    }
}
