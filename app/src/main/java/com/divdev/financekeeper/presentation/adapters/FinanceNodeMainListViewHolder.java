package com.divdev.financekeeper.presentation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.divdev.financekeeper.R;

/**
 * View holder for FinanceNodeMainListAdapter
 *
 * @author jlopez
 */
public class FinanceNodeMainListViewHolder extends RecyclerView.ViewHolder {
    /**
     * Text view with the node's name.
     */
    protected TextView financeNodeName;
    /**
     * Text view with the node's description.
     */
    protected TextView financeNodeDescription;
    /**
     * Text view with the node's current balance.
     */
    protected TextView financeNodeBalance;

    /**
     * Constructor with mandatory view.
     *
     * @param itemView the view to bind the view holder
     */
    public FinanceNodeMainListViewHolder(View itemView) {
        super(itemView);
        financeNodeName = (TextView) itemView.findViewById(R.id.main_list_item_name);
        financeNodeDescription = (TextView) itemView.findViewById(R.id.main_list_item_description);
        financeNodeBalance = (TextView) itemView.findViewById(R.id.main_list_item_balance);
    }
}
