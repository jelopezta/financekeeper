package com.divdev.financekeeper.core.persistence.model;

import java.util.Date;

/**
 * Log of an operation done on a Finance Node
 *
 * @author jlopez
 */
public class FinanceNodeOperation {
    /**
     * Type of operation done on the Finance Node.
     */
    private FinanceNodeOperationType type;

    /**
     * Date of the operation.
     */
    private Date operationDate;

    /**
     * System date of the record creation.
     */
    private Date systemDate;

    /**
     * Node in which the operation took place.
     */
    private FinanceNode mainNode;

    /**
     * Associated node for balance movement operations.
     */
    private FinanceNode associatedNode;

    /**
     * Tag associated with this operation.
     */
    private FinanceNodeOperationTag tag;

    /**
     * Additional comments associated with this operation.
     */
    private String comments;
}
