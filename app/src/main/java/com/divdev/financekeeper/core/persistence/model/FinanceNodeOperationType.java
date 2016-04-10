package com.divdev.financekeeper.core.persistence.model;

import com.divdev.financekeeper.R;

/**
 * Accepted actions for Finance Nodes.
 *
 * @author jlopez
 */
public enum FinanceNodeOperationType {

    /**
     * Add balance to a Finance Node.
     */
    ADD_BALANCE(""),
    /**
     * Subtract balance from a Finance Node.
     */
    SUBTRACT_BALANCE(""),
    /**
     * Moved balance to another Finance Node.
     */
    MOVED_BALANCE_TO(""),
    /**
     * Moved balance from another Finance Node.
     */
    MOVED_BALANCE_FROM("");

    /**
     * Enum item description.
     */
    private String description;

    /**
     * Constructor with mandatory localized description.
     *
     * @param description
     */
    FinanceNodeOperationType(String description) {
        this.description = description;
    }

    /**
     * get description.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }
}
