package com.swietlica.Frontend.Komponenty.ElementDoEkranuPomoc;

import com.swietlica.Frontend.Komponenty.GraZListy.ObiektGra;
import com.swietlica.Frontend.Pomoc;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ObiektPomoc extends HBox {

    private ObiektPomocKontroller kontrolka;

    private ObiektGra gra;

    public ObiektPomoc(ObiektGra gra, Pomoc wskaznik) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/elementZListyPomoc.fxml"));
        loader.setRoot(this);
        loader.load();
        this.kontrolka=loader.getController();
        this.kontrolka.przekazWskaznik(wskaznik);
        this.gra=gra;
        this.kontrolka.inicjuj(this.gra);
    }
    public ObiektPomocKontroller zwrocKontrolke(){return this.kontrolka;}
    public String ZwrocNazwe(){return this.gra.zwrocKontrolke().zwrocNazwe();}
}
