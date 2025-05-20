package view.Components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PainelButons extends HBox {

    public Button BtnCad = new Button("Cadastrar");
    public Button BtnUp = new Button("Atualizar");
    public Button BtnDel = new Button("Deletar");

    public PainelButons() {

    Image imgBtnCad = new Image(getClass().getResourceAsStream
            ("/view/Resources/img/plus48px.png"));
    Image imgBtnUp = new Image(getClass().getResourceAsStream
            ("/view/Resources/img/update48px.png"));
    Image imgBtnDel = new Image(getClass().getResourceAsStream
            ("/view/Resources/img/delete48px.png"));


    //Parâmetros para definir como a imagem será visualizada
    ImageView viewImgBtnCad = new ImageView(imgBtnCad);
        viewImgBtnCad.setFitWidth(20); //Definição de largura
        viewImgBtnCad.setFitHeight(20); //Definição de altura
    //viewImgBtnCad.setOpacity(0.5); //Definição de opacidade: 0.0 (invisível) - 1.0 (opaco)

    ImageView viewImgBtnUp = new ImageView(imgBtnUp);
        viewImgBtnUp.setFitWidth(20);
        viewImgBtnUp.setFitHeight(20);


    ImageView viewImgBtnDel = new ImageView(imgBtnDel);
        viewImgBtnDel.setFitWidth(20);
        viewImgBtnDel.setFitHeight(20);

    BtnCad.setGraphic(viewImgBtnCad);
    BtnUp.setGraphic(viewImgBtnUp);
    BtnDel.setGraphic(viewImgBtnDel);

        String styleButton = "-fx-background-color: transparent;" +
                "-fx-bordeer-color: transparent;" +
                "-fx-gramphic-text-gap: 10px;" +
                "-fx-cursor: hand;" +
                "-fx-border-color: Black;";

        BtnDel.setStyle(styleButton);
        BtnCad.setStyle(styleButton);
        BtnUp.setStyle(styleButton);

        BtnCad.setOnMouseEntered(event ->
                BtnCad.setStyle(styleButton.replace("transparent", "rgba(255,191,0,0.75)")));
        BtnCad.setOnMouseExited(event -> BtnCad.setStyle(styleButton));

        BtnDel.setOnMouseEntered(event ->
                BtnDel.setStyle(styleButton.replace("transparent", "rgba(255,191,0,0.75)")));
        BtnDel.setOnMouseExited(event -> BtnDel.setStyle(styleButton));

        BtnUp.setOnMouseEntered(event ->
                BtnUp.setStyle(styleButton.replace("transparent", "rgba(255,191,0,0.75)")));
        BtnUp.setOnMouseExited(event -> BtnUp.setStyle(styleButton));

        GridPane formGrid = new GridPane();
        formGrid.add(BtnCad, 0, 0);
        formGrid.add(BtnUp, 1, 0);
        formGrid.add(BtnDel, 2, 0);
        formGrid.setHgap(10);
        formGrid.setVgap(10);


        getChildren().addAll(formGrid);


    }
}
