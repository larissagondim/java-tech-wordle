package model;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private String palavraSecreta;
    private int tentativas;
    private int maxTentativas;
    private List<String> chutes;

    public Jogo(BancoPalavras banco, int maxTentativas) {
        this.palavraSecreta = banco.palavraSecreta();
        this.tentativas = 0;
        this.maxTentativas = maxTentativas;
        this.chutes = new ArrayList<>();
    }


}