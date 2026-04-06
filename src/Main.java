import model.BancoPalavras;
import model.Jogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bem-vindo ao jogo!");

        BancoPalavras banco = new BancoPalavras();
        Jogo jogo = new Jogo(banco, 6);

        Scanner sc = new Scanner(System.in);

        while (!jogo.acabou()) {

            System.out.print("\nDigite uma palavra de 5 letras: ");
            String chute = sc.nextLine();

            String resultado = jogo.verificarChute(chute);

            if (resultado.equals("INVALIDO")) {
                System.out.println("A palavra deve ter 5 letras!");
                continue;
            }

            for (char c : resultado.toCharArray()) {
                switch (c) {
                    case 'G':
                        System.out.print("🟩");
                        break;
                    case 'Y':
                        System.out.print("🟨");
                        break;
                    default:
                        System.out.print("⬛");
                }
            }
            System.out.println();

            if (jogo.venceu(chute)) {
                System.out.println("\nVocê ganhou!");
                return;
            }
        }

        System.out.println("\nSuas tentativas acabaram.");
        System.out.println("A palavra era: " + jogo.getPalavraSecreta());
        System.out.println("Fim de jogo");
    }
}