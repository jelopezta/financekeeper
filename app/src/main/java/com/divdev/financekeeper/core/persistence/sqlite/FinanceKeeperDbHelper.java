package com.divdev.financekeeper.core.persistence.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.divdev.financekeeper.core.persistence.sqlite.sqlitemodel.FinanceNodeSqliteImpl;
import com.divdev.financekeeper.core.persistence.sqlite.sqlitemodel.OperationTagSqliteImple;

/**
 * SQLite Helper
 *
 * @author jlopez
 */
public class FinanceKeeperDbHelper extends SQLiteOpenHelper {

    /**
     * Current database version.
     */
    public static final int DATABASE_VERSION = 1;
    /**
     * Database file name.
     */
    public static final String DATABASE_NAME = "FinanceKeeper.db";

    /**
     * Constructor with mandatory attribute Context.
     *
     * @param context the application context
     */
    public FinanceKeeperDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO
        db.execSQL(FinanceNodeSqliteImpl.CREATE_TABLE);
        db.execSQL(OperationTagSqliteImple.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Currently unnecesary
    }
}
