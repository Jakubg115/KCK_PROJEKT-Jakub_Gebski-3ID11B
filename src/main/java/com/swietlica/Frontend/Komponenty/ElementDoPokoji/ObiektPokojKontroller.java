package com.swietlica.Frontend.Komponenty.ElementDoPokoji;

import com.swietlica.Frontend.Pokoje;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ObiektPokojKontroller {

    private int indeks;
    private Pokoje wskaznik;

    @FXML
    private Label idPokoju;
    @FXML
    private GridPane panel;

    public void przekazWskaznik(Pokoje wsk){wskaznik=wsk;}
    public void wstawindeks(int ind){this.indeks=ind; this.idPokoju.setText("#"+this.indeks);}
    public void wstawGracza(int indeks, String gracz){
        this.panel.add(new Label(gracz),1,indeks);
    }



    public void wstawWieluGraczy(String[] lista){
        int size=lista.length;
        for (int i=0; i<size; i++){
            this.panel.add(new Label(lista[i]),1,i);
        }
    }

    public void usunGracza(int indeks){
        Node s=panel.getChildren().get((3*indeks)+1);

        if (s instanceof Label){
            ((Label) s).setText("-");
        }
    }


    @FXML
    public void zwrocIndeks(){wskaznik.zmienIndeksPokoju(this.indeks);}
}
