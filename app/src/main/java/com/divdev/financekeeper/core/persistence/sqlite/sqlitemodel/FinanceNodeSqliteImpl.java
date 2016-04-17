package com.divdev.financekeeper.core.persistence.sqlite.sqlitemodel;

import android.provider.BaseColumns;

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
        createTableBuilder.append(TABLE_NAME).append("(").append(COLUMN_ID).append(") ");
        createTableBuilder.append(")");
        CREATE_TABLE = createTableBuilder.toString();
    }
}
