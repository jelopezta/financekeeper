package com.divdev.financekeeper.core.persistence.model;

import android.content.Context;

import com.divdev.financekeeper.R;

/**
 * Accepted actions for Finance Nodes.
 *
 * @author jlopez
 */
public enum OperationType {

    /**
     * Add balance to a Finance Node.
     */
    ADD_BALANCE,

    /**
     * Subtract balance from a Finance Node.
     */
    SUBTRACT_BALANCE,

    /**
     * Moved balance to another Finance Node.
     */
    MOVED_BALANCE_TO,

    /**
     * Moved balance from another Finance Node.
     */
    MOVED_BALANCE_FROM;

    /**
     * Returns the localized description for the operation type.
     *
     * @return localized description as expressed in the string resources
     */
    public String getDescription(Context context) {
        String description = null;
        switch (this) {
            case ADD_BALANCE:
                description = context.getResources().getString(R.string.operation_type_add_balance);
                break;
            case SUBTRACT_BALANCE:
                description = context.getResources().getString(R.string.operation_type_subtract_balance);
                break;
            case MOVED_BALANCE_TO:
                description = context.getResources().getString(R.string.operation_type_moved_balance_to);
                break;
            case MOVED_BALANCE_FROM:
                description = context.getResources().getString(R.string.operation_type_moved_balance_from);
                break;
        }
        return description;
    }
}
