package com.example.times;

public class Jogador {

    private int    idJogador;
    private String nomeJogador;
    private int numeroCamisa;

    public Jogador() {
    }

    public Jogador(String nomeProduto) {
        this.nomeJogador = nomeProduto;
    }

    public Jogador(String nomeProduto, int valor) {
        this.nomeJogador = nomeProduto;
        this.numeroCamisa = valor;
    }

    public Jogador(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {this.idJogador = idJogador;}

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public double getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }
}
