package com.divdev.financekeeper.core.persistence.dao;

import com.divdev.financekeeper.core.persistence.model.FinanceNode;

import java.util.List;

/**
 * Interface for interactions with persistence systems that have a representation for the FinanceNode entity
 *
 * @author jlopez
 */
public interface FinanceNodeDao {

    /**
     * Obtains all finance nodes in the persistent system.
     *
     * @return list of the FinanceNode in persistent system
     */
    List<FinanceNode> getAllFinanceNodes();
}