package com.krillin.futebol_tictactoe.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jogos")
public class Jogo {
    @Id
    private String id; // ID gerado pelo MongoDB
    private String time1; // Nome do primeiro time
    private String time2; // Nome do segundo time

    // Construtor padrão
    public Jogo() {
    }

    // Construtor
    public Jogo(String time1, String time2) {
        this.time1 = time1;
        this.time2 = time2;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }
}
