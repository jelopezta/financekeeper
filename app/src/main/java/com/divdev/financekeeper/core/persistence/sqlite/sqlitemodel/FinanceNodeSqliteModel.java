package com.divdev.financekeeper.core.persistence.sqlite.sqlitemodel;

import android.content.Context;
import android.provider.BaseColumns;

import com.divdev.financekeeper.R;

/**
 * Sqlite implementation of table and columns for the FinanceNode entity.
 *
 * @author jlopez
 */
public final class FinanceNodeSqliteModel implements BaseColumns {
    public static final String TABLE_NAME = "FINANCE_NODE";
    public static final String COLUMN_ID = "FNID";
    public static final String COLUMN_COMPLETE_CODE = "FNCOMPLETECODE";
    public static final String COLUMN_NAME = "FNNAME";
    public static final String COLUMN_DESCRIPTION = "FNDESCRIPTION";
    public static final String COLUMN_PARENT = "FNPARENT";
    public static final String COLUMN_BALANCE = "FNBALANCE";

    public static final String CREATE_TABLE;

    static {
        StringBuilder createTableBuilder = new StringBuilder();
        createTableBuilder.append("CREATE TABLE ").append(TABLE_NAME).append(" (");
        createTableBuilder.append(COLUMN_ID).append(" NUMERIC PRIMARY KEY, ");
        createTableBuilder.append(COLUMN_COMPLETE_CODE).append(" TEXT, ");
        createTableBuilder.append(COLUMN_NAME).append(" TEXT, ");
        createTableBuilder.append(COLUMN_DESCRIPTION).append(" TEXT, ");
        createTableBuilder.append(COLUMN_PARENT).append(" NUMERIC, ");
        createTableBuilder.append(COLUMN_BALANCE).append(" NUMERIC");

        createTableBuilder.append(",FOREIGN KEY(").append(COLUMN_PARENT).append(") REFERENCES ");
        createTableBuilder.append(TABLE_NAME)
                .append("(").append(COLUMN_ID).append(") ");
        createTableBuilder.append(")");
        CREATE_TABLE = createTableBuilder.toString();
    }

    /**
     * Gets the string query for the default node "Wallet".
     *
     * @param context the application context
     * @return the query to insert the default node "Wallet"
     */
    public static String getDefaultInsertWallet(Context context) {
        short nodeId = 1;
        String nodeCompleteCode = "001";
        String nodeName = context.getString(R.string.default_node_insert_wallet_name);
        String nodeDescription = context.getString(R.string.default_node_insert_wallet_description);
        short parentNodeId = 0;
        return getDefaultInsertForParams(nodeId, nodeCompleteCode, nodeName, nodeDescription, parentNodeId);
    }

    /**
     * Gets the string query for the default node "Main Account".
     *
     * @param context the application context
     * @return the query to insert the default node "Main Account"
     */
    public static String getDefaultInsertMainAccount(Context context) {
        short nodeId = 2;
        String nodeCompleteCode = "002";
        String nodeName = context.getString(R.string.default_node_insert_main_account_name);
        String nodeDescription = context.getString(R.string.default_node_insert_main_account_description);
        short parentNodeId = 0;
        return getDefaultInsertForParams(nodeId, nodeCompleteCode, nodeName, nodeDescription, parentNodeId);
    }

    /**
     * Gets the string query for the default node "Bills".
     *
     * @param context the application context
     * @return the query to insert the default node "Bills"
     */
    public static String getDefaultInsertMainAccountBills(Context context) {
        short nodeId = 3;
        String nodeCompleteCode = "002003";
        String nodeName = context.getString(R.string.default_node_insert_main_account_bills_name);
        String nodeDescription = context.getString(R.string.default_node_insert_main_account_bills_description);
        short parentNodeId = 2;
        return getDefaultInsertForParams(nodeId, nodeCompleteCode, nodeName, nodeDescription, parentNodeId);
    }

