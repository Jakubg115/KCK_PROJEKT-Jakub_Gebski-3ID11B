package com.swietlica.Frontend.Komponenty.ElementDoPokoji;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ObiektGracz extends GridPane {

    private final ObiektGraczKontroller kontrolka;
    public final static String DEFAULT="/Icons/DomyslnaIkonka.png";

    public ObiektGracz(String urlZdjecie, String nazwaGracza, int ranking) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/ElementGracz.fxml"));
        loader.setRoot(this);
        try {
            loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.kontrolka=loader.getController();
        this.kontrolka.wstawZdjecie(getClass().getResource(urlZdjecie));
        this.kontrolka.wstawNazwe(nazwaGracza);
        this.kontrolka.wstawRanking(ranking);
    }

    public String zwrocGracza(){return this.kontrolka.zwrocGracza();}


}
