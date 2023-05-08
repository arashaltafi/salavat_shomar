package com.arash.altafi.salavat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.arash.altafi.salavat.databinding.ActivityZekrSalavatBinding;

public class ZekrSalavat extends AppCompatActivity {

    private ActivityZekrSalavatBinding binding;
    private SharedPreferences preferences;
    private static final String NAME = "nameKey";
    private static final String MyPerf = "MyPrefers";
    private int numbers = 0;
    private int add = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityZekrSalavatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toast.makeText(this, getString(R.string.click_to_salavat), Toast.LENGTH_SHORT).show();
        init();
    }

    private void init() {
        preferences = getSharedPreferences(MyPerf, MODE_PRIVATE);

        binding.ivSalavat.setOnClickListener((View.OnClickListener) view -> {
            if (preferences.contains(NAME)) {
                numbers = preferences.getInt(NAME, 0);
                if (numbers == 0) {
                    add++;
                    binding.tvShow.setText(String.valueOf(add));
                    String a = binding.tvShow.getText().toString().trim();
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(NAME, a);
                    editor.apply();
                } else {
                    add = numbers;
                    add++;
                    binding.tvShow.setText(String.valueOf(add));
                    String a = binding.tvShow.getText().toString().trim();
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt(NAME, Integer.parseInt(a));
                    editor.apply();
                }
            } else {
                add++;
                binding.tvShow.setText(String.valueOf(add));
                String a = binding.tvShow.getText().toString().trim();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt(NAME, Integer.parseInt(a));
                editor.apply();
            }

        });

        binding.btnDelete.setOnClickListener((View.OnClickListener) v ->
                new AlertDialog.Builder(ZekrSalavat.this)
                        .setTitle(getString(R.string.attention))
                        .setCancelable(true)
                        .setIcon(R.drawable.ic_exit_zekr)
                        .setMessage(getString(R.string.delete_salavats))
                        .setPositiveButton(getString(R.string.yes), (dialog, which) -> {
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.clear();
                            editor.apply();
                            binding.tvShow.setText("0");
                            add = 0;
                        })
                        .setNegativeButton(getString(R.string.no), (dialog, which) -> dialog.cancel())
                        .show()
        );


        if (preferences.contains(NAME))
            binding.tvShow.setText(String.valueOf(preferences.getInt(NAME, 0)));

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
