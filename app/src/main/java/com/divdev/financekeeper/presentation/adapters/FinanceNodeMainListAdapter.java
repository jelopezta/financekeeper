package com.divdev.financekeeper.presentation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.divdev.financekeeper.R;
import com.divdev.financekeeper.core.persistence.model.FinanceNode;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

/**
 * Adapter for the Finance Node main list
 *
 * @author jlopez
 */
public class FinanceNodeMainListAdapter extends RecyclerView.Adapter<FinanceNodeMainListViewHolder> {
    /**
     * List of items to display.
     */
    private List<FinanceNode> feedItemList;


    /**
     * Constructor with mandatory attributes.
     *
     * @param feedItemList the list of items to display
     */
    public FinanceNodeMainListAdapter(List<FinanceNode> feedItemList) {
        this.feedItemList = feedItemList;
    }

    @Override
    public FinanceNodeMainListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_finance_node_main_list, null);
        FinanceNodeMainListViewHolder viewHolder = new FinanceNodeMainListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FinanceNodeMainListViewHolder holder, int position) {
        FinanceNode feedItem = feedItemList.get(position);

        StringBuilder treePrefix = new StringBuilder();
        short tokens = (short) (feedItem.getCompleteCode().length() / FinanceNode.NODE_COMPLETE_CODE_TOKEN_LENGHT);
        for (int i = 0; i < tokens - 1; i++) {
            treePrefix.append("      ");
        }
        String prefix = treePrefix.toString();
        //Setting list item values
        final String initialPipeNodeName = "| ";
        final String initialPipeNodeDescription = prefix.isEmpty() ? "| " : " | ";

        holder.financeNodeName.setText(prefix + initialPipeNodeName + feedItem.getName());
        holder.financeNodeDescription.setText(prefix + initialPipeNodeDescription + feedItem.getDescription());

        // Format balance in system currency
        final BigDecimal balance = feedItem.getBalance();
        final NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        holder.financeNodeBalance.setText(currencyInstance.format(balance));
    }

    @Override
    public int getItemCount() {
        return ((feedItemList != null) ? feedItemList.size() : 0);
    }
}
