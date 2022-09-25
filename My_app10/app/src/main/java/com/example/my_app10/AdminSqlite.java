package com.example.my_app10;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSqlite extends SQLiteOpenHelper {
    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String ID = "ID";
    public static final String CUSTOMER_AGE = "CUSTOMER_AGE";
    public static final String ACTIVE = "ACTIVE";

    public AdminSqlite(@Nullable Context context) {
        super(context, "Customer.db", null, 1);//context es donde esta la db, name es el nombre
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//se ejecuta solamente la primera vez
       String sentencia = "CREATE TABLE " + CUSTOMER_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ CUSTOMER_NAME + " TEXT, "+ CUSTOMER_AGE + " INT, "+ ACTIVE + " BOOL )";
       db.execSQL(sentencia);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public boolean addOne(ClientModel c){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();//objetos que cogen dos valores "value":"Name"
        cv.put(CUSTOMER_NAME,c.getName());
        cv.put(CUSTOMER_AGE,c.getAge());
        cv.put(ACTIVE,c.isActive());
        long exito = db.insert(CUSTOMER_TABLE,null,cv);//donde, que datos y nullColumnHack que es el valor quemete si la columna es vacia
        if(exito==-1){
            return false;
        }else{
            return true;
        }
    }
}
