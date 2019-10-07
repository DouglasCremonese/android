package com.example.times;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListaDAO {

    public static final void inserir(Lista time, Context context){
        Banco banco = new Banco(context);
        ContentValues valores = new ContentValues();
        valores.put("nome_time", time.getNome() );
        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("Times", null, valores);
    }

    public static final void excluir(int idLista, Context context){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("Times", "id_time = "+idLista, null);
        db.delete("Jogadores", "id_time_FK = "+idLista, null);
    }

    public static final List<Lista> listar(Context context){
        List<Lista> lista = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        String sql = "SELECT * FROM Times ORDER BY id_time DESC ";
        Cursor cursor = db.rawQuery(sql, null);
        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Lista time = new Lista();
                time.setId( cursor.getInt( 0 ) );
                time.setNome( cursor.getString( 1 ) );
                lista.add( time );
            }while ( cursor.moveToNext() );
        }
        return lista;
    }

}
