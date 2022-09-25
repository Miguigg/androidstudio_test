package com.example.my_app10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSqlite extends SQLiteOpenHelper {
    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final int ID = 1;
    public static final int CUSTOMER_AGE = 10;
    public static final boolean ACTIVE = false;

    public AdminSqlite(@Nullable Context context) {
        super(context, "Customer.db", null, 1);//context es donde esta la db, name es el nombre
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//se ejecuta solamente la primera vez
       String sentencia = "CREATE TABLE " + CUSTOMER_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ CUSTOMER_NAME + " text,"+ CUSTOMER_AGE + " integer,"+ ACTIVE + " bool )";

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
