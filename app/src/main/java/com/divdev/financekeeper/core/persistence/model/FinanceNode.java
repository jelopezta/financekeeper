package com.divdev.financekeeper.core.persistence.model;

import java.math.BigDecimal;

/**
 * Node representing a segmented balance. May have a number of child Finance Nodes.
 *
 * @author jlopez
 */
public class FinanceNode {

    /**
     * Length of each token of the complete code of a node.
     */
    public static final short NODE_COMPLETE_CODE_TOKEN_LENGHT = 3;

    /**
     * Id for the parent node of the main nodes (nodes without a parent).
     */
    public static final short MAIN_PARENT_NODE_ID = 0;

    /**
     * Finance Node code.
     */
    private short id;

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
     * Id of the parent of this FinanceNode. May be null for absolute parents.
     */
    private short parent_id;

    /**
     * Balance of the node.
     */
    private BigDecimal balance;


    public int getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
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

    public short getParent_Id() {
        return parent_id;
    }

    public void setParent_Id(short parentId) {
        this.parent_id = parentId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
