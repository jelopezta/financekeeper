package com.divdev.financekeeper.core.persistence.model;

import java.util.Date;

/**
 * Log of an operation done on a Finance Node
 *
 * @author jlopez
 */
public class FinanceNodeOperation {

    /**
     * Unique identifier for the operation.
     */
    private String uuid;

    /**
     * Type of operation done on the Finance Node.
     */
    private OperationType type;

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
    private OperationTag tag;

    /**
     * Additional comments associated with this operation.
     */
    private String comments;

    /**
     * Latitude coordinate of where the operation took place.
     */
    private double locationLatitude;

    /**
     * Longitude coordinate of where the operation took place.
     */
    private double locationLongitude;
}
