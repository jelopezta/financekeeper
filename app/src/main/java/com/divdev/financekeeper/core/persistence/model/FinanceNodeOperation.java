package com.divdev.financekeeper.core.persistence.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Log of an operation done on a Finance Node
 *
 * @author jlopez
 */
public class FinanceNodeOperation {
    /**
     * Action done on the Finance Node.
     */
    private FinanceNodeOperationAction action;
    /**
     * Date of the operation.
     */
    private Date operationDate;
    /**
     * System date of the record creation.
     */
    private Date systemDate = Calendar.getInstance().getTime();

    /**
     * Node in which the operation took place.
     */
    private FinanceNode node;

}
