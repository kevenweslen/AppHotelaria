package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application {
    @Override
    public void start(Stage janela) throws Exception {

        Button BtnSub = new Button("Subimeter");
        BtnSub.setStyle("-fx-gramphic-text-gap: 10px;" +
                "-fx-cursor: hand;" +
                "-fx-border-radius: 25px;" +
                "-fx-padding: 10px;" +
                "-fx-border-color: Black;" +
                "-fx-background-color: rgba(255,191,0,0.75);" +
                "-fx-background-radius: 25px");

        Image imgLogin = new Image(getClass().getResourceAsStream
                ("/view/img/imgLogin.jpeg"));
        ImageView imgLog = new ImageView(imgLogin);
        imgLog.setFitWidth(400);
        imgLog.setFitHeight(500);

        Image imgIcon = new Image(getClass().getResourceAsStream
                ("/view/Resources/img/logoHotel.png"));

        Image imgEyeC = new Image(getClass().getResourceAsStream("/view/resources/img/olhoFechado.png"));
        ImageView imgEye = new ImageView(imgEyeC);
        imgEye.setFitWidth(20);
        imgEye.setFitHeight(20);


        Image imgEyeO = new Image(getClass().getResourceAsStream("/view/Resources/img/olhoAberto.png"));
        ImageView imgEye1 = new ImageView(imgEyeO);
        imgEye1.setFitWidth(20);
        imgEye1.setFitHeight(20);

        Button eyeButton1 = new Button();
        eyeButton1.setGraphic(imgEye1);
        eyeButton1.setStyle("-fx-background-color: transparent;");

        Button eyeButton = new Button();
        eyeButton.setGraphic(imgEye);
        eyeButton.setStyle("-fx-background-color: transparent;");

        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/Resources/Fonts/" + "Lexend-Regular.ttf"), 14);
        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/Resources/Fonts/" + "Lexend-Bold.ttf"), 14);


        //CONTAONER PRINCIPAL
        BorderPane mainPane = new BorderPane();

        //Titulo
        Label lblTitulo = new Label("Faça o seu login");
        lblTitulo.setAlignment(Pos.TOP_CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        lblTitulo.setFont(Font.font(fonteNegrito.getFamily(), 25));
        HBox titleBox = new HBox(lblTitulo);
        titleBox.setPadding(new Insets(20, 20, 20, 20));
        titleBox.setAlignment(Pos.TOP_CENTER);

        Label lblUser = new Label("Usuário:");
        lblUser.setFont(fonteRegular);
        TextField txtUser = new TextField();
        txtUser.setPrefWidth(140);
        txtUser.setPromptText("Tipo:");
        txtUser.setStyle("-fx-border-color: Black");

        Label senha = new Label("Senha: ");
        PasswordField passSenha =new PasswordField();
        passSenha.setMaxWidth(140);
        passSenha.setPromptText("Digite sua senha");

        TextField txtSenha = new TextField();
        txtSenha.setPrefWidth(140);
        txtSenha.setPromptText("Digite sua senha");

        StackPane senha123 = new StackPane();
        senha123.setPrefWidth(140);
        senha123.getChildren().addAll(txtSenha, passSenha);

        final boolean[] clicado = {false};
        eyeButton.setOnMouseClicked(evento -> {
            if (clicado[0]) {
                eyeButton.setGraphic(imgEye1);

                passSenha.setText(txtSenha.getText());
                passSenha.setVisible(true);
                passSenha.setManaged(true);
                txtSenha.setVisible(false);

            } else {
                eyeButton.setGraphic(imgEye);

                txtSenha.setText(passSenha.getText());
                txtSenha.setVisible(true);
                txtSenha.setManaged(true);
                passSenha.setVisible(false);

            }
            clicado[0] = !clicado[0];
        });


        StackPane stackPane = new StackPane(passSenha, txtSenha);

        HBox btnBox = new HBox(stackPane, eyeButton);

        GridPane formGrid = new GridPane();
        formGrid.add(lblUser, 0, 0);
        formGrid.add(txtUser, 1, 0);
        formGrid.add(senha, 0, 1);
        formGrid.add(btnBox, 1, 1);
        formGrid.add(BtnSub, 1, 3);
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);


        VBox sidebarLog = new VBox(imgLog);
        mainPane.setLeft(sidebarLog);

        VBox layout = new VBox(10, titleBox, formGrid);
        layout.setAlignment(Pos.CENTER);
        mainPane.setRight(layout);//adiciona nova linha
        layout.setPrefWidth(400);

        Scene scene = new Scene(mainPane, 800, 500);
        janela.setTitle("Golden Sun");
        janela.getIcons().add(imgIcon);
        janela.setScene(scene);
        janela.setResizable(false);//empedi a anela de redimencionar
        janela.show();

    }

    public static void main(String[] args) {
        launch(args); //Inicializa o JAVAFX (aplicação)
    }
}

