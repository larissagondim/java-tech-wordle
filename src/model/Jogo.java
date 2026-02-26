package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// classe construtora do jogo
public class Jogo {
    private final String palavraSecreta;
    private int tentativas;
    private final int maxTentativas;
    private List<String> chutes;
    private Scanner sc;
    private String chuteAtual;
// método principal
    public Jogo(BancoPalavras banco, int maxTentativas) {
        this.palavraSecreta = banco.palavraSecreta();
        this.tentativas = 0;
        this.maxTentativas = maxTentativas;
        this.chutes = new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.chuteAtual = " ";
    }

    public void jogar() {
        // lógica temporária do jogo
        while(this.tentativas < this.maxTentativas) {
            System.out.print("\nInsira sua " + (this.tentativas + 1) + "ª tentativa: ");
            this.chuteAtual = sc.nextLine().toUpperCase();
            this.chutes.add(chuteAtual);
            this.tentativas += 1;

            if(chuteAtual.equals(palavraSecreta.toUpperCase())) {
                System.out.println("\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9");
                System.out.println("\nVocê acertou em " + this.tentativas + " tentativas!");
                break;
            } else {
                for(int i = 0; i < 5; i++) {
                    char letraChute = chuteAtual.charAt(i);
                    char letraSecreta = palavraSecreta.charAt(i);
                    if(letraChute == letraSecreta) {
                        System.out.print("\uD83D\uDFE9");
                    } else if(letraChute != letraSecreta) {
                        boolean temNaPalavra = false;
                        for (int j = 0; j < 5; j++) {
                            if (letraChute == Character.toUpperCase(palavraSecreta.charAt(j))) {
                                temNaPalavra = true;
                                break;
                            }
                        }
                        if (temNaPalavra) System.out.print("\uD83D\uDFe8");
                        else System.out.print("\u2B1B");
                    }

                }
            }
        }

        if (this.tentativas == this.maxTentativas && !this.chuteAtual.equals(this.palavraSecreta.toUpperCase())) {
            System.out.println("\nQue pena, suas tentativas acabaram! A palavra era: " + this.palavraSecreta);
        }

        sc.close();
    }
}