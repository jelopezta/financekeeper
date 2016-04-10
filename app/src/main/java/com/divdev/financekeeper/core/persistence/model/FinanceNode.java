package com.divdev.financekeeper.core.persistence.model;

import java.math.BigDecimal;

/**
 * Node representing a segmented balance. May have a number of child Finance Nodes
 *
 * @author jlopez
 */
public class FinanceNode {

    /**
     * Finance Node code.
     */
    private int code;

    /**
     * Finance Node complete code. code of the node normalized to 2 characters with the complete code of his parent.
     */
    private String completeCode;

    /**
     * Name of the node.
     */
    private String name;

    /**
     * Description of the node.
     */
    private String description;

    /**
     * Balance of the node.
     */
    private BigDecimal balance;

}
