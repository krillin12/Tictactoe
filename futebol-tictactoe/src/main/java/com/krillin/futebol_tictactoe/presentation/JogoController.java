package com.krillin.futebol_tictactoe.presentation;
import com.krillin.futebol_tictactoe.application.JogoService;
import com.krillin.futebol_tictactoe.domain.Jogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    private final JogoService jogoService;

    @Autowired
    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @PostMapping
    public Jogo criarJogo(@RequestBody Jogo jogo) {
        return jogoService.criarJogo(jogo);
    }

    @GetMapping("/listar")
    public List<Jogo> listarJogos() {
        return jogoService.listarJogos();
    }

    @PostMapping("/scraper")
    public void criar() {
         jogoService.criar();
    }

    // Endpoint para encontrar jogos por time1
    @GetMapping("/time1/{time1}")
    public List<Jogo> encontrarJogosPorTime1(@PathVariable String time1) {
        List<Jogo> jogos = jogoService.encontrarJogosPorTime1(time1);
        System.out.println("Jogos encontrados: " + jogos); // Para debug
        return jogos;
    }
}