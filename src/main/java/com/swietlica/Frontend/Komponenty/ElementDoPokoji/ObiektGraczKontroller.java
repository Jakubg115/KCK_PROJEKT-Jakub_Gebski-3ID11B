package com.swietlica.Frontend.Komponenty.ElementDoPokoji;

import com.swietlica.Frontend.Pokoje;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ObiektGraczKontroller {
    private int indeks;

    private Pokoje wskaznik;
    @FXML
    private ImageView profilGracza;
    @FXML
    private Label nazwaGracza,ranking;

    public void wstawindeks(int ind){this.indeks=ind;}
    public void przekazWskaznik(Pokoje wsk){wskaznik=wsk;}
    public void wstawZdjecie(String url){this.profilGracza.setImage(new Image(url));}
    public void wstawNazwe(String nazwa){this.nazwaGracza.setText(nazwa);}
    public void wstawRanking(int ranking){this.ranking.setText("#"+ranking);}

    @FXML
    public void zwrocIndeks(){wskaznik.zmienIndeksGracza(this.indeks);}
}
