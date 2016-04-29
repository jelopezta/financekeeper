package com.divdev.financekeeper.core.persistence.sqlite.sqlitemodel;

import android.provider.BaseColumns;

/**
 * Sqlite implementation of table and columns for the FinanceNodeOperation entity.
 *
 * @author jlopez
 */
public class FinanceNodeOperationSqliteModel implements BaseColumns {
    public static final String TABLE_NAME = "FINANCE_NODE_OPERATION";
    public static final String COLUMN_ID = "FNOID";
    public static final String COLUMN_OPERATION_TYPE = "FNOOPTYPE";
    public static final String COLUMN_OPERATION_DATE = "FNOOPDATE";
    public static final String COLUMN_SYSTEM_DATE = "FNOSYSTEMDATE";
    public static final String COLUMN_MAIN_NODE = "FNOMAINNODE";
    public static final String COLUMN_ASSOCIATED_NODE = "FNOASSOCNODE";
    public static final String COLUMN_TAG = "FNOTAG";
    public static final String COLUMN_LOCATION_LATITUDE = "FNOLOCLATITUDE";
    public static final String COLUMN_LOCATION_LONGITUDE = "FNOLOCLONGITUDE";

    public static final String CREATE_TABLE;

    static {
        StringBuilder createTableBuilder = new StringBuilder();
        createTableBuilder.append("CREATE TABLE ").append(TABLE_NAME).append(" (");
        createTableBuilder.append(COLUMN_ID).append(" NUMERIC PRIMARY KEY, ");
        createTableBuilder.append(COLUMN_OPERATION_TYPE).append(" TEXT, ");
        createTableBuilder.append(COLUMN_OPERATION_DATE).append(" DATETIME, ");
        createTableBuilder.append(COLUMN_SYSTEM_DATE).append(" DATETIME, ");
        createTableBuilder.append(COLUMN_MAIN_NODE).append(" NUMERIC, ");
        createTableBuilder.append(COLUMN_ASSOCIATED_NODE).append(" NUMERIC, ");
        createTableBuilder.append(COLUMN_TAG).append(" TEXT, ");
        createTableBuilder.append(COLUMN_LOCATION_LATITUDE).append(" NUMBER, ");
        createTableBuilder.append(COLUMN_LOCATION_LONGITUDE).append(" NUMBER");

        createTableBuilder.append(",FOREIGN KEY(").append(COLUMN_TAG).append(") REFERENCES ");
        createTableBuilder.append(OperationTagSqliteModel.TABLE_NAME).
                append("(").append(OperationTagSqliteModel.COLUMN_ID).append(") ");

        createTableBuilder.append(")");
        CREATE_TABLE = createTableBuilder.toString();
    }
}
