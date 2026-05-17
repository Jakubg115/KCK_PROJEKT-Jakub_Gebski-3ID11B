package com.swietlica.Frontend.Komponenty.PoleBoczne;

import com.swietlica.Frontend.EkranGlowny;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PoleBoczne extends AnchorPane {
    private final PoleBoczneKontroler kontrolka;

    public PoleBoczne(String nazwa, Stage stage, EkranGlowny wskaznik){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/BocznePole.fxml"));
        loader.setRoot(this);
        try {
            loader.load();
            this.kontrolka=loader.getController();
            this.kontrolka.przekazWskaznik(wskaznik);
            this.kontrolka.wstawNazwe(nazwa);
            this.kontrolka.przekazStage(stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void utworzPole(int ilosc) {
        for (int i=0; i<ilosc; i++){
            this.kontrolka.utworzRekord();
        }
    }

}

