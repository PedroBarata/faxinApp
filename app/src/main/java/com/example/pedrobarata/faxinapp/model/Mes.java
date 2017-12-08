package com.example.pedrobarata.faxinapp.model;

import java.util.Date;
import java.util.List;

/**
 * Created by pedro.barata on 06/12/17.
 */

public class Mes {
    private String nome;
    private List<Semana> semanasList;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Semana> getSemanasList() {
        return semanasList;
    }

    public void setSemanasList(List<Semana> semanasList) {
        this.semanasList = semanasList;
    }
}
