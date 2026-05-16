package com.swietlica.Frontend.Komponenty.ElementDoEkranuPomoc;

import com.swietlica.Frontend.Komponenty.GraZListy.ObiektGra;
import com.swietlica.Frontend.Pomoc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ObiektPomocKontroller {
    private int indeks;

    private Pomoc wskaznik;

    @FXML
    private Label nazwa;
    @FXML
    private HBox ramka;

    public void inicjuj(ObiektGra gra){
        this.nazwa.setText(gra.zwrocNazwe());
        this.indeks=gra.pobierzIndeks();
    }

    public void zwrocIndeks(){wskaznik.zmienIndeks(this.indeks);}
    public void przekazWskaznik(Pomoc wskaz){this.wskaznik=wskaz;}

    public void komunikatON(){
        String style="-fx-background-color:#d9d9d9;"+"-fx-border-color:lightgray;";
        this.ramka.setStyle(style);
    }
    public void komunikatOFF(){this.ramka.setStyle("-fx-border-color:lightgray;");}

}
