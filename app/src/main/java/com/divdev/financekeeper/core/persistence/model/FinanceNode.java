package com.divdev.financekeeper.core.persistence.model;

import java.math.BigDecimal;

/**
 * Node representing a segmented balance. May have a number of child Finance Nodes.
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
     * The parent of this FinanceNode. May be null for absolute parents.
     */
    private FinanceNode parent;

    /**
     * Balance of the node.
     */
    private BigDecimal balance;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCompleteCode() {
        return completeCode;
    }

    public void setCompleteCode(String completeCode) {
        this.completeCode = completeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FinanceNode getParent() {
        return parent;
    }

    public void setParent(FinanceNode parent) {
        this.parent = parent;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
