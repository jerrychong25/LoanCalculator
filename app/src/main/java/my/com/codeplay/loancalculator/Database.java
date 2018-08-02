package my.com.codeplay.loancalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class Database {
    public static final String TABLENAME = "tablename";
    public static final String COL_LOANAMOUNT = "t_loanamount";
    public static final String COL_DOWNPAYMENT = "t_downpayment";
    public static final String COL_TERM = "t_term";
    public static final String COL_ANNUALINTERESTRATE = "t_annualinterestrate";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE" + TABLENAME + "(" + BaseColumns._ID + " integer primary key autoincrement, "
            + COL_LOANAMOUNT + " text not null, "
            + COL_DOWNPAYMENT + " text not null, "
            + COL_TERM + " text not null, "
            + COL_ANNUALINTERESTRATE + " text not null);";
    private MySQLiteOpenHelper dbHelper;

    private class MySQLiteOpenHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "database.db";
        private static final int DATABASE_VERSION = 1;

        public MySQLiteOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {

            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS" + TABLENAME);

            onCreate(db);
        }
    }

    public void insert(ContentValues contentValues) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert(TABLENAME, null, contentValues);
    }

    public Database(Context context) {
        dbHelper = new MySQLiteOpenHelper(context);
    }
}
