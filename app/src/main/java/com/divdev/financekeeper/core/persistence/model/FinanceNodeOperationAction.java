package com.divdev.financekeeper.core.persistence.model;

/**
 * Accepted actions for Finance Nodes.
 *
 * @author jlopez
 */
public enum FinanceNodeOperationAction {
    /**
     * Add balance to a Finance Node.
     */
    ADD_BALANCE,
    /**
     * Substract balance from a Finance Node.
     */
    SUBSTRACT_BALANCE,
    /**
     * Moved balance to another Finance Node.
     */
    MOVE_BALANCE_TO,
    /**
     * Moved balance from another Finance Node.
     */
    MOVE_BALANCE_FROM

}
