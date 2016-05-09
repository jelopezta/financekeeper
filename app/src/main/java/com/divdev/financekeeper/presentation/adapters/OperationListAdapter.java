package com.divdev.financekeeper.presentation.adapters;

import android.app.Activity;
import android.app.Presentation;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.divdev.financekeeper.R;
import com.divdev.financekeeper.core.persistence.model.OperationType;
import com.divdev.financekeeper.presentation.activities.FinanceKeeperMainActivity;
import com.divdev.financekeeper.presentation.activities.OperationActivity;
import com.divdev.financekeeper.presentation.dialogs.OperationListFragment;
import com.divdev.financekeeper.presentation.utils.PresentationUtilities;

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

    /**
     * The fragment that contains the list backed by this adapter.
     */
    OperationListFragment operationFragment;

    /**
     * Constructor with mandatory attributes
     *
     * @param operationFragment the fragment that contains the component backed by this adapter
     */
    public OperationListAdapter(Context context, OperationListFragment operationFragment) {
        this.mContext = context;
        this.operationFragment = operationFragment;
        OperationItem operationAdd = new OperationItem();
        operationAdd.operationIconResource = R.drawable.ic_menu_gallery;
        operationAdd.operationTitle = context.getResources().getString(R.string.operation_add_balance_title);
        operationAdd.operationDescription = context.getResources().getString(R.string.operation_add_balance_description);
        operationAdd.operationType = OperationType.ADD_BALANCE;

        OperationItem operationSubtract = new OperationItem();
        operationSubtract.operationIconResource = R.drawable.ic_menu_gallery;
        operationSubtract.operationTitle = context.getResources().getString(R.string.operation_subtract_balance_title);
        operationSubtract.operationDescription = context.getResources().getString(R.string.operation_subtract_balance_description);
        operationSubtract.operationType = OperationType.SUBTRACT_BALANCE;

        OperationItem operationMove = new OperationItem();
        operationMove.operationIconResource = R.drawable.ic_menu_gallery;
        operationMove.operationTitle = context.getResources().getString(R.string.operation_move_balance_to_title);
        operationMove.operationDescription = context.getResources().getString(R.string.operation_move_balance_to_description);
        operationMove.operationType = OperationType.MOVE_BALANCE_TO;

        operationItemList.add(operationAdd);
        operationItemList.add(operationSubtract);
        operationItemList.add(operationMove);
    }

    @Override
    public OperationListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_operation_dialog, null);
        OperationListViewHolder viewHolder = new OperationListViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationListViewHolder viewHolder = (OperationListViewHolder) v.getTag();
                operationFragment.onOperationSelected(viewHolder.operationType);
            }
        });
        view.setTag(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OperationListViewHolder holder, int position) {
        final OperationItem operationItem = operationItemList.get(position);
        final Drawable drawable = ContextCompat.getDrawable(mContext, operationItem.operationIconResource);
        holder.operationIcon.setImageDrawable(drawable);
        holder.operationTitle.setText(operationItem.operationTitle);
        holder.operationDescription.setText(operationItem.operationDescription);
        holder.operationType = operationItem.operationType;
    }

    @Override
    public int getItemCount() {
        return operationItemList.size();
    }

    /**
     * Anchor class for operation list.
     */
    private static class OperationItem {
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

        /**
         * The operation type.
         */
        private OperationType operationType;
    }

}
