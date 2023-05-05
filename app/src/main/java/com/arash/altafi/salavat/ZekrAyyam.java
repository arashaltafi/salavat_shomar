package com.arash.altafi.salavat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class ZekrAyyam extends AppCompatActivity {

    ImageView imgShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zekr_ayyam);

        bindViews();
        init();
    }

    private void bindViews() {
        imgShow = findViewById(R.id.ivShow);
    }

    private void init() {
        int DayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        String weekDay = null;
        switch (DayOfWeek) {
            case Calendar.SATURDAY:
                weekDay = getString(R.string.saturday);
                imgShow.setImageResource(R.drawable.shanbe);
                break;
            case Calendar.SUNDAY:
                weekDay = getString(R.string.sunday);
                imgShow.setImageResource(R.drawable.yekshanbe);
                break;
            case Calendar.MONDAY:
                weekDay = getString(R.string.monday);
                imgShow.setImageResource(R.drawable.doshanbe);
                break;
            case Calendar.TUESDAY:
                weekDay = getString(R.string.tuesday);
                imgShow.setImageResource(R.drawable.seshanbe);
                break;
            case Calendar.WEDNESDAY:
                weekDay = getString(R.string.wednesday);
                imgShow.setImageResource(R.drawable.chaharsh);
                break;
            case Calendar.THURSDAY:
                weekDay = getString(R.string.thursday);
                imgShow.setImageResource(R.drawable.panjshanbe);
                break;
            case Calendar.FRIDAY:
                weekDay = getString(R.string.friday);
                imgShow.setImageResource(R.drawable.jome);
                break;
            default:
                break;
        }

        Toast.makeText(this, weekDay, Toast.LENGTH_SHORT).show();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
