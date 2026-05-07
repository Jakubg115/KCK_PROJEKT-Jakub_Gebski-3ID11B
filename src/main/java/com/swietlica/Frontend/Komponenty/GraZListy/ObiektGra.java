package com.swietlica.Frontend.Komponenty.GraZListy;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ObiektGra extends AnchorPane {

    private final ObiektGraKontroler kontrolka;


    public ObiektGra(int indeks, String nazwaGry){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/GraZListy.fxml"));
        loader.setRoot(this);
        try {
            loader.load();
            this.kontrolka=loader.getController();
            this.kontrolka.ustawIndeks(indeks);
            this.kontrolka.ustawNazwe(nazwaGry);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void wstawHandler(EventHandler<MouseEvent> mouse){
        zwrocKontrolke().zwrocPanel().setOnMouseClicked(mouse);
    }
    public ObiektGraKontroler zwrocKontrolke(){return this.kontrolka;}
}
