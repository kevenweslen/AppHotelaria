package view.Components;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Sidebar extends VBox {

    public Button BtnClientes = new Button("Clientes");
    public Button BtnFuncionario = new Button("Funcionarios");
    public Button BtnQuarto = new Button("Quatos");
    public Button BtnReserva = new Button("Reservas");
    public Button BtnRelatorios = new Button("Relatorios");

    public Sidebar() {
        Image logoHotel2 = new Image
                (getClass().getResourceAsStream("/view/Resources/img/logoHotel2.png"));

        Image iconFuncionario = new Image
                (getClass().getResourceAsStream("/view/Resources/img/icon-funcionario.png"));

        Image iconCliente = new Image
                (getClass().getResourceAsStream("/view/Resources/img/icon-cliente.png"));

        Image iconQuarto = new Image
                (getClass().getResourceAsStream("/view/Resources/img/icon-quarto.png"));

        Image iconReserva = new Image
                (getClass().getResourceAsStream("/view/Resources/img/icon-reserva.png"));

        Image iconRelatorio = new Image
                (getClass().getResourceAsStream("/view/Resources/img/icon-relatorio.png"));


        //Carregar as fontes
        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/Resources/Fonts/" + "Newsreader_14pt-Bold.ttf"),14);
        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/Resources/Fonts/" + "Lexend-Bold.ttf"),14);


        //Objeto para manipular dimensões das imagens JÀ CARREGADAS
        ImageView viewIconFuncionarios = new ImageView(iconFuncionario);
        viewIconFuncionarios.setFitWidth(20);//altura
        viewIconFuncionarios.setFitHeight(20);//largura

        ImageView viewIconCliente = new ImageView(iconCliente);
        viewIconCliente.setFitWidth(20);//altura
        viewIconCliente.setFitHeight(20);//largura

        ImageView viewIconQuarto = new ImageView(iconQuarto);
        viewIconQuarto.setFitWidth(20);//altura
        viewIconQuarto.setFitHeight(20);//largura

        ImageView viewIconReserva = new ImageView(iconReserva);
        viewIconReserva.setFitWidth(20);//altura
        viewIconReserva.setFitHeight(20);//largura

        ImageView viewIconRelatorio = new ImageView(iconRelatorio);
        viewIconRelatorio.setFitWidth(20);//altura
        viewIconRelatorio.setFitHeight(20);//largura



        BtnClientes.setGraphic(viewIconCliente);
        BtnFuncionario.setGraphic(viewIconFuncionarios);
        BtnQuarto.setGraphic(viewIconQuarto);
        BtnReserva.setGraphic(viewIconReserva);
        BtnRelatorios.setGraphic(viewIconRelatorio);

        ImageView imgHotel = new ImageView(logoHotel2);
        imgHotel.setFitWidth(70);
        imgHotel.setFitHeight(70);
        Label lblMenu = new Label("Golden Sun");
        lblMenu.setStyle("-fx-text-fill: #ffbf00;");

        lblMenu.setFont(Font.font(fonteRegular.getFamily(), 25));

        //Estilização dos botoes da barra latera
        String styleButton = "-fx-background-color: transparent;" +
                "-fx-bordeer-color: transparent;" +
                "-fx-gramphic-text-gap: 20px;" +
                "-fx-cursor: hand;" +
                "-fx-text-fill: #ffffff;" +
                "-fx-font-size: 15;" +
                "-fx-border-color: #ffbf00;" +
                "-fx-border-radius: 10px;";

        BtnClientes.setStyle(styleButton);
        BtnFuncionario.setStyle(styleButton);
        BtnQuarto.setStyle(styleButton);
        BtnReserva.setStyle(styleButton);
        BtnRelatorios.setStyle(styleButton);

        //ao passar o mouse em cima do botão, ele muda de cor
        BtnClientes.setOnMouseEntered(event ->
            BtnClientes.setStyle(styleButton.replace("transparent", "rgba(255,191,0,0.75)")));

        BtnClientes.setOnMouseExited(event -> BtnClientes.setStyle(styleButton));

        BtnFuncionario.setOnMouseEntered(event ->
                BtnFuncionario.setStyle(styleButton.replace("transparent", "rgba(255,191,0,0.75)")));

        BtnFuncionario.setOnMouseExited(event -> BtnFuncionario.setStyle(styleButton));

        BtnQuarto.setOnMouseEntered(event ->
                BtnQuarto.setStyle(styleButton.replace("transparent", "rgba(255,191,0,0.75)")));

    BtnQuarto.setOnMouseExited(event -> BtnQuarto.setStyle(styleButton));

        BtnReserva.setOnMouseEntered(event ->
                BtnReserva.setStyle(styleButton.replace("transparent", "rgba(255,191,0,0.75)")));

        BtnReserva.setOnMouseExited(event -> BtnReserva.setStyle(styleButton));

        BtnRelatorios.setOnMouseEntered(event ->
                BtnRelatorios.setStyle(styleButton.replace("transparent", "rgba(255,191,0,0.75)")));

        BtnRelatorios.setOnMouseExited(event -> BtnRelatorios.setStyle(styleButton));


        HBox layout = new HBox(10,imgHotel ,lblMenu );
        layout.setAlignment(Pos.CENTER);

        //Espaçamento externo (margem) do componente label até o botão
        setMargin(lblMenu, new Insets(0,0,20,0));
        //Margem sucesivamente: superior, dirreita, Inferior, esquerda

        setStyle("-fx-background-color: #070000FF; -fx-padding: 40px");
        setSpacing(18); // Metodo para espaçar  todos os componentes abaixo
        getChildren().addAll(layout, BtnClientes, BtnFuncionario,
                BtnQuarto, BtnReserva, BtnRelatorios);


    }

}
