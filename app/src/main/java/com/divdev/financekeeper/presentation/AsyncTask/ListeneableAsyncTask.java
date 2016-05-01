package com.divdev.financekeeper.presentation.asynctask;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Async task with listener callback.
 *
 * @author jlopez
 */
public class ListeneableAsyncTask extends AsyncTask<Void, Void, Void> {

    /**
     * The callee that listens for this asyncTask's completion.
     */
    protected final AsyncTaskCompletionListener listener;

    /**
     * The context to use in this async task.
     */
    protected final Context context;

    /**
     * Constructor with mandatory argument.
     *
     * @param listener the component listening for this task completion
     */
    public ListeneableAsyncTask(AsyncTaskCompletionListener listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Void o) {
        listener.processAsyncTaskCompletion(this);
    }
}
