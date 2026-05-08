package com.swietlica.Frontend.Komponenty.ElementDoEkranuPomoc;

import com.swietlica.Frontend.Komponenty.GraZListy.ObiektGra;
import com.swietlica.Frontend.Pomoc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ObiektPomocKontroller {
    private int indeks;

    private Pomoc pom;

    @FXML
    private HBox ramka;
    @FXML
    private Label nazwa;

    public void inicjuj(ObiektGra gra){
        this.nazwa.setText(gra.zwrocKontrolke().zwrocNazwe());
        this.indeks=gra.zwrocKontrolke().pobierzIndeks();
    }

    public void zwrocIndeks(){
        pom.zmienIndeks(this.indeks);
    }
    public void przekazWskaznik(Pomoc wskaznik){pom=wskaznik;}


}
