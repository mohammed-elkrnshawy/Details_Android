package com.zt.details.PackageAuth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.zt.details.PackageTry.LanguageType;
import com.zt.details.R;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    private String type, language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_splash);
        ReadSharedPreference();
        setLanguages();
    }

    private void ReadSharedPreference() {
        SharedPreferences prefs = getSharedPreferences(getApplication().getPackageName(), MODE_PRIVATE);
        type = prefs.getString("type", "arabic");
        language = prefs.getString("language", "ar");
        boolean isLogin = prefs.getBoolean("isLogin", false);

        if (isLogin) {
            //getUser(prefs.getString("Token", ""));
        } else {
            loading();
        }
    }

    private void setLanguages() {
        LanguageType languageType = new LanguageType();
        languageType.languageType = type;
        Configuration config = new Configuration();
        config.locale = new Locale(language);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

    private void loading() {
        new CountDownTimer(3500, 2000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this, AuthActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();

    }
}
