package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.BancoPalavras;
import model.Jogo;

public class TelaJogo extends Application {

    @Override
    public void start(Stage stage) {
        // inicializa a logica do jogo aqui
        BancoPalavras banco = new BancoPalavras();
        Jogo meuJogo = new Jogo(banco, 6);

        // texto que va aparecer na janela
        Label label = new Label("Teste GUI");
        label.setStyle("- kinship-font-size: 20px; -fx-text-alignment: center;");

        StackPane root = new StackPane();
        root.getChildren().add(label);

        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("Java Tech Wordle");
        stage.setScene(scene);
        stage.show();

        System.out.println("Janela propriamente exibida");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

