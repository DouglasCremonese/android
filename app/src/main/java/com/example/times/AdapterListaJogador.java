package com.example.times;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.times.R;

import java.util.List;

public class AdapterListaJogador extends BaseAdapter {


    private Context context;
    private List<Jogador> jogadores;
    private LayoutInflater inflater;

    public AdapterListaJogador(Context context, List<Jogador> jogadores) {
        this.context = context;
        this.jogadores = jogadores;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return jogadores.size();
    }

    @Override
    public Object getItem(int position) {
        return jogadores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return jogadores.get(position).getIdJogador();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.layout_item_jogador, null);
            item = new Suporte();

            item.tvNomeJogador = (TextView) convertView.findViewById(R.id.tvIdNomeJogador);
            //item.tvQtdProduto = (TextView) convertView.findViewById(R.id.tvQuantidaeProduto);
            item.tvNumeroCamisa = (TextView) convertView.findViewById(R.id.tvNumeroCamisa);
            item.tvIdJogador= (TextView) convertView.findViewById(R.id.tvIdJogador);
            convertView.setTag(item);

        } else {
            item = (Suporte) convertView.getTag();
        }

        Jogador prod = jogadores.get(position);
        item.tvIdJogador.setText(String.valueOf(prod.getIdJogador()));
        item.tvNomeJogador.setText(prod.getNomeJogador());
        item.tvNumeroCamisa.setText(String.valueOf(prod.getNumeroCamisa()));


        return convertView;
    }

    private class Suporte {
        TextView tvNomeJogador, tvNumeroCamisa, tvIdJogador;
    }

}
