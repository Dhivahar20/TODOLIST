package com.example.hp.todolist;


import android.content.Context;
import android.content.contantValues;
import android.content.context;
import android.content.contantValues;
import android.content.contantValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DbHelper extends SQLiteopenHelper{

    private static final String DB_NAME = "TODODB";
    private static final String TABLE_NAME = "ItemsTODO";
    private static final String COLUMN_NAME = "Items";
    private static final int DB_VERSION = 1;


    public DbHelper(Context context) {

        super(contaxt,DB_NAME,null,DB_VERSION);
    }

 public void onCreate(SQLiteDatabase db){
        String query = String.format("CREATE TABLE @S(ID INTEGER PRIMARY KEY AUTOINCREAMENT,@s TEXT NOT NULL);"),TABLE_NAME,COLUMN_NAME);
        db.execsql(query);

    }

 public void onUpgrade(SQLiteDatabase db,int oldVerson,int intnewversion){
        String query = String.format("DELETE TABLE IF EXIST @s",TABLE_NAME);
        db.execSQL(query);
        oncreate(db);



 }

    public  void insertNewItems(String items) {
        SQLiteDatabase db = this.getwritableDatabase();
        contantvalues values = new contantvalues();
        values.put(COLUMN_NAME,item);
        db.insertwithonconflict(TABLE_NAME,null,values,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();

    }

    public void delete(String item){
        SQLiteDatabase db = this.getwritableDatabase();
        db.delete(TABLE_NAME,COLUMN_NAME +"=?", new String[]{item});
        db.close();
        }

    public Arraylist<String> getToDoList(){
        ArrayList<String> todolist = new ArrayList<>();
        SQLiteDatabase db = this.getwritableDatabase();
        cursor c = db.query(TABLE_NAME,new String[]{COLUMN_NAME},null,null)
         while(c.moveToNext()){
            int index = (c.getColumnIndex(COLUMN_NAME));

            }

             c.close();
             db.close();
             return getToDoList();

    }

}
