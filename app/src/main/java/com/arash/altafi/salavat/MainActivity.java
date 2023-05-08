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
import android.widget.Toast;

import com.arash.altafi.salavat.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init() {
        binding.btnZekr.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ZekrAyyam.class))
        );

        binding.btnSalavat.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ZekrSalavat.class))
        );

        binding.btnAbout.setOnClickListener(v ->
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.arash_pic)
                        .setTitle(getString(R.string.about_me))
                        .setMessage(getString(R.string.arashaltafi))
                        .setNeutralButton("website", (dialogInterface, i) -> {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("https://arashaltafi.ir"));
                            startActivity(intent);
                        })
                        .show()
        );

        binding.btnExit.setOnClickListener(v ->
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(getString(R.string.exit))
                        .setCancelable(true)
                        .setIcon(R.drawable.ic_exit_zekr)
                        .setMessage(getString(R.string.exit_app))
                        .setPositiveButton(getString(R.string.yes), (dialog, which) -> finish())
                        .setNegativeButton(getString(R.string.no), (dialog, which) -> dialog.cancel())
                        .show()
        );

        binding.btnBazaar.setOnClickListener(v -> {
            boolean install = isPackageInstalled(MainActivity.this, "com.farsitel.bazaar");
            if (install) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("bazaar://collection?slug=by_author&aid=" + "arashaltafi"));
                intent.setPackage("com.farsitel.bazaar");
                startActivity(intent);
            } else
                Toast.makeText(getApplicationContext(), getString(R.string.see_other_apps), Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, getString(R.string.press_back_to_finish), Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 4000);
    }
}
