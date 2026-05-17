package com.swietlica.Frontend.Komponenty.ElementDoEkranuPomoc;

import com.swietlica.Frontend.Komponenty.GraZListy.ObiektGra;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ObiektPomoc extends HBox {

    private final ObiektPomocKontroller kontrolka;


    public ObiektPomoc(ObiektGra gra) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/elementZListyPomoc.fxml"));
        loader.setRoot(this);
        loader.load();
        this.kontrolka=loader.getController();
        this.kontrolka.inicjuj(gra);
    }

    public String ZwrocNazwe(){return this.kontrolka.zwrocNazwe();}
}