    /**
     * Gets the string query for the default node "Rent".
     *
     * @param context the application context
     * @return the query to insert the default node "Rent"
     */
    public static String getDefaultInsertMainAccountRent(Context context) {
        short nodeId = 4;
        String nodeCompleteCode = "002004";
        String nodeName = context.getString(R.string.default_node_insert_main_account_rent_name);
        String nodeDescription = context.getString(R.string.default_node_insert_main_account_rent_description);
        short parentNodeId = 2;
        return getDefaultInsertForParams(nodeId, nodeCompleteCode, nodeName, nodeDescription, parentNodeId);
    }

    /**
     * Gets the string query for the default node "Auxiliary Account".
     *
     * @param context the application context
     * @return the query to insert the default node "Auxiliary Account"
     */
    public static String getDefaultInsertAuxiliaryAccount(Context context) {
        short nodeId = 5;
        String nodeCompleteCode = "005";
        String nodeName = context.getString(R.string.default_node_insert_auxiliary_account_name);
        String nodeDescription = context.getString(R.string.default_node_insert_auxiliary_account_description);
        short parentNodeId = 0;
        return getDefaultInsertForParams(nodeId, nodeCompleteCode, nodeName, nodeDescription, parentNodeId);
    }

    /**
     * Gets the string query for the default node "Savings".
     *
     * @param context the application context
     * @return the query to insert the default node "Savings"
     */
    public static String getDefaultInsertAuxiliaryAccountSavings(Context context) {
        short nodeId = 6;
        String nodeCompleteCode = "005006";
        String nodeName = context.getString(R.string.default_node_insert_auxiliary_account_savings_name);
        String nodeDescription = context.getString(R.string.default_node_insert_auxiliary_account_savings_description);
        short parentNodeId = 5;
        return getDefaultInsertForParams(nodeId, nodeCompleteCode, nodeName, nodeDescription, parentNodeId);
    }

    /**
     * Gets the string query for the default node "Trip Reserve".
     *
     * @param context the application context
     * @return the query to insert the default node "Trip Reserve"
     */
    public static String getDefaultInsertAuxiliaryAccountTripReserve(Context context) {
        short nodeId = 7;
        String nodeCompleteCode = "005007";
        String nodeName = context.getString(R.string.default_node_insert_auxiliary_account_trip_reserve_name);
        String nodeDescription = context.getString(R.string.default_node_insert_auxiliary_account_trip_reserve_description);
        short parentNodeId = 5;
        return getDefaultInsertForParams(nodeId, nodeCompleteCode, nodeName, nodeDescription, parentNodeId);
    }

    /**
     * Returns the default insert for a FinanceNode configured with the parameters provided.
     *
     * @param nodeId           the nodeId
     * @param nodeCompleteCode the node's complete code
     * @param nodeName         the node's name
     * @param nodeDescription  the node's description
     * @param nodeParent       the id of the parent node
     * @return the string for the default insert query
     */
    private static String getDefaultInsertForParams(short nodeId, String nodeCompleteCode, String nodeName, String nodeDescription, short nodeParent) {
        StringBuilder insertBuilder = new StringBuilder();
        insertBuilder.append("INSERT INTO " + TABLE_NAME).append(" (");
        insertBuilder.append(COLUMN_ID).append(", ");
        insertBuilder.append(COLUMN_COMPLETE_CODE).append(", ");
        insertBuilder.append(COLUMN_NAME).append(", ");
        insertBuilder.append(COLUMN_DESCRIPTION).append(", ");
        insertBuilder.append(COLUMN_PARENT).append(", ");
        insertBuilder.append(COLUMN_BALANCE).append(") ");
        insertBuilder.append("VALUES (");
        insertBuilder.append(nodeId).append(", ");
        insertBuilder.append("'").append(nodeCompleteCode).append("', ");
        insertBuilder.append("'").append(nodeName).append("', ");
        insertBuilder.append("'").append(nodeDescription).append("', ");
        insertBuilder.append(nodeParent).append(", ");
        insertBuilder.append(100_000d).append(")"); // TODO

        return insertBuilder.toString();
    }
}
