package com.arash.altafi.salavat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.style.FadingCircle;

public class Splash extends AppCompatActivity {

    private SpinKitView progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bindViews();
        setStatusBarColor();
        init();


    }

    private void bindViews() {
        progressBar = findViewById(R.id.spinSplash);
    }

    private void init() {
        FadingCircle FadingCircle = new FadingCircle();
        progressBar.setIndeterminateDrawable(FadingCircle);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goMain();
            }
        }, 2000);
    }

    private void setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int color = ContextCompat.getColor(this, R.color.colorPrimary);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    private void goMain() {
        Intent i = new Intent(Splash.this, MainActivity.class);
        startActivity(i);
        finish();
    }

}
