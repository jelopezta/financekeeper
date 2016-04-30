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
    private List<FinanceNode> feedItemList;
    private Context mContext;

    public FinanceNodeMainListAdapter(Context context, List<FinanceNode> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
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
        //Setting list item values
        holder.financeNodeName.setText(feedItem.getName());
        holder.financeNodeDescription.setText(feedItem.getDescription());

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
