package com.divdev.financekeeper.presentation.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.divdev.financekeeper.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for the operation list.
 *
 * @author jlopez
 */
public class OperationListAdapter extends RecyclerView.Adapter<OperationListViewHolder> {

    /**
     * Operations available.
     */
    List<OperationItem> operationItemList = new ArrayList<>();

    /**
     * Context of the adapter.
     */
    Context mContext;

    public OperationListAdapter(Context context) {
        this.mContext = context;
        OperationItem operationAdd = new OperationItem();
        operationAdd.operationIconResource = R.drawable.main_icon;
        operationAdd.operationTitle = "Add Balance";
        operationAdd.operationDescription = "Add balance to a finance node.";

        OperationItem operationSubtract = new OperationItem();
        operationSubtract.operationIconResource = R.drawable.main_icon;
        operationSubtract.operationTitle = "Subtract Balance";
        operationSubtract.operationDescription = "Subtract balance from a finance node.";

        OperationItem operationMove = new OperationItem();
        operationMove.operationIconResource = R.drawable.main_icon;
        operationMove.operationTitle = "Move Balance";
        operationMove.operationDescription = "move balance between two finance nodes.";

        operationItemList.add(operationAdd);
        operationItemList.add(operationSubtract);
        operationItemList.add(operationMove);
    }

    @Override
    public OperationListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_operation_dialog, null);
        OperationListViewHolder viewHolder = new OperationListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OperationListViewHolder holder, int position) {
        final OperationItem operationItem = operationItemList.get(position);
        final Drawable drawable = ContextCompat.getDrawable(mContext, operationItem.operationIconResource);
        holder.operationIcon.setImageDrawable(drawable);
        holder.operationTitle.setText(operationItem.operationTitle);
        holder.operationDescription.setText(operationItem.operationDescription);
    }

    @Override
    public int getItemCount() {
        return operationItemList.size();
    }

    /**
     * Anchor class for operation list.
     */
    private class OperationItem {
        /**
         * The id of the icon resource for the operation.
         */
        private int operationIconResource;

        /**
         * The title for the operation.
         */
        private String operationTitle;

        /**
         * The description for the operation.
         */
        private String operationDescription;
    }

}
