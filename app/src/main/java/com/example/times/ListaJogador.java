package com.example.times;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.times.R;

import java.util.List;

public class ListaJogador extends AppCompatActivity {

    ListView lvListaJogador;
    List<Jogador> jogadores;
    AdapterListaJogador adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jogador);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvListaJogador = (ListView) findViewById(R.id.lvListaJogador);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ListaJogador.this, ViewAddProduto.class);
                in.putExtra("idLista2", getIntent().getExtras().getInt("idLista1"));
                startActivity(in);
            }
        });


        lvListaJogador.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final Jogador listaSelecionada = jogadores.get(position);
                AlertDialog.Builder alerta =
                        new AlertDialog.Builder(ListaJogador.this);
                alerta.setTitle(R.string.deletarJogador);
                alerta.setMessage(listaSelecionada.getNomeJogador());
                alerta.setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        JogadorDAO.excluir(listaSelecionada.getIdJogador(),
                                ListaJogador.this);

                        jogadores.remove(position);
                        carregarJogadorPorTime();

                        adapter.notifyDataSetChanged();

                    }
                });
                alerta.setNeutralButton(R.string.nao, null);
                alerta.show();


                return true;
            }
        });

        /*lvListaProduto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Jogador produtoSelecionado = produtos.get(position);
            }*/
    }

    private void carregarJogadorPorTime() {
        jogadores = JogadorDAO.listar(this, getIntent().getExtras().getInt("idLista1"));
        adapter = new AdapterListaJogador(this, jogadores);
        lvListaJogador.setAdapter(adapter);
    }



    @Override
    protected void onResume() {
        super.onResume();
        carregarJogadorPorTime();
    }


}