package com.divdev.financekeeper.presentation.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.divdev.financekeeper.R;
import com.divdev.financekeeper.core.persistence.sqlite.FinanceKeeperDbHelper;

import java.util.prefs.Preferences;

public class InitialSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    FinanceKeeperDbHelper helper = new FinanceKeeperDbHelper(getApplicationContext());
                    SQLiteDatabase readableDatabase = helper.getReadableDatabase();
                    if(readableDatabase != null) {
                        System.out.println("database ready");// TODO
                    }
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(InitialSplashActivity.this, FinanceKeeperMainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
}
