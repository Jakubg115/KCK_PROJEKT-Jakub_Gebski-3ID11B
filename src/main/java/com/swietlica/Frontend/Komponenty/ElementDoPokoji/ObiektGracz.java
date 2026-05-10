package com.swietlica.Frontend.Komponenty.ElementDoPokoji;

import com.swietlica.Frontend.Pokoje;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ObiektGracz extends GridPane {

    private ObiektGraczKontroller kontrolka;

    public ObiektGracz(String urlZdjecie, String nazwaGracza, int ranking, Pokoje wskaznik) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/ElementGracz.fxml"));
        loader.setRoot(this);
        loader.load();
        this.kontrolka=loader.getController();
        this.kontrolka.przekazWskaznik(wskaznik);
        this.kontrolka.wstawZdjecie(urlZdjecie);
        this.kontrolka.wstawNazwe(nazwaGracza);
        this.kontrolka.wstawRanking(ranking);
    }


}
