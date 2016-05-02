package com.divdev.financekeeper.core.persistence.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.divdev.financekeeper.core.persistence.sqlite.sqlitemodel.FinanceNodeOperationSqliteModel;
import com.divdev.financekeeper.core.persistence.sqlite.sqlitemodel.FinanceNodeSqliteModel;
import com.divdev.financekeeper.core.persistence.sqlite.sqlitemodel.OperationTagSqliteModel;

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
     * The application context.
     */
    private Context context;

    /**
     * Constructor with mandatory attribute Context.
     *
     * @param context the application context
     */
    public FinanceKeeperDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO
        db.execSQL(FinanceNodeSqliteModel.CREATE_TABLE);
        db.execSQL(OperationTagSqliteModel.CREATE_TABLE);
        db.execSQL(FinanceNodeOperationSqliteModel.CREATE_TABLE);

        db.execSQL(FinanceNodeSqliteModel.getDefaultInsertWallet(context));

        db.execSQL(FinanceNodeSqliteModel.getDefaultInsertMainAccount(context));
        db.execSQL(FinanceNodeSqliteModel.getDefaultInsertMainAccountBills(context));
        db.execSQL(FinanceNodeSqliteModel.getDefaultInsertMainAccountRent(context));

        db.execSQL(FinanceNodeSqliteModel.getDefaultInsertAuxiliaryAccount(context));
        db.execSQL(FinanceNodeSqliteModel.getDefaultInsertAuxiliaryAccountSavings(context));
        db.execSQL(FinanceNodeSqliteModel.getDefaultInsertAuxiliaryAccountTripReserve(context));


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Currently unnecesary
    }
}
