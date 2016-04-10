package com.divdev.financekeeper.core.persistence.model;

/**
 * General parameters for the application.
 *
 * @author jlopez
 */
public class ApplicationParameter {
    /**
     * Default Finance Node for the operation type add balance.
     */
    private FinanceNode defaultFinanceNodeForAdd;

    /**
     * Default Finance Node for the operation type subtract balance.
     */
    private FinanceNode defaultFinanceNodeForSubtract;
    /**
     * Default Finance Node for the operation type move balance from.
     */
    private FinanceNode defaultFinanceNodeForMoveFrom;
    /**
     * Default Finance Node for the operation type move balance to.
     */
    private FinanceNode defaultFinanceNodeForMoveTo;

    /**
     * Max number of Finance Nodes.
     */
    private final short maxNumberOfFinanceNodes = 99;

    /**
     * Max number of Tags.
     */
    private final short maxNumberOfTags = 99;

}
