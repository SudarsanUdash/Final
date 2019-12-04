package com.sudarsanudash.ilamteagarden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText et_Email, et_password;
    Button btn_login;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("IlamTeaGarden");


       et_Email = (EditText)findViewById(R.id.et_Email);
       et_password = (EditText)findViewById(R.id.et_password);
       btn_login = (Button)findViewById(R.id.btn_login);

       firebaseAuth = FirebaseAuth.getInstance();

       btn_login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String Email = et_Email.getText().toString().trim();

               String password = et_password.getText().toString().trim();

               if (TextUtils.isEmpty(Email)) {
                   Toast.makeText(LoginActivity.this, "Please Enter Your Email", Toast.LENGTH_SHORT).show();
                   return;
               }
               if (TextUtils.isEmpty(password)) {
                   Toast.makeText(LoginActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                   return;
               }

               if (password.length()<6){
                   Toast.makeText(LoginActivity.this, "Password is too short", Toast.LENGTH_SHORT).show();
               }

               firebaseAuth.signInWithEmailAndPassword(Email, password)
                       .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {
                                   startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                   Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                               } else {
                                   Toast.makeText(LoginActivity.this, "Cannot Login Some Credentials are incorrect", Toast.LENGTH_SHORT).show();

                               }

                               // ...
                           }
                       });



           }
       });


    }

    public void btn_SignupForm(View view) {
        startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
    }
}
