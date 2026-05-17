package com.swietlica.Frontend.Komponenty.ElementDoPokoji;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ObiektPokoj extends GridPane {

    private final ObiektPokojKontroller kontrolka;

    public ObiektPokoj(int indeks,int iloscGraczy) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/ElementPokoj.fxml"));
        loader.setRoot(this);
        loader.load();
        this.kontrolka=loader.getController();
        this.kontrolka.ustawRozmiarPokoju(iloscGraczy);
        this.kontrolka.inicjuj();
        this.kontrolka.wstawIndeks(indeks);
    }
    public Label zwrocGracza(int indeks){return this.kontrolka.zwrocGracza(indeks);}
}
