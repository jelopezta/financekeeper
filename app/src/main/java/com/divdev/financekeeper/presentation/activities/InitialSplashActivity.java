package com.divdev.financekeeper.presentation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.divdev.financekeeper.FinanceKeeperApplication;
import com.divdev.financekeeper.R;
import com.divdev.financekeeper.core.persistence.PersistenceSystem;
import com.divdev.financekeeper.core.persistence.model.FinanceNode;

import java.util.List;

public class InitialSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread initFinanceNodeCacheThread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<FinanceNode> financeNodeList = PersistenceSystem.getInstance().getFinanceNodeListCache();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(InitialSplashActivity.this, FinanceKeeperMainActivity.class);
                startActivity(intent);
            }
        });

        initFinanceNodeCacheThread.start();
    }
}
