package com.sudarsanudash.ilamteagarden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class MainActivity extends AppIntro {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    addSlide(AppIntroFragment.newInstance("Welcome to Ilam Tea Garden", "A garden renowned all over the world",
            R.drawable.aaaaa, ContextCompat.getColor(getApplicationContext(),R.color.first)));

    addSlide(AppIntroFragment.newInstance("Enjoy the freshness of Ilam Tea", "Buy and sell your products at your own rate",
            R.drawable.ssss, ContextCompat.getColor(getApplicationContext(),R.color.second)));

    addSlide(AppIntroFragment.newInstance("Finally Connect with Us", "Register and Login to our system",
            R.drawable.logo, ContextCompat.getColor(getApplicationContext(),R.color.first)));
    setFadeAnimation();

sharedPreferences = getApplicationContext().getSharedPreferences("MyPREFERENCES",Context.MODE_PRIVATE);
editor = sharedPreferences.edit();

if(sharedPreferences!=null){

    boolean checkShared = sharedPreferences.getBoolean("checkStated",false);

    if(checkShared == true){
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }
}

        }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.

        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        editor.putBoolean("checkStated",false);

        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        editor.putBoolean("checkStated",true);
        finish();

    }
        }

