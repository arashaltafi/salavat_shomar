package com.arash.altafi.salavat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ZekrSalavat extends AppCompatActivity {

    ImageView imageButton;
    TextView txtShow;
    Button delete;
    int add = 0;
    SharedPreferences preferences;
    public static final String NAME = "nameKey";
    public static final String MyPerf = "MyPrefers";
    int numbers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zekr_salavat);

        Toast.makeText(this, getString(R.string.click_to_salavat), Toast.LENGTH_SHORT).show();

        bindViews();
        init();
    }

    private void bindViews() {
        imageButton = findViewById(R.id.ivSalavat);
        txtShow = findViewById(R.id.tvShow);
        delete = findViewById(R.id.btnDelete);
    }

    private void init() {
        preferences = getSharedPreferences(MyPerf, MODE_PRIVATE);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preferences.contains(NAME)) {
                    numbers = preferences.getInt(NAME, 0);
                    if (numbers == 0) {
                        add++;
                        txtShow.setText(String.valueOf(add));
                        String a = txtShow.getText().toString().trim();
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString(NAME, a);
                        editor.apply();
                    } else {
                        add = numbers;
                        add++;
                        txtShow.setText(String.valueOf(add));
                        String a = txtShow.getText().toString().trim();
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt(NAME, Integer.parseInt(a));
                        editor.apply();
                    }
                } else {
                    add++;
                    txtShow.setText(String.valueOf(add));
                    String a = txtShow.getText().toString().trim();
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt(NAME, Integer.parseInt(a));
                    editor.apply();
                }

            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ZekrSalavat.this)
                        .setTitle(getString(R.string.attention))
                        .setCancelable(true)
                        .setIcon(R.drawable.ic_exit_zekr)
                        .setMessage(getString(R.string.delete_salavats))
                        .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.clear();
                                editor.apply();
                                txtShow.setText("0");
                                add = 0;
                            }
                        })
                        .setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }
        });


        if (preferences.contains(NAME))
            txtShow.setText(String.valueOf(preferences.getInt(NAME, 0)));

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
