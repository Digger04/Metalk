package com.example.metalk.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.metalk.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private EditText phone, pass;
    private Button login, sigup;
    private CheckBox checkBox_save;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
        Login();
        Sigup();
    }

    private void Sigup() {
        sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Sigup.class));
            }
        });
    }

    private void Login() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check_login();
            }
        });
    }

    private void check_login() {

        if (TextUtils.isEmpty(phone.getText().toString()) || TextUtils.isEmpty(pass.getText().toString())) {

            View view = findViewById(android.R.id.content);
            Snackbar.make(view, "Nhập số điện thoại và mật khẩu", Snackbar.LENGTH_LONG)
                    .setBackgroundTint(getResources().getColor(android.R.color.holo_purple))
                    .show();
        }else {



        }
    }

    private void initview() {
        phone = findViewById(R.id.phone);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.button_dangnhap);
        sigup = findViewById(R.id.button_dangki);
        mAuth = FirebaseAuth.getInstance();
    }
}