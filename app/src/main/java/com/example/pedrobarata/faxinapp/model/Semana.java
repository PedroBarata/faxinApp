package com.example.pedrobarata.faxinapp.model;

/**
 * Created by pedro.barata on 06/12/17.
 */

public class Semana {
    private String nomeUsuario;
    private Comodo comodo;
    private Situacao situacao;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Comodo getComodo() {
        return comodo;
    }

    public void setComodo(Comodo comodo) {
        this.comodo = comodo;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
}
