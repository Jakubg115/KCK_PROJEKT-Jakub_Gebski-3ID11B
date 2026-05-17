package com.swietlica.Frontend.Komponenty.ElementDoEkranuPomoc;

import com.swietlica.Frontend.Komponenty.GraZListy.ObiektGra;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ObiektPomocKontroller {


    @FXML
    private Label nazwa;
    @FXML
    private HBox ramka;

    public void inicjuj(ObiektGra gra){
        this.nazwa.setText(gra.zwrocNazwe());
    }

    public void komunikatON(){
        String style="-fx-background-color:#d9d9d9;"+"-fx-border-color:lightgray;";
        this.ramka.setStyle(style);
    }
    public void komunikatOFF(){this.ramka.setStyle("-fx-border-color:lightgray;");}
    public String zwrocNazwe(){return this.nazwa.getText();}

}
