package com.swietlica.Frontend.Komponenty.GraZListy;

import com.swietlica.Frontend.EkranGlowny;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ObiektGraKontroler {

    private int indeksWliscie;

    private EkranGlowny wskaznik;

    @FXML
    private Label nazwaGry, daneIlosciGraczy;
    @FXML
    private ImageView obrazPodgladowy;
    @FXML
    private AnchorPane obiektDoListy;

    public void zwrocIndeks(){wskaznik.zmienindeks(this.indeksWliscie);}
    public int pobierzIndeks(){return this.indeksWliscie;}

    public void przekazWskaznik(EkranGlowny ek){this.wskaznik =ek;}
    public void ustawIndeks(int ind){
        this.indeksWliscie=ind;
    }

    public void ustawNazwe(String nazwa){
        this.nazwaGry.setText(nazwa);
    }
    public String zwrocNazwe(){
        return this.nazwaGry.getText();
    }

    public void wstawObraz(String url){
        obrazPodgladowy.setImage(new Image(url));
    }
    public void wstawIloscGraczy(int ilosc){
        daneIlosciGraczy.setText("("+ilosc+")");
    }

    public void komunikatON(){
        String style="-fx-background-color:#d9d9d9;"+"-fx-border-color:lightgray;";
        this.obiektDoListy.setStyle(style);
    }
    public void komunikatOFF(){this.obiektDoListy.setStyle("-fx-border-color:lightgray;");}

}
