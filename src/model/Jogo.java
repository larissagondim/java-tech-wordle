package model;

import java.util.ArrayList;
import java.util.List;

public class Jogo {

    private final String palavraSecreta;
    private int tentativas;
    private final int maxTentativas;
    private final List<String> chutes;

    public Jogo(BancoPalavras banco, int maxTentativas) {
        this.palavraSecreta = banco.palavraSecreta().toUpperCase();
        this.tentativas = 0;
        this.maxTentativas = maxTentativas;
        this.chutes = new ArrayList<>();
    }

    public String verificarChute(String chuteAtual) {
        chuteAtual = chuteAtual.toUpperCase();

        if (chuteAtual.length() != 5) {
            return "INVALIDO";
        }

        this.chutes.add(chuteAtual);
        this.tentativas++;

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char letraChute = chuteAtual.charAt(i);
            char letraSecreta = this.palavraSecreta.charAt(i);

            if (letraChute == letraSecreta) {
                resultado.append("G");
            } else if (this.palavraSecreta.contains(String.valueOf(letraChute))) {
                resultado.append("Y");
            } else {
                resultado.append("B");
            }
        }

        return resultado.toString();
    }

    public boolean venceu(String chute) {
        return chute.toUpperCase().equals(this.palavraSecreta);
    }

    public boolean acabou() {
        return tentativas >= maxTentativas;
    }

    public String getPalavraSecreta() {
        return palavraSecreta;
    }
}