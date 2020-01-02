package com.sudarsanudash.ilamteagarden;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sudarsanudash.ilamteagarden.Adapter.ViewPageDashboardAdapter;
import com.sudarsanudash.ilamteagarden.Fragments.ContactUsFragment;
import com.sudarsanudash.ilamteagarden.Fragments.SellFragment;
import com.sudarsanudash.ilamteagarden.Fragments.ShopFragment;

public class DashboardActivity extends AppCompatActivity {

    Dialog myDialog;
    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        myDialog = new Dialog(this);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabId);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffffff"));
        ViewPageDashboardAdapter viewPageDashboardAdapter = new ViewPageDashboardAdapter(getSupportFragmentManager());
        viewPageDashboardAdapter.addFragment(new ShopFragment(),"Shop");
        viewPageDashboardAdapter.addFragment(new ContactUsFragment(),"Contact Us");
        viewPageDashboardAdapter.addFragment(new SellFragment(),"Sell");


        viewPager.setAdapter(viewPageDashboardAdapter);
        tabLayout.setupWithViewPager(viewPager);



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