package com.arash.altafi.salavat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pushpole.sdk.PushPole;

public class MainActivity extends AppCompatActivity {

    Button btnZekr, btnSlvt, btnAbout,btnExit,btnBazar;
    private boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PushPole.initialize(this,false);


        btnZekr =  findViewById(R.id.btn_zekr);
        btnSlvt =  findViewById(R.id.btn_slvt);
        btnAbout = findViewById(R.id.btn_About);
        btnExit = findViewById(R.id.btn_exit);
        btnBazar = findViewById(R.id.btn_bazar);


        btnZekr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mintent = new Intent(MainActivity.this,zekr_ayyam.class);
                startActivity(mintent);
            }
        });

        btnSlvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, zekr_salavat.class));
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        // .setIcon(R.drawable.icon)
                        .setIcon(R.drawable.arash_pic)
                        .setTitle("درباره مـــا")
                        .setMessage("طراح برنامه : آرش الـــــطافی")
                        .show();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("خروج")
                        .setCancelable(true)
                        .setIcon(R.drawable.ic_exit_zekr)
                        .setMessage("آیا می خواهید از این قسمت خارج شوید؟")
                        .setPositiveButton("بلـــه", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) { ;
                                finish();
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

        btnBazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                boolean install = isPackageInstalled(MainActivity.this , "com.farsitel.bazaar");
//                if (install) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse("bazaar://collection?slug=by_author&aid=" + "arashaltafi"));
//                    intent.setPackage("com.farsitel.bazaar");
//                    startActivity(intent);
//                } else
//                    Toast.makeText(getApplicationContext(), "برای مشاهده دیگر برنامه ها لطفا کافه بازار را نصب نمایید", Toast.LENGTH_SHORT).show();





                String url = "https://myket.ir/app/com.arash.altafi.joke";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }
        });


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
