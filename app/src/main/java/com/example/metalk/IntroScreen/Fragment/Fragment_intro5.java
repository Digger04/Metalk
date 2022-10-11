package com.example.metalk.IntroScreen.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.metalk.R;
import com.example.metalk.UI.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_intro5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_intro5 extends Fragment {


    public static Fragment_intro5 newInstance() {
        Fragment_intro5 fragment = new Fragment_intro5();
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

        View view =  inflater.inflate(R.layout.fragment_intro5, container, false);

        Button button_batdau = view.findViewById(R.id.button_start);

        button_batdau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), MainActivity.class));
            }
        });

        return view;
    }
}