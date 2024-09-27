package com.krillin.futebol_tictactoe.application;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krillin.futebol_tictactoe.domain.Jogo;
import com.krillin.futebol_tictactoe.domain.JogoRepository;

@Service
public class JogoService {
    private final JogoRepository jogoRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public Jogo criarJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public void criar() {
        String url = "https://liquipedia.net/counterstrike/SAW";
        System.out.println("sssssssssssssssss");
        try {

        Document doc = Jsoup.connect(url).get();
        
        Elements tables = doc.select("table.wikitable.wikitable-striped.roster-card");

           
           for (Element table : tables) {

                Elements rows = table.select("tbody tr");

                for (Element row : rows) {
                   
                    Elements cols = row.select("td");
                    if (!cols.isEmpty()) {
                      
                        for (Element col : cols) {
                            System.out.print(col.text() + "\t"); 
                        }
                        System.out.println();
                    }
                }

            }
        } catch (IOException e) {
            System.err.println("Erro ao conectar-se ao site: " + e.getMessage());
        }
    }
    public List<Jogo> listarJogos() {
        return jogoRepository.findAll(); // Retorna todos os jogos
    }


    public List<Jogo> encontrarJogosPorTime1(String time1) {
        List<Jogo> jogos = jogoRepository.findByTime1(time1);
        return jogos;
    }
}
