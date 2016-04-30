package com.divdev.financekeeper;

import android.app.Application;
import android.content.Context;

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
     * Cached list of the application's finance nodes.
     */
    List<FinanceNode> financeNodeListCache;

    /**
     * Get the application general context.
     */
    public Context getFinanceKeeperContext() {
        return mContext;
    }

    /**
     * Get the FinanceNode cache list.
     */
    public List<FinanceNode> getFinanceNodeListCache() {
        return financeNodeListCache;
    }

    /**
     * Set the FinanceNode cache list.
     */
    public void setFinanceNodeListCache(List<FinanceNode> financeNodeListCache) {
        this.financeNodeListCache = financeNodeListCache;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        financeNodeListCache = new ArrayList<>();
    }
}
