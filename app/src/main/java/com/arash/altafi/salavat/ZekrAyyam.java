package com.arash.altafi.salavat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.arash.altafi.salavat.databinding.ActivityZekrAyyamBinding;

import java.util.Calendar;

public class ZekrAyyam extends AppCompatActivity {

    private ActivityZekrAyyamBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityZekrAyyamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init() {
        int DayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        String weekDay = null;
        int drawableResource = R.drawable.salavat1;
        switch (DayOfWeek) {
            case Calendar.SATURDAY:
                weekDay = getString(R.string.saturday);
                drawableResource = R.drawable.shanbe;
                break;
            case Calendar.SUNDAY:
                weekDay = getString(R.string.sunday);
                drawableResource = R.drawable.yekshanbe;
                break;
            case Calendar.MONDAY:
                weekDay = getString(R.string.monday);
                drawableResource = R.drawable.doshanbe;
                break;
            case Calendar.TUESDAY:
                weekDay = getString(R.string.tuesday);
                drawableResource = R.drawable.seshanbe;
                break;
            case Calendar.WEDNESDAY:
                weekDay = getString(R.string.wednesday);
                drawableResource = R.drawable.chaharsh;
                break;
            case Calendar.THURSDAY:
                weekDay = getString(R.string.thursday);
                drawableResource = R.drawable.panjshanbe;
                break;
            case Calendar.FRIDAY:
                weekDay = getString(R.string.friday);
                drawableResource = R.drawable.jome;
                break;
            default:
                break;
        }

        Toast.makeText(this, weekDay, Toast.LENGTH_SHORT).show();
        binding.ivShow.setImageResource(drawableResource);

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
