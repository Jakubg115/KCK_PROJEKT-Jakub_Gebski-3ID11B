package com.swietlica.Frontend.Komponenty.ElementDoPokoji;

import com.swietlica.Frontend.Pokoje;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

public class ObiektGraczKontroller {
    private int indeks;

    private Pokoje wskaznik;
    @FXML
    private ImageView profilGracza;
    @FXML
    private Label nazwaGracza,ranking;
    @FXML
    private GridPane panel;

    public void wstawindeks(int ind){this.indeks=ind;}
    public void przekazWskaznik(Pokoje wsk){wskaznik=wsk;}
    public void wstawZdjecie(URL url) throws FileNotFoundException {this.profilGracza.setImage(new Image(String.valueOf(url)));}
    public void wstawNazwe(String nazwa){this.nazwaGracza.setText(nazwa);}
    public void wstawRanking(int ranking){this.ranking.setText("#"+ranking);}

    @FXML
    public void zwrocIndeks(){wskaznik.zmienIndeksGracza(this.indeks);}

    public void komunikatON(){
        String style="-fx-background-color:white;"+"-fx-border-color:gray;";
        this.panel.setStyle(style);
    }
    public void komunikatOFF(){this.panel.setStyle("-fx-border-color:gray;");}
}
