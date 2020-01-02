package com.sudarsanudash.ilamteagarden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText et_Email, et_Password;

    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_Email=findViewById(R.id.et_Email);
        et_Password=findViewById(R.id.et_Password);

    }
    @Override
    public void onClick(View view) {




            }

            private void checkUser() {
                SharedPreferences sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);
                String username = sharedPreferences.getString("username","");
                String password = sharedPreferences.getString("password","");

                if(et_Email.getText().toString().equals("admin@admin.com") && et_Password.getText().toString().equals("admin")){

                    startActivity(new Intent(this, DashboardActivity.class)); }

                else

                {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_LONG).show();
                }
            }
        }





