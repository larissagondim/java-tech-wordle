package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {

    private final String palavraSecreta;
    private int tentativas;
    private final int maxTentativas;
    private List<String> chutes;
    private Scanner sc;

    public Jogo(BancoPalavras banco, int maxTentativas) {
        this.palavraSecreta = banco.palavraSecreta().toUpperCase();
        this.tentativas = 0;
        this.maxTentativas = maxTentativas;
        this.chutes = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public void jogar() {
        while (this.tentativas < this.maxTentativas) {
            System.out.print("\nInsira sua " + (this.tentativas + 1) + "ª tentativa: ");
            String chuteAtual = sc.nextLine().toUpperCase();

            if (chuteAtual.length() != 5) {
                System.out.println("A palavra deve ter 5 letras!");
                continue;
            }

            this.chutes.add(chuteAtual);
            this.tentativas++;

            if (chuteAtual.equals(palavraSecreta)) {
                System.out.println("🟩🟩🟩🟩🟩");
                System.out.println("\nVocê acertou em " + this.tentativas + " tentativas!");
                return;
            }

            for (int i = 0; i < 5; i++) {

                char letraChute = chuteAtual.charAt(i);
                char letraSecreta = palavraSecreta.charAt(i);

                if (letraChute == letraSecreta)
                    System.out.print("🟩");
                else if (palavraSecreta.contains(String.valueOf(letraChute)))
                    System.out.print("🟨");
                else
                    System.out.print("⬛");
            }
            System.out.println();
        }

        System.out.println("\nSuas tentativas acabaram.");
        System.out.println("A palavra era: " + this.palavraSecreta);
    }
}