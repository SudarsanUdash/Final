package com.sudarsanudash.ilamteagarden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    EditText et_FullName, et_PhoneNumber, et_Address, et_Email, et_password, et_cpassword;
    Button btn_register, btn_login;
    ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        et_FullName = (EditText) findViewById(R.id.et_FullName);
        et_PhoneNumber = (EditText) findViewById(R.id.et_PhoneNumber);
        et_Address = (EditText) findViewById(R.id.et_Address);
        et_Email = (EditText) findViewById(R.id.et_Email);
        et_password = (EditText) findViewById(R.id.et_password);
        et_cpassword = (EditText) findViewById(R.id.et_cpassword);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_login = (Button) findViewById(R.id.btn_login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);



        firebaseAuth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FullName = et_FullName.getText().toString().trim();
                String PhoneNumber = et_PhoneNumber.getText().toString().trim();
                String Address = et_Address.getText().toString().trim();
                String Email = et_Email.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                String cpassword = et_cpassword.getText().toString().trim();

                if (TextUtils.isEmpty(FullName)) {
                    Toast.makeText(SignUpActivity.this, "Please Enter Your Full Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(PhoneNumber)) {
                    Toast.makeText(SignUpActivity.this, "Please Enter Phone Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(SignUpActivity.this, "Please Enter Your Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Address)) {
                    Toast.makeText(SignUpActivity.this, "Please Enter Your Address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(SignUpActivity.this, "Please Enter Your password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cpassword)) {
                    Toast.makeText(SignUpActivity.this, "Please confirm your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length()<6){
                    Toast.makeText(SignUpActivity.this, "Password is too short", Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.VISIBLE);

                if (password.equals(cpassword)){
                    firebaseAuth.createUserWithEmailAndPassword(Email, password)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()){

                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(SignUpActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));


                                    } else {
                                        Toast.makeText(SignUpActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();


                                    }

                                    // ...
                                }
                            });

                }
            }
        });




    }
    public void btn_LoginForm(View view) {
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }};
