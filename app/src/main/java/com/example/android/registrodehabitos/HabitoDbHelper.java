package com.example.android.registrodehabitos;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andrik on 10/04/2018.
 */

public class HabitoDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habitos.db";

    private static final int DATABASE_VERSION = 1;

    public HabitoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABITOS_TABLE = "CREATE TABLE " + HabitoContract.HabitoEntry.TABELA_NOME + " ("
                + HabitoContract.HabitoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitoContract.HabitoEntry.COLUNA_HABITO_ACAO + " TEXT NOT NULL, "
                + HabitoContract.HabitoEntry.COLUNA_HABITO_DATA + " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_HABITOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean onInsert(String acao, int data){
        ContentValues values = new ContentValues();
        values.put(HabitoContract.HabitoEntry.COLUNA_HABITO_ACAO,acao);
        values.put(HabitoContract.HabitoEntry.COLUNA_HABITO_DATA,data);
        long newRowId = getWritableDatabase().insert(HabitoContract.HabitoEntry.TABELA_NOME,null,values);
        return newRowId !=-1;
    }

    public Cursor getDados(){
        String [] projection ={
                HabitoContract.HabitoEntry._ID,
                HabitoContract.HabitoEntry.COLUNA_HABITO_ACAO,
                HabitoContract.HabitoEntry.COLUNA_HABITO_DATA};
        Cursor cursor = getReadableDatabase().query(
                HabitoContract.HabitoEntry.TABELA_NOME, projection, null,null,null,null,null);
        return cursor;
    }

}
