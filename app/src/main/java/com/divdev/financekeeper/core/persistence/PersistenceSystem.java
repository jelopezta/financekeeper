package com.divdev.financekeeper.core.persistence;

import android.content.Context;

import com.divdev.financekeeper.core.persistence.dao.FinanceNodeDao;
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
    private FinanceNodeDao financeNodeDao;


    /**
     * Cached list of the application's finance nodes.
     */
    List<FinanceNode> financeNodeListCache;

    /**
     * Get the FinanceNodeDao.
     *
     * @return FinanceNodeDao
     */
    public FinanceNodeDao getFinanceNodeDao() {
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

    /**
     * Private constructor with context initialization and singleton component creation.
     *
     * @param context the application context
     */
    private PersistenceSystem(Context context) {
        financeNodeDao = new FinanceNodeSqliteDao(context);
    }

    /**
     * Obtains the instance of the PersistenceSystem. Fails if the application hasn't created the instance previosly.
     *
     * @return persistenceSystemInstance
     */
    public static synchronized PersistenceSystem getInstance() {
        if (persistenceSystemInstance == null) {
            throw new IllegalStateException("PersistenceSystem not yet initialized by Application");
        }
        return persistenceSystemInstance;
    }

    /**
     * Builds the intance of the persistence system. Fails if there is already an instance created.
     *
     * @param context the context for the PersistenceSystem components
     */
    public static synchronized void buildInstance(Context context) {
        if (persistenceSystemInstance == null) {
            persistenceSystemInstance = new PersistenceSystem(context);
            return;
        }
        throw new IllegalStateException("PersistenceSystem was already initialized by Application");

    }
}
