package com.sudarsanudash.ilamteagarden;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
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