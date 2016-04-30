package com.divdev.financekeeper.presentation.AsyncTask;

/**
 * Interface to receive asyncTask responses
 *
 * @author jlopez
 */
public interface AsyncTaskCompletionListener {

    /**
     * Process the execution completion of the asyncTask.
     *
     * @param asyncTask the asyncTask that was completed
     */
    void processAsyncTaskCompletion(ListeneableAsyncTask asyncTask);
}