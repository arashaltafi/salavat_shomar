package com.arash.altafi.salavat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//Apr 06 2020
public class MainActivity extends AppCompatActivity {

    Button btnZekr, btnSlvt, btnAbout, btnExit, btnBazar;
    private boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        init();
    }

    private void init() {
        btnZekr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ZekrAyyam.class));
            }
        });

        btnSlvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ZekrSalavat.class));
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.arash_pic)
                        .setTitle(getString(R.string.about_me))
                        .setMessage(getString(R.string.arashaltafi))
                        .show();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(getString(R.string.exit))
                        .setCancelable(true)
                        .setIcon(R.drawable.ic_exit_zekr)
                        .setMessage(getString(R.string.exit_app))
                        .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
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

        btnBazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean install = isPackageInstalled(MainActivity.this, "com.farsitel.bazaar");
                if (install) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("bazaar://collection?slug=by_author&aid=" + "arashaltafi"));
                    intent.setPackage("com.farsitel.bazaar");
                    startActivity(intent);
                } else
                    Toast.makeText(getApplicationContext(), getString(R.string.see_other_apps), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bindViews() {
        btnZekr = findViewById(R.id.btnZekr);
        btnSlvt = findViewById(R.id.btnSalavat);
        btnAbout = findViewById(R.id.btnAbout);
        btnExit = findViewById(R.id.btnExit);
        btnBazar = findViewById(R.id.btnBazaar);
    }

    public static boolean isPackageInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finish();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "برای خروج از برنامه بکبار دیگر کلید برگشت را فشار دهید", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 4000);
    }
}
