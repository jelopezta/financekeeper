package com.divdev.financekeeper.core.persistence.model;

import android.content.Context;

import com.divdev.financekeeper.core.persistence.sqlite.FinanceNodeSqliteImpl;

import java.math.BigDecimal;
import java.util.List;

/**
 * Node representing a segmented balance. May have a number of child Finance Nodes.
 *
 * @author jlopez
 */
public class FinanceNode {

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
    private Short parent_id;

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

    public Short getParent_Id() {
        return parent_id;
    }

    public void setParent_Id(Short parentId) {
        this.parent_id = parentId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Returns the full list of Finance Nodes.
     *
     * @param applicationContext the context of the application
     * @return the list of finance nodes
     */
    public static List<FinanceNode> getAllFinanceNodes(Context applicationContext) {
        return FinanceNodeSqliteImpl.getAllFinanceNodes(applicationContext);
    }
}
