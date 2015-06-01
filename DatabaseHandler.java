package com.example.daniel.koerelogbogapp;

/**
 * Created by Daniel on 30-05-2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

/**
 * Created by Daniel on 4/11/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {


    public static SQLiteDatabase db;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";

    public static final String AUTHORITY = "DanielZ.Koerelogbog";
    public static final Uri CONTENT_URI_TRAVELNOTES = Uri.parse("content://" + AUTHORITY + "/entries");

    //COLUMNNAMES
    //Has to be implemented in order for cursor to work
    public static final String ID = "_id";
    public static final String TABLE_NAME = "entries";
    public static final String DATE = "date";
    public static final String DRIVING_PURPOSE = "purpose";
    public static final String DESTINATION = "destination";
    public static final String DEPARTURE_POINT = "departurePoint";
    public static final String LICENSE_PLATE = "licensePlate";
    public static final String DRIVERS_NAME = "driversName";
    public static final String SSN = "socialSecurityNumber";
    public static final String COMPANY_NAME = "companyName";
    public static final String COMPANY_ADDRESS = "companyAddress";
    public static final String ODOMETER_FROM = "odometerFrom";
    public static final String ODOMETER_TO = "odometerTo";
    public static final String[] TABLE_COLUMNS = new String[]{DRIVING_PURPOSE};
    public static final String[] ALL_COLUMNS = new String[]{ID, DATE, DRIVING_PURPOSE, DESTINATION, DEPARTURE_POINT, LICENSE_PLATE, DRIVERS_NAME, COMPANY_NAME, SSN};

    //Final computed create table string
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + " (" +
                                ID + " integer primary key autoincrement, " +
                                DATE + " text not null," +
                                DRIVING_PURPOSE + " text not null, " +
                                DESTINATION + " text not null, " +
                                DEPARTURE_POINT + " text not null, " +
                                LICENSE_PLATE + " text not null, " +
                                DRIVERS_NAME + " text not null, " +
                                COMPANY_NAME + " text not null," +
                                COMPANY_ADDRESS + " text not null," +
                                SSN + " text not null," +
                                ODOMETER_FROM + " double default '0'," +
                                ODOMETER_TO + " double default '0');";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d(null, "onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if it exists " + TABLE_NAME);
        onCreate(db);
    }

    public static void insert(String query, SQLiteDatabase db) {
        db.execSQL(query);
    }

    public static void insert(ContentValues values) {
        db.insert(DatabaseHandler.TABLE_NAME, null, values);
    }

    public static void update(ContentValues values, int id){
        db.update(DatabaseHandler.TABLE_NAME, values, ID + " = ? ", new String[] {id + ""});
    }

    public static void insert(String query) {
        db.execSQL(query);
    }

    public static Entry get(long id) {
        Entry entry = null;
        return entry;
    }

    public static void delete(long id) {
        db.execSQL("delete from " + DatabaseHandler.TABLE_NAME + " where " + DatabaseHandler.ID + " = " + id);;
    }
}