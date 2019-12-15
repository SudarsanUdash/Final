package com.sudarsanudash.ilamteagarden;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    Dialog myDialog;
    Button buttonProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        buttonProfile = findViewById(R.id.buttonProfile);

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DashboardActivity.this, shopNowActivity.class);
                startActivity(intent);

            }
        });
        myDialog = new Dialog(this);
    }


    public void ShowPopup(View v) {
        TextView Close;
        Button btnFollow;
        myDialog.setContentView(R.layout.custompopup);
        Close =(TextView) myDialog.findViewById(R.id.Close);
        Close.setText("M");
        btnFollow = (Button) myDialog.findViewById(R.id.btnfollow);
        Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}