package com.example.times;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.times.R;

public class ViewAddProduto extends AppCompatActivity {

    private EditText edtNomeJogador;
    //private EditText edtQntdProduto;
    private EditText edtNumeroCamisa;
    private Button btnCadastrarJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_add_jogador);

        edtNomeJogador = (EditText)findViewById(R.id.edtNomeJogador);
        //edtQntdProduto = (EditText)findViewById(R.id.edtQntdProduto);
        edtNumeroCamisa = (EditText)findViewById(R.id.edtNumeroCamisa);
        btnCadastrarJogador = (Button)findViewById(R.id.btnCadastrarJogador);

        btnCadastrarJogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

    }

    public void salvar(){
        Jogador j = new Jogador();
        j.setNomeJogador( edtNomeJogador.getText().toString() );
        //p.setQtdProduto(Integer.parseInt(edtQntdProduto.getText().toString()));
        j.setNumeroCamisa(Integer.parseInt(edtNumeroCamisa.getText().toString()));
        JogadorDAO.inserir( j, getIntent().getExtras().getInt("idLista2"), this );
        this.finish();
    }
}
