package com.divdev.financekeeper;

import android.app.Application;
import android.content.Context;

import com.divdev.financekeeper.core.persistence.PersistenceSystem;
import com.divdev.financekeeper.core.persistence.model.FinanceNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jlopez
 */
public class FinanceKeeperApplication extends Application {

    /**
     * General context for application components without an available context.
     */
    Context mContext;

    /**
     * Get the application general context.
     */
    public Context getFinanceKeeperContext() {
        return mContext;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        PersistenceSystem.buildInstance(mContext);
    }
}
