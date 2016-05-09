package com.divdev.financekeeper.presentation.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.divdev.financekeeper.R;
import com.divdev.financekeeper.core.persistence.model.OperationType;
import com.divdev.financekeeper.presentation.activities.OperationActivity;
import com.divdev.financekeeper.presentation.adapters.OperationListAdapter;
import com.divdev.financekeeper.presentation.utils.PresentationUtilities;

/**
 * Fragment for finance node's operations visualization.
 *
 * @author jlopez
 */
public class OperationListFragment extends DialogFragment {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public OperationListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_operationlist_list, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new OperationListAdapter(recyclerView.getContext(), this));
        return recyclerView;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    /**
     * Opens an operation activity with the operationType.
     *
     * @param operationTypeSelected operation type to be sent to the new activity
     */
    public void onOperationSelected(OperationType operationTypeSelected) {
        Intent intent = new Intent(this.getActivity(), OperationActivity.class);
        intent.putExtra(PresentationUtilities.INTENT_OPERATION_TYPE_EXTRA, operationTypeSelected);
        this.getActivity().startActivity(intent);
        this.dismiss();
    }

}
