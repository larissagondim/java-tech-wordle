import javafx.application.Application;
import view.TelaJogo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando o Java Tech Wordle...");

        // classe com interface gráfica
        Application.launch(TelaJogo.class, args);
    }
}