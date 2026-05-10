package com.swietlica.Frontend.Komponenty.ElementDoEkranuPomoc;

import com.swietlica.Frontend.Komponenty.GraZListy.ObiektGra;
import com.swietlica.Frontend.Pomoc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ObiektPomocKontroller {
    private int indeks;

    private Pomoc wskaznik;

    @FXML
    private Label nazwa;

    public void inicjuj(ObiektGra gra){
        this.nazwa.setText(gra.zwrocNazwe());
        this.indeks=gra.pobierzIndeks();
    }

    public void zwrocIndeks(){wskaznik.zmienIndeks(this.indeks);}
    public void przekazWskaznik(Pomoc wskaz){this.wskaznik=wskaz;}


}
