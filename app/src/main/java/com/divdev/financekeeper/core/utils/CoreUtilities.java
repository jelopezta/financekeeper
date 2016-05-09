package com.divdev.financekeeper.core.utils;

import com.divdev.financekeeper.core.persistence.model.FinanceNode;

import java.math.BigDecimal;
import java.util.List;

/**
 * Utilities for core operations
 *
 * @author jlopez
 */
public class CoreUtilities {

    /**
     * Get the total balance for the main nodes on the list passed as parameter.
     *
     * @param financeNodeList the list of the nodes to use in the calculation
     * @return the total balance for the main nodes
     */
    public static BigDecimal getMainFinanceNodesTotal(List<FinanceNode> financeNodeList) {
        BigDecimal total = new BigDecimal("0");
        for (FinanceNode node : financeNodeList) {
            if (node.getParent_Id() == FinanceNode.MAIN_PARENT_NODE_ID) {
                total = total.add(node.getBalance());
            }
        }
        return total;
    }
}
