package view; //Package view (classes que, quando executadas, interagem com o usuário)

import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage; //Classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.Components.PainelButons;
import view.Components.Sidebar;

public class CadCliente extends Application {
    @Override
    public void start(Stage janela) throws Exception {

        Sidebar MenuLateral = new Sidebar();

        //Carregar imagens
        Sidebar Menu = new Sidebar();
        PainelButons menuButons = new PainelButons();


        Image imgIcon = new Image(getClass().getResourceAsStream
                ("/view/Resources/img/logoHotel.png"));
        Image imgUser = new Image(getClass().getResourceAsStream
                ("/view/Resources/img/icons8usuario24.png"));

        //CONTAONER PRINCIPAL
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(Menu);

        ImageView viewImgUser = new ImageView(imgUser);
        viewImgUser.setFitWidth(20);
        viewImgUser.setFitHeight(20);


        //Titulo
        Label lblTitulo = new Label("Cadastro de Clientes");
        lblTitulo.setAlignment(Pos.TOP_CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox titleBox = new HBox(viewImgUser, lblTitulo);
        titleBox.setPadding(new Insets(20, 20, 20, 20));
        titleBox.setAlignment(Pos.TOP_CENTER);


        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome:");
        txtNome.setStyle("-fx-border-color: black");

        Label lblCPF = new Label("CPF: ");
        TextField txtCPF = criarMascaraCampo("###.###.###-##");
        txtCPF.setPromptText("CPF:");
        txtCPF.setStyle("-fx-border-color: black");

        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("E-Mail:");
        txtEmail.setStyle("-fx-border-color: black");

        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione:");
        boxEmail.setStyle("-fx-background-color: transparent;" +
                "-fx-border-color: black;" +
                "-fx-cursor: hand;");


        Label lblTel = new Label("Telefone: ");
        TextField txtTel = criarMascaraCampo("(##) #####-####");
        txtTel.setPromptText("Telefone:");
        txtTel.setStyle("-fx-border-color: black");


        GridPane formGrid = new GridPane();
        formGrid.add(menuButons, 1, 4);

        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblCPF, 0, 1);
        formGrid.add(txtCPF, 1, 1);
        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(lblTel, 0, 3);
        formGrid.add(txtTel, 1, 3);
        formGrid.add(boxEmail, 2, 2);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        formGrid.setAlignment(Pos.CENTER);

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

    //metodo para criar um campo de texto com MASCARA

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
