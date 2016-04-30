package com.divdev.financekeeper.core.persistence.sqlite.sqlitedao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.divdev.financekeeper.core.persistence.model.FinanceNode;
import com.divdev.financekeeper.core.persistence.sqlite.FinanceKeeperDbHelper;
import com.divdev.financekeeper.core.persistence.sqlite.sqlitemodel.FinanceNodeSqliteModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Dao for operations with the sqlite database for the FinanceNode entity.
 *
 * @author jlopez
 */
public class FinanceNodeSqliteDao {

    /**
     * The application context.
     */
    private Context context;

    /**
     * Constructor with mandatory attribute.
     *
     * @param context the application's context
     */
    public FinanceNodeSqliteDao(Context context) {
        this.context = context;
    }

    /**
     * Obtains the full list of finance nodes in the database.
     *
     * @return the list of finance nodes in the database
     */
    public List<FinanceNode> getAllFinanceNodes() {
        List<FinanceNode> nodes = new ArrayList<FinanceNode>();

        FinanceKeeperDbHelper helper = new FinanceKeeperDbHelper(context);
        SQLiteDatabase readableDatabase = null;
        try {
            readableDatabase = helper.getReadableDatabase();

            String[] cursorSelectColumns = new String[]{
                    FinanceNodeSqliteModel.COLUMN_ID,
                    FinanceNodeSqliteModel.COLUMN_COMPLETE_CODE,
                    FinanceNodeSqliteModel.COLUMN_NAME,
                    FinanceNodeSqliteModel.COLUMN_DESCRIPTION,
                    FinanceNodeSqliteModel.COLUMN_PARENT,
                    FinanceNodeSqliteModel.COLUMN_BALANCE
            };
            String cursorOrderBy = FinanceNodeSqliteModel.COLUMN_COMPLETE_CODE;
            // perform query
            Cursor cursor = readableDatabase.query(FinanceNodeSqliteModel.TABLE_NAME, cursorSelectColumns,
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
        return node;
    }
}
