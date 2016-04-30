package com.divdev.financekeeper.core.persistence;

import android.content.Context;

import com.divdev.financekeeper.core.persistence.model.FinanceNode;
import com.divdev.financekeeper.core.persistence.sqlite.sqlitedao.FinanceNodeSqliteDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton to communicate with the persistence system.
 *
 * @author jlopez
 */
public class PersistenceSystem {

    /**
     * Singleton instance of the persistence system.
     */
    private static PersistenceSystem persistenceSystemInstance;


    /**
     * Dao for operations with the FinanceNode model.
     */
    private FinanceNodeSqliteDao financeNodeDao;


    /**
     * Cached list of the application's finance nodes.
     */
    List<FinanceNode> financeNodeListCache;

    /**
     * Get the FinanceNodeDao.
     *
     * @return FinanceNodeDao
     */
    public FinanceNodeSqliteDao getFinanceNodeDao() {
        return financeNodeDao;
    }

    /**
     * Get the FinanceNode cache list.
     */
    public List<FinanceNode> getFinanceNodeListCache() {
        if (financeNodeListCache == null) {
            financeNodeListCache = new ArrayList<>();
        }
        if (financeNodeListCache.isEmpty()) {
            financeNodeListCache = PersistenceSystem.getInstance().getFinanceNodeDao().getAllFinanceNodes();
        }
        return financeNodeListCache;
    }

    /**
     * Set the FinanceNode cache list.
     */
    public void setFinanceNodeListCache(List<FinanceNode> financeNodeListCache) {
        this.financeNodeListCache = financeNodeListCache;
    }

    private PersistenceSystem(Context context) {
        financeNodeDao = new FinanceNodeSqliteDao(context);
    }

    public static synchronized PersistenceSystem getInstance() {
        if (persistenceSystemInstance == null) {
            throw new IllegalStateException("PersistenceSystem not yet initialized by Application");
        }
        return persistenceSystemInstance;
    }

    public static synchronized void buildInstance(Context context) {
        if (persistenceSystemInstance == null) {
            persistenceSystemInstance = new PersistenceSystem(context);
            return;
        }
        throw new IllegalStateException("PersistenceSystem was already initialized by Application");

    }
}
