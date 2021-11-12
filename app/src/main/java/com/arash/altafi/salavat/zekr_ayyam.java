package com.arash.altafi.salavat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class zekr_ayyam extends AppCompatActivity {


    ImageView imgShow;
    Calendar taqwim = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zekr_ayyam);

        imgShow = findViewById(R.id.img_show);

        int DayOfWeek = taqwim.get(Calendar.DAY_OF_WEEK);


        String RoozHafte = null;
        switch (DayOfWeek) {
            case Calendar.SATURDAY:
                RoozHafte = "شــنبه";
                imgShow.setImageResource(R.drawable.shanbe);
                break;
            case Calendar.SUNDAY:
                RoozHafte = "یکــشنبه";
                imgShow.setImageResource(R.drawable.yekshanbe);
                break;
            case Calendar.MONDAY:
                RoozHafte = "دوشنبه";
                imgShow.setImageResource(R.drawable.doshanbe);
                break;
            case Calendar.TUESDAY:
                RoozHafte = "سـه شنبه";
                imgShow.setImageResource(R.drawable.seshanbe);
                break;
            case Calendar.WEDNESDAY:
                RoozHafte = "چهارشنبه";
                imgShow.setImageResource(R.drawable.chaharsh);
                break;
            case Calendar.THURSDAY:
                RoozHafte = "پنج شنبه";
                imgShow.setImageResource(R.drawable.panjshanbe);
                break;
            case Calendar.FRIDAY:
                RoozHafte = "جمعه";
                imgShow.setImageResource(R.drawable.jome);
                break;
            default:

                break;

        }

        Toast.makeText(this, RoozHafte, Toast.LENGTH_SHORT).show();

        // برای گذاشتن دکمه برگشت
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    // برای گذاشتن دکمه برگشت
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
