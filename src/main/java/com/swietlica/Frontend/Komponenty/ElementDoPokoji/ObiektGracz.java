package com.swietlica.Frontend.Komponenty.ElementDoPokoji;

import com.swietlica.Frontend.Pokoje;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;

public class ObiektGracz extends GridPane {

    private ObiektGraczKontroller kontrolka;
    public final static String DEFAULT="/Icons/DomyslnaIkonka.png";

    public ObiektGracz(String urlZdjecie, String nazwaGracza, int ranking,int indeks, Pokoje wskaznik) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/ElementGracz.fxml"));
        loader.setRoot(this);
        loader.load();
        this.kontrolka=loader.getController();
        this.kontrolka.przekazWskaznik(wskaznik);
        this.kontrolka.wstawZdjecie(getClass().getResource(urlZdjecie));
        this.kontrolka.wstawNazwe(nazwaGracza);
        this.kontrolka.wstawRanking(ranking);
        this.kontrolka.wstawindeks(indeks);
    }


}
