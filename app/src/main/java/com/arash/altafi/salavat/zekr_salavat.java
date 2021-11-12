package com.arash.altafi.salavat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class zekr_salavat extends AppCompatActivity {

    ImageView imageButton;
    TextView txtShow;
    Button delete;
    int adad=0;
    SharedPreferences preferences;
    public static final String NAME = "nameKey";
    public static final String MyPerf = "MyPrefers";
    String nums;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zekr_salavat);

        Toast.makeText(this, "بر روی عکس کلیک کنید تا صلوات شما ثبت شود" , Toast.LENGTH_SHORT).show();

        imageButton = findViewById(R.id.imageButton);
        txtShow = findViewById(R.id.txt_show);
        delete = findViewById(R.id.delete);
        preferences = getSharedPreferences(MyPerf,MODE_PRIVATE);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (preferences.contains(NAME))
                {
                    nums = preferences.getString(NAME, null);
                    if (nums == "0" || nums == "" || nums.isEmpty())
                    {
                        adad++;
                        txtShow.setText(String.valueOf(adad));
                        String a = txtShow.getText().toString().trim();
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString(NAME, a);
                        editor.apply();
                    }
                    else
                    {
                        adad = Integer.valueOf(nums);
                        adad++;
                        txtShow.setText(String.valueOf(adad));
                        String a = txtShow.getText().toString().trim();
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString(NAME, a);
                        editor.apply();
                    }
                }
                else
                {
                    adad++;
                    txtShow.setText(String.valueOf(adad));
                    String a = txtShow.getText().toString().trim();
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(NAME, a);
                    editor.apply();
                }


//                nums = preferences.getString(NAME,null);
//                if (nums == "")
//                {
//                    adad++;
//                    txtShow.setText(String.valueOf(adad));
//                    String a = txtShow.getText().toString().trim();
//                    SharedPreferences.Editor editor = preferences.edit();
//                    editor.putString(NAME, a);
//                    editor.apply();
//                }
//                else
//                {
//                    adad = Integer.valueOf(nums);
//                    adad++;
//                    txtShow.setText(String.valueOf(adad));
//                    String a = txtShow.getText().toString().trim();
//                    SharedPreferences.Editor editor = preferences.edit();
//                    editor.putString(NAME, a);
//                    editor.apply();
//                }


            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(zekr_salavat.this)
                        .setTitle("توجه")
                        .setCancelable(true)
                        .setIcon(R.drawable.ic_exit_zekr)
                        .setMessage("آیا می خواهید تعداد صلوات ها را پاک کنید؟")
                        .setPositiveButton("بلـــه", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) { ;
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.clear();
                                editor.apply();
                                txtShow.setText("0");
                                adad = 0;
                            }
                        })
                        .setNegativeButton("خیـــر", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }
        });


        if (preferences.contains(NAME))
            txtShow.setText(preferences.getString(NAME, null));




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
