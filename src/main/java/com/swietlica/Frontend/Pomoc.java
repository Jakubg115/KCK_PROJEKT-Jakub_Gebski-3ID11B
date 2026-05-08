package com.swietlica.Frontend;

import com.swietlica.Frontend.Komponenty.ElementDoEkranuPomoc.ObiektPomoc;
import com.swietlica.Frontend.Komponenty.GraZListy.ObiektGra;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Pomoc {

    private static int INDEKS=0;
    @FXML
    private VBox listaGier= new VBox();
    @FXML
    private Label tytul;

    private Stage stage;

    public void inicjuj(VBox lista, int indeks) throws IOException {
        ObservableList<Node> it=lista.getChildren();
        for (Node node : it) {
            this.listaGier.getChildren().add(new ObiektPomoc((ObiektGra) node, this));
        }
        zmienIndeks(indeks);
        przeczytajWybranyIndeks();
    }

    public Stage dajStage(){return this.stage;}
    public void wstawStage(Stage st){this.stage=st;}
    public void zmienIndeks(int ind){INDEKS=ind;}

    public void przeczytajWybranyIndeks(){
        if(INDEKS!=-1){
            String nazwa=((ObiektPomoc) this.listaGier.getChildren().get(INDEKS)).ZwrocNazwe();
            tytul.setText(nazwa);
        }
    }
}


