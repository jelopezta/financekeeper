package com.divdev.financekeeper.presentation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.divdev.financekeeper.R;

/**
 * @author jlopez
 */
public class OperationListViewHolder extends RecyclerView.ViewHolder {
    /**
     * Image view for the operation's icon.
     */
    protected ImageView operationIcon;
    /**
     * Text view for the operation's title.
     */
    protected TextView operationTitle;
    /**
     * Text view for the operation's description.
     */
    protected TextView operationDescription;

    /**
     * Constructor with mandatory view
     *
     * @param itemView the view to bind the view holder
     */
    public OperationListViewHolder(View itemView) {
        super(itemView);
        operationIcon = (ImageView) itemView.findViewById(R.id.operation_list_item_icon);
        operationTitle = (TextView) itemView.findViewById(R.id.operation_list_item_title);
        operationDescription = (TextView) itemView.findViewById(R.id.operation_list_item_description);
    }
}
