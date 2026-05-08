package com.swietlica.Frontend.Komponenty.GraZListy;

import com.swietlica.Frontend.EkranGlowny;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ObiektGraKontroler {

    private int indeksWliscie;

    @FXML
    private Label nazwaGry;
    @FXML
    private Label daneIlosciGraczy;
    @FXML
    private AnchorPane obiektDoListy;

    private EkranGlowny ek;

    @FXML
    private ImageView obrazPodgladowy;
    public void zwrocIndeks(){
        ek.zmienindeks(this.indeksWliscie);}
    public int pobierzIndeks(){return this.indeksWliscie;}
    public void przekazWskaznik(EkranGlowny ek){this.ek=ek;}
    public void ustawIndeks(int ind){
        this.indeksWliscie=ind;
    }
    public void ustawNazwe(String nazwa){
        this.nazwaGry.setText(nazwa);
    }
    public String zwrocNazwe(){
        return this.nazwaGry.getText();
    }
    public AnchorPane zwrocPanel(){return this.obiektDoListy;}
    public void wstawObraz(String url){
        obrazPodgladowy.setImage(new Image(url));
    }
    public void wstawIloscGraczy(int ilosc){
        daneIlosciGraczy.setText("("+ilosc+")");
    }

}
