package com.bv.annakshetra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class PHONENUM extends AppCompatActivity {
    Button verify;
    EditText phonenum;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseAuth mAuth;
    TextView guest;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonenum);

        guest = findViewById(R.id.guest);
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PHONENUM.this,HomePage.class);
                startActivity(intent);
            }
        });


        final EditText phonenum = findViewById(R.id.phonenum);
        final ProgressBar progressBar = findViewById(R.id.progressbar);




        verify = (android.widget.Button) findViewById(R.id.verify);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(phonenum.getText().toString().trim().isEmpty()){
                    Toast.makeText(PHONENUM.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                verify.setVisibility(View.INVISIBLE);
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + phonenum.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        PHONENUM.this,

                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(View.GONE);
                                verify.setVisibility(View.VISIBLE);

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                                verify.setVisibility(View.VISIBLE);
                                Toast.makeText(PHONENUM.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar.setVisibility(View.GONE);
                                verify.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getApplicationContext(), OTPVERIFY.class);
                                intent.putExtra("mobile", phonenum.getText().toString());
                                intent.putExtra("verificationId", verificationId);
                                startActivity(intent);

                            }
                        }

                );


            }
        });

    }
}