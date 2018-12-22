package com.example.android.registrodehabitos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitoDbHelper habitos = new HabitoDbHelper(this);
        habitos.onInsert("levantar da cama",700);// 7:00 horas
        Cursor cursor = habitos.getDados();
        int idColunaIndice=cursor.getColumnIndex(HabitoContract.HabitoEntry._ID);
        int acaoColunaIndice=cursor.getColumnIndex(HabitoContract.HabitoEntry.COLUNA_HABITO_ACAO);
        int dataColunaIndice=cursor.getColumnIndex(HabitoContract.HabitoEntry.COLUNA_HABITO_DATA);
        cursor.moveToLast();
        int currentID=cursor.getInt(idColunaIndice);
        String currentAcao=cursor.getString(acaoColunaIndice);
        int currentData=cursor.getInt(dataColunaIndice);
        TextView displayView = (TextView) findViewById(R.id.teste);
        displayView.setText("Quantidade de habitos =" + cursor.getCount()+"\n");
        displayView.append(HabitoContract.HabitoEntry._ID + " - "
            +HabitoContract.HabitoEntry.COLUNA_HABITO_ACAO + " - "
            +HabitoContract.HabitoEntry.COLUNA_HABITO_DATA + "\n");
        displayView.append("\n"+currentID+" - "+currentAcao+" - "+currentData);
    }

}
