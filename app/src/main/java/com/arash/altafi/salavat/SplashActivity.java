package com.arash.altafi.salavat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.arash.altafi.salavat.databinding.ActivitySplashBinding;
import com.github.ybq.android.spinkit.style.FadingCircle;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setStatusBarColor();
        init();
    }

    private void init() {
        FadingCircle FadingCircle = new FadingCircle();
        binding.spinSplash.setIndeterminateDrawable(FadingCircle);

        new Handler().postDelayed(this::goMain, 3000);
    }

    private void setStatusBarColor() {
        int color = ContextCompat.getColor(this, R.color.colorPrimary);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(color);
    }

    private void goMain() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

}
