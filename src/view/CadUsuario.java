package view;
import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage; //Classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.Components.PainelButons;
import view.Components.Sidebar;

public class CadUsuario extends Application {
    @Override
    public void start(Stage janela) throws Exception{

    Sidebar Menu = new Sidebar();
        PainelButons menuButons = new PainelButons();

        Image imgIcon = new Image(getClass().getResourceAsStream
                ("/view/Resources/img/logoHotel.png"));
        Image imgUser = new Image(getClass().getResourceAsStream
                ("/view/Resources/img/icons8usuario24.png"));

        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/Resources/Fonts/" + "Lexend-Regular.ttf"),14);
        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/Resources/Fonts/" + "Lexend-Bold.ttf"),14);


        //CONTAONER PRINCIPAL
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(Menu);

        ImageView viewImgUser = new ImageView(imgUser);
        viewImgUser.setFitWidth(20);
        viewImgUser.setFitHeight(20);


        //Titulo
        Label lblTitulo = new Label("Cadastro de Funcionarios");
        lblTitulo.setAlignment(Pos.TOP_CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox titleBox = new HBox(viewImgUser, lblTitulo);
        titleBox.setPadding(new Insets(20, 20, 20, 20));
        titleBox.setAlignment(Pos.TOP_CENTER);
        lblTitulo.setFont(Font.font(fonteNegrito.getFamily(), 25));

        Label lblNome = new Label("Nome: ");
        lblNome.setFont(fonteRegular);
        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome:");
        txtNome.setStyle("-fx-border-color: black");

        Label lblEmail = new Label("E-mail: ");
        lblEmail.setFont(fonteRegular);
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("E-mail:");
        txtEmail.setStyle("-fx-border-color: black");

        Label lblTel = new Label("Telefone: ");
        lblTel.setFont(fonteRegular);
        TextField txtTel = criarMascaraCampo("(##) #####-####");
        txtTel.setPromptText("Telefone:");
        txtTel.setStyle("-fx-border-color: black");

        Label lblSetor = new Label("Setores: ");
        lblSetor.setFont(fonteRegular);


        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione");
        boxEmail.setStyle("-fx-background-color: transparente;" +
                "-fx-border-color: black;" +
                "-fx-cursor: hand;");


        ComboBox<String> boxRules = new ComboBox<>();
        boxRules.getItems().addAll("Limpesa", "Rescepição", "Cozinheiro", "Garçom");
        boxRules.setPromptText("Selecione seu setor");
        boxRules.setStyle("-fx-background-color: transparente;" +
                "-fx-border-color: black;" +
                "-fx-cursor: hand;");


        GridPane formGrid = new GridPane();
        formGrid.add(menuButons, 1, 4);
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblEmail, 0, 1);
        formGrid.add(txtEmail, 1, 1);
        formGrid.add(lblTel, 0, 2);
        formGrid.add(txtTel, 1, 2);
        formGrid.add(lblSetor, 0, 3);
        formGrid.add(boxEmail, 2, 1);
        formGrid.add(boxRules, 1, 3);
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        VBox layout = new VBox(10, titleBox, formGrid);
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
