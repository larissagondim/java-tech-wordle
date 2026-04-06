package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.BancoPalavras;
import model.Jogo;

public class TelaJogo extends Application {

    private Jogo jogo;
    private VBox tentativasBox;
    private Label mensagem;

    @Override
    public void start(Stage stage) {

        BancoPalavras banco = new BancoPalavras();
        jogo = new Jogo(banco, 6);

        // Campo de input
        TextField input = new TextField();
        input.setPromptText("Digite uma palavra de 5 letras");

        // Botão
        Button botao = new Button("Enviar");

        // Área das tentativas
        tentativasBox = new VBox(10);
        tentativasBox.setAlignment(Pos.CENTER);

        // Mensagem
        mensagem = new Label();

        // Evento do botão
        botao.setOnAction(e -> {
            String chute = input.getText();

            String resultado = jogo.verificarChute(chute);

            if (resultado.equals("INVALIDO")) {
                mensagem.setText("A palavra deve ter 5 letras!");
                return;
            }

            // Criar linha visual
            HBox linha = new HBox(5);
            linha.setAlignment(Pos.CENTER);

            for (int i = 0; i < resultado.length(); i++) {
                Label letra = new Label(String.valueOf(chute.toUpperCase().charAt(i)));

                letra.setMinSize(45, 45);
                letra.setAlignment(Pos.CENTER);

                switch (resultado.charAt(i)) {
                    case 'G':
                        letra.setStyle("-fx-background-color: #6aaa64; -fx-text-fill: white;");
                        break;
                    case 'Y':
                        letra.setStyle("-fx-background-color: #c9b458; -fx-text-fill: white;");
                        break;
                    default:
                        letra.setStyle("-fx-background-color: #787c7e; -fx-text-fill: white;");
                }

                linha.getChildren().add(letra);
            }

            tentativasBox.getChildren().add(linha);

            // Verifica vitória
            if (jogo.venceu(chute)) {
                mensagem.setText("🎉 Você ganhou!");
                botao.setDisable(true);
            }

            // Verifica derrota
            else if (jogo.acabou()) {
                mensagem.setText("❌ Fim de jogo! Palavra: " + jogo.getPalavraSecreta());
                botao.setDisable(true);
            }

            input.clear();
        });

        // Layout principal
        VBox root = new VBox(15, tentativasBox, input, botao, mensagem);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 500);

        stage.setTitle("Java Tech Wordle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}