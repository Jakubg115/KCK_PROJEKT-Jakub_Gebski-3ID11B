package com.swietlica.Frontend.Komponenty.GraZListy;

import com.swietlica.Frontend.EkranGlowny;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.net.URL;

public class ObiektGraKontroler {

    @FXML
    private Label nazwaGry, daneIlosciGraczy;
    @FXML
    private ImageView obrazPodgladowy;
    @FXML
    private AnchorPane obiektDoListy;

    public void ustawNazwe(String nazwa){
        this.nazwaGry.setText(nazwa);
    }
    public String zwrocNazwe(){
        return this.nazwaGry.getText();
    }


    public void wstawObraz(URL url) throws FileNotFoundException{this.obrazPodgladowy.setImage(new Image(String.valueOf(url)));}
    public void wstawIloscGraczy(int ilosc){
        daneIlosciGraczy.setText("("+ilosc+")");
    }
    @FXML
    public void komunikatON(){
        String style="-fx-background-color:#d9d9d9;"+"-fx-border-color:lightgray;";
        this.obiektDoListy.setStyle(style);
    }
    @FXML
    public void komunikatOFF(){this.obiektDoListy.setStyle("-fx-border-color:lightgray;");}

}
