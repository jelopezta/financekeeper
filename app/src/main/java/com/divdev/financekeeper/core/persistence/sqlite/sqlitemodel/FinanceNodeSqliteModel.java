package com.divdev.financekeeper.core.persistence.sqlite.sqlitemodel;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.divdev.financekeeper.core.persistence.model.FinanceNode;
import com.divdev.financekeeper.core.persistence.sqlite.FinanceKeeperDbHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
}
