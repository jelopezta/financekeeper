package com.divdev.financekeeper.core.persistence.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.divdev.financekeeper.core.persistence.model.FinanceNode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Sqlite implementation of table and columns for the FinanceNode entity.
 *
 * @author jlopez
 */
public final class FinanceNodeSqliteImpl implements BaseColumns {
    public static final String TABLE_NAME = "FINANCE_NODE";
    public static final String COLUMN_ID = "FNID";
    public static final String COLUMN_COMPLETE_CODE = "FNCOMPLETECODE";
    public static final String COLUMN_NAME = "FNNAME";
    public static final String COLUMN_DESCRIPTION = "FNDESCRIPTION";
    public static final String COLUMN_PARENT = "FNPARENT";
    public static final String COLUMN_BALANCE = "FNBALANCE";

    public static final String CREATE_TABLE;

    public static final String INSERT_WALLET;

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


        StringBuilder insertWalletBuilder = new StringBuilder();
        insertWalletBuilder.append("INSERT INTO " + TABLE_NAME).append(" (");
        insertWalletBuilder.append(COLUMN_ID).append(", ");
        insertWalletBuilder.append(COLUMN_COMPLETE_CODE).append(", ");
        insertWalletBuilder.append(COLUMN_NAME).append(", ");
        insertWalletBuilder.append(COLUMN_DESCRIPTION).append(", ");
        insertWalletBuilder.append(COLUMN_PARENT).append(", ");
        insertWalletBuilder.append(COLUMN_BALANCE).append(") ");
        insertWalletBuilder.append("VALUES (");
        insertWalletBuilder.append("1, ");
        insertWalletBuilder.append("'001', ");
        insertWalletBuilder.append("'Wallet', ");
        insertWalletBuilder.append("'Money carried inside main wallet', ");
        insertWalletBuilder.append("NULL, ");
        insertWalletBuilder.append(100_000d).append(")");
        INSERT_WALLET = insertWalletBuilder.toString();

    }

    /**
     * Obtains the full list of finance nodes in the database.
     *
     * @param applicationContext context of the application
     * @return the list of finance nodes in the database
     */
    public static List<FinanceNode> getAllFinanceNodes(Context applicationContext) {
        List<FinanceNode> nodes = new ArrayList<FinanceNode>();

        FinanceKeeperDbHelper helper = new FinanceKeeperDbHelper(applicationContext);
        SQLiteDatabase readableDatabase = null;
        try {
            readableDatabase = helper.getReadableDatabase();

            String[] cursorSelectColumns = new String[]{
                    COLUMN_ID,
                    COLUMN_COMPLETE_CODE,
                    COLUMN_NAME,
                    COLUMN_DESCRIPTION,
                    COLUMN_PARENT,
                    COLUMN_BALANCE
            };
            String cursorOrderBy = COLUMN_COMPLETE_CODE;
            // perform query
            Cursor cursor = readableDatabase.query(TABLE_NAME, cursorSelectColumns,
                    null, null, null, null, cursorOrderBy); // get all rows

            if (cursor != null) {
                // add items to the list
                for (cursor.moveToFirst(); cursor.isAfterLast() == false; cursor.moveToNext()) {
                    nodes.add(getFinanceNodeFromCursor(cursor));
                }

                // close the cursor
                cursor.close();
            }
        } finally {
            // close the database connection
            if (readableDatabase != null) {
                readableDatabase.close();
            }
        }
        return nodes;
    }

    /**
     * Builds a FinanceNode object from the information on the current position of the cursor.
     *
     * @param cursor the cursor with the information for the node
     * @return the complete finance node
     */
    private static FinanceNode getFinanceNodeFromCursor(Cursor cursor) {
        FinanceNode node = new FinanceNode();
        node.setId(cursor.getShort(0));
        node.setCompleteCode(cursor.getString(1));
        node.setName(cursor.getString(2));
        node.setDescription(cursor.getString(3));
        node.setParent_Id(cursor.getShort(4));
        node.setBalance(new BigDecimal(cursor.getString(5)));
        // TODO
        return node;
    }
}
