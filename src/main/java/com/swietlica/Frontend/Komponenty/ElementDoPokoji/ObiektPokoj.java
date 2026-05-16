package com.swietlica.Frontend.Komponenty.ElementDoPokoji;

import com.swietlica.Frontend.Pokoje;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ObiektPokoj extends GridPane {

    private ObiektPokojKontroller kontrolka;

    public ObiektPokoj(int indeks, int iloscGraczy, Pokoje wskaznik) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/ElementPokoj.fxml"));
        loader.setRoot(this);
        loader.load();
        this.kontrolka=loader.getController();
        this.kontrolka.przekazWskaznik(wskaznik);
        this.kontrolka.wstawindeks(indeks);
        this.kontrolka.ustawRozmiarPokoju(iloscGraczy);
        this.kontrolka.inicjuj();
    }
}
