package com.divdev.financekeeper.core.persistence.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.divdev.financekeeper.R;

/**
 * @author jlopez
 */
public class FinanceNodeMainListViewHolder extends RecyclerView.ViewHolder {
    protected TextView financeNodeName;
    protected TextView financeNodeBalance;

    public FinanceNodeMainListViewHolder(View itemView) {
        super(itemView);
        financeNodeName = (TextView) itemView.findViewById(R.id.main_list_item_name);
        financeNodeBalance = (TextView) itemView.findViewById(R.id.main_list_item_balance);
    }
}
