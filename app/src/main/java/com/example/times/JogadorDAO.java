package com.example.times;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class JogadorDAO {

    public static final void inserir(Jogador item, int idLista, Context context) {
        Banco banco = new Banco(context);
        ContentValues valores = new ContentValues();
        valores.put("nome_jogador", item.getNomeJogador());
        valores.put("numero_camiseta", item.getNumeroCamisa());
        //valores.put("valorProduto", item.getValor());
        valores.put("id_time_FK", idLista);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("Jogadores", null, valores);
    }

    public static final void excluir(int idJogador, Context context) {
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("Jogadores", "id_jogador = " + idJogador, null);
    }

    public static final List<Jogador> listar(Context context, int idLista) {
        List<Jogador> listaJogador = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();

        String sql = "SELECT * FROM Jogadores WHERE id_time_FK = " + idLista;
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Jogador jogador = new Jogador();
                jogador.setIdJogador(cursor.getInt(0));
                jogador.setNomeJogador(cursor.getString(2));
                jogador.setNumeroCamisa(cursor.getInt(3));
                //jogador.setValor(cursor.getDouble(4));
                listaJogador.add(jogador);

            } while (cursor.moveToNext());
        }

        return listaJogador;
    } public static final List<Jogador> listarTudo(Context context) {
        List<Jogador> listaJogador = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();

        String sql = "SELECT * FROM Jogadores";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Jogador item = new Jogador();
                item.setIdJogador(cursor.getInt(0));
                item.setNomeJogador(cursor.getString(2));
                item.setNumeroCamisa(cursor.getInt(3));
                //item.setValor(cursor.getDouble(4));
                //System.out.println("DAO: TODOS PRODUTOS - " + " IDITEM:" + cursor.getInt(0) + " IDLISTA:" + cursor.getInt(1) + " NOME:" + cursor.getString(2) + " QTD:" + cursor.getInt(3) + " PRECO:" + cursor.getDouble(4));
                listaJogador.add(item);

            } while (cursor.moveToNext());
        }

        return listaJogador;
    }

}
