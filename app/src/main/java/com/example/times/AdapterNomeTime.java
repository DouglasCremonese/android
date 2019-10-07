package com.example.times;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.times.R;

import java.util.List;

public class AdapterNomeTime extends BaseAdapter {

    private Context context;
    private List<Lista> lista;
    private LayoutInflater inflater;

    public AdapterNomeTime(Context context, List<Lista> lista) {
        this.context = context;
        this.lista = lista;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if (convertView == null) {
            convertView = inflater.inflate
                    (R.layout.layout_nome_time, null);
            item = new Suporte();
            item.tvIdTitulo = (TextView)
                    convertView.findViewById(R.id.tvIdNomeTime);
            item.tvTitulo = (TextView)
                    convertView.findViewById(R.id.tvNomeTime);

            convertView.setTag(item);
        } else {
            item = (Suporte) convertView.getTag();
        }

        Lista Nome = lista.get(position);
        item.tvIdTitulo.setText(String.valueOf(Nome.getId()));
        item.tvTitulo.setText(Nome.getNome());


        return convertView;
    }

    private class Suporte {
        TextView tvIdTitulo, tvTitulo;
    }
}



