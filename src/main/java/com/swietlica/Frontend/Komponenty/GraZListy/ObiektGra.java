package com.swietlica.Frontend.Komponenty.GraZListy;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ObiektGra extends AnchorPane {

    private final ObiektGraKontroler kontrolka;


    public ObiektGra(String nazwaGry){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/GraZListy.fxml"));
        loader.setRoot(this);
        try {
            loader.load();
            this.kontrolka=loader.getController();
            this.kontrolka.ustawNazwe(nazwaGry);
            this.kontrolka.wstawObraz(getClass().getResource("/Icons/test.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObiektGraKontroler zwrocKontrolke(){return this.kontrolka;}
    public String zwrocNazwe(){return zwrocKontrolke().zwrocNazwe();}
}
