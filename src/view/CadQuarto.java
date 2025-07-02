package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import view.Components.PainelButons;
import view.Components.Sidebar;


public class CadQuarto extends Application {
    @Override
    public void start(Stage janela) throws Exception {

        Sidebar Menu = new Sidebar();
        PainelButons menuButons = new PainelButons();

        Image imgIcon = new Image(getClass().getResourceAsStream
                ("/view/Resources/img/logoHotel.png"));
        Image imgUser = new Image(getClass().getResourceAsStream
                ("/view/Resources/img/icons8usuario24.png"));

        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/Resources/Fonts/" + "Lexend-Regular.ttf"), 14);
        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/Resources/Fonts/" + "Lexend-Bold.ttf"), 14);


        //CONTAONER PRINCIPAL
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(Menu);

        ImageView viewImgUser = new ImageView(imgUser);
        viewImgUser.setFitWidth(20);
        viewImgUser.setFitHeight(20);


        //Titulo
        Label lblTitulo = new Label("Cadastro de Quartos");
        lblTitulo.setAlignment(Pos.TOP_CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox titleBox = new HBox(viewImgUser, lblTitulo);
        titleBox.setPadding(new Insets(20, 20, 20, 20));
        titleBox.setAlignment(Pos.TOP_CENTER);
        lblTitulo.setFont(Font.font(fonteNegrito.getFamily(), 25));

        Label lblQaurto = new Label("Tipo do Quarto:");
        lblQaurto.setFont(fonteRegular);
        TextField txtQaurto = new TextField();
        txtQaurto.setPrefWidth(250);
        txtQaurto.setPromptText("Tipo:");
        txtQaurto.setStyle("-fx-border-color: Black");

        Label lblNumero = new Label("Número do quarto:");
        lblNumero.setFont(fonteRegular);
        TextField txtNumero = new TextField();
        txtNumero.setPromptText("Número:");
        txtNumero.setStyle("-fx-border-color: Black");

        Label lblPreco = new Label("Preço do quarto:");
        lblPreco.setFont(fonteRegular);
        TextField txtPreco = criarMascaraCampo("R$:#.###,##");
        txtPreco.setPromptText("Preço:");
        txtPreco.setStyle("-fx-border-color: Black");

        Label lblQtdSolteiro = new Label("Camas de solteireo:");
        lblQtdSolteiro.setFont(fonteRegular);
        ComboBox<String> boxQtdSolteiro = new ComboBox<>();
        boxQtdSolteiro.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        boxQtdSolteiro.setPromptText("Selecione");
        boxQtdSolteiro.setStyle("-fx-background-color: transparente;" +
                "-fx-border-color: black;" +
                "-fx-cursor: hand;");

        Label lblQtdCasal = new Label("Camas de casal:");
        lblQtdCasal.setFont(fonteRegular);
        ComboBox<String> boxQtdCasal = new ComboBox<>();
        boxQtdCasal.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        boxQtdCasal.setPromptText("Selecione");
        boxQtdCasal.setStyle("-fx-background-color: transparente;" +
                "-fx-border-color: black;" +
                "-fx-cursor: hand;");

        Label lblDisp = new Label("Quatidade disponivel:");
        lblDisp.setFont(fonteRegular);
        ComboBox<String> boxDisp = new ComboBox<>();
        boxDisp.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9","10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25");
        boxDisp.setPromptText("Selecione");
        boxDisp.setStyle("-fx-background-color: transparente;" + "-fx-border-color: black;");


        GridPane formGrid = new GridPane();
        formGrid.add(lblQaurto, 0, 0);
        formGrid.add(txtQaurto, 1, 0);
        formGrid.add(lblNumero, 0, 1);
        formGrid.add(txtNumero, 1, 1);
        formGrid.add(lblPreco, 0, 2);
        formGrid.add(txtPreco, 1, 2);
        formGrid.add(lblQtdSolteiro, 0, 3);
        formGrid.add(boxQtdSolteiro, 1, 3);
        formGrid.add(lblQtdCasal, 0, 4);
        formGrid.add(boxQtdCasal, 1, 4);
        formGrid.add(lblDisp, 0, 5);
        formGrid.add(boxDisp, 1, 5);
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        menuButons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10, titleBox, formGrid, menuButons);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);//adiciona nova linha
        Scene scene = new Scene(mainPane, 800, 500);
        janela.setTitle("Golden Sun");
        janela.getIcons().add(imgIcon);
        janela.setScene(scene);
        janela.setResizable(false);//empedi a anela de redimencionar
        janela.show();

    }

    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
        {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;

            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    } else {
                        break;
                    }
                } else {
                    formatacaoCampo.append(caracter);
                }
            }
            txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }

    public static void main(String[] args) {
        launch(args); //Inicializa o JAVAFX (aplicação)
    }
}
