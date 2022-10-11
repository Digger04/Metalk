package com.example.metalk.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.metalk.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
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

public class Sigup extends AppCompatActivity {

    private EditText phone, password;
    private Button sigup;
    private FirebaseAuth mAuth;
    private Dialog dialog_cofirmOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigup);

        initview();
        click_sigup();
    }

    private void click_sigup() {

        sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(phone.getText().toString())) {
                    Snackbar.make(view, "Nhập đầy đủ thông tin để đăng kí", Snackbar.LENGTH_LONG)
                            .setBackgroundTint(getResources().getColor(android.R.color.holo_purple))
                            .show();
                }else {

                    Confirm_PhoneOtp();

                }
            }
        });

    }

    private void Confirm_PhoneOtp() {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+84" +phone.getText().toString())       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                signInWithPhoneAuthCredential(phoneAuthCredential);
                                Log.d("", "sdvs");

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Log.d("ewfwef", e +"loi");
                            }

                            @Override
                            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                                super.onCodeSent(s, forceResendingToken);

                                Confirm_Otp(s);
                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }

    private void Confirm_Otp(String s) {
        dialog_cofirmOtp = new Dialog(this);
        dialog_cofirmOtp.setContentView(R.layout.activity_dialog_cofirm_otp);
        EditText txt_otp = dialog_cofirmOtp.findViewById(R.id.txt_otp);
        Button bt_ok = dialog_cofirmOtp.findViewById(R.id.bt_ok);

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(txt_otp.getText().toString().trim())) {
                    return;
                }else {
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(s, txt_otp.getText().toString().trim());
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });


        dialog_cofirmOtp.show();
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        View view = findViewById(android.R.id.content);

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = task.getResult().getUser();
                            // Update UI
                            Intent intent = new Intent(getApplicationContext(),Home.class);
                            startActivity(intent);
                        } else {
                            Snackbar.make(view, "Đăng nhập thất bại", Snackbar.LENGTH_LONG)
                                    .setTextColor(getResources().getColor(android.R.color.white))
                                    .setBackgroundTint(getResources().getColor(android.R.color.holo_purple))
                                    .show();
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Snackbar.make(view, "Mã xác minh không hợp lệ", Snackbar.LENGTH_LONG)
                                        .setTextColor(getResources().getColor(android.R.color.white))
                                        .setBackgroundTint(getResources().getColor(android.R.color.holo_purple))
                                        .show();
                            }
                        }
                    }
                });
    }

    private void initview() {
        phone = findViewById(R.id.phone);
        sigup = findViewById(R.id.button_dangki);
        mAuth = FirebaseAuth.getInstance();
        password = findViewById(R.id.password);
    }
}