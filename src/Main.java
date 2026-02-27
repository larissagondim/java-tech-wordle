import model.BancoPalavras;
import model.Jogo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao jogo!");

        BancoPalavras banco = new BancoPalavras();

        Jogo meuJogo = new Jogo(banco, 6);

        meuJogo.jogar();

        System.out.println("Fim de jogo");
    }
}