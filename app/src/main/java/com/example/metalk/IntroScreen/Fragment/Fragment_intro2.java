package com.example.metalk.IntroScreen.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.metalk.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_intro2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_intro2 extends Fragment {


    public static Fragment_intro2 newInstance() {
        Fragment_intro2 fragment = new Fragment_intro2();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro2, container, false);
    }
}