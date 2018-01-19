package com.example.admin.registrationpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public void addUser(User user) {



        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_FNAME, user.getFname());
        values.put(COLUMN_USER_MNAME, user.getMname());
        values.put(COLUMN_USER_LNAME, user.getLname());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_PHONO,user.getPhno());
        values.put(COLUMN_USER_FAXNO,user.getFaxno());
        values.put(COLUMN_USER_DOB, String.valueOf(user.getDOB()));
        values.put(COLUMN_USER_ADDRESS,user.getAddress());



        db.insert(TABLE_USER, null, values);
        db.close();
    }
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_FNAME,
                COLUMN_USER_PASSWORD,COLUMN_USER_MNAME,COLUMN_USER_LNAME,COLUMN_USER_PHONO,COLUMN_USER_FAXNO,COLUMN_USER_DOB,COLUMN_USER_ADDRESS
        };
        String sortOrder =
                COLUMN_USER_FNAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setFname(cursor.getString(cursor.getColumnIndex(COLUMN_USER_FNAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));

                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }


}
