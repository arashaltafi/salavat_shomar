package com.arash.altafi.salavat;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.style.FadingCircle;
import com.google.android.material.snackbar.Snackbar;

public class Splash extends AppCompatActivity {

    private long ms = 0,splashTime=2000;
    private boolean splashActivity = true,paused = false;
    ImageView img_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setStatusBarColor(R.color.colorPrimary);

        img_splash = findViewById(R.id.image_splash);

        final RelativeLayout cl = findViewById(R.id.cl);

        SpinKitView progressBar = findViewById(R.id.spin_splash);
        FadingCircle FadingCircle = new FadingCircle();
        progressBar.setIndeterminateDrawable(FadingCircle);

        Thread thread = new Thread(){
            public void run(){
                try {
                    while (splashActivity && ms < splashTime) {
                        if (!paused)
                            ms = ms + 100;
                        sleep(100);

                    }
                }
                catch (Exception e) {
                }
                finally
                {
                    goMain();
                }
            }
        };

        thread.start();
    }

    private void setStatusBarColor(@ColorRes int statusBarColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            int color = ContextCompat.getColor(this,statusBarColor);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    private void goMain() {
        Intent i = new Intent(Splash.this , MainActivity.class);
        startActivity(i);
        finish();
    }

}
