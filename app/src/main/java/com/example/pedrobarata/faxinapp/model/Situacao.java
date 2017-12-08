package com.example.pedrobarata.faxinapp.model;

/**
 * Created by pedro.barata on 06/12/17.
 */

public enum Situacao {

    CONCLUIDO(1, "Concluído"),
    PENDENTE(2, "Pendente");

    private Integer id;
    private String descricao;

    Situacao(Integer id, String desc) {
        this.id         = id;
        this.descricao  = desc;
    }

    public static Situacao obterPorId(Integer id) {

        Situacao[] array = Situacao.values();
        Situacao Situacao = null;
        for(int i = 0; i < array.length; i++) {
            if(String.valueOf(array[i].getId()).equalsIgnoreCase(String.valueOf(id))) {

                Situacao = array[i];
            }
        }
        return Situacao;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
