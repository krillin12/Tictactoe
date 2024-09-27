package com.krillin.futebol_tictactoe.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JogoRepository extends MongoRepository<Jogo, String> {

    List<Jogo> findByTime1(String time1);
}
