package com.divdev.financekeeper.core.persistence.sqlite.sqlitemodel;

import android.provider.BaseColumns;

/**
 * Sqlite implementation of table and columns for the FinanceNodeOperation entity.
 *
 * @author jlopez
 */
public class FinanceNodeOperationSqliteImpl implements BaseColumns {
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
}
