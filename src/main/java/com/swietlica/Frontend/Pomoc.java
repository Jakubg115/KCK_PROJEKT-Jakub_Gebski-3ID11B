package com.swietlica.Frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Pomoc {
    @FXML
    private ListView<String> listaGier= new ListView<>();

    private Stage stage;

    public void inicjuj(Stage stage){

        ObservableList<String> asd=FXCollections.observableArrayList(
                "Gra 1","Gra 2","Gra 3","Gra 4","Gra 5","Gra 6","Gra 7","Gra 8","Gra 9","Gra 10"
        );

        this.stage=stage;
        this.listaGier.setItems(asd);
    }
    public Stage dajStage(){return this.stage;}
    @FXML
    public void cos(){

    }
}


