package com.divdev.financekeeper.core.persistence.sqlite;

import android.provider.BaseColumns;

/**
 * Sqlite implementation of table and columns for the OperationTag entity.
 *
 * @author jlopez
 */
public class OperationTagSqliteImpl implements BaseColumns {
    public static final String TABLE_NAME = "TAG";
    public static final String COLUMN_ID = "TAGID";
    public static final String COLUMN_DESCRIPTION = "TAGDESCRIPTION";

    public static final String CREATE_TABLE;

    static {
        StringBuilder createTableBuilder = new StringBuilder();
        createTableBuilder.append("CREATE TABLE ").append(TABLE_NAME).append(" (");
        createTableBuilder.append(COLUMN_ID).append(" NUMERIC PRIMARY KEY, ");
        createTableBuilder.append(COLUMN_DESCRIPTION).append(" TEXT");
        createTableBuilder.append(")");
        CREATE_TABLE = createTableBuilder.toString();
    }
}
