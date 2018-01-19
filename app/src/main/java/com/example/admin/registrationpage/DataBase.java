package com.example.admin.registrationpage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

/**
 * Created by admin on 19-Jan-18.
 */

public class DataBase extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserManager.db";
    private static final String TABLE_USER = "user";

    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_FNAME = "user_fname";
    private static final String COLUMN_USER_MNAME = "user_mname";
    private static final String COLUMN_USER_LNAME = "user_lname";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_PHONO="phno";
    private static final String COLUMN_USER_FAXNO = "faxno";
    private static final String COLUMN_USER_DOB = "dob";
    private static final String COLUMN_USER_ADDRESS = "address";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_FNAME + " TEXT,"+ COLUMN_USER_MNAME + " TEXT,"+ COLUMN_USER_LNAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT"+ COLUMN_USER_PHONO + " TEXT,"+ COLUMN_USER_FAXNO + " TEXT," + COLUMN_USER_DOB + " TEXT," + COLUMN_USER_ADDRESS + " TEXT" + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);


        onCreate(db);
    }
}
