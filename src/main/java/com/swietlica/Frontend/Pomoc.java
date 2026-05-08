package com.swietlica.Frontend;

import com.swietlica.Frontend.Komponenty.GraZListy.ObiektGra;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Pomoc {

    private static int INDEKS=0;
    @FXML
    private VBox listaGier= new VBox();

    private Stage stage;

    public void inicjuj(Stage stage, ObservableList<Node> lista){



        this.stage=stage;
    }
    public Stage dajStage(){return this.stage;}

    public void zmienIndeks(int ind){INDEKS=ind;}
}


